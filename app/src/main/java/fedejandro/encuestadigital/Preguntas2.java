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
        String[] actividadPrincipal = new String[] {
                "Agricultura", "Comercio", "Construcción", "Ganadería", "Minería", "Turismo", "Pesca", "Transporte", "Otra, ¿Cuál?"
        };
        String[] tipoUnidad = new String[] {
                "Propia", "Arrendada", "Familiar", "Posesión", "Otra, ¿Cuál?"
        };
        String[] tipoCultivo = new String[] {
                "Estanques", "Jaulas"
        };
        String[] sistemaCultivo = new String[] {
                "Semi intensivo", "Intensivo", "Super intensivo"
        };
        String[] fuenteAgua = new String[] {
                "Agua lluvia", "Ríos/Canales", "Lagos/Embalses", "Diques", "Pozos profundos/Pozos entubados", "Pozos poco profundos", "Abastecimiento municipal de aguas", "Aguas residuales tratadas", "Otra, ¿Cuál?"
        };
        String[] transporteAgua = new String[] {
                "Por gravedad", "Por bombeo"
        };
        String[] tipoSuelos = new String[] {
                "Sí", "No"
        };
        String[] pagoAgua = new String[] {
                "Sí", "No"
        };
        String[] paramAgua = new String[] {
                "Sí", "No"
        };
        String[] contamAgua = new String[] {
                "Sí", "No"
        };
        String[] destinoProd = new String[] {
                "Autoconsumo", "Comercialización"
        };
        String[] tipoProd = new String[] {
                "Producción de animales para engorde", "Producción de alevines", "Ciclo completo", "Producción de peces ornamentales", "Producción de plantas", "Producción combinda de plantas y animales \n(hidropónica)","Procesamiento y/o transformación de productos", "Fines recreativos (pesca deportiva)", "Animales para ensayos/conservación/otros"
        };
        String[] practica = new String[] {
                "Monocultivo", "Policultivo"
        };
        String[] obtencionRepro = new String[] {
                "Pesca", "Compra"
        };
        String[] implementaBBPA = new String[] {
                "Sí", "No"
        };
        String[] desastres = new String[] {
                "Inundaciones", "Sequías", "Vientos fuertes", "Sismos", "Otras, ¿Cuáles?", "Ninguno"
        };
        String[] predadores = new String[] {
                "Aves", "Anfibios", "Réptiles", "Insectos", "Peces", "No ha sufrido pérdidas"
        };
        String[] patologias = new String[] {
                "Bacterianas", "Virus", "Hongos", "Protozoarios", "Parásitos", "Otros, ¿Cuáles?", "Ninguno"
        };
        String[] pesticidas = new String[] {
                "Sí", "No"
        };
        String[] maquinas = new String[] {
                "Propios", "Propios en sociedad con otras UPAC", "Alquilados", "Proporcionada  por una cooperativa", "Proporcionada por  una entidad del estado", "Otro tipo de tenencia"
        };
        String[] sistema = new String[] {
                "Estanques", "Jaulas"
        };

        Spinner ans43 = (Spinner) findViewById(R.id.ans43);
        ArrayAdapter<String> adapterAns43 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoActividad);
        adapterAns43.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans43.setAdapter(adapterAns43);

        Spinner ans43_1 = (Spinner) findViewById(R.id.ans43_1);
        ArrayAdapter<String> adapterAns43_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, actividadPrincipal);
        adapterAns43_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans43_1.setAdapter(adapterAns43_1);

        Spinner ans45 = (Spinner) findViewById(R.id.ans45);
        ArrayAdapter<String> adapterAns45 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoUnidad);
        adapterAns45.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans45.setAdapter(adapterAns45);

        Spinner ans46 = (Spinner) findViewById(R.id.ans46);
        ArrayAdapter<String> adapterAns46 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoCultivo);
        adapterAns46.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans46.setAdapter(adapterAns46);

        Spinner ans47 = (Spinner) findViewById(R.id.ans47);
        ArrayAdapter<String> adapterAns47 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sistemaCultivo);
        adapterAns47.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans47.setAdapter(adapterAns47);

        Spinner ans53 = (Spinner) findViewById(R.id.ans53);
        ArrayAdapter<String> adapterAns53 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fuenteAgua);
        adapterAns53.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans53.setAdapter(adapterAns53);

        Spinner ans54 = (Spinner) findViewById(R.id.ans54);
        ArrayAdapter<String> adapterAns54 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, transporteAgua);
        adapterAns54.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans54.setAdapter(adapterAns54);

        Spinner ans58 = (Spinner) findViewById(R.id.ans58);
        ArrayAdapter<String> adapterAns58 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoSuelos);
        adapterAns58.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans58.setAdapter(adapterAns58);

        Spinner ans60 = (Spinner) findViewById(R.id.ans60);
        ArrayAdapter<String> adapterAns60 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pagoAgua);
        adapterAns60.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans60.setAdapter(adapterAns60);

        Spinner ans61 = (Spinner) findViewById(R.id.ans61);
        ArrayAdapter<String> adapterAns61 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paramAgua);
        adapterAns61.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans61.setAdapter(adapterAns61);

        Spinner ans62 = (Spinner) findViewById(R.id.ans62);
        ArrayAdapter<String> adapterAns62 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, contamAgua);
        adapterAns62.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans62.setAdapter(adapterAns62);

        Spinner ans63 = (Spinner) findViewById(R.id.ans63);
        ArrayAdapter<String> adapterAns63 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, destinoProd);
        adapterAns63.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans63.setAdapter(adapterAns63);

        Spinner ans64 = (Spinner) findViewById(R.id.ans64);
        ArrayAdapter<String> adapterAns64 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoProd);
        adapterAns64.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans64.setAdapter(adapterAns64);

        Spinner ans66 = (Spinner) findViewById(R.id.ans66);
        ArrayAdapter<String> adapterAns66 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, practica);
        adapterAns66.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans66.setAdapter(adapterAns66);

        Spinner ans86 = (Spinner) findViewById(R.id.ans86);
        ArrayAdapter<String> adapterAns86 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, obtencionRepro);
        adapterAns86.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans86.setAdapter(adapterAns86);

        Spinner ans100 = (Spinner) findViewById(R.id.ans100);
        ArrayAdapter<String> adapterAns100 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, implementaBBPA);
        adapterAns100.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans100.setAdapter(adapterAns100);

        Spinner ans101 = (Spinner) findViewById(R.id.ans101);
        ArrayAdapter<String> adapterAns101 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, desastres);
        adapterAns101.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans101.setAdapter(adapterAns101);

        Spinner ans102 = (Spinner) findViewById(R.id.ans102);
        ArrayAdapter<String> adapterAns102 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, predadores);
        adapterAns102.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans102.setAdapter(adapterAns102);

        Spinner ans103 = (Spinner) findViewById(R.id.ans103);
        ArrayAdapter<String> adapterAns103 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, patologias);
        adapterAns103.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans103.setAdapter(adapterAns103);

        Spinner ans104 = (Spinner) findViewById(R.id.ans104);
        ArrayAdapter<String> adapterAns104 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pesticidas);
        adapterAns104.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans104.setAdapter(adapterAns104);

        Spinner ans107 = (Spinner) findViewById(R.id.ans107);
        ArrayAdapter<String> adapterAns107 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, maquinas);
        adapterAns107.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans107.setAdapter(adapterAns107);

        Spinner ans108 = (Spinner) findViewById(R.id.ans108);
        ArrayAdapter<String> adapterAns108 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sistema);
        adapterAns108.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans108.setAdapter(adapterAns108);
    }
}
