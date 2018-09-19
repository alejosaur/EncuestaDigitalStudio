package fedejandro.encuestadigital;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.*;

public class Preguntas3 extends AppCompatActivity {

    Button saveButton;
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

        Spinner ans42 = (Spinner) findViewById(R.id.ans42);
        ArrayAdapter<String> adapterAns42 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, formaPesca);
        adapterAns42.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans42.setAdapter(adapterAns42);

        Spinner ans43 = (Spinner) findViewById(R.id.ans43);
        ArrayAdapter<String> adapterAns43 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoActividad);
        adapterAns43.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans43.setAdapter(adapterAns43);

        Spinner ans43_1 = (Spinner) findViewById(R.id.ans43_1);
        ArrayAdapter<String> adapterAns43_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, actividadPrincipal);
        adapterAns43_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans43_1.setAdapter(adapterAns43_1);

        Spinner ans44 = (Spinner) findViewById(R.id.ans44);
        ArrayAdapter<String> adapterAns44 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns44.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans44.setAdapter(adapterAns44);

        Spinner ans44_1 = (Spinner) findViewById(R.id.ans44_1);
        ArrayAdapter<String> adapterAns44_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, permiso);
        adapterAns44_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans44_1.setAdapter(adapterAns44_1);

        Spinner ans45 = (Spinner) findViewById(R.id.ans45);
        ArrayAdapter<String> adapterAns45 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns45.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans45.setAdapter(adapterAns45);

        Spinner ans46 = (Spinner) findViewById(R.id.ans46);
        ArrayAdapter<String> adapterAns46 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lugarPesca);
        adapterAns46.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans46.setAdapter(adapterAns46);

        Spinner ans48 = (Spinner) findViewById(R.id.ans48);
        ArrayAdapter<String> adapterAns48 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tiempoDia);
        adapterAns48.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans48.setAdapter(adapterAns48);

        Spinner ans49 = (Spinner) findViewById(R.id.ans49);
        ArrayAdapter<String> adapterAns49 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, destinoProductos);
        adapterAns49.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans49.setAdapter(adapterAns49);

        Spinner ans50 = (Spinner) findViewById(R.id.ans50);
        ArrayAdapter<String> adapterAns50 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns50.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans50.setAdapter(adapterAns50);

        Spinner ans51 = (Spinner) findViewById(R.id.ans51);
        ArrayAdapter<String> adapterAns51 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns51.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans51.setAdapter(adapterAns51);

        Spinner ans64 = (Spinner) findViewById(R.id.ans64);
        ArrayAdapter<String> adapterAns64 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, destinoProductos);
        adapterAns64.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans64.setAdapter(adapterAns64);

        Spinner ans75 = (Spinner) findViewById(R.id.ans75);
        ArrayAdapter<String> adapterAns75 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns75.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans75.setAdapter(adapterAns75);

        Spinner ans77_1 = (Spinner) findViewById(R.id.ans77_1);
        ArrayAdapter<String> adapterAns77_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns77_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans77_1.setAdapter(adapterAns77_1);

        Spinner ans78 = (Spinner) findViewById(R.id.ans78);
        ArrayAdapter<String> adapterAns78 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns78.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans78.setAdapter(adapterAns78);

        Spinner ans79_1 = (Spinner) findViewById(R.id.ans79_1);
        ArrayAdapter<String> adapterAns79_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, disminucionCaptura);
        adapterAns79_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans79_1.setAdapter(adapterAns79_1);

        Spinner ans80 = (Spinner) findViewById(R.id.ans80);
        ArrayAdapter<String> adapterAns80 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, predadores);
        adapterAns80.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans80.setAdapter(adapterAns80);

        Spinner ans81 = (Spinner) findViewById(R.id.ans81);
        ArrayAdapter<String> adapterAns81 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns81.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans81.setAdapter(adapterAns81);

        Spinner ans82 = (Spinner) findViewById(R.id.ans82);
        ArrayAdapter<String> adapterAns82 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns82.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans82.setAdapter(adapterAns82);

        Spinner ans82_2 = (Spinner) findViewById(R.id.ans82_2);
        ArrayAdapter<String> adapterAns82_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoEmbarcacion);
        adapterAns82_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans82_2.setAdapter(adapterAns82_2);

        Spinner ans82_3 = (Spinner) findViewById(R.id.ans82_3);
        ArrayAdapter<String> adapterAns82_3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, materialEmbarcacion);
        adapterAns82_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans82_3.setAdapter(adapterAns82_3);

        Spinner ans82_4 = (Spinner) findViewById(R.id.ans82_4);
        ArrayAdapter<String> adapterAns82_4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, propulsion);
        adapterAns82_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans82_4.setAdapter(adapterAns82_4);

        Spinner ans82_6 = (Spinner) findViewById(R.id.ans82_6);
        ArrayAdapter<String> adapterAns82_6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, duenoEmbarcacion);
        adapterAns82_6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans82_6.setAdapter(adapterAns82_6);

        Spinner ans82_7 = (Spinner) findViewById(R.id.ans82_7);
        ArrayAdapter<String> adapterAns82_7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns82_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans82_7.setAdapter(adapterAns82_7);

        Spinner ans82_8 = (Spinner) findViewById(R.id.ans82_8);
        ArrayAdapter<String> adapterAns82_8 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns82_8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans82_8.setAdapter(adapterAns82_8);

        Spinner ans84 = (Spinner) findViewById(R.id.ans84);
        ArrayAdapter<String> adapterAns84 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns84.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans84.setAdapter(adapterAns84);

        Spinner ans84_1 = (Spinner) findViewById(R.id.ans84_1);
        ArrayAdapter<String> adapterAns84_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, instalacion);
        adapterAns84_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans84_1.setAdapter(adapterAns84_1);

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

        Spinner ans92_1 = (Spinner) findViewById(R.id.ans92_1);
        ArrayAdapter<String> adapterAns92_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns92_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans92_1.setAdapter(adapterAns92_1);

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
        ArrayAdapter<String> adapterAns95 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fuentesEnergia);
        adapterAns95.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans95.setAdapter(adapterAns95);

        Spinner ans96 = (Spinner) findViewById(R.id.ans96);
        ArrayAdapter<String> adapterAns96 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns96.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans96.setAdapter(adapterAns96);

        Spinner ans96_1 = (Spinner) findViewById(R.id.ans96_1);
        ArrayAdapter<String> adapterAns96_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoAsociacion);
        adapterAns96_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans96_1.setAdapter(adapterAns96_1);

        Spinner ans96_2 = (Spinner) findViewById(R.id.ans96_2);
        ArrayAdapter<String> adapterAns96_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns96_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans96_2.setAdapter(adapterAns96_2);

        Spinner ans96_7 = (Spinner) findViewById(R.id.ans96_7);
        ArrayAdapter<String> adapterAns96_7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, departamentos);
        adapterAns96_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans96_7.setAdapter(adapterAns96_7);

        Spinner ans96_9 = (Spinner) findViewById(R.id.ans96_9);
        ArrayAdapter<String> adapterAns96_9 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns96_9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans96_9.setAdapter(adapterAns96_9);

        Spinner ans97 = (Spinner) findViewById(R.id.ans97);
        ArrayAdapter<String> adapterAns97 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns97.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans97.setAdapter(adapterAns97);

        Spinner ans101 = (Spinner) findViewById(R.id.ans101);
        ArrayAdapter<String> adapterAns101 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lugarVenta);
        adapterAns101.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans101.setAdapter(adapterAns101);

        Spinner ans102 = (Spinner) findViewById(R.id.ans102);
        ArrayAdapter<String> adapterAns102 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, compradores);
        adapterAns102.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans102.setAdapter(adapterAns102);

        Spinner ans104 = (Spinner) findViewById(R.id.ans104);
        ArrayAdapter<String> adapterAns104 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, presentacion);
        adapterAns104.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans104.setAdapter(adapterAns104);

        Spinner ans105 = (Spinner) findViewById(R.id.ans105);
        ArrayAdapter<String> adapterAns105 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
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

        EditText ans42other = (EditText) findViewById(R.id.ans42other);
        ans42other.setVisibility(View.GONE);

        EditText ans43_1other = (EditText) findViewById(R.id.ans43_1other);
        ans43_1other.setVisibility(View.GONE);

        EditText ans44_1other = (EditText) findViewById(R.id.ans44_1other);
        ans44_1other.setVisibility(View.GONE);

        EditText ans76other = (EditText) findViewById(R.id.ans76other);
        ans76other.setVisibility(View.GONE);

        EditText ans79other = (EditText) findViewById(R.id.ans79other);
        ans79other.setVisibility(View.GONE);

        EditText ans80other = (EditText) findViewById(R.id.ans80other);
        ans80other.setVisibility(View.GONE);

        EditText ans82_2other = (EditText) findViewById(R.id.ans82_2other);
        ans82_2other.setVisibility(View.GONE);

        EditText ans82_3other = (EditText) findViewById(R.id.ans82_3other);
        ans82_3other.setVisibility(View.GONE);

        EditText ans82_4other = (EditText) findViewById(R.id.ans82_4other);
        ans82_4other.setVisibility(View.GONE);

        EditText ans82_6other = (EditText) findViewById(R.id.ans82_6other);
        ans82_6other.setVisibility(View.GONE);

        EditText ans83other = (EditText) findViewById(R.id.ans83other);
        ans83other.setVisibility(View.GONE);

        EditText ans84_1other = (EditText) findViewById(R.id.ans84_1other);
        ans84_1other.setVisibility(View.GONE);

        EditText ans85_1other = (EditText) findViewById(R.id.ans85_1other);
        ans85_1other.setVisibility(View.GONE);

        EditText ans86_1other = (EditText) findViewById(R.id.ans86_1other);
        ans86_1other.setVisibility(View.GONE);

        EditText ans95other = (EditText) findViewById(R.id.ans95other);
        ans95other.setVisibility(View.GONE);

        EditText ans96_1other = (EditText) findViewById(R.id.ans96_1other);
        ans96_1other.setVisibility(View.GONE);

        EditText ans104other = (EditText) findViewById(R.id.ans104other);
        ans104other.setVisibility(View.GONE);

        CheckBox ans76k = (CheckBox) findViewById(R.id.ans76k);
        CheckBox ans79e = (CheckBox) findViewById(R.id.ans79e);
        CheckBox ans83j = (CheckBox) findViewById(R.id.ans83j);

        ans42.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans42 = (Spinner) findViewById(R.id.ans42);
                EditText ans42other = (EditText) findViewById(R.id.ans42other);
                if(ans42.getSelectedItemPosition()==3) {
                    ans42other.setVisibility(View.VISIBLE);
                }else{
                    ans42other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans43_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans43_1 = (Spinner) findViewById(R.id.ans43_1);
                EditText ans43_1other = (EditText) findViewById(R.id.ans43_1other);
                if(ans43_1.getSelectedItemPosition()==8) {
                    ans43_1other.setVisibility(View.VISIBLE);
                }else{
                    ans43_1other.setVisibility(View.GONE);
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
                if(ans44_1.getSelectedItemPosition()==3) {
                    ans44_1other.setVisibility(View.VISIBLE);
                }else{
                    ans44_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans76k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans76k = (CheckBox) findViewById(R.id.ans76k);
                EditText ans76other = (EditText) findViewById(R.id.ans76other);
                if(ans76k.isChecked()){
                    ans76other.setVisibility(View.VISIBLE);
                }
                else {
                    ans76other.setVisibility(View.GONE);
                }
            }
        });

        ans79e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans79e = (CheckBox) findViewById(R.id.ans79e);
                EditText ans79other = (EditText) findViewById(R.id.ans79other);
                if(ans79e.isChecked()){
                    ans79other.setVisibility(View.VISIBLE);
                }
                else {
                    ans79other.setVisibility(View.GONE);
                }
            }
        });

        ans80.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans80 = (Spinner) findViewById(R.id.ans80);
                EditText ans80other = (EditText) findViewById(R.id.ans80other);
                if(ans80.getSelectedItemPosition()==7) {
                    ans80other.setVisibility(View.VISIBLE);
                }else{
                    ans80other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans82_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans82_2 = (Spinner) findViewById(R.id.ans82_2);
                EditText ans82_2other = (EditText) findViewById(R.id.ans82_2other);
                if(ans82_2.getSelectedItemPosition()==4) {
                    ans82_2other.setVisibility(View.VISIBLE);
                }else{
                    ans82_2other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans82_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans82_3 = (Spinner) findViewById(R.id.ans82_3);
                EditText ans82_3other = (EditText) findViewById(R.id.ans82_3other);
                if(ans82_3.getSelectedItemPosition()==3) {
                    ans82_3other.setVisibility(View.VISIBLE);
                }else{
                    ans82_3other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans82_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans82_4 = (Spinner) findViewById(R.id.ans82_4);
                EditText ans82_4other = (EditText) findViewById(R.id.ans82_4other);
                if(ans82_4.getSelectedItemPosition()==3) {
                    ans82_4other.setVisibility(View.VISIBLE);
                }else{
                    ans82_4other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans82_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans82_6 = (Spinner) findViewById(R.id.ans82_6);
                EditText ans82_6other = (EditText) findViewById(R.id.ans82_6other);
                if(ans82_6.getSelectedItemPosition()==4) {
                    ans82_6other.setVisibility(View.VISIBLE);
                }else{
                    ans82_6other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans83j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans83j = (CheckBox) findViewById(R.id.ans83j);
                EditText ans83other = (EditText) findViewById(R.id.ans83other);
                if(ans83j.isChecked()){
                    ans83other.setVisibility(View.VISIBLE);
                }
                else {
                    ans83other.setVisibility(View.GONE);
                }
            }
        });

        ans84_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans84_1 = (Spinner) findViewById(R.id.ans84_1);
                EditText ans84_1other = (EditText) findViewById(R.id.ans84_1other);
                if(ans84_1.getSelectedItemPosition()==2) {
                    ans84_1other.setVisibility(View.VISIBLE);
                }else{
                    ans84_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

        ans95.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans95 = (Spinner) findViewById(R.id.ans95);
                EditText ans95other = (EditText) findViewById(R.id.ans95other);
                if(ans95.getSelectedItemPosition()==5) {
                    ans95other.setVisibility(View.VISIBLE);
                }else{
                    ans95other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans96_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans96_1 = (Spinner) findViewById(R.id.ans96_1);
                EditText ans96_1other = (EditText) findViewById(R.id.ans96_1other);
                if(ans96_1.getSelectedItemPosition()==3) {
                    ans96_1other.setVisibility(View.VISIBLE);
                }else{
                    ans96_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans104.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans104 = (Spinner) findViewById(R.id.ans104);
                EditText ans104other = (EditText) findViewById(R.id.ans104other);
                if(ans104.getSelectedItemPosition()==11) {
                    ans104other.setVisibility(View.VISIBLE);
                }else{
                    ans104other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        saveButton =  (Button) findViewById(R.id.endButton2);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                escribir();
                Intent main = new Intent(getApplicationContext(), MainScreen.class);
                startActivity(main);
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

            EditText ans46_1 = (EditText) findViewById(R.id.ans46_1);
            EditText ans46_2 = (EditText) findViewById(R.id.ans46_2);
            EditText ans47 = (EditText) findViewById(R.id.ans47);
            EditText ans47_1 = (EditText) findViewById(R.id.ans47_1);
            EditText ans52 = (EditText) findViewById(R.id.ans52);
            EditText ans52_1 = (EditText) findViewById(R.id.ans52_1);
            EditText ans52_2 = (EditText) findViewById(R.id.ans52_2);
            EditText ans52_3 = (EditText) findViewById(R.id.ans52_3);
            EditText ans52_4 = (EditText) findViewById(R.id.ans52_4);
            EditText ans53 = (EditText) findViewById(R.id.ans53);
            EditText ans53_1 = (EditText) findViewById(R.id.ans53_1);
            EditText ans53_2 = (EditText) findViewById(R.id.ans53_2);
            EditText ans53_3 = (EditText) findViewById(R.id.ans53_3);
            EditText ans53_4 = (EditText) findViewById(R.id.ans53_4);
            EditText ans53_5 = (EditText) findViewById(R.id.ans53_5);
            EditText ans53_6 = (EditText) findViewById(R.id.ans53_6);
            EditText ans54 = (EditText) findViewById(R.id.ans54);
            EditText ans55 = (EditText) findViewById(R.id.ans55);
            EditText ans56 = (EditText) findViewById(R.id.ans56);
            EditText ans57 = (EditText) findViewById(R.id.ans57);
            EditText ans58 = (EditText) findViewById(R.id.ans58);
            EditText ans59 = (EditText) findViewById(R.id.ans59);
            EditText ans60 = (EditText) findViewById(R.id.ans60);
            EditText ans61 = (EditText) findViewById(R.id.ans61);
            EditText ans62 = (EditText) findViewById(R.id.ans62);
            EditText ans63 = (EditText) findViewById(R.id.ans63);
            EditText ans64_1 = (EditText) findViewById(R.id.ans64_1);
            EditText ans64_2 = (EditText) findViewById(R.id.ans64_2);
            EditText ans65 = (EditText) findViewById(R.id.ans65);
            EditText ans65_1 = (EditText) findViewById(R.id.ans65_1);
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
            EditText ans77 = (EditText) findViewById(R.id.ans77);
            EditText ans78_1 = (EditText) findViewById(R.id.ans78_1);
            EditText ans82_1 = (EditText) findViewById(R.id.ans82_1);
            EditText ans82_5 = (EditText) findViewById(R.id.ans82_5);
            EditText ans82_9 = (EditText) findViewById(R.id.ans82_9);
            EditText ans83_1 = (EditText) findViewById(R.id.ans83_1);
            EditText ans83_2 = (EditText) findViewById(R.id.ans83_2);
            EditText ans83_3 = (EditText) findViewById(R.id.ans83_3);
            EditText ans83_4 = (EditText) findViewById(R.id.ans83_4);
            EditText ans83_5 = (EditText) findViewById(R.id.ans83_5);
            EditText ans83_6 = (EditText) findViewById(R.id.ans83_6);
            EditText ans83_7 = (EditText) findViewById(R.id.ans83_7);
            EditText ans83_8 = (EditText) findViewById(R.id.ans83_8);
            EditText ans83_9 = (EditText) findViewById(R.id.ans83_9);
            EditText ans83_10 = (EditText) findViewById(R.id.ans83_10);
            EditText ans87_1 = (EditText) findViewById(R.id.ans87_1);
            EditText ans89_1 = (EditText) findViewById(R.id.ans89_1);
            EditText ans96_3 = (EditText) findViewById(R.id.ans96_3);
            EditText ans96_4 = (EditText) findViewById(R.id.ans96_4);
            EditText ans96_5 = (EditText) findViewById(R.id.ans96_5);
            EditText ans96_6 = (EditText) findViewById(R.id.ans96_6);
            EditText ans96_8 = (EditText) findViewById(R.id.ans96_8);
            EditText ans97_1 = (EditText) findViewById(R.id.ans97_1);
            EditText ans98 = (EditText) findViewById(R.id.ans98);
            EditText ans99 = (EditText) findViewById(R.id.ans99);
            EditText ans100 = (EditText) findViewById(R.id.ans100);
            EditText ans103 = (EditText) findViewById(R.id.ans103);
            EditText ans106_1 = (EditText) findViewById(R.id.ans106_1);

            Spinner ans42 = (Spinner) findViewById(R.id.ans42);
            Spinner ans43 = (Spinner) findViewById(R.id.ans43);
            Spinner ans43_1 = (Spinner) findViewById(R.id.ans43_1);
            Spinner ans44 = (Spinner) findViewById(R.id.ans44);
            Spinner ans44_1 = (Spinner) findViewById(R.id.ans44_1);
            Spinner ans45 = (Spinner) findViewById(R.id.ans45);
            Spinner ans46 = (Spinner) findViewById(R.id.ans46);
            Spinner ans48 = (Spinner) findViewById(R.id.ans48);
            Spinner ans49 = (Spinner) findViewById(R.id.ans49);
            Spinner ans50 = (Spinner) findViewById(R.id.ans50);
            Spinner ans51 = (Spinner) findViewById(R.id.ans51);
            Spinner ans64 = (Spinner) findViewById(R.id.ans64);
            Spinner ans75 = (Spinner) findViewById(R.id.ans75);
            Spinner ans77_1 = (Spinner) findViewById(R.id.ans77_1);
            Spinner ans78 = (Spinner) findViewById(R.id.ans78);
            Spinner ans79_1 = (Spinner) findViewById(R.id.ans79_1);
            Spinner ans80 = (Spinner) findViewById(R.id.ans80);
            Spinner ans81 = (Spinner) findViewById(R.id.ans81);
            Spinner ans82 = (Spinner) findViewById(R.id.ans82);
            Spinner ans82_2 = (Spinner) findViewById(R.id.ans82_2);
            Spinner ans82_3 = (Spinner) findViewById(R.id.ans82_3);
            Spinner ans82_4 = (Spinner) findViewById(R.id.ans82_4);
            Spinner ans82_6 = (Spinner) findViewById(R.id.ans82_6);
            Spinner ans82_7 = (Spinner) findViewById(R.id.ans82_7);
            Spinner ans82_8 = (Spinner) findViewById(R.id.ans82_8);
            Spinner ans84 = (Spinner) findViewById(R.id.ans84);
            Spinner ans84_1 = (Spinner) findViewById(R.id.ans84_1);
            Spinner ans85 = (Spinner) findViewById(R.id.ans85);
            Spinner ans85_1 = (Spinner) findViewById(R.id.ans85_1);
            Spinner ans86 = (Spinner) findViewById(R.id.ans86);
            Spinner ans86_1 = (Spinner) findViewById(R.id.ans86_1);
            Spinner ans87 = (Spinner) findViewById(R.id.ans87);
            Spinner ans88 = (Spinner) findViewById(R.id.ans88);
            Spinner ans89 = (Spinner) findViewById(R.id.ans89);
            Spinner ans90 = (Spinner) findViewById(R.id.ans90);
            Spinner ans91 = (Spinner) findViewById(R.id.ans91);
            Spinner ans92 = (Spinner) findViewById(R.id.ans92);
            Spinner ans92_1 = (Spinner) findViewById(R.id.ans92_1);
            Spinner ans93 = (Spinner) findViewById(R.id.ans93);
            Spinner ans93_1 = (Spinner) findViewById(R.id.ans93_1);
            Spinner ans94 = (Spinner) findViewById(R.id.ans94);
            Spinner ans94_1 = (Spinner) findViewById(R.id.ans94_1);
            Spinner ans95 = (Spinner) findViewById(R.id.ans95);
            Spinner ans96 = (Spinner) findViewById(R.id.ans96);
            Spinner ans96_1 = (Spinner) findViewById(R.id.ans96_1);
            Spinner ans96_2 = (Spinner) findViewById(R.id.ans96_2);
            Spinner ans96_7 = (Spinner) findViewById(R.id.ans96_7);
            Spinner ans96_9 = (Spinner) findViewById(R.id.ans96_9);
            Spinner ans97 = (Spinner) findViewById(R.id.ans97);
            Spinner ans101 = (Spinner) findViewById(R.id.ans101);
            Spinner ans102 = (Spinner) findViewById(R.id.ans102);
            Spinner ans104 = (Spinner) findViewById(R.id.ans104);
            Spinner ans105 = (Spinner) findViewById(R.id.ans105);
            Spinner ans106 = (Spinner) findViewById(R.id.ans106);
            Spinner ans107 = (Spinner) findViewById(R.id.ans107);
            Spinner ans108 = (Spinner) findViewById(R.id.ans108);
            Spinner ans109 = (Spinner) findViewById(R.id.ans109);

            EditText ans42other = (EditText) findViewById(R.id.ans42other);
            EditText ans43_1other = (EditText) findViewById(R.id.ans43_1other);
            EditText ans44_1other = (EditText) findViewById(R.id.ans44_1other);
            EditText ans76other = (EditText) findViewById(R.id.ans76other);
            EditText ans79other = (EditText) findViewById(R.id.ans79other);
            EditText ans80other = (EditText) findViewById(R.id.ans80other);
            EditText ans82_2other = (EditText) findViewById(R.id.ans82_2other);
            EditText ans82_3other = (EditText) findViewById(R.id.ans82_3other);
            EditText ans82_4other = (EditText) findViewById(R.id.ans82_4other);
            EditText ans82_6other = (EditText) findViewById(R.id.ans82_6other);
            EditText ans83other = (EditText) findViewById(R.id.ans83other);
            EditText ans84_1other = (EditText) findViewById(R.id.ans84_1other);
            EditText ans85_1other = (EditText) findViewById(R.id.ans85_1other);
            EditText ans86_1other = (EditText) findViewById(R.id.ans86_1other);
            EditText ans95other = (EditText) findViewById(R.id.ans95other);
            EditText ans96_1other = (EditText) findViewById(R.id.ans96_1other);
            EditText ans104other = (EditText) findViewById(R.id.ans104other);
            
            CheckBox ans76a = (CheckBox) findViewById(R.id.ans76a);
            CheckBox ans76b = (CheckBox) findViewById(R.id.ans76b);
            CheckBox ans76c = (CheckBox) findViewById(R.id.ans76c);
            CheckBox ans76d = (CheckBox) findViewById(R.id.ans76d);
            CheckBox ans76e = (CheckBox) findViewById(R.id.ans76e);
            CheckBox ans76f = (CheckBox) findViewById(R.id.ans76f);
            CheckBox ans76g = (CheckBox) findViewById(R.id.ans76g);
            CheckBox ans76h = (CheckBox) findViewById(R.id.ans76h);
            CheckBox ans76i = (CheckBox) findViewById(R.id.ans76i);
            CheckBox ans76j = (CheckBox) findViewById(R.id.ans76j);
            CheckBox ans76k = (CheckBox) findViewById(R.id.ans76k);
            CheckBox ans76l = (CheckBox) findViewById(R.id.ans76l);
            CheckBox ans79a = (CheckBox) findViewById(R.id.ans79a);
            CheckBox ans79b = (CheckBox) findViewById(R.id.ans79b);
            CheckBox ans79c = (CheckBox) findViewById(R.id.ans79c);
            CheckBox ans79d = (CheckBox) findViewById(R.id.ans79d);
            CheckBox ans79e = (CheckBox) findViewById(R.id.ans79e);
            CheckBox ans79f = (CheckBox) findViewById(R.id.ans79f);
            CheckBox ans83a = (CheckBox) findViewById(R.id.ans83a);
            CheckBox ans83b = (CheckBox) findViewById(R.id.ans83b);
            CheckBox ans83c = (CheckBox) findViewById(R.id.ans83c);
            CheckBox ans83d = (CheckBox) findViewById(R.id.ans83d);
            CheckBox ans83e = (CheckBox) findViewById(R.id.ans83e);
            CheckBox ans83f = (CheckBox) findViewById(R.id.ans83f);
            CheckBox ans83g = (CheckBox) findViewById(R.id.ans83g);
            CheckBox ans83h = (CheckBox) findViewById(R.id.ans83h);
            CheckBox ans83i = (CheckBox) findViewById(R.id.ans83i);
            CheckBox ans83j = (CheckBox) findViewById(R.id.ans83j);
            
            FileOutputStream fos = new FileOutputStream(myExternalFile, true);
            for (int i = 0; i < 161; i++) {
                fos.write("\t".getBytes());
            }

            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans42.getSelectedItemPosition()+1).getBytes());
            fos.write(ans42other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans43.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans43_1.getSelectedItemPosition()+1).getBytes());
            fos.write(ans43_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans44.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans44_1.getSelectedItemPosition()+1).getBytes());
            fos.write(ans44_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans45.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans46.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans46_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans46_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans47.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans47_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans48.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans49.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans50.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans51.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans52.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans52_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans52_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans52_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans52_4.getText().toString().getBytes());
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
            fos.write(ans53_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans53_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans54.getText().toString().getBytes());
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
            fos.write(Integer.toString(ans64.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans64_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans64_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans65.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans65_1.getText().toString().getBytes());
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
            fos.write(Integer.toString(ans75.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            if(ans76a.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans76b.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(ans76c.isChecked()){
                fos.write("3, ".getBytes());
            }
            if(ans76d.isChecked()){
                fos.write("4, ".getBytes());
            }
            if(ans76e.isChecked()){
                fos.write("5, ".getBytes());
            }
            if(ans76f.isChecked()){
                fos.write("6, ".getBytes());
            }
            if(ans76g.isChecked()){
                fos.write("7, ".getBytes());
            }
            if(ans76h.isChecked()){
                fos.write("8, ".getBytes());
            }
            if(ans76i.isChecked()){
                fos.write("9, ".getBytes());
            }
            if(ans76j.isChecked()){
                fos.write("10, ".getBytes());
            }
            if(ans76k.isChecked()){
                fos.write("11, ".getBytes());
            }
            if(ans76l.isChecked()){
                fos.write("12, ".getBytes());
            }
            fos.write(ans76other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans77.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans77_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans78.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans78_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            if(ans79a.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans79b.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(ans79c.isChecked()){
                fos.write("3, ".getBytes());
            }
            if(ans79d.isChecked()){
                fos.write("4, ".getBytes());
            }
            if(ans79e.isChecked()){
                fos.write("5, ".getBytes());
            }
            if(ans79f.isChecked()){
                fos.write("6, ".getBytes());
            }
            fos.write(ans79other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans79_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans80.getSelectedItemPosition()+1).getBytes());
            fos.write(ans80other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans81.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans82.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans82_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans82_2.getSelectedItemPosition()+1).getBytes());
            fos.write(ans82_2other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans82_3.getSelectedItemPosition()+1).getBytes());
            fos.write(ans82_3other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans82_4.getSelectedItemPosition()+1).getBytes());
            fos.write(ans82_4other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans82_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans82_6.getSelectedItemPosition()+1).getBytes());
            fos.write(ans82_6other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans82_7.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans82_8.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans82_9.getText().toString().getBytes());
            fos.write("\t".getBytes());
            if(ans83a.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans83b.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(ans83c.isChecked()){
                fos.write("3, ".getBytes());
            }
            if(ans83d.isChecked()){
                fos.write("4, ".getBytes());
            }
            if(ans83e.isChecked()){
                fos.write("5, ".getBytes());
            }
            if(ans83f.isChecked()){
                fos.write("6, ".getBytes());
            }
            if(ans83g.isChecked()){
                fos.write("7, ".getBytes());
            }
            if(ans83h.isChecked()){
                fos.write("8, ".getBytes());
            }
            if(ans83i.isChecked()){
                fos.write("9, ".getBytes());
            }
            if(ans83j.isChecked()){
                fos.write("10, ".getBytes());
            }
            fos.write(ans83other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_7.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_8.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_9.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_10.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans84.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans84_1.getSelectedItemPosition()+1).getBytes());
            fos.write(ans84_1other.getText().toString().getBytes());
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
            fos.write(ans87_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans88.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans89.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans89_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans90.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans91.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans92.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans92_1.getSelectedItemPosition()+1).getBytes());
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
            fos.write(ans95other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans96.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans96_1.getSelectedItemPosition()+1).getBytes());
            fos.write(ans96_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans96_2.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans96_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans96_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans96_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans96_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans96_7.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans96_8.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans96_9.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans97.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans97_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans98.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans99.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans100.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans101.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans102.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans103.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans104.getSelectedItemPosition()+1).getBytes());
            fos.write(ans104other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans105.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans106.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans106_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans107.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans108.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans109.getSelectedItemPosition()+1).getBytes());

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}