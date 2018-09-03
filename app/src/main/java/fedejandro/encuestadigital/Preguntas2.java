package fedejandro.encuestadigital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Preguntas2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas2);

        String[] tipoActividad = new String[] {
                "Principal", "Complementaria"
        };
        Spinner ans44 = (Spinner) findViewById(R.id.ans44);
        ArrayAdapter<String> adapterAns44 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoActividad);
        adapterAns44.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans44.setAdapter(adapterAns44);

        String[] actividadPrincipal = new String[] {
                "Agricultura", "Comercio", "Construcción", "Ganadería", "Minería", "Turismo", "Pesca", "Transporte", "Otra, ¿Cuál?"
        };
        Spinner ans44_1 = (Spinner) findViewById(R.id.ans44_1);
        ArrayAdapter<String> adapterAns44_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, actividadPrincipal);
        adapterAns44_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans44_1.setAdapter(adapterAns44_1);

        String[] tipoUnidad = new String[] {
                "Propia", "Arrendada", "Familiar", "Posesión", "Otra, ¿Cuál?"
        };
        Spinner ans46 = (Spinner) findViewById(R.id.ans46);
        ArrayAdapter<String> adapterAns46 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoUnidad);
        adapterAns46.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans46.setAdapter(adapterAns46);

        String[] tipoCultivo = new String[] {
                "Estanques", "Jaulas"
        };
        Spinner ans47 = (Spinner) findViewById(R.id.ans47);
        ArrayAdapter<String> adapterAns47 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoCultivo);
        adapterAns47.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans47.setAdapter(adapterAns47);

        String[] sistemaCultivo = new String[] {
                "Semi intensivo", "Intensivo", "Super intensivo"
        };
        Spinner ans48 = (Spinner) findViewById(R.id.ans48);
        ArrayAdapter<String> adapterAns48 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sistemaCultivo);
        adapterAns48.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans48.setAdapter(adapterAns48);

        String[] fuenteAgua = new String[] {
                "Agua lluvia", "Ríos/Canales", "Lagos/Embalses", "Diques", "Pozos profundos/Pozos entubados", "Pozos poco profundos", "Abastecimiento municipal de aguas", "Aguas residuales tratadas", "Otra, ¿Cuál?"
        };
        Spinner ans54 = (Spinner) findViewById(R.id.ans54);
        ArrayAdapter<String> adapterAns54 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fuenteAgua);
        adapterAns54.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans54.setAdapter(adapterAns54);

        String[] transporteAgua = new String[] {
                "Por gravedad", "Por bombeo"
        };
        Spinner ans55 = (Spinner) findViewById(R.id.ans55);
        ArrayAdapter<String> adapterAns55 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, transporteAgua);
        adapterAns55.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans55.setAdapter(adapterAns55);

        String[] tipoSuelos = new String[] {
                "Sí", "No"
        };
        Spinner ans59 = (Spinner) findViewById(R.id.ans59);
        ArrayAdapter<String> adapterAns59 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoSuelos);
        adapterAns59.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans59.setAdapter(adapterAns59);

        String[] pagoAgua = new String[] {
                "Sí", "No"
        };
        Spinner ans61 = (Spinner) findViewById(R.id.ans61);
        ArrayAdapter<String> adapterAns61 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pagoAgua);
        adapterAns61.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans61.setAdapter(adapterAns61);

        String[] paramAgua = new String[] {
                "Sí", "No"
        };
        Spinner ans62 = (Spinner) findViewById(R.id.ans62);
        ArrayAdapter<String> adapterAns62 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paramAgua);
        adapterAns62.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans62.setAdapter(adapterAns62);

        String[] contamAgua = new String[] {
                "Sí", "No"
        };
        Spinner ans63 = (Spinner) findViewById(R.id.ans63);
        ArrayAdapter<String> adapterAns63 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, contamAgua);
        adapterAns63.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans63.setAdapter(adapterAns63);

        String[] destinoProd = new String[] {
                "Autoconsumo", "Comercialización"
        };
        Spinner ans64 = (Spinner) findViewById(R.id.ans64);
        ArrayAdapter<String> adapterAns64 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, destinoProd);
        adapterAns64.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans64.setAdapter(adapterAns64);

        String[] tipoProd = new String[] {
                "Producción de animales para engorde", "Producción de alevines", "Ciclo completo", "Producción de peces ornamentales", "Producción de plantas", "Producción combinda de plantas y animales \n(hidropónica)","Procesamiento y/o transformación de productos", "Fines recreativos (pesca deportiva)", "Animales para ensayos/conservación/otros"
        };
        Spinner ans65 = (Spinner) findViewById(R.id.ans65);
        ArrayAdapter<String> adapterAns65 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoProd);
        adapterAns65.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans65.setAdapter(adapterAns65);

        String[] practica = new String[] {
                "Monocultivo", "Policultivo"
        };
        Spinner ans67 = (Spinner) findViewById(R.id.ans67);
        ArrayAdapter<String> adapterAns67 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, practica);
        adapterAns67.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans67.setAdapter(adapterAns67);
    }
}
