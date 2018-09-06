package fedejandro.encuestadigital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Preguntas3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas3);

        String[] formaPesca = new String[] {
                "Permanente", "Ocasional", "Temporal", "Otra, ¿Cuál?"
        };
        String[] tipoActividad = new String[] {
                "Principal", "Complementaria"
        };
        String[] actividadPrincipal = new String[] {
                "Agricultura", "Comercio", "Construcción", "Ganadería", "Minería", "Turismo", "Acuicultura", "Transporte", "Otra, ¿Cuál?"
        };
        String[] siNo = new String[] {
                "Sí", "No"
        };
        String[] permiso = new String[] {
                "Autoridad pesquera", "La comunidad", "Asociación de pescadores", "Otro, ¿Cuál?"
        };
        String[] lugarPesca = new String[] {
                "Río", "Ciénaga", "Embalse", "Quebrada", "Caño"
        };
        String[] tiempoDia = new String[] {
                "Mañana", "Tarde", "Noche", "Madrugada"
        };
        String[] destinoProductos = new String[] {
                "Autoconsumo", "Comercialización"
        };
        String[] desastres = new String[] {
                "Inundaciones", "Sequías", "Vientos fuertes", "Sismos", "Otras, ¿Cuáles?", "Ninguno"
        };
        String[] disminucionCaptura = new String[] {
                "Menor al 20% (Pérdidas mínimas)", "Entre el 20% y el 40% (Pérdidas moderadas)", "Mayor al 40% (Perdidas graves)"
        };
        String[] predadores = new String[] {
                "Aves", "Anfibios", "Réptiles", "Insectos", "Peces", "Manatíes", "Nutrias", "Otros, ¿Cuáles?", "Ninguno"
        };
        String[] tipoEmbarcacion = new String[] {
                "Bote", "Lancha", "Canoa", "Cayuco", "Otro, ¿Cuál?"
        };
        String[] materialEmbarcacion = new String[] {
                "Madera", "Fibra de vidrio", "Madera revestida en fibra", "Otro, ¿Cuál?"
        };
        String[] propulsion = new String[] {
                "Vela", "Remo", "Motor fuera de borda ", "Otro, ¿Cuál?"
        };
        String[] duenoEmbarcacion = new String[] {
                "Propia", "Alquilada", "Prestada", "Cooperativa", "Otro, ¿Cuál?"
        };
        String[] instalacion = new String[] {
                "Propia", "Arrendada", "Otro tipo de tenencia, ¿Cuál?"
        };


        Spinner ans43 = (Spinner) findViewById(R.id.ans43);
        ArrayAdapter<String> adapterAns43 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, formaPesca);
        adapterAns43.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans43.setAdapter(adapterAns43);

        Spinner ans44 = (Spinner) findViewById(R.id.ans44);
        ArrayAdapter<String> adapterAns44 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoActividad);
        adapterAns44.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans44.setAdapter(adapterAns44);

        Spinner ans44_1 = (Spinner) findViewById(R.id.ans44_1);
        ArrayAdapter<String> adapterAns44_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, actividadPrincipal);
        adapterAns44_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans44_1.setAdapter(adapterAns44_1);

        Spinner ans45 = (Spinner) findViewById(R.id.ans45);
        ArrayAdapter<String> adapterAns45 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns45.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans45.setAdapter(adapterAns45);

        Spinner ans45_1 = (Spinner) findViewById(R.id.ans45_1);
        ArrayAdapter<String> adapterAns45_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, permiso);
        adapterAns45_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans45_1.setAdapter(adapterAns45_1);

        Spinner ans46 = (Spinner) findViewById(R.id.ans46);
        ArrayAdapter<String> adapterAns46 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns46.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans46.setAdapter(adapterAns46);

        Spinner ans47 = (Spinner) findViewById(R.id.ans47);
        ArrayAdapter<String> adapterAns47 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lugarPesca);
        adapterAns47.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans47.setAdapter(adapterAns47);

        Spinner ans49 = (Spinner) findViewById(R.id.ans49);
        ArrayAdapter<String> adapterAns49 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tiempoDia);
        adapterAns49.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans49.setAdapter(adapterAns49);

        Spinner ans50 = (Spinner) findViewById(R.id.ans50);
        ArrayAdapter<String> adapterAns50 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, destinoProductos);
        adapterAns50.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans50.setAdapter(adapterAns50);

        Spinner ans51 = (Spinner) findViewById(R.id.ans51);
        ArrayAdapter<String> adapterAns51 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns51.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans51.setAdapter(adapterAns51);

        Spinner ans52 = (Spinner) findViewById(R.id.ans52);
        ArrayAdapter<String> adapterAns52 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns52.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans52.setAdapter(adapterAns52);

        Spinner ans65 = (Spinner) findViewById(R.id.ans65);
        ArrayAdapter<String> adapterAns65 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, destinoProductos);
        adapterAns65.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans65.setAdapter(adapterAns65);

        Spinner ans76 = (Spinner) findViewById(R.id.ans76);
        ArrayAdapter<String> adapterAns76 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns76.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans76.setAdapter(adapterAns76);

        Spinner ans78_1 = (Spinner) findViewById(R.id.ans78_1);
        ArrayAdapter<String> adapterAns78_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns78_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans78_1.setAdapter(adapterAns78_1);

        Spinner ans79 = (Spinner) findViewById(R.id.ans79);
        ArrayAdapter<String> adapterAns79 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns79.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans79.setAdapter(adapterAns79);

        Spinner ans80_1 = (Spinner) findViewById(R.id.ans80_1);
        ArrayAdapter<String> adapterAns80_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, disminucionCaptura);
        adapterAns80_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans80_1.setAdapter(adapterAns80_1);

        Spinner ans81 = (Spinner) findViewById(R.id.ans81);
        ArrayAdapter<String> adapterAns81 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, predadores);
        adapterAns81.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans81.setAdapter(adapterAns81);

        Spinner ans82 = (Spinner) findViewById(R.id.ans82);
        ArrayAdapter<String> adapterAns82 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns82.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans82.setAdapter(adapterAns82);

        Spinner ans83 = (Spinner) findViewById(R.id.ans83);
        ArrayAdapter<String> adapterAns83 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns83.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans83.setAdapter(adapterAns83);

        Spinner ans83_2 = (Spinner) findViewById(R.id.ans83_2);
        ArrayAdapter<String> adapterAns83_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoEmbarcacion);
        adapterAns83_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans83_2.setAdapter(adapterAns83_2);

        Spinner ans83_3 = (Spinner) findViewById(R.id.ans83_3);
        ArrayAdapter<String> adapterAns83_3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, materialEmbarcacion);
        adapterAns83_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans83_3.setAdapter(adapterAns83_3);

        Spinner ans83_4 = (Spinner) findViewById(R.id.ans83_4);
        ArrayAdapter<String> adapterAns83_4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, propulsion);
        adapterAns83_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans83_4.setAdapter(adapterAns83_4);

        Spinner ans83_6 = (Spinner) findViewById(R.id.ans83_6);
        ArrayAdapter<String> adapterAns83_6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, duenoEmbarcacion);
        adapterAns83_6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans83_6.setAdapter(adapterAns83_6);

        Spinner ans83_7 = (Spinner) findViewById(R.id.ans83_7);
        ArrayAdapter<String> adapterAns83_7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns83_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans83_7.setAdapter(adapterAns83_7);

        Spinner ans83_8 = (Spinner) findViewById(R.id.ans83_8);
        ArrayAdapter<String> adapterAns83_8 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns83_8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans83_8.setAdapter(adapterAns83_8);

        Spinner ans85 = (Spinner) findViewById(R.id.ans85);
        ArrayAdapter<String> adapterAns85 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns85.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans85.setAdapter(adapterAns85);

        Spinner ans85_1 = (Spinner) findViewById(R.id.ans85_1);
        ArrayAdapter<String> adapterAns85_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, instalacion);
        adapterAns85_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans85_1.setAdapter(adapterAns85_1);

        Spinner ans86 = (Spinner) findViewById(R.id.ans86);
        ArrayAdapter<String> adapterAns86 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns86.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans86.setAdapter(adapterAns86);

        Spinner ans86_1 = (Spinner) findViewById(R.id.ans86_1);
        ArrayAdapter<String> adapterAns86_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, instalacion);
        adapterAns86_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans86_1.setAdapter(adapterAns86_1);

        Spinner ans87 = (Spinner) findViewById(R.id.ans87);
        ArrayAdapter<String> adapterAns87 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns87.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans87.setAdapter(adapterAns87);

        Spinner ans87_1 = (Spinner) findViewById(R.id.ans87_1);
        ArrayAdapter<String> adapterAns87_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, instalacion);
        adapterAns87_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans87_1.setAdapter(adapterAns87_1);
    }
}
