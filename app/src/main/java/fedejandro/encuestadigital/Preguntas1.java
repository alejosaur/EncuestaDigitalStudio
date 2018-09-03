package fedejandro.encuestadigital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.FileOutputStream;
import java.io.IOException;

public class Preguntas1 extends AppCompatActivity {

    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas1);

        String[] departamentos = new String[] {
                "Amazonas","Antioquia","Arauca","Atlántico","Bolívar","Boyacá","Caldas","Caquetá","Casanare","Cauca","Cesar","Chocó","Córdoba","Cundinamarca","Guainía","Guaviare","Huila","La Guajira","Magdalena","Meta","Nariño","Norte de Santander","Putumayo","Quindío","Risaralda","San Andrés y Providencia","Santander","Sucre","Tolima","Valle del Cauca","Vaupés","Vichada"
        };
        String[] tipoDoc = new String[] {
                "Tarjeta de Identidad","Cédula de Ciudadanía","Cédula de Extranjería","Visa de Trabajo"
        };
        String[] gruposEtnicos = new String[] {
                "No Aplica","Afrocolombiano","Indígena","Mestizo","Otro, ¿Cuál?"
        };
        String[] genero = new String[] {
                "Masculino","Femenino","Otro","Prefiero no decirlo"
        };
        String[] tipoPersona = new String[] {
                "Natural","Jurídica"
        };
        String[] sino = new String[] {
                "Sí","No"
        };
        String[] causaDesplazamiento = new String[] {
                "No Aplica","Conflicto Armado","Ambiental","Económica"
        };
        String[] relacionPersonas = new String[] {
                "Cónyuge","Hijo/a","Yerno/Nuera","Nieto/a, Bisnieto/a","Padre o madre del cónyuge","Otro pariente","No emparentado"
        };
        String[] estadoCivil = new String[] {
                "Soltero","Casado","Unión Libre","Separado","Divorciado","Viudo"
        };
        String[] gradoEstudio = new String[] {
                "Ninguno","Básica primaria (1° a 5° grado)","Básica secundaria (6° a 9° grado)","Media (10° a 11° grado)","Técnico","Tecnólogo","Profesional pregrado","Postgrado"
        };
        String[] estadoEmpleo = new String[] {
                "Empleado","Desempleado"
        };
        String[] dentroFuera = new String[] {
                "Dentro de la unidad de producción","Fuera de la unidad de producción"
        };
        String[] tiempoJornada = new String[] {
                "Jornada completa","Jornada parcial"
        };
        String[] etapasProduccion = new String[] {
                "Etapa de producción","Etapa de transformación","Etapa de comercialización"
        };
        String[] fijoIndependiente = new String[] {
                "Empleado fijo (algún tipo de contrato)","Trabajador independiente"
        };
        String[] tipoIndependiente = new String[] {
                "No Aplica","Empleador","Trabaja por cuenta propia","Trabajador familiar no retribuído","Socio de cooperativa de productores","Otro, ¿cuál?"
        };
        String[] tipoVivienda = new String[] {
                "Propia","Arrendada","Familiar","Posesión","Otro, ¿cuál?"
        };
        String[] materialTecho = new String[] {
                "Madera","Teja de barro","Teja de asbesto","Zinc","Palma","Otro, ¿cuál?"
        };
        String[] materialPiso = new String[] {
                "Tierra","Madera","Cemento","Baldosa","Otro, ¿cuál?"
        };
        String[] materialPared = new String[] {
                "Madera","Ladrillo","Tapia","Bahareque","Otro, ¿cuál?"
        };
        String[] tipoEducacion = new String[] {
                "Pública","Privada","Ninguna"
        };
        String[] afiliacionSalud = new String[] {
                "Régimen Contributivo (EPS)","Régimen Subsidiado","Régimen Especial","No afiliado","No sabe"
        };
        String[] establecimientoSalud = new String[] {
                "Hospital","Clínica","Centro de Salud","Puesto de Salud"
        };
        String[] entidadesAcuicolas = new String[] {
                "AUNAP","ICA","CAR-CORPOCESAR","UMATA","Otras"
        };
        String[] periodicaPermanente = new String[] {
                "Periódica","Permanente"
        };
        String[] entidadesCredito = new String[] {
                "No Aplica","Banco comercial","Sociedad o cooperativas de crédito","Prestamista","Proveedores de insumos","Familiares o amigos","Gobierno","Otro, ¿cuál?"
        };
        String[] entidadesAsistencia = new String[] {
                "No Aplica","Organizaciones gubernamentales","ONG, ¿cuál?","Asociaciones de productores","Otro, ¿cuál?"
        };
        String[] gratisPago = new String[] {
                "No Aplica","Gratis","Pago"
        };


        Spinner ans1 = (Spinner) findViewById(R.id.ans1);
        ArrayAdapter<String> adapterAns1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, departamentos);
        adapterAns1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans1.setAdapter(adapterAns1);

        Spinner ans8 = (Spinner) findViewById(R.id.ans8);
        ArrayAdapter<String> adapterAns8 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoDoc);
        adapterAns8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans8.setAdapter(adapterAns8);

        Spinner ans9 = (Spinner) findViewById(R.id.ans9);
        ArrayAdapter<String> adapterAns9 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gruposEtnicos);
        adapterAns9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans9.setAdapter(adapterAns9);

        Spinner ans11 = (Spinner) findViewById(R.id.ans11);
        ArrayAdapter<String> adapterAns11 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genero);
        adapterAns11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans11.setAdapter(adapterAns11);

        Spinner ans14 = (Spinner) findViewById(R.id.ans14);
        ArrayAdapter<String> adapterAns14 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoPersona);
        adapterAns14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans14.setAdapter(adapterAns14);

        Spinner ans15 = (Spinner) findViewById(R.id.ans15);
        ArrayAdapter<String> adapterAns15 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans15.setAdapter(adapterAns15);

        Spinner ans15_1 = (Spinner) findViewById(R.id.ans15_1);
        ArrayAdapter<String> adapterAns15_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, causaDesplazamiento);
        adapterAns15_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans15_1.setAdapter(adapterAns15_1);

        Spinner ans16 = (Spinner) findViewById(R.id.ans16);
        ArrayAdapter<String> adapterAns16 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans16.setAdapter(adapterAns16);

        Spinner ans19_1 = (Spinner) findViewById(R.id.ans19_1);
        ArrayAdapter<String> adapterAns19_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, relacionPersonas);
        adapterAns19_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans19_1.setAdapter(adapterAns19_1);

        Spinner ans19_2 = (Spinner) findViewById(R.id.ans19_2);
        ArrayAdapter<String> adapterAns19_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genero);
        adapterAns19_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans19_2.setAdapter(adapterAns19_2);

        Spinner ans19_4 = (Spinner) findViewById(R.id.ans19_4);
        ArrayAdapter<String> adapterAns19_4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estadoCivil);
        adapterAns19_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans19_4.setAdapter(adapterAns19_4);

        Spinner ans19_5 = (Spinner) findViewById(R.id.ans19_5);
        ArrayAdapter<String> adapterAns19_5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns19_5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans19_5.setAdapter(adapterAns19_5);

        Spinner ans19_6 = (Spinner) findViewById(R.id.ans19_6);
        ArrayAdapter<String> adapterAns19_6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns19_6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans19_6.setAdapter(adapterAns19_6);

        Spinner ans19_7 = (Spinner) findViewById(R.id.ans19_7);
        ArrayAdapter<String> adapterAns19_7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gradoEstudio);
        adapterAns19_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans19_7.setAdapter(adapterAns19_7);

        Spinner ans20 = (Spinner) findViewById(R.id.ans20);
        ArrayAdapter<String> adapterAns20 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estadoEmpleo);
        adapterAns20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans20.setAdapter(adapterAns20);

        Spinner ans20_1 = (Spinner) findViewById(R.id.ans20_1);
        ArrayAdapter<String> adapterAns20_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dentroFuera);
        adapterAns20_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans20_1.setAdapter(adapterAns20_1);

        Spinner ans20_2 = (Spinner) findViewById(R.id.ans20_2);
        ArrayAdapter<String> adapterAns20_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tiempoJornada);
        adapterAns20_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans20_2.setAdapter(adapterAns20_2);

        Spinner ans20_3 = (Spinner) findViewById(R.id.ans20_3);
        ArrayAdapter<String> adapterAns20_3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, etapasProduccion);
        adapterAns20_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans20_3.setAdapter(adapterAns20_3);

        Spinner ans21 = (Spinner) findViewById(R.id.ans21);
        ArrayAdapter<String> adapterAns21 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fijoIndependiente);
        adapterAns21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans21.setAdapter(adapterAns21);

        Spinner ans21_1 = (Spinner) findViewById(R.id.ans21_1);
        ArrayAdapter<String> adapterAns21_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoIndependiente);
        adapterAns21_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans21_1.setAdapter(adapterAns21_1);

        Spinner ans22 = (Spinner) findViewById(R.id.ans22);
        ArrayAdapter<String> adapterAns22 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans22.setAdapter(adapterAns22);

        Spinner ans23 = (Spinner) findViewById(R.id.ans23);
        ArrayAdapter<String> adapterAns23 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoVivienda);
        adapterAns23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans23.setAdapter(adapterAns23);

        Spinner ans24 = (Spinner) findViewById(R.id.ans24);
        ArrayAdapter<String> adapterAns24 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, materialTecho);
        adapterAns24.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans24.setAdapter(adapterAns24);

        Spinner ans25 = (Spinner) findViewById(R.id.ans25);
        ArrayAdapter<String> adapterAns25 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, materialPiso);
        adapterAns25.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans25.setAdapter(adapterAns25);

        Spinner ans26 = (Spinner) findViewById(R.id.ans26);
        ArrayAdapter<String> adapterAns26 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, materialPared);
        adapterAns26.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans26.setAdapter(adapterAns26);

        Spinner ans28 = (Spinner) findViewById(R.id.ans28);
        ArrayAdapter<String> adapterAns28 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans28.setAdapter(adapterAns28);

        Spinner ans29 = (Spinner) findViewById(R.id.ans29);
        ArrayAdapter<String> adapterAns29 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns29.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans29.setAdapter(adapterAns29);

        Spinner ans30 = (Spinner) findViewById(R.id.ans30);
        ArrayAdapter<String> adapterAns30 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns30.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans30.setAdapter(adapterAns30);

        Spinner ans31 = (Spinner) findViewById(R.id.ans31);
        ArrayAdapter<String> adapterAns31 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoEducacion);
        adapterAns31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans31.setAdapter(adapterAns31);

        Spinner ans32_1 = (Spinner) findViewById(R.id.ans32_1);
        ArrayAdapter<String> adapterAns32_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gradoEstudio);
        adapterAns32_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans32_1.setAdapter(adapterAns32_1);

        Spinner ans33 = (Spinner) findViewById(R.id.ans33);
        ArrayAdapter<String> adapterAns33 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, afiliacionSalud);
        adapterAns33.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans33.setAdapter(adapterAns33);

        Spinner ans33_1 = (Spinner) findViewById(R.id.ans33_1);
        ArrayAdapter<String> adapterAns33_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, establecimientoSalud);
        adapterAns33_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans33_1.setAdapter(adapterAns33_1);

        Spinner ans34 = (Spinner) findViewById(R.id.ans34);
        ArrayAdapter<String> adapterAns34 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, entidadesAcuicolas);
        adapterAns34.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans34.setAdapter(adapterAns34);

        Spinner ans39 = (Spinner) findViewById(R.id.ans39);
        ArrayAdapter<String> adapterAns39 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, periodicaPermanente);
        adapterAns39.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans39.setAdapter(adapterAns39);

        Spinner ans40 = (Spinner) findViewById(R.id.ans40);
        ArrayAdapter<String> adapterAns40 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns40.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans40.setAdapter(adapterAns40);

        Spinner ans40_1 = (Spinner) findViewById(R.id.ans40_1);
        ArrayAdapter<String> adapterAns40_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, entidadesCredito);
        adapterAns40_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans40_1.setAdapter(adapterAns40_1);

        Spinner ans41 = (Spinner) findViewById(R.id.ans41);
        ArrayAdapter<String> adapterAns41 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns41.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans41.setAdapter(adapterAns41);

        Spinner ans41_1 = (Spinner) findViewById(R.id.ans41_1);
        ArrayAdapter<String> adapterAns41_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, entidadesAsistencia);
        adapterAns41_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans41_1.setAdapter(adapterAns41_1);

        Spinner ans41_3 = (Spinner) findViewById(R.id.ans41_3);
        ArrayAdapter<String> adapterAns41_3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns41_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans41_3.setAdapter(adapterAns41_3);

        Spinner ans41_4 = (Spinner) findViewById(R.id.ans41_4);
        ArrayAdapter<String> adapterAns41_4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gratisPago);
        adapterAns41_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans41_4.setAdapter(adapterAns41_4);

        Spinner ans42 = (Spinner) findViewById(R.id.ans42);
        ArrayAdapter<String> adapterAns42 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns42.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans42.setAdapter(adapterAns42);

        Spinner ans42_1 = (Spinner) findViewById(R.id.ans42_1);
        ArrayAdapter<String> adapterAns42_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, entidadesAsistencia);
        adapterAns42_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans42_1.setAdapter(adapterAns42_1);

        Spinner ans42_3 = (Spinner) findViewById(R.id.ans42_3);
        ArrayAdapter<String> adapterAns42_3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns42_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans42_3.setAdapter(adapterAns42_3);

        Spinner ans42_4 = (Spinner) findViewById(R.id.ans42_4);
        ArrayAdapter<String> adapterAns42_4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gratisPago);
        adapterAns42_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans42_4.setAdapter(adapterAns42_4);

        nextButton =  (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //try {
                    Intent preg2 = new Intent(getApplicationContext(), Preguntas2.class);
                    startActivity(preg2);

                /*} catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
        });
    }
}
