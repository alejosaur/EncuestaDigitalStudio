package fedejandro.encuestadigital;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Calendar;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainScreen extends AppCompatActivity implements View.OnClickListener {

    EditText fechaText;
    EditText encuestadorText;
    EditText consecutivoText;
    Button nextButton, fechaButton, downloadButton;
    private int day, month, year;

    private String filename = "datos.txt";
    private String filepath = "EncuestaDatos";
    File myExternalFile;
    String myData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);


        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            nextButton.setEnabled(false);
        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }

        StringBuffer datax = new StringBuffer("");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            InputStreamReader isr = new InputStreamReader ( fis ) ;
            BufferedReader buffreader = new BufferedReader ( isr ) ;

            String readString = buffreader.readLine( ) ;
            while ( readString != null ) {
                datax.insert(0,readString);
                readString = buffreader.readLine ( ) ;
            }

            isr.close( ) ;

            consecutivoText = (EditText) findViewById(R.id.consecutivoText);
            String str = datax.toString();
            String consecutivo = String.valueOf(Integer.parseInt(str.split("\t")[1])+1);
            consecutivoText.setText(consecutivo);

        }catch (IOException e){
            try {
                FileOutputStream fos = new FileOutputStream(myExternalFile, true);
                    fos.write(("Fecha\tN° de visita \tNombre del encuestador\tUPAC/UPPA\t" +
                            "Departamento\tMunicipio\tResguardo indígena\tCorregimiento, vereda o barrio\tCoordenadas\tNombre\tNúmero telefónico\tTipo de documento de identidad\tNúmero de Documento\tGrupos étnicos\tEdad\tGenero \tHace cuantos años reside en la zona\tHace cuantos años se dedica a esta actividad\tUsted está organizado como persona natural o jurídica\tHa sido víctima del desplazamiento forzado\tCuál fue la causa del desplazamiento\tEs usted desmovilizado de algún grupo armado\tCuántas personas componen su grupo familiar\tQuién es el /la jefe del hogar\tCuál es su relación con el/la productor/a\tGenero\tEdad\tEstado civil\tSabe leer y/o escribir\tActualmente asiste a un centro educativo\tCuál es el último grado de educación que estudio y aprobó\tCuál es su profesión\t¿Actualmente usted se encuentra?\t¿Según las siguientes categorías usted es?\t¿Usted trabaja de forma independiente cómo?\t¿Cuantas personas trabajan en el hogar? \tEn promedio, ¿Cuanto es el ingreso mensual familiar?\tEn promedio, ¿Cuanto son los gastos familiares?\t¿La vivienda en la que habita es?\t¿El techo está construido con?\t¿El piso está construido con?\t¿Las paredes están construidas con?\tDe los siguientes servicios públicos y/o privados ¿Cuáles tiene en su vivienda?\tEn los últimos 3 meses, por falta de dinero u otros recursos, ¿alguna vez en su hogar se quedaron sin alimentos?\tEn los últimos 3 meses, por falta de dinero u otros recursos, ¿alguna vez usted o algún miembro de su hogar dejó de desayunar, almorzar o cenar?\tEn los últimos 3 meses, por falta de dinero u otros recursos, ¿alguna vez usted o algún miembro de su hogar solo comió una vez al día o dejó de comer durante todo un día?\t¿Tiene acceso a educación?\t¿Cuál es el nombre del establecimiento educativo?\t¿Qué nivel de educación ofrece?\t¿Cuánta distancia hay entre su vivienda y el establecimiento educativo?\t¿Cuánto tiempo gasta para desplazarse desde su vivienda hacia el establecimiento educativo?\t¿Qué medio de transporte (uno o varios) utiliza para desplazarse hacia el establecimiento educativo?\t¿Está afiliado a servicio de salud?\t¿El establecimiento se clasifica como?\t¿Cuánta distancia hay entre su vivienda y el establecimiento de salud?\t¿Cuánto tiempo gasta para desplazarse desde su vivienda hacia el establecimiento de salud?\t¿Qué medio de transporte (uno o varios) utiliza para desplazarse hacia el establecimiento de salud?\t¿Qué entidades?\t¿Cuánta distancia recorre para acceder a los servicios ofrecidos por esta entidad?\t¿Cuánto tiempo emplea para acceder a los servicios ofrecidos por esta entidad?\t¿Qué medio de transporte (uno o varios) utiliza para desplazarse hacia la institución?\t¿Qué servicios?\t¿Cuánta distancia recorre para acceder a un centro de comercialización?\t¿Cuánto tiempo emplea para desplazarse hacia el centro de comercialización?\t¿Qué medio de transporte (uno o varios) utiliza para desplazarse hacia el centro de comercialización? \t¿El centro de comercialización permanece en funcionamiento de manera?\t¿Usted ha solicitado alguna vez crédito o financiación para desarrollar actividades acuícolas?\t¿El crédito o la financiación fue otorgada por?\t¿Cuál fue el destino final del crédito o financiación?\t¿Ha recibido asistencia técnica?\tLa asistencia técnica fue ofrecida por\t¿En cuál de los siguientes temas fue o es asesorado/asistido?\t¿Le sirvió la asesoría?\t¿La asistencia técnica recibida fue?\t¿Ha asistido a algún taller, curso, seminario, capacitación, otros?\tLa formación complementaria fue ofrecida por:\t¿En cuál de las siguientes áreas recibió formación complementaria?\t¿La formación complementaria fue de utilidad?\t¿La formación complementaria recibida fue?\t" +
                            "¿La acuicultura es una actividad económica principal o complementaria?\t¿Cuántas unidades de producción acuícola están bajo su cargo?\t¿La unidad de producción acuícola es?\t¿Cuál es el área total de los predios que estan bajo su cargo? (Propios)\t¿Cuál es el área total de los predios que estan bajo su cargo? (Arrendados)\t¿Cuál es el área total de los predios que estan bajo su cargo? (Familiares)\t¿Cuál es el área total de los predios que estan bajo su cargo? (Posesión)\t¿Cuál es el área total de los predios que estan bajo su cargo? (Otro tipo de tenencia)\t¿Cuál es el área destinada a la producción acuícola? (Propia)\t¿Cuál es el área destinada a la producción acuícola? (Arrendada)\t¿Cuál es el área destinada a la producción acuícola? (Familiar)\t¿Cuál es el área destinada a la producción acuícola? (Posesión)\t¿Cuál es el área destinada a la producción acuícola? (Otro tipo de tenencia)\t¿La fuente de agua para la produccion proviene de?\t¿Qué método utiliza para transportar el agua desde la fuente de captación hacia la unidad de producción?\t¿Cuál es la distancia entre la fuente de captación y la unidad de producción?\t¿Cuáles son los meses de mayor precipitación?\t¿Cuáles son los meses de menor precipitación?\t¿Conoce el tipo de suelos de la UPAC?\t¿Qué tipo de suelos hay en la UPAC?\t¿Cuánta agua emplea en la UPAC?\t¿Paga por el suministro de agua empleado en la UPAC?\t¿Cuál es el costo del agua empleada (indique unidad)?\t¿Lleva registros de los parametros fisico químicos?\tT(°C)\tpH\tOxígeno disuelto OD (ppm)\tAlcalinidad (mg/l)\tDureza (mg/l)\tTurbidez (cm Secchi)\tAmonio (NH3+)\t¿En los últimos 3 meses ha observado eventos de contaminación de aguas?\t¿Qué tipo de contaminante observó?\t¿Los productos de la UPAC se destinan para?\t¿Qué porcentaje se destina para el autoconsumo? \t¿Qué porcentaje se destina para la comercialización?\t¿Qué produce?\t¿Cuál es el tipo de producción que realiza?\t¿Cuál es el precio de compra de su base productiva?\t¿Cuál es el porcentaje (%) de sobrevivencia de su base productiva?\t¿Qué especie o especies produce?\t¿Cuántos meses dura el ciclo de producción?\t¿Cuántos animales son su base productiva por ciclo?\t¿Cuántos animales cosecha por ciclo?\t¿Cuál es la producción bruta por ciclo (Kg)?\t¿Cuál es el peso promedio inicial en gramos (g) de los animales?\t¿Cuál es el peso promedio final en gramos (g), de los animales?\t¿Qué cantidad vende?\t¿Cuál es la unidad de venta?\t¿Cuál es el precio promedio por unidad?\t¿Realiza proceso de eviscerado?\t¿Cuál es el porcentaje de pérdida por evíscerado (%)?\t¿Qué tipo de Procesamiento, transformación, agregación de valor (Valor agregado) le da al producto?\t¿Cuál es el peso neto final en gramos (g) de los animales?\t¿Cuál es el porcentaje de pérdida por transformación (%)?\t¿Cuál es la producción neta por ciclo (Kg)?\tTiene reproductores?\t¿Cómo obtiene los reproductores?\t¿Cuál es el precio promedio que pagó por cada reproductor?\t¿Cuantos años promedio permanece un reproductor en la UPAC?\t¿Cuál es el porcentaje de sobrevivencia?\t¿Cuál es el área de producción?\t¿Cuál es la proporción sexual macho:hembra?\t¿Implementa BPPA?\t¿Cuáles BPPA implementa?\t¿Utiliza fungicidas, antibióticos, pesticidas, u otros elementos químicos? \t¿Ha sufrido pérdidas por alguno de los siguientes desastres naturales?\t¿Cuál fue el porcentaje de pérdida?\t¿Ha sufrido pérdidas por presencia de predadores cómo?\t¿Cuál fue el porcentaje de pérdida?\t¿Ha sufrido pérdida por enfermedades o patologías asociadas a?\t¿Cuál fue el porcentaje de pérdida?\t¿Con que maquinaria o equipos cuenta la UPAC?\tEl tipo de tenencia de la maquinaria y equipos que utiliza en la UPAC son?\t¿El tipo de producción de la UPAC es?\tSistema de producción\t¿Cuántos estanques/tanques tiene en la UPAC?\tÁrea total\tMaterial del Estanque / Tanque\t¿Cuántas jaulas tiene la UPAC?\tVolumen total\tMaterial de las jaulas\t¿Cuál es el principal alimento en la UPAC?\t¿Dónde adquiere los alimentos?\t¿Cuál es la frecuencia de alimentación?\t¿Cuál es el departamento donde se ubica el proveedor?\t¿Ciudad o municipio donde se encuentra ubicado el proveedor?\t¿Qué cantidad de alimento compra?\t¿Cuál es la unidad de compra?\t¿Cuál es el precio por unidad?\t¿Cada cuanto compra?\t¿Hace recambio de agua?\t¿Con que frecuencia hace recambio (cada cuanto)?\t¿Cuál es el porcentaje (%) de recambio?\t¿Realiza algún tipo de tratamiento de los vertimientos antes de enviarlos al punto de descarga?\tDescriba el tratamiento implementa en la UPAC\t¿Dónde queda el punto de descarga de los vertimientos?\t¿Realiza algún tipo de tratamiento para los lodos producidos en la UPAC?\t¿Qué tratamiento implementa en la UPAC?\t¿Realiza disposición adecuado de los desechos sólidos por faenado y/o transformación (vísceras, huesos, escamas, otros)?\tDescriba el procedimiento\t¿Implementa planes de saneamiento y bioseguridad en la UPAC?\t¿Implementa actividades para la protección de las fuentes de agua?\t¿Qué actividades implementa para la protección de las fuentes de agua?\t¿La principal fuente de energía utilizada en la UPAC es?\t¿Es miembro activo de alguna asociación acuícola?\t¿Qué tipo de asociación?\t¿Cuántas personas participan en la asociación?\t¿Cuál es el nombre de la asociación?\tNombre del representante legal\tNúmero de teléfono fijo o móvil del representante legal\tDepartamento\tMunicipio\t¿Le interesa formar parte de alguna asociación\t¿Ha recibido apoyo para el fomento de la asociatividad por parte de alguna entidad pública o privada?\t¿Cuál es el nombre de la entidad?\t¿Dónde vende?\t¿Quién le compra?\t¿Bajo qué presentación vende?\t¿Los productos de la UPAC cuentan con algún certificado de calidad?\t¿Cuál es el certificado de calidad con el que cuenta la UPAC?\t¿Quién expide el certificado?\t¿Lleva registros de los costos de producción?\t¿Ha participado en convocatorias de proyectos de inversión para la UPAC?\t¿Ha participado en capacitaciones para la formulación de proyectos de inversión?\t¿Quién lo capacitó?\t¿Implementa algun tipo de tecnologia en la producción?\t¿Qué tipo de tecnología implementa?\t¿Posee planta de procesamiento para alimentos?\t¿Emplea cultivos pro bióticos para la nutrición animal?\t¿Alimentación automatizada?\t¿Emplea herramientas tecnológicas, como redes sociales, para la comercialización de los productos?\t¿Conoce y/o emplea software para llevar los registros de la UPAC?\t¿Conoce y/o emplea tecnologías para la transformación y conservación de los productos?\t¿Conoce y/o emplea tecnologías para la transformación y conservación de los subproductos\tAireación\tRaceway\tOtro ¿Cuál?\t" +
                            "¿Se dedica a la pesca de forma?\t¿La pesca es su actividad económica principal o complementaria?\tSi la pesca artesanal es complementaria ¿su principal actividad económica es?\t¿Tiene permiso para realizar la actividad pesquera? \t¿Quién le otorgó el permiso? \t¿Posee carnet emitido por la autoridad de pesca?\t¿Dónde pesca?\tRegistre el nombre del lugar\t¿Cuál es el lugar de desembarque de la producción pesquera?\t¿Durante que parte del día pesca?\t¿Los productos de la UPPA se destinan para? \t¿Ha participado en actividades de acuicultura?\t¿Le interesa participar en proyectos de acuicultura?\t¿Cuántos pescadores van en la embarcación en una jornada de pesca?\tAguas bajas\tAguas subiendo\tAguas altas\tAguas descendiendo\tDuración de la faena (Días)\tIndique cada arte de pesca empleado durante la faena de pesca\tNúmero (N°) de lances por faena para cada arte de pesca\tTiempo de duración del lance\tN° horas madrugada\tN° horas mañana\tN° horas tarde\tN° horas noche\tNumero de faenas por mes\tMeses del año dedicados a la pesca\tAguas bajas\tAguas subiendo\tAguas altas\tAguas descendiendo\tIndique el nombre de las especies capturadas y desembarcadas\tIndique el peso en kilogramos de las especies capturadas\tIndique el valor en pesos recibido por cada kilogramo\tIndique el destino de los productos pesqueros\t¿Qué porcentaje se destina para el autoconsumo? \t¿Qué porcentaje se destina para la comercialización? \tCarnada\tCosto\tMano de obra (sueldos)\tCosto\tAlimentación \tCosto\tCombustible\tCosto\tArte de pesca (Reparación de artes de pesca)\tCosto\tEmbarcación\tCosto\tArrendamiento de embarcación\tCosto\tArrendamiento de Motor\tCosto\tHielo\tCosto\tOtros (Cuales)\tCosto\t¿Distribuye el producto de cada faena?\t¿Qué tipo de Procesamiento, transformación, agregación de valor (Valor agregado) le da al producto pesquero?\tSeleccione las actividades que realiza el pescador desde la captura hasta  la comercialización\tEscriba el orden en el que se realiza el procedimiento\t¿Utiliza hielo para la conservación del producto?\t¿Implementa Buenas prácticas pesqueras artesanales?\t¿Cuáles buenas prácticas pesqueras artesanales?\t¿El porcentaje (%) de captura ha sido afectado por alguno de los siguientes fenómenos naturales?\t¿Cuál fue el porcentaje (%) de disminución de la captura?\t¿El porcentaje (%) de captura ha sido afectado por la presencia de predadores cómo?\t¿El porcentaje (%) de captura ha sido afectado por la contaminación de las fuentes de agua?\t¿Utiliza embarcación?\t¿Cuántas embarcaciones utiliza?\t¿De qué tipo es la embarcación que utiliza?\t¿La embarcación utilizada está construida en?\t¿Qué elemento de propulsión emplea?\t¿Cuál es la potencia del motor?\t¿La embarcación que utiliza es?\t¿Está registrada ante la inspección fluvial?\tPosee equipos de Seguridad\t¿Qué equipos de seguridad posee en la embarcación?\tDe la siguiente lista ¿Qué artes de pesca utiliza?\t¿Cuál es el arte de pesca primario?\t¿Cuántos utiliza?\tLargo (m)\tAltura (m)\tOjo de malla (pulgadas)\tTipo de material\tN° de Paños\tN° de líneas\tAnzuelos número de (N)° del anzuelo\tCantidad de anzuelos\tBodega para fines mixtos \t¿La instalación es?\tOficinas\t¿La instalación es?\tPlanta de beneficio de los animales\t¿La instalación es?\t¿Realiza disposición adecuado de los desechos sólidos como basuras, restos de redes y otros residuos producto de la faena de pesca?\tDescriba el procedimiento\t¿Eviscera a bordo?\t¿Realiza disposición adecuado de los desechos sólidos por faenado y/o transformación (vísceras, huesos, escamas, otros)?\tDescriba el procedimiento\t¿Implementa planes de saneamiento y bioseguridad en la UPPA?\t¿Implementa actividades para la protección de las fuentes de agua?\t¿Conoce la norma sobre época de veda para las especies de interés comercial?\t¿Cumple la norma sobre época de veda para las especies de interés comercial?\t¿Conoce la normatividad sobre las tallas mínimas de captura?\t¿Cumple con la norma de tallas mínimas de captura?\t¿Conoce las normatividad sobre artes de pesca prohibidas?\t¿Cumple la norma sobre artes de pesca prohibidas?\t¿Las fuentes de energía utilizada en la UPPA son?\t¿Es miembro o ha sido miembro de alguna asociación Pesquera?\t¿Qué tipo de asociación\t¿Actualmente se encuentra activa?\t¿Cuántas personas participan en la asociación?\t¿Cuál es el nombre de la asociación?\tNombre del representante legal\tNúmero de teléfono fijo o móvil del representante legal\tDepartamento\tMunicipio\t¿le gustaría formar parte de alguna asociación\t¿Ha recibido apoyo para el fomento de la asociatividad por parte de alguna entidad pública o privada?\t¿Cuál es el nombre de la entidad?\t¿Qué especies vende?\t¿Cuál es la unidad de venta?\t¿Cuál es el precio promedio por unidad?\t¿Qué especies vende?\t¿Cuál es la unidad de venta?\t¿Cuál es el precio promedio por unidad?\t¿Qué especies vende?\t¿Cuál es la unidad de venta?\t¿Cuál es el precio promedio por unidad?\t¿Dónde vende?\t¿Quién le compra?\t¿Bajo qué presentación vende?\t¿Lleva registros de los costos de producción?\t¿Ha participado en convocatorias de proyectos de inversión para la upa\t¿Quién o qué entidad publico/privada lo capacito?\t¿Emplea herramientas tecnologías para la comercialización de los productos?\t¿Conoce y/o emplea tecnologías para la transformación y conservación de los productos?\t¿Conoce y/o emplea tecnologías para la transformación y conservación de los subproductos?").getBytes());
            } catch (IOException err) {
                err.printStackTrace();
            }
            consecutivoText = (EditText) findViewById(R.id.consecutivoText);
            consecutivoText.setText("1");
        }


        fechaText = (EditText) findViewById(R.id.fechaText);
        encuestadorText = (EditText) findViewById(R.id.encuestadorText);
        consecutivoText = (EditText) findViewById(R.id.consecutivoText);

        encuestadorText.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        fechaButton = (Button) findViewById(R.id.fechaButton);
        fechaButton.setOnClickListener(this);

        nextButton =  (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = new FileOutputStream(myExternalFile,true);
                    fos.write(("\n" +
                            "").getBytes());
                    fos.write(fechaText.getText().toString().getBytes());
                    fos.write("\t".getBytes());
                    fos.write(consecutivoText.getText().toString().getBytes());
                    fos.write("\t".getBytes());
                    fos.write(encuestadorText.getText().toString().getBytes());
                    fos.close();

                    Intent preg1 = new Intent(getApplicationContext(), Preguntas1.class);
                    startActivity(preg1);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        downloadButton =  (Button) findViewById(R.id.downloadButton);
        downloadButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                compartirArchivo();
            }
        });
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        if (v==fechaButton){
            final Calendar myCalendar = Calendar.getInstance();
            day=myCalendar.get(Calendar.DAY_OF_MONTH);
            month=myCalendar.get(Calendar.MONTH);
            year=myCalendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fechaText.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
            , year, month, day);
            datePickerDialog.show();
        }

    }

    private void compartirArchivo(){
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/*");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + myExternalFile.getAbsolutePath()));
        startActivity(Intent.createChooser(sharingIntent, "share file with"));
    }

}
