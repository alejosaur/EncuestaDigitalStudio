package fedejandro.encuestadigital;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.*;

public class Preguntas3 extends AppCompatActivity {

    private String filename = "datos.txt";
    private String filepath = "EncuestaDatos";
    File myExternalFile;

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
        String[] fuentesEnergia = new String[] {
                "Red eléctrica publica", "Generador eléctrico a gasolina o diésel", "Energía solar", "Energía eólica", "Combustibles fósiles", "Otra, ¿Cuál?"
        };
        String[] tipoAsociacion = new String[] {
                "Cooperativa", "Asociación ", "Sindicato", "Otra, ¿Cuál?"
        };
        String[] departamentos = new String[] {
                "Amazonas","Antioquia","Arauca","Atlántico","Bolívar","Boyacá","Caldas","Caquetá","Casanare","Cauca","Cesar","Chocó","Córdoba","Cundinamarca","Guainía","Guaviare","Huila","La Guajira","Magdalena","Meta","Nariño","Norte de Santander","Putumayo","Quindío","Risaralda","San Andrés y Providencia","Santander","Sucre","Tolima","Valle del Cauca","Vaupés","Vichada"
        };
        String[] lugarVenta = new String[] {
                "Venta en el lugar de desembarco", "Centro de acopio", "Centro de comercialización"
        };
        String[] compradores = new String[] {
                "Intermediario", "Almacén de cadena", "Restaurante", "Consumidor final"
        };
        String[] presentacion = new String[] {
                "Entero", "Vivo", "Eviscerado", "Empacado en canastillas", "Empacado al vacío", "Seco", "Salado", "Sin escama", "Sin branquias", "Postas", "Descabezado", "Otro, ¿Cuál?"
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

        Spinner ans88 = (Spinner) findViewById(R.id.ans88);
        ArrayAdapter<String> adapterAns88 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns88.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans88.setAdapter(adapterAns88);

        Spinner ans89 = (Spinner) findViewById(R.id.ans89);
        ArrayAdapter<String> adapterAns89 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns89.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans89.setAdapter(adapterAns89);

        Spinner ans90 = (Spinner) findViewById(R.id.ans90);
        ArrayAdapter<String> adapterAns90 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns90.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans90.setAdapter(adapterAns90);

        Spinner ans91 = (Spinner) findViewById(R.id.ans91);
        ArrayAdapter<String> adapterAns91 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns91.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans91.setAdapter(adapterAns91);

        Spinner ans92 = (Spinner) findViewById(R.id.ans92);
        ArrayAdapter<String> adapterAns92 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns92.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans92.setAdapter(adapterAns92);

        Spinner ans93 = (Spinner) findViewById(R.id.ans93);
        ArrayAdapter<String> adapterAns93 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns93.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans93.setAdapter(adapterAns93);

        Spinner ans93_1 = (Spinner) findViewById(R.id.ans93_1);
        ArrayAdapter<String> adapterAns93_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns93_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans93_1.setAdapter(adapterAns93_1);

        Spinner ans94 = (Spinner) findViewById(R.id.ans94);
        ArrayAdapter<String> adapterAns94 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns94.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans94.setAdapter(adapterAns94);

        Spinner ans94_1 = (Spinner) findViewById(R.id.ans94_1);
        ArrayAdapter<String> adapterAns94_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns94_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans94_1.setAdapter(adapterAns94_1);

        Spinner ans95 = (Spinner) findViewById(R.id.ans95);
        ArrayAdapter<String> adapterAns95 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns95.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans95.setAdapter(adapterAns95);

        Spinner ans95_1 = (Spinner) findViewById(R.id.ans95_1);
        ArrayAdapter<String> adapterAns95_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns95_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans95_1.setAdapter(adapterAns95_1);

        Spinner ans96 = (Spinner) findViewById(R.id.ans96);
        ArrayAdapter<String> adapterAns96 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fuentesEnergia);
        adapterAns96.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans96.setAdapter(adapterAns96);

        Spinner ans97 = (Spinner) findViewById(R.id.ans97);
        ArrayAdapter<String> adapterAns97 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns97.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans97.setAdapter(adapterAns97);

        Spinner ans97_1 = (Spinner) findViewById(R.id.ans97_1);
        ArrayAdapter<String> adapterAns97_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoAsociacion);
        adapterAns97_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans97_1.setAdapter(adapterAns97_1);

        Spinner ans97_2 = (Spinner) findViewById(R.id.ans97_2);
        ArrayAdapter<String> adapterAns97_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns97_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans97_2.setAdapter(adapterAns97_2);

        Spinner ans97_7 = (Spinner) findViewById(R.id.ans97_7);
        ArrayAdapter<String> adapterAns97_7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, departamentos);
        adapterAns97_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans97_7.setAdapter(adapterAns97_7);

        Spinner ans97_9 = (Spinner) findViewById(R.id.ans97_9);
        ArrayAdapter<String> adapterAns97_9 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns97_9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans97_9.setAdapter(adapterAns97_9);

        Spinner ans98 = (Spinner) findViewById(R.id.ans98);
        ArrayAdapter<String> adapterAns98 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns98.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans98.setAdapter(adapterAns98);

        Spinner ans102 = (Spinner) findViewById(R.id.ans102);
        ArrayAdapter<String> adapterAns102 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lugarVenta);
        adapterAns102.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans102.setAdapter(adapterAns102);

        Spinner ans103 = (Spinner) findViewById(R.id.ans103);
        ArrayAdapter<String> adapterAns103 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, compradores);
        adapterAns103.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans103.setAdapter(adapterAns103);

        Spinner ans105 = (Spinner) findViewById(R.id.ans105);
        ArrayAdapter<String> adapterAns105 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, presentacion);
        adapterAns105.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans105.setAdapter(adapterAns105);

        Spinner ans106 = (Spinner) findViewById(R.id.ans106);
        ArrayAdapter<String> adapterAns106 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns106.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans106.setAdapter(adapterAns106);

        Spinner ans107 = (Spinner) findViewById(R.id.ans107);
        ArrayAdapter<String> adapterAns107 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns107.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans107.setAdapter(adapterAns107);

        Spinner ans108 = (Spinner) findViewById(R.id.ans108);
        ArrayAdapter<String> adapterAns108 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns108.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans108.setAdapter(adapterAns108);

        Spinner ans109 = (Spinner) findViewById(R.id.ans109);
        ArrayAdapter<String> adapterAns109 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns109.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans109.setAdapter(adapterAns109);

        Spinner ans110 = (Spinner) findViewById(R.id.ans110);
        ArrayAdapter<String> adapterAns110 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns110.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans110.setAdapter(adapterAns110);

        EditText ans43other = (EditText) findViewById(R.id.ans43other);
        ans43other.setVisibility(View.GONE);

        EditText ans44_1other = (EditText) findViewById(R.id.ans44_1other);
        ans44_1other.setVisibility(View.GONE);

        EditText ans45_1other = (EditText) findViewById(R.id.ans45_1other);
        ans45_1other.setVisibility(View.GONE);

        EditText ans77other = (EditText) findViewById(R.id.ans77other);
        ans77other.setVisibility(View.GONE);

        EditText ans80other = (EditText) findViewById(R.id.ans80other);
        ans80other.setVisibility(View.GONE);

        EditText ans81other = (EditText) findViewById(R.id.ans81other);
        ans81other.setVisibility(View.GONE);

        EditText ans83_2other = (EditText) findViewById(R.id.ans83_2other);
        ans83_2other.setVisibility(View.GONE);

        EditText ans83_3other = (EditText) findViewById(R.id.ans83_3other);
        ans83_3other.setVisibility(View.GONE);

        EditText ans83_4other = (EditText) findViewById(R.id.ans83_4other);
        ans83_4other.setVisibility(View.GONE);

        EditText ans83_6other = (EditText) findViewById(R.id.ans83_6other);
        ans83_6other.setVisibility(View.GONE);

        EditText ans84other = (EditText) findViewById(R.id.ans84other);
        ans84other.setVisibility(View.GONE);

        EditText ans85_1other = (EditText) findViewById(R.id.ans85_1other);
        ans85_1other.setVisibility(View.GONE);

        EditText ans86_1other = (EditText) findViewById(R.id.ans86_1other);
        ans86_1other.setVisibility(View.GONE);

        EditText ans87_1other = (EditText) findViewById(R.id.ans87_1other);
        ans87_1other.setVisibility(View.GONE);

        EditText ans96other = (EditText) findViewById(R.id.ans96other);
        ans96other.setVisibility(View.GONE);

        EditText ans97_1other = (EditText) findViewById(R.id.ans97_1other);
        ans97_1other.setVisibility(View.GONE);

        EditText ans105other = (EditText) findViewById(R.id.ans105other);
        ans105other.setVisibility(View.GONE);

        CheckBox ans77k = (CheckBox) findViewById(R.id.ans77k);
        CheckBox ans80e = (CheckBox) findViewById(R.id.ans80e);
        CheckBox ans84j = (CheckBox) findViewById(R.id.ans84j);

        ans43.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans43 = (Spinner) findViewById(R.id.ans43);
                EditText ans43other = (EditText) findViewById(R.id.ans43other);
                if(ans43.getSelectedItemPosition()==3) {
                    ans43other.setVisibility(View.VISIBLE);
                }else{
                    ans43other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans44_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans44_1 = (Spinner) findViewById(R.id.ans44_1);
                EditText ans44_1other = (EditText) findViewById(R.id.ans44_1other);
                if(ans44_1.getSelectedItemPosition()==8) {
                    ans44_1other.setVisibility(View.VISIBLE);
                }else{
                    ans44_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans45_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans45_1 = (Spinner) findViewById(R.id.ans45_1);
                EditText ans45_1other = (EditText) findViewById(R.id.ans45_1other);
                if(ans45_1.getSelectedItemPosition()==3) {
                    ans45_1other.setVisibility(View.VISIBLE);
                }else{
                    ans45_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans77k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans77k = (CheckBox) findViewById(R.id.ans77k);
                EditText ans77other = (EditText) findViewById(R.id.ans77other);
                if(ans77k.isChecked()){
                    ans77other.setVisibility(View.VISIBLE);
                }
                else {
                    ans77other.setVisibility(View.GONE);
                }
            }
        });

        ans80e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans80e = (CheckBox) findViewById(R.id.ans80e);
                EditText ans80other = (EditText) findViewById(R.id.ans80other);
                if(ans80e.isChecked()){
                    ans80other.setVisibility(View.VISIBLE);
                }
                else {
                    ans80other.setVisibility(View.GONE);
                }
            }
        });

        ans81.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans81 = (Spinner) findViewById(R.id.ans81);
                EditText ans81other = (EditText) findViewById(R.id.ans81other);
                if(ans81.getSelectedItemPosition()==7) {
                    ans81other.setVisibility(View.VISIBLE);
                }else{
                    ans81other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans83_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans83_2 = (Spinner) findViewById(R.id.ans83_2);
                EditText ans83_2other = (EditText) findViewById(R.id.ans83_2other);
                if(ans83_2.getSelectedItemPosition()==4) {
                    ans83_2other.setVisibility(View.VISIBLE);
                }else{
                    ans83_2other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans83_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans83_3 = (Spinner) findViewById(R.id.ans83_3);
                EditText ans83_3other = (EditText) findViewById(R.id.ans83_3other);
                if(ans83_3.getSelectedItemPosition()==3) {
                    ans83_3other.setVisibility(View.VISIBLE);
                }else{
                    ans83_3other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans83_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans83_4 = (Spinner) findViewById(R.id.ans83_4);
                EditText ans83_4other = (EditText) findViewById(R.id.ans83_4other);
                if(ans83_4.getSelectedItemPosition()==3) {
                    ans83_4other.setVisibility(View.VISIBLE);
                }else{
                    ans83_4other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans83_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans83_6 = (Spinner) findViewById(R.id.ans83_6);
                EditText ans83_6other = (EditText) findViewById(R.id.ans83_6other);
                if(ans83_6.getSelectedItemPosition()==4) {
                    ans83_6other.setVisibility(View.VISIBLE);
                }else{
                    ans83_6other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans84j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans84j = (CheckBox) findViewById(R.id.ans84j);
                EditText ans84other = (EditText) findViewById(R.id.ans84other);
                if(ans84j.isChecked()){
                    ans84other.setVisibility(View.VISIBLE);
                }
                else {
                    ans84other.setVisibility(View.GONE);
                }
            }
        });

        ans85_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans85_1 = (Spinner) findViewById(R.id.ans85_1);
                EditText ans85_1other = (EditText) findViewById(R.id.ans85_1other);
                if(ans85_1.getSelectedItemPosition()==2) {
                    ans85_1other.setVisibility(View.VISIBLE);
                }else{
                    ans85_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans86_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans86_1 = (Spinner) findViewById(R.id.ans86_1);
                EditText ans86_1other = (EditText) findViewById(R.id.ans86_1other);
                if(ans86_1.getSelectedItemPosition()==2) {
                    ans86_1other.setVisibility(View.VISIBLE);
                }else{
                    ans86_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans87_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans87_1 = (Spinner) findViewById(R.id.ans87_1);
                EditText ans87_1other = (EditText) findViewById(R.id.ans87_1other);
                if(ans87_1.getSelectedItemPosition()==2) {
                    ans87_1other.setVisibility(View.VISIBLE);
                }else{
                    ans87_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans96.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans96 = (Spinner) findViewById(R.id.ans96);
                EditText ans96other = (EditText) findViewById(R.id.ans96other);
                if(ans96.getSelectedItemPosition()==5) {
                    ans96other.setVisibility(View.VISIBLE);
                }else{
                    ans96other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans97_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans97_1 = (Spinner) findViewById(R.id.ans97_1);
                EditText ans97_1other = (EditText) findViewById(R.id.ans97_1other);
                if(ans97_1.getSelectedItemPosition()==3) {
                    ans97_1other.setVisibility(View.VISIBLE);
                }else{
                    ans97_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans105.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans105 = (Spinner) findViewById(R.id.ans105);
                EditText ans105other = (EditText) findViewById(R.id.ans105other);
                if(ans105.getSelectedItemPosition()==11) {
                    ans105other.setVisibility(View.VISIBLE);
                }else{
                    ans105other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {

        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }

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

    private void escribir(){

        try {

            EditText ans47_1 = (EditText) findViewById(R.id.ans47_1);
            EditText ans47_2 = (EditText) findViewById(R.id.ans47_2);
            EditText ans48 = (EditText) findViewById(R.id.ans48);
            EditText ans48_1 = (EditText) findViewById(R.id.ans48_1);
            EditText ans53 = (EditText) findViewById(R.id.ans53);
            EditText ans53_1 = (EditText) findViewById(R.id.ans53_1);
            EditText ans53_2 = (EditText) findViewById(R.id.ans53_2);
            EditText ans53_3 = (EditText) findViewById(R.id.ans53_3);
            EditText ans53_4 = (EditText) findViewById(R.id.ans53_4);
            EditText ans54 = (EditText) findViewById(R.id.ans54);
            EditText ans54_1 = (EditText) findViewById(R.id.ans54_1);
            EditText ans54_2 = (EditText) findViewById(R.id.ans54_2);
            EditText ans54_3 = (EditText) findViewById(R.id.ans54_3);
            EditText ans54_4 = (EditText) findViewById(R.id.ans54_4);
            EditText ans54_5 = (EditText) findViewById(R.id.ans54_5);
            EditText ans54_6 = (EditText) findViewById(R.id.ans54_6);
            EditText ans55 = (EditText) findViewById(R.id.ans55);
            EditText ans56 = (EditText) findViewById(R.id.ans56);
            EditText ans57 = (EditText) findViewById(R.id.ans57);
            EditText ans58 = (EditText) findViewById(R.id.ans58);
            EditText ans59 = (EditText) findViewById(R.id.ans59);
            EditText ans60 = (EditText) findViewById(R.id.ans60);
            EditText ans61 = (EditText) findViewById(R.id.ans61);
            EditText ans62 = (EditText) findViewById(R.id.ans62);
            EditText ans63 = (EditText) findViewById(R.id.ans63);
            EditText ans64 = (EditText) findViewById(R.id.ans64);
            EditText ans65_1 = (EditText) findViewById(R.id.ans65_1);
            EditText ans65_2 = (EditText) findViewById(R.id.ans65_2);
            EditText ans66 = (EditText) findViewById(R.id.ans66);
            EditText ans66_1 = (EditText) findViewById(R.id.ans66_1);
            EditText ans67 = (EditText) findViewById(R.id.ans67);
            EditText ans67_1 = (EditText) findViewById(R.id.ans67_1);
            EditText ans68 = (EditText) findViewById(R.id.ans68);
            EditText ans68_1 = (EditText) findViewById(R.id.ans68_1);
            EditText ans69 = (EditText) findViewById(R.id.ans69);
            EditText ans69_1 = (EditText) findViewById(R.id.ans69_1);
            EditText ans70 = (EditText) findViewById(R.id.ans70);
            EditText ans70_1 = (EditText) findViewById(R.id.ans70_1);
            EditText ans71 = (EditText) findViewById(R.id.ans71);
            EditText ans71_1 = (EditText) findViewById(R.id.ans71_1);
            EditText ans72 = (EditText) findViewById(R.id.ans72);
            EditText ans72_1 = (EditText) findViewById(R.id.ans72_1);
            EditText ans73 = (EditText) findViewById(R.id.ans73);
            EditText ans73_1 = (EditText) findViewById(R.id.ans73_1);
            EditText ans74 = (EditText) findViewById(R.id.ans74);
            EditText ans74_1 = (EditText) findViewById(R.id.ans74_1);
            EditText ans75 = (EditText) findViewById(R.id.ans75);
            EditText ans75_1 = (EditText) findViewById(R.id.ans75_1);
            EditText ans78 = (EditText) findViewById(R.id.ans78);
            EditText ans79_1 = (EditText) findViewById(R.id.ans79_1);
            EditText ans83_1 = (EditText) findViewById(R.id.ans83_1);
            EditText ans83_5 = (EditText) findViewById(R.id.ans83_5);
            EditText ans83_9 = (EditText) findViewById(R.id.ans83_9);
            EditText ans84_1 = (EditText) findViewById(R.id.ans84_1);
            EditText ans84_2 = (EditText) findViewById(R.id.ans84_2);
            EditText ans84_3 = (EditText) findViewById(R.id.ans84_3);
            EditText ans84_4 = (EditText) findViewById(R.id.ans84_4);
            EditText ans84_5 = (EditText) findViewById(R.id.ans84_5);
            EditText ans84_6 = (EditText) findViewById(R.id.ans84_6);
            EditText ans84_7 = (EditText) findViewById(R.id.ans84_7);
            EditText ans84_8 = (EditText) findViewById(R.id.ans84_8);
            EditText ans84_9 = (EditText) findViewById(R.id.ans84_9);
            EditText ans84_10 = (EditText) findViewById(R.id.ans84_10);
            EditText ans88_1 = (EditText) findViewById(R.id.ans88_1);
            EditText ans90_1 = (EditText) findViewById(R.id.ans90_1);
            EditText ans97_3 = (EditText) findViewById(R.id.ans97_3);
            EditText ans97_4 = (EditText) findViewById(R.id.ans97_4);
            EditText ans97_5 = (EditText) findViewById(R.id.ans97_5);
            EditText ans97_6 = (EditText) findViewById(R.id.ans97_6);
            EditText ans97_8 = (EditText) findViewById(R.id.ans97_8);
            EditText ans98_1 = (EditText) findViewById(R.id.ans98_1);
            EditText ans99 = (EditText) findViewById(R.id.ans99);
            EditText ans100 = (EditText) findViewById(R.id.ans100);
            EditText ans101 = (EditText) findViewById(R.id.ans101);
            EditText ans104 = (EditText) findViewById(R.id.ans104);
            EditText ans107_1 = (EditText) findViewById(R.id.ans107_1);

            Spinner ans43 = (Spinner) findViewById(R.id.ans43);
            Spinner ans44 = (Spinner) findViewById(R.id.ans44);
            Spinner ans44_1 = (Spinner) findViewById(R.id.ans44_1);
            Spinner ans45 = (Spinner) findViewById(R.id.ans45);
            Spinner ans45_1 = (Spinner) findViewById(R.id.ans45_1);
            Spinner ans46 = (Spinner) findViewById(R.id.ans46);
            Spinner ans47 = (Spinner) findViewById(R.id.ans47);
            Spinner ans49 = (Spinner) findViewById(R.id.ans49);
            Spinner ans50 = (Spinner) findViewById(R.id.ans50);
            Spinner ans51 = (Spinner) findViewById(R.id.ans51);
            Spinner ans52 = (Spinner) findViewById(R.id.ans52);
            Spinner ans65 = (Spinner) findViewById(R.id.ans65);
            Spinner ans76 = (Spinner) findViewById(R.id.ans76);
            Spinner ans78_1 = (Spinner) findViewById(R.id.ans78_1);
            Spinner ans79 = (Spinner) findViewById(R.id.ans79);
            Spinner ans80_1 = (Spinner) findViewById(R.id.ans80_1);
            Spinner ans81 = (Spinner) findViewById(R.id.ans81);
            Spinner ans82 = (Spinner) findViewById(R.id.ans82);
            Spinner ans83 = (Spinner) findViewById(R.id.ans83);
            Spinner ans83_2 = (Spinner) findViewById(R.id.ans83_2);
            Spinner ans83_3 = (Spinner) findViewById(R.id.ans83_3);
            Spinner ans83_4 = (Spinner) findViewById(R.id.ans83_4);
            Spinner ans83_6 = (Spinner) findViewById(R.id.ans83_6);
            Spinner ans83_7 = (Spinner) findViewById(R.id.ans83_7);
            Spinner ans83_8 = (Spinner) findViewById(R.id.ans83_8);
            Spinner ans85 = (Spinner) findViewById(R.id.ans85);
            Spinner ans85_1 = (Spinner) findViewById(R.id.ans85_1);
            Spinner ans86 = (Spinner) findViewById(R.id.ans86);
            Spinner ans86_1 = (Spinner) findViewById(R.id.ans86_1);
            Spinner ans87 = (Spinner) findViewById(R.id.ans87);
            Spinner ans87_1 = (Spinner) findViewById(R.id.ans87_1);
            Spinner ans88 = (Spinner) findViewById(R.id.ans88);
            Spinner ans89 = (Spinner) findViewById(R.id.ans89);
            Spinner ans90 = (Spinner) findViewById(R.id.ans90);
            Spinner ans91 = (Spinner) findViewById(R.id.ans91);
            Spinner ans92 = (Spinner) findViewById(R.id.ans92);
            Spinner ans93 = (Spinner) findViewById(R.id.ans93);
            Spinner ans93_1 = (Spinner) findViewById(R.id.ans93_1);
            Spinner ans94 = (Spinner) findViewById(R.id.ans94);
            Spinner ans94_1 = (Spinner) findViewById(R.id.ans94_1);
            Spinner ans95 = (Spinner) findViewById(R.id.ans95);
            Spinner ans95_1 = (Spinner) findViewById(R.id.ans95_1);
            Spinner ans96 = (Spinner) findViewById(R.id.ans96);
            Spinner ans97 = (Spinner) findViewById(R.id.ans97);
            Spinner ans97_1 = (Spinner) findViewById(R.id.ans97_1);
            Spinner ans97_2 = (Spinner) findViewById(R.id.ans97_2);
            Spinner ans97_7 = (Spinner) findViewById(R.id.ans97_7);
            Spinner ans97_9 = (Spinner) findViewById(R.id.ans97_9);
            Spinner ans98 = (Spinner) findViewById(R.id.ans98);
            Spinner ans102 = (Spinner) findViewById(R.id.ans102);
            Spinner ans103 = (Spinner) findViewById(R.id.ans103);
            Spinner ans105 = (Spinner) findViewById(R.id.ans105);
            Spinner ans106 = (Spinner) findViewById(R.id.ans106);
            Spinner ans107 = (Spinner) findViewById(R.id.ans107);
            Spinner ans108 = (Spinner) findViewById(R.id.ans108);
            Spinner ans109 = (Spinner) findViewById(R.id.ans109);
            Spinner ans110 = (Spinner) findViewById(R.id.ans110);

            EditText ans43other = (EditText) findViewById(R.id.ans43other);
            EditText ans44_1other = (EditText) findViewById(R.id.ans44_1other);
            EditText ans45_1other = (EditText) findViewById(R.id.ans45_1other);
            EditText ans77other = (EditText) findViewById(R.id.ans77other);
            EditText ans80other = (EditText) findViewById(R.id.ans80other);
            EditText ans81other = (EditText) findViewById(R.id.ans81other);
            EditText ans83_2other = (EditText) findViewById(R.id.ans83_2other);
            EditText ans83_3other = (EditText) findViewById(R.id.ans83_3other);
            EditText ans83_4other = (EditText) findViewById(R.id.ans83_4other);
            EditText ans83_6other = (EditText) findViewById(R.id.ans83_6other);
            EditText ans84other = (EditText) findViewById(R.id.ans84other);
            EditText ans85_1other = (EditText) findViewById(R.id.ans85_1other);
            EditText ans86_1other = (EditText) findViewById(R.id.ans86_1other);
            EditText ans87_1other = (EditText) findViewById(R.id.ans87_1other);
            EditText ans96other = (EditText) findViewById(R.id.ans96other);
            EditText ans97_1other = (EditText) findViewById(R.id.ans97_1other);
            EditText ans105other = (EditText) findViewById(R.id.ans105other);
            
            CheckBox ans77a = (CheckBox) findViewById(R.id.ans77a);
            CheckBox ans77b = (CheckBox) findViewById(R.id.ans77b);
            CheckBox ans77c = (CheckBox) findViewById(R.id.ans77c);
            CheckBox ans77d = (CheckBox) findViewById(R.id.ans77d);
            CheckBox ans77e = (CheckBox) findViewById(R.id.ans77e);
            CheckBox ans77f = (CheckBox) findViewById(R.id.ans77f);
            CheckBox ans77g = (CheckBox) findViewById(R.id.ans77g);
            CheckBox ans77h = (CheckBox) findViewById(R.id.ans77h);
            CheckBox ans77i = (CheckBox) findViewById(R.id.ans77i);
            CheckBox ans77j = (CheckBox) findViewById(R.id.ans77j);
            CheckBox ans77k = (CheckBox) findViewById(R.id.ans77k);
            CheckBox ans77l = (CheckBox) findViewById(R.id.ans77l);
            CheckBox ans80a = (CheckBox) findViewById(R.id.ans80a);
            CheckBox ans80b = (CheckBox) findViewById(R.id.ans80b);
            CheckBox ans80c = (CheckBox) findViewById(R.id.ans80c);
            CheckBox ans80d = (CheckBox) findViewById(R.id.ans80d);
            CheckBox ans80e = (CheckBox) findViewById(R.id.ans80e);
            CheckBox ans80f = (CheckBox) findViewById(R.id.ans80f);
            CheckBox ans84a = (CheckBox) findViewById(R.id.ans84a);
            CheckBox ans84b = (CheckBox) findViewById(R.id.ans84b);
            CheckBox ans84c = (CheckBox) findViewById(R.id.ans84c);
            CheckBox ans84d = (CheckBox) findViewById(R.id.ans84d);
            CheckBox ans84e = (CheckBox) findViewById(R.id.ans84e);
            CheckBox ans84f = (CheckBox) findViewById(R.id.ans84f);
            CheckBox ans84g = (CheckBox) findViewById(R.id.ans84g);
            CheckBox ans84h = (CheckBox) findViewById(R.id.ans84h);
            CheckBox ans84i = (CheckBox) findViewById(R.id.ans84i);
            CheckBox ans84j = (CheckBox) findViewById(R.id.ans84j);
            
            FileOutputStream fos = new FileOutputStream(myExternalFile, true);
            for (int i = 0; i < 162; i++) {
                fos.write("\t".getBytes());
            }

            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans43.getSelectedItemPosition()+1).getBytes());
            fos.write(ans43other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans44.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans44_1.getSelectedItemPosition()+1).getBytes());
            fos.write(ans44_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans45.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans45_1.getSelectedItemPosition()+1).getBytes());
            fos.write(ans45_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans46.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans47.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans47_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans47_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans48.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans48_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans49.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans50.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans51.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans52.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans53.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans53_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans53_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans53_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans53_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans54.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans54_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans54_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans54_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans54_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans54_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans54_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans55.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans56.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans57.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans58.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans59.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans60.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans61.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans62.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans63.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans64.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans65.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans65_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans65_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans66.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans66_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans67.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans67_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans68.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans68_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans69.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans69_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans70.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans70_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans71.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans71_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans72.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans72_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans73.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans73_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans74.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans74_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans75.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans75_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans76.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            if(ans77a.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans77b.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(ans77c.isChecked()){
                fos.write("3, ".getBytes());
            }
            if(ans77d.isChecked()){
                fos.write("4, ".getBytes());
            }
            if(ans77e.isChecked()){
                fos.write("5, ".getBytes());
            }
            if(ans77f.isChecked()){
                fos.write("6, ".getBytes());
            }
            if(ans77g.isChecked()){
                fos.write("7, ".getBytes());
            }
            if(ans77h.isChecked()){
                fos.write("8, ".getBytes());
            }
            if(ans77i.isChecked()){
                fos.write("9, ".getBytes());
            }
            if(ans77j.isChecked()){
                fos.write("10, ".getBytes());
            }
            if(ans77k.isChecked()){
                fos.write("11, ".getBytes());
            }
            if(ans77l.isChecked()){
                fos.write("12, ".getBytes());
            }
            fos.write(ans77other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans78.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans78_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans79.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans79_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            if(ans80a.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans80b.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(ans80c.isChecked()){
                fos.write("3, ".getBytes());
            }
            if(ans80d.isChecked()){
                fos.write("4, ".getBytes());
            }
            if(ans80e.isChecked()){
                fos.write("5, ".getBytes());
            }
            if(ans80f.isChecked()){
                fos.write("6, ".getBytes());
            }
            fos.write(ans80other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans80_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans81.getSelectedItemPosition()+1).getBytes());
            fos.write(ans81other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans82.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans83.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans83_2.getSelectedItemPosition()+1).getBytes());
            fos.write(ans83_2other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans83_3.getSelectedItemPosition()+1).getBytes());
            fos.write(ans83_3other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans83_4.getSelectedItemPosition()+1).getBytes());
            fos.write(ans83_4other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans83_6.getSelectedItemPosition()+1).getBytes());
            fos.write(ans83_6other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans83_7.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans83_8.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_9.getText().toString().getBytes());
            fos.write("\t".getBytes());
            if(ans84a.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans84b.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(ans84c.isChecked()){
                fos.write("3, ".getBytes());
            }
            if(ans84d.isChecked()){
                fos.write("4, ".getBytes());
            }
            if(ans84e.isChecked()){
                fos.write("5, ".getBytes());
            }
            if(ans84f.isChecked()){
                fos.write("6, ".getBytes());
            }
            if(ans84g.isChecked()){
                fos.write("7, ".getBytes());
            }
            if(ans84h.isChecked()){
                fos.write("8, ".getBytes());
            }
            if(ans84i.isChecked()){
                fos.write("9, ".getBytes());
            }
            if(ans84j.isChecked()){
                fos.write("10, ".getBytes());
            }
            fos.write(ans84other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_7.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_8.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_9.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_10.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans85.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans85_1.getSelectedItemPosition()+1).getBytes());
            fos.write(ans85_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans86.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans86_1.getSelectedItemPosition()+1).getBytes());
            fos.write(ans86_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans87.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans87_1.getSelectedItemPosition()+1).getBytes());
            fos.write(ans87_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans88.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans88_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans89.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans90.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans90_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans91.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans92.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans93.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans93_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans94.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans94_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans95.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans95_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans96.getSelectedItemPosition()+1).getBytes());
            fos.write(ans96other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans97.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans97_1.getSelectedItemPosition()+1).getBytes());
            fos.write(ans97_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans97_2.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans97_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans97_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans97_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans97_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans97_7.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans97_8.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans97_9.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans98.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans98_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans99.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans100.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans101.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans102.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans103.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans104.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans105.getSelectedItemPosition()+1).getBytes());
            fos.write(ans105other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans106.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans107.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans107_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans108.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans109.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans110.getSelectedItemPosition()+1).getBytes());

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}