package fedejandro.encuestadigital;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.io.*;

public class Preguntas2 extends AppCompatActivity {

    private String filename = "datos.txt";
    private String filepath = "EncuestaDatos";
    File myExternalFile;

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
        String[] siNo = new String[] {
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
        String[] desastres = new String[] {
                "Inundaciones", "Sequías", "Vientos fuertes", "Sismos", "Otras, ¿Cuáles?", "Ninguno"
        };
        String[] predadores = new String[] {
                "Aves", "Anfibios", "Réptiles", "Insectos", "Peces", "No ha sufrido pérdidas"
        };
        String[] patologias = new String[] {
                "Bacterianas", "Virus", "Hongos", "Protozoarios", "Parásitos", "Otros, ¿Cuáles?", "Ninguno"
        };
        String[] maquinas = new String[] {
                "Propios", "Propios en sociedad con otras UPAC", "Alquilados", "Proporcionada  por una cooperativa", "Proporcionada por  una entidad del estado", "Otro tipo de tenencia"
        };
        String[] sistema = new String[] {
                "Estanques", "Jaulas"
        };
        String[] materialTanque = new String[] {
                "Tierra", "Cemento", "Geomembrana"
        };
        String[] alimentoPrincipal = new String[] {
                "Alimentos balanceados", "Subproductos agrícolas", "Hidroponías", "Materias primas no convencionales (bore, ñame, yuca, ahuyama)"
        };
        String[] procedenciaAlimento = new String[] {
                "Casa comerciales", "Asociaciones", "Corporaciones", "Proyectos", "ONG", "UPAC (Producción interna)"
        };
        String[] frecuenciaAlimento = new String[] {
                "Siempre", "Casi Siempre", "Casi nunca", "Nunca"
        };
        String[] departamentos = new String[] {
                "Amazonas","Antioquia","Arauca","Atlántico","Bolívar","Boyacá","Caldas","Caquetá","Casanare","Cauca","Cesar","Chocó","Córdoba","Cundinamarca","Guainía","Guaviare","Huila","La Guajira","Magdalena","Meta","Nariño","Norte de Santander","Putumayo","Quindío","Risaralda","San Andrés y Providencia","Santander","Sucre","Tolima","Valle del Cauca","Vaupés","Vichada"
        };
        String[] frecuenciaRecambio = new String[] {
                "Mensual", "Semanal", "Diaria"
        };
        String[] puntoDescarga = new String[] {
                "Ciénagas", "Ríos", "Otro, ¿Cuál?"
        };
        String[] fuenteEnergia = new String[] {
                "Red eléctrica publica", "Generador eléctrico a gasolina o diésel", "Energía solar", "Energía eólica", "Otro, ¿Cuál?"
        };
        String[] tipoAsociacion = new String[] {
                "Cooperativa", "Asociacion", "Sindicato", "Otro, ¿Cuál?"
        };
        String[] cargoAsociacion = new String[] {
                "Directivo", "Centro de acopio", "Centro de comercialización"
        };
        String[] lugarVenta = new String[] {
                "Venta en la UPAC", "Socio activo", "Socio pasivo"
        };
        String[] compradores = new String[] {
                "Intermediario", "Almacén de cadena", "Consumidor", "Tienda", "Restaurante", "Industria", "Exportador"
        };
        String[] presentacion = new String[] {
                "Entero", "Vivo", "Eviscerado", "Empacado", "Seco", "Salado", "Sin escama", "Sin branquias", "Postas"
        };
        String[] tecnicasReproduccion = new String[] {
                "Reproducción natural", "Reproducción artificial"
        };
        String[] tecnicasIncubacion = new String[] {
                "Incubación natural", "Incubación artificial"
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
        ArrayAdapter<String> adapterAns58 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns58.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans58.setAdapter(adapterAns58);

        Spinner ans60 = (Spinner) findViewById(R.id.ans60);
        ArrayAdapter<String> adapterAns60 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns60.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans60.setAdapter(adapterAns60);

        Spinner ans61 = (Spinner) findViewById(R.id.ans61);
        ArrayAdapter<String> adapterAns61 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns61.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans61.setAdapter(adapterAns61);

        Spinner ans62 = (Spinner) findViewById(R.id.ans62);
        ArrayAdapter<String> adapterAns62 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
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
        ArrayAdapter<String> adapterAns100 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
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
        ArrayAdapter<String> adapterAns104 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
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

        Spinner ans109_7 = (Spinner) findViewById(R.id.ans109_7);
        ArrayAdapter<String> adapterAns109_7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, materialTanque);
        adapterAns109_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans109_7.setAdapter(adapterAns109_7);

        Spinner ans111 = (Spinner) findViewById(R.id.ans111);
        ArrayAdapter<String> adapterAns111 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, alimentoPrincipal);
        adapterAns111.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans111.setAdapter(adapterAns111);

        Spinner ans111_1 = (Spinner) findViewById(R.id.ans111_1);
        ArrayAdapter<String> adapterAns111_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, procedenciaAlimento);
        adapterAns111_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans111_1.setAdapter(adapterAns111_1);

        Spinner ans111_2 = (Spinner) findViewById(R.id.ans111_2);
        ArrayAdapter<String> adapterAns111_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frecuenciaAlimento);
        adapterAns111_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans111_2.setAdapter(adapterAns111_2);

        Spinner ans111_3 = (Spinner) findViewById(R.id.ans111_3);
        ArrayAdapter<String> adapterAns111_3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, departamentos);
        adapterAns111_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans111_3.setAdapter(adapterAns111_3);

        Spinner ans112 = (Spinner) findViewById(R.id.ans112);
        ArrayAdapter<String> adapterAns112 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns112.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans112.setAdapter(adapterAns112);

        Spinner ans112_2 = (Spinner) findViewById(R.id.ans112_2);
        ArrayAdapter<String> adapterAns112_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frecuenciaRecambio);
        adapterAns112_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans112_2.setAdapter(adapterAns112_2);

        Spinner ans113 = (Spinner) findViewById(R.id.ans113);
        ArrayAdapter<String> adapterAns113 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns113.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans113.setAdapter(adapterAns113);

        Spinner ans113_2 = (Spinner) findViewById(R.id.ans113_2);
        ArrayAdapter<String> adapterAns113_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, puntoDescarga);
        adapterAns113_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans113_2.setAdapter(adapterAns113_2);

        Spinner ans114 = (Spinner) findViewById(R.id.ans114);
        ArrayAdapter<String> adapterAns114 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns114.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans114.setAdapter(adapterAns114);

        Spinner ans115 = (Spinner) findViewById(R.id.ans115);
        ArrayAdapter<String> adapterAns115 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns115.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans115.setAdapter(adapterAns115);

        Spinner ans116 = (Spinner) findViewById(R.id.ans116);
        ArrayAdapter<String> adapterAns116 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns116.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans116.setAdapter(adapterAns116);

        Spinner ans117 = (Spinner) findViewById(R.id.ans117);
        ArrayAdapter<String> adapterAns117 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns117.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans117.setAdapter(adapterAns117);

        Spinner ans118 = (Spinner) findViewById(R.id.ans118);
        ArrayAdapter<String> adapterAns118 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fuenteEnergia);
        adapterAns118.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans118.setAdapter(adapterAns118);

        Spinner ans119 = (Spinner) findViewById(R.id.ans119);
        ArrayAdapter<String> adapterAns119 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns119.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans119.setAdapter(adapterAns119);

        Spinner ans119_1 = (Spinner) findViewById(R.id.ans119_1);
        ArrayAdapter<String> adapterAns119_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoAsociacion);
        adapterAns119_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans119_1.setAdapter(adapterAns119_1);

        Spinner ans119_2 = (Spinner) findViewById(R.id.ans119_2);
        ArrayAdapter<String> adapterAns119_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns119_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans119_2.setAdapter(adapterAns119_2);

        Spinner ans119_4 = (Spinner) findViewById(R.id.ans119_4);
        ArrayAdapter<String> adapterAns119_4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cargoAsociacion);
        adapterAns119_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans119_4.setAdapter(adapterAns119_4);

        Spinner ans119_10 = (Spinner) findViewById(R.id.ans119_10);
        ArrayAdapter<String> adapterAns119_10 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, departamentos);
        adapterAns119_10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans119_10.setAdapter(adapterAns119_10);

        Spinner ans120 = (Spinner) findViewById(R.id.ans120);
        ArrayAdapter<String> adapterAns120 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns120.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans120.setAdapter(adapterAns120);

        Spinner ans121 = (Spinner) findViewById(R.id.ans121);
        ArrayAdapter<String> adapterAns121 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns121.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans121.setAdapter(adapterAns121);

        Spinner ans124 = (Spinner) findViewById(R.id.ans124);
        ArrayAdapter<String> adapterAns124 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lugarVenta);
        adapterAns124.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans124.setAdapter(adapterAns124);

        Spinner ans125 = (Spinner) findViewById(R.id.ans125);
        ArrayAdapter<String> adapterAns125 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, compradores);
        adapterAns125.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans125.setAdapter(adapterAns125);

        Spinner ans127 = (Spinner) findViewById(R.id.ans127);
        ArrayAdapter<String> adapterAns127 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, presentacion);
        adapterAns127.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans127.setAdapter(adapterAns127);

        Spinner ans128 = (Spinner) findViewById(R.id.ans128);
        ArrayAdapter<String> adapterAns128 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns128.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans128.setAdapter(adapterAns128);

        Spinner ans129 = (Spinner) findViewById(R.id.ans129);
        ArrayAdapter<String> adapterAns129 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns129.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans129.setAdapter(adapterAns129);

        Spinner ans129_1 = (Spinner) findViewById(R.id.ans129_1);
        ArrayAdapter<String> adapterAns129_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns129_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans129_1.setAdapter(adapterAns129_1);

        Spinner ans130 = (Spinner) findViewById(R.id.ans130);
        ArrayAdapter<String> adapterAns130 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns130.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans130.setAdapter(adapterAns130);

        Spinner ans131 = (Spinner) findViewById(R.id.ans131);
        ArrayAdapter<String> adapterAns131 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tecnicasReproduccion);
        adapterAns131.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans131.setAdapter(adapterAns131);

        Spinner ans132 = (Spinner) findViewById(R.id.ans132);
        ArrayAdapter<String> adapterAns132 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tecnicasIncubacion);
        adapterAns132.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans132.setAdapter(adapterAns132);

        Spinner ans133 = (Spinner) findViewById(R.id.ans133);
        ArrayAdapter<String> adapterAns133 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns133.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans133.setAdapter(adapterAns133);

        Spinner ans134 = (Spinner) findViewById(R.id.ans134);
        ArrayAdapter<String> adapterAns134 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns134.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans134.setAdapter(adapterAns134);

        Spinner ans135 = (Spinner) findViewById(R.id.ans135);
        ArrayAdapter<String> adapterAns135 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns135.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans135.setAdapter(adapterAns135);

        Spinner ans136 = (Spinner) findViewById(R.id.ans136);
        ArrayAdapter<String> adapterAns136 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns136.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans136.setAdapter(adapterAns136);

        Spinner ans137 = (Spinner) findViewById(R.id.ans137);
        ArrayAdapter<String> adapterAns137 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns137.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans137.setAdapter(adapterAns137);

        Spinner ans138 = (Spinner) findViewById(R.id.ans138);
        ArrayAdapter<String> adapterAns138 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns138.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans138.setAdapter(adapterAns138);

        Spinner ans139 = (Spinner) findViewById(R.id.ans139);
        ArrayAdapter<String> adapterAns139 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns139.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans139.setAdapter(adapterAns139);

        Spinner ans140 = (Spinner) findViewById(R.id.ans140);
        ArrayAdapter<String> adapterAns140 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns140.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans140.setAdapter(adapterAns140);

        Spinner ans141 = (Spinner) findViewById(R.id.ans141);
        ArrayAdapter<String> adapterAns141 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns141.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans141.setAdapter(adapterAns141);

        Spinner ans142 = (Spinner) findViewById(R.id.ans142);
        ArrayAdapter<String> adapterAns142 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns142.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans142.setAdapter(adapterAns142);

        Spinner ans143 = (Spinner) findViewById(R.id.ans143);
        ArrayAdapter<String> adapterAns143 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns143.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans143.setAdapter(adapterAns143);

        Spinner ans144 = (Spinner) findViewById(R.id.ans144);
        ArrayAdapter<String> adapterAns144 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns144.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans144.setAdapter(adapterAns144);

        EditText ans43_1other = (EditText) findViewById(R.id.ans43_1other);
        ans43_1other.setVisibility(View.GONE);

        EditText ans45other = (EditText) findViewById(R.id.ans45other);
        ans45other.setVisibility(View.GONE);

        EditText ans65other = (EditText) findViewById(R.id.ans65other);
        ans65other.setVisibility(View.GONE);

        EditText ans101other = (EditText) findViewById(R.id.ans101other);
        ans101other.setVisibility(View.GONE);

        EditText ans103other = (EditText) findViewById(R.id.ans103other);
        ans103other.setVisibility(View.GONE);

        EditText ans113_2other = (EditText) findViewById(R.id.ans113_2other);
        ans113_2other.setVisibility(View.GONE);

        EditText ans118other = (EditText) findViewById(R.id.ans118other);
        ans118other.setVisibility(View.GONE);

        EditText ans119_1other = (EditText) findViewById(R.id.ans119_1other);
        ans119_1other.setVisibility(View.GONE);

        CheckBox ans65g = (CheckBox) findViewById(R.id.ans65g);
        CheckBox ans98k = (CheckBox) findViewById(R.id.ans98k);

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

        ans45.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans45 = (Spinner) findViewById(R.id.ans45);
                EditText ans45other = (EditText) findViewById(R.id.ans45other);
                if(ans45.getSelectedItemPosition()==4) {
                    ans45other.setVisibility(View.VISIBLE);
                }else{
                    ans45other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans53.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans53 = (Spinner) findViewById(R.id.ans53);
                EditText ans53other = (EditText) findViewById(R.id.ans53other);
                if(ans53.getSelectedItemPosition()==8) {
                    ans53other.setVisibility(View.VISIBLE);
                }else{
                    ans53other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans65g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans65g = (CheckBox) findViewById(R.id.ans65g);
                EditText ans65other = (EditText) findViewById(R.id.ans65other);
                if(ans65g.isChecked()){
                    ans65other.setVisibility(View.VISIBLE);
                }
                else {
                    ans65other.setVisibility(View.GONE);
                }
            }
        });

        ans98k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans98k = (CheckBox) findViewById(R.id.ans98k);
                EditText ans98other = (EditText) findViewById(R.id.ans98other);
                if(ans98k.isChecked()){
                    ans98other.setVisibility(View.VISIBLE);
                }
                else {
                    ans98other.setVisibility(View.GONE);
                }
            }
        });

        ans101.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans101 = (Spinner) findViewById(R.id.ans101);
                EditText ans101other = (EditText) findViewById(R.id.ans101other);
                if(ans101.getSelectedItemPosition()==4) {
                    ans101other.setVisibility(View.VISIBLE);
                }else{
                    ans101other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans103.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans103 = (Spinner) findViewById(R.id.ans103);
                EditText ans103other = (EditText) findViewById(R.id.ans103other);
                if(ans103.getSelectedItemPosition()==5) {
                    ans103other.setVisibility(View.VISIBLE);
                }else{
                    ans103other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans113_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans113_2 = (Spinner) findViewById(R.id.ans113_2);
                EditText ans113_2other = (EditText) findViewById(R.id.ans113_2other);
                if(ans113_2.getSelectedItemPosition()==2) {
                    ans113_2other.setVisibility(View.VISIBLE);
                }else{
                    ans113_2other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans118.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans118 = (Spinner) findViewById(R.id.ans118);
                EditText ans118other = (EditText) findViewById(R.id.ans118other);
                if(ans118.getSelectedItemPosition()==4) {
                    ans118other.setVisibility(View.VISIBLE);
                }else{
                    ans118other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans119_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans119_1 = (Spinner) findViewById(R.id.ans119_1);
                EditText ans119_1other = (EditText) findViewById(R.id.ans119_1other);
                if(ans119_1.getSelectedItemPosition()==3) {
                    ans119_1other.setVisibility(View.VISIBLE);
                }else{
                    ans119_1other.setVisibility(View.GONE);
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

    private void escribir(String destino) {
        try {

            EditText ans44 = (EditText) findViewById(R.id.ans44);
            EditText ans48 = (EditText) findViewById(R.id.ans48);
            EditText ans49 = (EditText) findViewById(R.id.ans49);
            EditText ans50 = (EditText) findViewById(R.id.ans50);
            EditText ans51 = (EditText) findViewById(R.id.ans51);
            EditText ans52 = (EditText) findViewById(R.id.ans52);
            EditText ans55 = (EditText) findViewById(R.id.ans55);
            EditText ans56 = (EditText) findViewById(R.id.ans56);
            EditText ans57 = (EditText) findViewById(R.id.ans57);
            EditText ans58_1 = (EditText) findViewById(R.id.ans58_1);
            EditText ans59 = (EditText) findViewById(R.id.ans59);
            EditText ans60_1 = (EditText) findViewById(R.id.ans60_1);
            EditText ans61_1 = (EditText) findViewById(R.id.ans61_1);
            EditText ans61_2 = (EditText) findViewById(R.id.ans61_2);
            EditText ans61_3 = (EditText) findViewById(R.id.ans61_3);
            EditText ans61_4 = (EditText) findViewById(R.id.ans61_4);
            EditText ans61_5 = (EditText) findViewById(R.id.ans61_5);
            EditText ans61_6 = (EditText) findViewById(R.id.ans61_6);
            EditText ans61_7 = (EditText) findViewById(R.id.ans61_7);
            EditText ans61_8 = (EditText) findViewById(R.id.ans61_8);
            EditText ans62_1 = (EditText) findViewById(R.id.ans62_1);
            EditText ans63_1 = (EditText) findViewById(R.id.ans63_1);
            EditText ans63_2 = (EditText) findViewById(R.id.ans63_2);
            EditText ans67 = (EditText) findViewById(R.id.ans67);
            EditText ans68 = (EditText) findViewById(R.id.ans68);
            EditText ans69 = (EditText) findViewById(R.id.ans69);
            EditText ans70 = (EditText) findViewById(R.id.ans70);
            EditText ans71 = (EditText) findViewById(R.id.ans71);
            EditText ans72 = (EditText) findViewById(R.id.ans72);
            EditText ans73 = (EditText) findViewById(R.id.ans73);
            EditText ans74 = (EditText) findViewById(R.id.ans74);
            EditText ans75 = (EditText) findViewById(R.id.ans75);
            EditText ans76 = (EditText) findViewById(R.id.ans76);
            EditText ans77 = (EditText) findViewById(R.id.ans77);
            EditText ans78 = (EditText) findViewById(R.id.ans78);
            EditText ans79 = (EditText) findViewById(R.id.ans79);
            EditText ans80 = (EditText) findViewById(R.id.ans80);
            EditText ans81 = (EditText) findViewById(R.id.ans81);
            EditText ans82 = (EditText) findViewById(R.id.ans82);
            EditText ans83 = (EditText) findViewById(R.id.ans83);
            EditText ans84 = (EditText) findViewById(R.id.ans84);
            EditText ans85 = (EditText) findViewById(R.id.ans85);
            EditText ans87 = (EditText) findViewById(R.id.ans87);
            EditText ans88 = (EditText) findViewById(R.id.ans88);
            EditText ans89 = (EditText) findViewById(R.id.ans89);
            EditText ans90 = (EditText) findViewById(R.id.ans90);
            EditText ans91 = (EditText) findViewById(R.id.ans91);
            EditText ans92 = (EditText) findViewById(R.id.ans92);
            EditText ans93 = (EditText) findViewById(R.id.ans93);
            EditText ans94 = (EditText) findViewById(R.id.ans94);
            EditText ans95 = (EditText) findViewById(R.id.ans95);
            EditText ans96 = (EditText) findViewById(R.id.ans96);
            EditText ans97 = (EditText) findViewById(R.id.ans97);
            EditText ans99 = (EditText) findViewById(R.id.ans99);
            EditText ans100_1 = (EditText) findViewById(R.id.ans100_1);
            EditText ans106 = (EditText) findViewById(R.id.ans106);
            EditText ans109 = (EditText) findViewById(R.id.ans109);
            EditText ans109_1 = (EditText) findViewById(R.id.ans109_1);
            EditText ans109_2 = (EditText) findViewById(R.id.ans109_2);
            EditText ans109_3 = (EditText) findViewById(R.id.ans109_3);
            EditText ans109_4 = (EditText) findViewById(R.id.ans109_4);
            EditText ans109_5 = (EditText) findViewById(R.id.ans109_5);
            EditText ans109_6 = (EditText) findViewById(R.id.ans109_6);
            EditText ans110 = (EditText) findViewById(R.id.ans110);
            EditText ans110_1 = (EditText) findViewById(R.id.ans110_1);
            EditText ans110_2 = (EditText) findViewById(R.id.ans110_2);
            EditText ans110_3 = (EditText) findViewById(R.id.ans110_3);
            EditText ans110_4 = (EditText) findViewById(R.id.ans110_4);
            EditText ans110_5 = (EditText) findViewById(R.id.ans110_5);
            EditText ans110_6 = (EditText) findViewById(R.id.ans110_6);
            EditText ans110_7 = (EditText) findViewById(R.id.ans110_7);
            EditText ans111_4 = (EditText) findViewById(R.id.ans111_4);
            EditText ans111_5 = (EditText) findViewById(R.id.ans111_5);
            EditText ans112_1 = (EditText) findViewById(R.id.ans112_1);
            EditText ans113_1 = (EditText) findViewById(R.id.ans113_1);
            EditText ans113_3 = (EditText) findViewById(R.id.ans113_3);
            EditText ans114_1 = (EditText) findViewById(R.id.ans114_1);
            EditText ans115_1 = (EditText) findViewById(R.id.ans115_1);
            EditText ans117_1 = (EditText) findViewById(R.id.ans117_1);
            EditText ans119_3 = (EditText) findViewById(R.id.ans119_3);
            EditText ans119_5 = (EditText) findViewById(R.id.ans119_5);
            EditText ans119_6 = (EditText) findViewById(R.id.ans119_6);
            EditText ans119_7 = (EditText) findViewById(R.id.ans119_7);
            EditText ans119_8 = (EditText) findViewById(R.id.ans119_8);
            EditText ans119_9 = (EditText) findViewById(R.id.ans119_9);
            EditText ans119_11 = (EditText) findViewById(R.id.ans119_11);
            EditText ans121_1 = (EditText) findViewById(R.id.ans121_1);
            EditText ans122 = (EditText) findViewById(R.id.ans122);
            EditText ans123 = (EditText) findViewById(R.id.ans123);
            EditText ans123_1 = (EditText) findViewById(R.id.ans123_1);
            EditText ans126 = (EditText) findViewById(R.id.ans126);
            EditText ans128_1 = (EditText) findViewById(R.id.ans128_1);
            EditText ans130_1 = (EditText) findViewById(R.id.ans130_1);
            EditText ans145 = (EditText) findViewById(R.id.ans145);

            Spinner ans43 = (Spinner) findViewById(R.id.ans43);
            Spinner ans43_1 = (Spinner) findViewById(R.id.ans43_1);
            Spinner ans45 = (Spinner) findViewById(R.id.ans45);
            Spinner ans46 = (Spinner) findViewById(R.id.ans46);
            Spinner ans47 = (Spinner) findViewById(R.id.ans47);
            Spinner ans53 = (Spinner) findViewById(R.id.ans53);
            Spinner ans54 = (Spinner) findViewById(R.id.ans54);
            Spinner ans58 = (Spinner) findViewById(R.id.ans58);
            Spinner ans60 = (Spinner) findViewById(R.id.ans60);
            Spinner ans61 = (Spinner) findViewById(R.id.ans61);
            Spinner ans62 = (Spinner) findViewById(R.id.ans62);
            Spinner ans63 = (Spinner) findViewById(R.id.ans63);
            Spinner ans64 = (Spinner) findViewById(R.id.ans64);
            Spinner ans66 = (Spinner) findViewById(R.id.ans66);
            Spinner ans86 = (Spinner) findViewById(R.id.ans86);
            Spinner ans100 = (Spinner) findViewById(R.id.ans100);
            Spinner ans101 = (Spinner) findViewById(R.id.ans101);
            Spinner ans102 = (Spinner) findViewById(R.id.ans102);
            Spinner ans103 = (Spinner) findViewById(R.id.ans103);
            Spinner ans104 = (Spinner) findViewById(R.id.ans104);
            Spinner ans107 = (Spinner) findViewById(R.id.ans107);
            Spinner ans108 = (Spinner) findViewById(R.id.ans108);
            Spinner ans109_7 = (Spinner) findViewById(R.id.ans109_7);
            Spinner ans111 = (Spinner) findViewById(R.id.ans111);
            Spinner ans111_1 = (Spinner) findViewById(R.id.ans111_1);
            Spinner ans111_2 = (Spinner) findViewById(R.id.ans111_2);
            Spinner ans111_3 = (Spinner) findViewById(R.id.ans111_3);
            Spinner ans112 = (Spinner) findViewById(R.id.ans112);
            Spinner ans112_2 = (Spinner) findViewById(R.id.ans112_2);
            Spinner ans113 = (Spinner) findViewById(R.id.ans113);
            Spinner ans113_2 = (Spinner) findViewById(R.id.ans113_2);
            Spinner ans114 = (Spinner) findViewById(R.id.ans114);
            Spinner ans115 = (Spinner) findViewById(R.id.ans115);
            Spinner ans116 = (Spinner) findViewById(R.id.ans116);
            Spinner ans117 = (Spinner) findViewById(R.id.ans117);
            Spinner ans118 = (Spinner) findViewById(R.id.ans118);
            Spinner ans119 = (Spinner) findViewById(R.id.ans119);
            Spinner ans119_1 = (Spinner) findViewById(R.id.ans119_1);
            Spinner ans119_2 = (Spinner) findViewById(R.id.ans119_2);
            Spinner ans119_4 = (Spinner) findViewById(R.id.ans119_4);
            Spinner ans119_10 = (Spinner) findViewById(R.id.ans119_10);
            Spinner ans120 = (Spinner) findViewById(R.id.ans120);
            Spinner ans121 = (Spinner) findViewById(R.id.ans121);
            Spinner ans124 = (Spinner) findViewById(R.id.ans124);
            Spinner ans125 = (Spinner) findViewById(R.id.ans125);
            Spinner ans127 = (Spinner) findViewById(R.id.ans127);
            Spinner ans128 = (Spinner) findViewById(R.id.ans128);
            Spinner ans129 = (Spinner) findViewById(R.id.ans129);
            Spinner ans129_1 = (Spinner) findViewById(R.id.ans129_1);
            Spinner ans130 = (Spinner) findViewById(R.id.ans130);
            Spinner ans131 = (Spinner) findViewById(R.id.ans131);
            Spinner ans132 = (Spinner) findViewById(R.id.ans132);
            Spinner ans133 = (Spinner) findViewById(R.id.ans133);
            Spinner ans134 = (Spinner) findViewById(R.id.ans134);
            Spinner ans135 = (Spinner) findViewById(R.id.ans135);
            Spinner ans136 = (Spinner) findViewById(R.id.ans136);
            Spinner ans137 = (Spinner) findViewById(R.id.ans137);
            Spinner ans138 = (Spinner) findViewById(R.id.ans138);
            Spinner ans139 = (Spinner) findViewById(R.id.ans139);
            Spinner ans140 = (Spinner) findViewById(R.id.ans140);
            Spinner ans141 = (Spinner) findViewById(R.id.ans141);
            Spinner ans142 = (Spinner) findViewById(R.id.ans142);
            Spinner ans143 = (Spinner) findViewById(R.id.ans143);
            Spinner ans144 = (Spinner) findViewById(R.id.ans144);

            EditText ans43_1other = (EditText) findViewById(R.id.ans43_1other);
            EditText ans45other = (EditText) findViewById(R.id.ans45other);
            EditText ans53other = (EditText) findViewById(R.id.ans53other);
            EditText ans65other = (EditText) findViewById(R.id.ans65other);
            EditText ans98other = (EditText) findViewById(R.id.ans98other);
            EditText ans101other = (EditText) findViewById(R.id.ans101other);
            EditText ans103other = (EditText) findViewById(R.id.ans103other);
            EditText ans113_2other = (EditText) findViewById(R.id.ans113_2other);
            EditText ans118other = (EditText) findViewById(R.id.ans118other);
            EditText ans119_1other = (EditText) findViewById(R.id.ans119_1other);

            CheckBox ans65a = (CheckBox) findViewById(R.id.ans65a);
            CheckBox ans65b = (CheckBox) findViewById(R.id.ans65b);
            CheckBox ans65c = (CheckBox) findViewById(R.id.ans65c);
            CheckBox ans65d = (CheckBox) findViewById(R.id.ans65d);
            CheckBox ans65e = (CheckBox) findViewById(R.id.ans65e);
            CheckBox ans65f = (CheckBox) findViewById(R.id.ans65f);
            CheckBox ans65g = (CheckBox) findViewById(R.id.ans65g);
            CheckBox ans98a = (CheckBox) findViewById(R.id.ans98a);
            CheckBox ans98b = (CheckBox) findViewById(R.id.ans98b);
            CheckBox ans98c = (CheckBox) findViewById(R.id.ans98c);
            CheckBox ans98d = (CheckBox) findViewById(R.id.ans98d);
            CheckBox ans98e = (CheckBox) findViewById(R.id.ans98e);
            CheckBox ans98f = (CheckBox) findViewById(R.id.ans98f);
            CheckBox ans98g = (CheckBox) findViewById(R.id.ans98g);
            CheckBox ans98h = (CheckBox) findViewById(R.id.ans98h);
            CheckBox ans98i = (CheckBox) findViewById(R.id.ans98i);
            CheckBox ans98j = (CheckBox) findViewById(R.id.ans98j);
            CheckBox ans98k = (CheckBox) findViewById(R.id.ans98k);
            CheckBox ans105a = (CheckBox) findViewById(R.id.ans105a);
            CheckBox ans105b = (CheckBox) findViewById(R.id.ans105b);
            CheckBox ans105c = (CheckBox) findViewById(R.id.ans105c);
            CheckBox ans105d = (CheckBox) findViewById(R.id.ans105d);
            CheckBox ans105e = (CheckBox) findViewById(R.id.ans105e);
            CheckBox ans105f = (CheckBox) findViewById(R.id.ans105f);

            FileOutputStream fos = new FileOutputStream(myExternalFile,true);

            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans43.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans43_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans43_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans44.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans45.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans45other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans46.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans47.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans48.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans49.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans50.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans51.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans52.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans53.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans53other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans54.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans55.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans56.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans57.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans58.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans58_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans59.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans60.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans60_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans61.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans61_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans61_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans61_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans61_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans61_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans61_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans61_7.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans61_8.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans62.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans62_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans63.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans63_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans63_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans64.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            if(ans65a.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans65b.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans65c.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans65d.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans65e.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans65f.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans65g.isChecked()){
                fos.write("1, ".getBytes());
            }
            fos.write(ans65other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans66.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans67.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans68.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans69.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans70.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans71.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans72.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans73.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans74.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans75.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans76.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans77.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans78.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans79.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans80.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans81.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans82.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans85.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans86.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans87.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans88.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans89.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans90.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans91.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans92.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans93.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans94.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans95.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans96.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans97.getText().toString().getBytes());
            fos.write("\t".getBytes());
            if(ans98a.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans98b.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans98c.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans98d.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans98e.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans98f.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans98g.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans98h.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans98i.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans98j.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans98k.isChecked()){
                fos.write("1, ".getBytes());
            }
            fos.write(ans98other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans99.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans100.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans100_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans101.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans101other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans102.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans103.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans103other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans104.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            if(ans105a.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans105b.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans105c.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans105d.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans105e.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans105f.isChecked()){
                fos.write("1, ".getBytes());
            }
            fos.write("\t".getBytes());
            fos.write(ans106.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans107.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans108.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans109.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans109_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans109_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans109_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans109_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans109_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans109_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans109_7.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans110.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans110_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans110_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans110_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans110_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans110_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans110_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans110_7.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans111.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans111_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans111_2.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans111_3.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans111_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans111_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans112.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans112_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans112_2.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans113.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans113_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans113_2.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans113_2other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans113_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans114.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans114_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans115.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans115_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans116.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans117.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans117_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans118.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans118other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans119.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans119_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans119_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans119_2.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans119_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans119_4.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans119_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans119_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans119_7.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans119_8.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans119_9.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans119_10.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans119_11.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans120.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans121.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans121_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans122.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans123.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans123_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans124.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans125.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans126.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans127.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans128.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans128_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans129.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans129_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans130.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans130_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans131.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans132.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans133.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans134.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans135.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans136.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans137.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans138.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans139.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans140.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans141.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans142.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans143.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans144.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans145.getText().toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}