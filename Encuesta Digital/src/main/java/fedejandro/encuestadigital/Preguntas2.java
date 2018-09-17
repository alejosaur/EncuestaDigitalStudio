package fedejandro.encuestadigital;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.io.*;

public class Preguntas2 extends AppCompatActivity {

    Button saveButton;
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

        Spinner ans42 = (Spinner) findViewById(R.id.ans42);
        ArrayAdapter<String> adapterAns42 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoActividad);
        adapterAns42.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans42.setAdapter(adapterAns42);

        Spinner ans42_1 = (Spinner) findViewById(R.id.ans42_1);
        ArrayAdapter<String> adapterAns42_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, actividadPrincipal);
        adapterAns42_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans42_1.setAdapter(adapterAns42_1);

        Spinner ans44 = (Spinner) findViewById(R.id.ans44);
        ArrayAdapter<String> adapterAns44 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoUnidad);
        adapterAns44.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans44.setAdapter(adapterAns44);

        Spinner ans45 = (Spinner) findViewById(R.id.ans45);
        ArrayAdapter<String> adapterAns45 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoCultivo);
        adapterAns45.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans45.setAdapter(adapterAns45);

        Spinner ans46 = (Spinner) findViewById(R.id.ans46);
        ArrayAdapter<String> adapterAns46 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sistemaCultivo);
        adapterAns46.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans46.setAdapter(adapterAns46);

        Spinner ans52 = (Spinner) findViewById(R.id.ans52);
        ArrayAdapter<String> adapterAns52 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fuenteAgua);
        adapterAns52.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans52.setAdapter(adapterAns52);

        Spinner ans53 = (Spinner) findViewById(R.id.ans53);
        ArrayAdapter<String> adapterAns53 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, transporteAgua);
        adapterAns53.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans53.setAdapter(adapterAns53);

        Spinner ans57 = (Spinner) findViewById(R.id.ans57);
        ArrayAdapter<String> adapterAns57 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns57.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans57.setAdapter(adapterAns57);

        Spinner ans59 = (Spinner) findViewById(R.id.ans59);
        ArrayAdapter<String> adapterAns59 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns59.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans59.setAdapter(adapterAns59);

        Spinner ans60 = (Spinner) findViewById(R.id.ans60);
        ArrayAdapter<String> adapterAns60 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns60.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans60.setAdapter(adapterAns60);

        Spinner ans61 = (Spinner) findViewById(R.id.ans61);
        ArrayAdapter<String> adapterAns61 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns61.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans61.setAdapter(adapterAns61);

        Spinner ans62 = (Spinner) findViewById(R.id.ans62);
        ArrayAdapter<String> adapterAns62 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, destinoProd);
        adapterAns62.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans62.setAdapter(adapterAns62);

        Spinner ans63 = (Spinner) findViewById(R.id.ans63);
        ArrayAdapter<String> adapterAns63 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoProd);
        adapterAns63.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans63.setAdapter(adapterAns63);

        Spinner ans65 = (Spinner) findViewById(R.id.ans65);
        ArrayAdapter<String> adapterAns65 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, practica);
        adapterAns65.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans65.setAdapter(adapterAns65);

        Spinner ans85 = (Spinner) findViewById(R.id.ans85);
        ArrayAdapter<String> adapterAns85 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, obtencionRepro);
        adapterAns85.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans85.setAdapter(adapterAns85);

        Spinner ans99 = (Spinner) findViewById(R.id.ans99);
        ArrayAdapter<String> adapterAns99 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns99.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans99.setAdapter(adapterAns99);

        Spinner ans100 = (Spinner) findViewById(R.id.ans100);
        ArrayAdapter<String> adapterAns100 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, desastres);
        adapterAns100.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans100.setAdapter(adapterAns100);

        Spinner ans101 = (Spinner) findViewById(R.id.ans101);
        ArrayAdapter<String> adapterAns101 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, predadores);
        adapterAns101.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans101.setAdapter(adapterAns101);

        Spinner ans102 = (Spinner) findViewById(R.id.ans102);
        ArrayAdapter<String> adapterAns102 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, patologias);
        adapterAns102.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans102.setAdapter(adapterAns102);

        Spinner ans103 = (Spinner) findViewById(R.id.ans103);
        ArrayAdapter<String> adapterAns103 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns103.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans103.setAdapter(adapterAns103);

        Spinner ans106 = (Spinner) findViewById(R.id.ans106);
        ArrayAdapter<String> adapterAns106 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, maquinas);
        adapterAns106.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans106.setAdapter(adapterAns106);

        Spinner ans107 = (Spinner) findViewById(R.id.ans107);
        ArrayAdapter<String> adapterAns107 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sistema);
        adapterAns107.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans107.setAdapter(adapterAns107);

        Spinner ans108_7 = (Spinner) findViewById(R.id.ans108_7);
        ArrayAdapter<String> adapterAns108_7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, materialTanque);
        adapterAns108_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans108_7.setAdapter(adapterAns108_7);

        Spinner ans110 = (Spinner) findViewById(R.id.ans110);
        ArrayAdapter<String> adapterAns110 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, alimentoPrincipal);
        adapterAns110.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans110.setAdapter(adapterAns110);

        Spinner ans110_1 = (Spinner) findViewById(R.id.ans110_1);
        ArrayAdapter<String> adapterAns110_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, procedenciaAlimento);
        adapterAns110_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans110_1.setAdapter(adapterAns110_1);

        Spinner ans110_2 = (Spinner) findViewById(R.id.ans110_2);
        ArrayAdapter<String> adapterAns110_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frecuenciaAlimento);
        adapterAns110_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans110_2.setAdapter(adapterAns110_2);

        Spinner ans110_3 = (Spinner) findViewById(R.id.ans110_3);
        ArrayAdapter<String> adapterAns110_3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, departamentos);
        adapterAns110_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans110_3.setAdapter(adapterAns110_3);

        Spinner ans111 = (Spinner) findViewById(R.id.ans111);
        ArrayAdapter<String> adapterAns111 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns111.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans111.setAdapter(adapterAns111);

        Spinner ans111_2 = (Spinner) findViewById(R.id.ans111_2);
        ArrayAdapter<String> adapterAns111_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frecuenciaRecambio);
        adapterAns111_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans111_2.setAdapter(adapterAns111_2);

        Spinner ans112 = (Spinner) findViewById(R.id.ans112);
        ArrayAdapter<String> adapterAns112 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns112.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans112.setAdapter(adapterAns112);

        Spinner ans112_2 = (Spinner) findViewById(R.id.ans112_2);
        ArrayAdapter<String> adapterAns112_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, puntoDescarga);
        adapterAns112_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans112_2.setAdapter(adapterAns112_2);

        Spinner ans113 = (Spinner) findViewById(R.id.ans113);
        ArrayAdapter<String> adapterAns113 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns113.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans113.setAdapter(adapterAns113);

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
        ArrayAdapter<String> adapterAns117 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fuenteEnergia);
        adapterAns117.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans117.setAdapter(adapterAns117);

        Spinner ans118 = (Spinner) findViewById(R.id.ans118);
        ArrayAdapter<String> adapterAns118 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns118.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans118.setAdapter(adapterAns118);

        Spinner ans118_1 = (Spinner) findViewById(R.id.ans118_1);
        ArrayAdapter<String> adapterAns118_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoAsociacion);
        adapterAns118_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans118_1.setAdapter(adapterAns118_1);

        Spinner ans118_2 = (Spinner) findViewById(R.id.ans118_2);
        ArrayAdapter<String> adapterAns118_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns118_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans118_2.setAdapter(adapterAns118_2);

        Spinner ans118_4 = (Spinner) findViewById(R.id.ans118_4);
        ArrayAdapter<String> adapterAns118_4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cargoAsociacion);
        adapterAns118_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans118_4.setAdapter(adapterAns118_4);

        Spinner ans118_10 = (Spinner) findViewById(R.id.ans118_10);
        ArrayAdapter<String> adapterAns118_10 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, departamentos);
        adapterAns118_10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans118_10.setAdapter(adapterAns118_10);

        Spinner ans119 = (Spinner) findViewById(R.id.ans119);
        ArrayAdapter<String> adapterAns119 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns119.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans119.setAdapter(adapterAns119);

        Spinner ans120 = (Spinner) findViewById(R.id.ans120);
        ArrayAdapter<String> adapterAns120 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns120.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans120.setAdapter(adapterAns120);

        Spinner ans123 = (Spinner) findViewById(R.id.ans123);
        ArrayAdapter<String> adapterAns123 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lugarVenta);
        adapterAns123.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans123.setAdapter(adapterAns123);

        Spinner ans124 = (Spinner) findViewById(R.id.ans124);
        ArrayAdapter<String> adapterAns124 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, compradores);
        adapterAns124.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans124.setAdapter(adapterAns124);

        Spinner ans126 = (Spinner) findViewById(R.id.ans126);
        ArrayAdapter<String> adapterAns126 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, presentacion);
        adapterAns126.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans126.setAdapter(adapterAns126);

        Spinner ans127 = (Spinner) findViewById(R.id.ans127);
        ArrayAdapter<String> adapterAns127 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns127.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans127.setAdapter(adapterAns127);

        Spinner ans128 = (Spinner) findViewById(R.id.ans128);
        ArrayAdapter<String> adapterAns128 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns128.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans128.setAdapter(adapterAns128);

        Spinner ans128_1 = (Spinner) findViewById(R.id.ans128_1);
        ArrayAdapter<String> adapterAns128_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns128_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans128_1.setAdapter(adapterAns128_1);

        Spinner ans129 = (Spinner) findViewById(R.id.ans129);
        ArrayAdapter<String> adapterAns129 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns129.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans129.setAdapter(adapterAns129);

        Spinner ans130 = (Spinner) findViewById(R.id.ans130);
        ArrayAdapter<String> adapterAns130 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tecnicasReproduccion);
        adapterAns130.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans130.setAdapter(adapterAns130);

        Spinner ans131 = (Spinner) findViewById(R.id.ans131);
        ArrayAdapter<String> adapterAns131 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tecnicasIncubacion);
        adapterAns131.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans131.setAdapter(adapterAns131);

        Spinner ans132 = (Spinner) findViewById(R.id.ans132);
        ArrayAdapter<String> adapterAns132 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
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

        EditText ans42_1other = (EditText) findViewById(R.id.ans42_1other);
        ans42_1other.setVisibility(View.GONE);

        EditText ans44other = (EditText) findViewById(R.id.ans44other);
        ans44other.setVisibility(View.GONE);

        EditText ans64other = (EditText) findViewById(R.id.ans64other);
        ans64other.setVisibility(View.GONE);

        EditText ans100other = (EditText) findViewById(R.id.ans100other);
        ans100other.setVisibility(View.GONE);

        EditText ans102other = (EditText) findViewById(R.id.ans102other);
        ans102other.setVisibility(View.GONE);

        EditText ans112_2other = (EditText) findViewById(R.id.ans112_2other);
        ans112_2other.setVisibility(View.GONE);

        EditText ans117other = (EditText) findViewById(R.id.ans117other);
        ans117other.setVisibility(View.GONE);

        EditText ans118_1other = (EditText) findViewById(R.id.ans118_1other);
        ans118_1other.setVisibility(View.GONE);

        CheckBox ans64g = (CheckBox) findViewById(R.id.ans64g);
        CheckBox ans97k = (CheckBox) findViewById(R.id.ans97k);

        ans42_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans42_1 = (Spinner) findViewById(R.id.ans42_1);
                EditText ans42_1other = (EditText) findViewById(R.id.ans42_1other);
                if(ans42_1.getSelectedItemPosition()==8) {
                    ans42_1other.setVisibility(View.VISIBLE);
                }else{
                    ans42_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans44.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans44 = (Spinner) findViewById(R.id.ans44);
                EditText ans44other = (EditText) findViewById(R.id.ans44other);
                if(ans44.getSelectedItemPosition()==4) {
                    ans44other.setVisibility(View.VISIBLE);
                }else{
                    ans44other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans52.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans52 = (Spinner) findViewById(R.id.ans52);
                EditText ans52other = (EditText) findViewById(R.id.ans52other);
                if(ans52.getSelectedItemPosition()==8) {
                    ans52other.setVisibility(View.VISIBLE);
                }else{
                    ans52other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans64g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans64g = (CheckBox) findViewById(R.id.ans64g);
                EditText ans64other = (EditText) findViewById(R.id.ans64other);
                if(ans64g.isChecked()){
                    ans64other.setVisibility(View.VISIBLE);
                }
                else {
                    ans64other.setVisibility(View.GONE);
                }
            }
        });

        ans97k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans97k = (CheckBox) findViewById(R.id.ans97k);
                EditText ans97other = (EditText) findViewById(R.id.ans97other);
                if(ans97k.isChecked()){
                    ans97other.setVisibility(View.VISIBLE);
                }
                else {
                    ans97other.setVisibility(View.GONE);
                }
            }
        });

        ans100.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans100 = (Spinner) findViewById(R.id.ans100);
                EditText ans100other = (EditText) findViewById(R.id.ans100other);
                if(ans100.getSelectedItemPosition()==4) {
                    ans100other.setVisibility(View.VISIBLE);
                }else{
                    ans100other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans102.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans102 = (Spinner) findViewById(R.id.ans102);
                EditText ans102other = (EditText) findViewById(R.id.ans102other);
                if(ans102.getSelectedItemPosition()==5) {
                    ans102other.setVisibility(View.VISIBLE);
                }else{
                    ans102other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans112_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans112_2 = (Spinner) findViewById(R.id.ans112_2);
                EditText ans112_2other = (EditText) findViewById(R.id.ans112_2other);
                if(ans112_2.getSelectedItemPosition()==2) {
                    ans112_2other.setVisibility(View.VISIBLE);
                }else{
                    ans112_2other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans117.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans117 = (Spinner) findViewById(R.id.ans117);
                EditText ans117other = (EditText) findViewById(R.id.ans117other);
                if(ans117.getSelectedItemPosition()==4) {
                    ans117other.setVisibility(View.VISIBLE);
                }else{
                    ans117other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans118_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans118_1 = (Spinner) findViewById(R.id.ans118_1);
                EditText ans118_1other = (EditText) findViewById(R.id.ans118_1other);
                if(ans118_1.getSelectedItemPosition()==3) {
                    ans118_1other.setVisibility(View.VISIBLE);
                }else{
                    ans118_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        saveButton =  (Button) findViewById(R.id.saveButton1);
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

    private void escribir() {
        try {

            EditText ans43 = (EditText) findViewById(R.id.ans43);
            EditText ans47 = (EditText) findViewById(R.id.ans47);
            EditText ans48 = (EditText) findViewById(R.id.ans48);
            EditText ans49 = (EditText) findViewById(R.id.ans49);
            EditText ans50 = (EditText) findViewById(R.id.ans50);
            EditText ans51 = (EditText) findViewById(R.id.ans51);
            EditText ans54 = (EditText) findViewById(R.id.ans54);
            EditText ans55 = (EditText) findViewById(R.id.ans55);
            EditText ans56 = (EditText) findViewById(R.id.ans56);
            EditText ans57_1 = (EditText) findViewById(R.id.ans57_1);
            EditText ans58 = (EditText) findViewById(R.id.ans58);
            EditText ans59_1 = (EditText) findViewById(R.id.ans59_1);
            EditText ans60_1 = (EditText) findViewById(R.id.ans60_1);
            EditText ans60_2 = (EditText) findViewById(R.id.ans60_2);
            EditText ans60_3 = (EditText) findViewById(R.id.ans60_3);
            EditText ans60_4 = (EditText) findViewById(R.id.ans60_4);
            EditText ans60_5 = (EditText) findViewById(R.id.ans60_5);
            EditText ans60_6 = (EditText) findViewById(R.id.ans60_6);
            EditText ans60_7 = (EditText) findViewById(R.id.ans60_7);
            EditText ans60_8 = (EditText) findViewById(R.id.ans60_8);
            EditText ans61_1 = (EditText) findViewById(R.id.ans61_1);
            EditText ans62_1 = (EditText) findViewById(R.id.ans62_1);
            EditText ans62_2 = (EditText) findViewById(R.id.ans62_2);
            EditText ans66 = (EditText) findViewById(R.id.ans66);
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
            EditText ans86 = (EditText) findViewById(R.id.ans86);
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
            EditText ans98 = (EditText) findViewById(R.id.ans98);
            EditText ans99_1 = (EditText) findViewById(R.id.ans99_1);
            EditText ans105 = (EditText) findViewById(R.id.ans105);
            EditText ans108 = (EditText) findViewById(R.id.ans108);
            EditText ans108_1 = (EditText) findViewById(R.id.ans108_1);
            EditText ans108_2 = (EditText) findViewById(R.id.ans108_2);
            EditText ans108_3 = (EditText) findViewById(R.id.ans108_3);
            EditText ans108_4 = (EditText) findViewById(R.id.ans108_4);
            EditText ans108_5 = (EditText) findViewById(R.id.ans108_5);
            EditText ans108_6 = (EditText) findViewById(R.id.ans108_6);
            EditText ans109 = (EditText) findViewById(R.id.ans109);
            EditText ans109_1 = (EditText) findViewById(R.id.ans109_1);
            EditText ans109_2 = (EditText) findViewById(R.id.ans109_2);
            EditText ans109_3 = (EditText) findViewById(R.id.ans109_3);
            EditText ans109_4 = (EditText) findViewById(R.id.ans109_4);
            EditText ans109_5 = (EditText) findViewById(R.id.ans109_5);
            EditText ans109_6 = (EditText) findViewById(R.id.ans109_6);
            EditText ans109_7 = (EditText) findViewById(R.id.ans109_7);
            EditText ans110_4 = (EditText) findViewById(R.id.ans110_4);
            EditText ans110_5 = (EditText) findViewById(R.id.ans110_5);
            EditText ans110_6 = (EditText) findViewById(R.id.ans110_6);
            EditText ans111_1 = (EditText) findViewById(R.id.ans111_1);
            EditText ans112_1 = (EditText) findViewById(R.id.ans112_1);
            EditText ans112_3 = (EditText) findViewById(R.id.ans112_3);
            EditText ans113_1 = (EditText) findViewById(R.id.ans113_1);
            EditText ans114_1 = (EditText) findViewById(R.id.ans114_1);
            EditText ans116_1 = (EditText) findViewById(R.id.ans116_1);
            EditText ans118_3 = (EditText) findViewById(R.id.ans118_3);
            EditText ans118_5 = (EditText) findViewById(R.id.ans118_5);
            EditText ans118_6 = (EditText) findViewById(R.id.ans118_6);
            EditText ans118_7 = (EditText) findViewById(R.id.ans118_7);
            EditText ans118_8 = (EditText) findViewById(R.id.ans118_8);
            EditText ans118_9 = (EditText) findViewById(R.id.ans118_9);
            EditText ans118_11 = (EditText) findViewById(R.id.ans118_11);
            EditText ans120_1 = (EditText) findViewById(R.id.ans120_1);
            EditText ans121 = (EditText) findViewById(R.id.ans121);
            EditText ans122 = (EditText) findViewById(R.id.ans122);
            EditText ans122_1 = (EditText) findViewById(R.id.ans122_1);
            EditText ans125 = (EditText) findViewById(R.id.ans125);
            EditText ans127_1 = (EditText) findViewById(R.id.ans127_1);
            EditText ans129_1 = (EditText) findViewById(R.id.ans129_1);
            EditText ans144 = (EditText) findViewById(R.id.ans144);

            Spinner ans42 = (Spinner) findViewById(R.id.ans42);
            Spinner ans42_1 = (Spinner) findViewById(R.id.ans42_1);
            Spinner ans44 = (Spinner) findViewById(R.id.ans44);
            Spinner ans45 = (Spinner) findViewById(R.id.ans45);
            Spinner ans46 = (Spinner) findViewById(R.id.ans46);
            Spinner ans52 = (Spinner) findViewById(R.id.ans52);
            Spinner ans53 = (Spinner) findViewById(R.id.ans53);
            Spinner ans57 = (Spinner) findViewById(R.id.ans57);
            Spinner ans59 = (Spinner) findViewById(R.id.ans59);
            Spinner ans60 = (Spinner) findViewById(R.id.ans60);
            Spinner ans61 = (Spinner) findViewById(R.id.ans61);
            Spinner ans62 = (Spinner) findViewById(R.id.ans62);
            Spinner ans63 = (Spinner) findViewById(R.id.ans63);
            Spinner ans65 = (Spinner) findViewById(R.id.ans65);
            Spinner ans85 = (Spinner) findViewById(R.id.ans85);
            Spinner ans99 = (Spinner) findViewById(R.id.ans99);
            Spinner ans100 = (Spinner) findViewById(R.id.ans100);
            Spinner ans101 = (Spinner) findViewById(R.id.ans101);
            Spinner ans102 = (Spinner) findViewById(R.id.ans102);
            Spinner ans103 = (Spinner) findViewById(R.id.ans103);
            Spinner ans106 = (Spinner) findViewById(R.id.ans106);
            Spinner ans107 = (Spinner) findViewById(R.id.ans107);
            Spinner ans108_7 = (Spinner) findViewById(R.id.ans108_7);
            Spinner ans110 = (Spinner) findViewById(R.id.ans110);
            Spinner ans110_1 = (Spinner) findViewById(R.id.ans110_1);
            Spinner ans110_2 = (Spinner) findViewById(R.id.ans110_2);
            Spinner ans110_3 = (Spinner) findViewById(R.id.ans110_3);
            Spinner ans111 = (Spinner) findViewById(R.id.ans111);
            Spinner ans111_2 = (Spinner) findViewById(R.id.ans111_2);
            Spinner ans112 = (Spinner) findViewById(R.id.ans112);
            Spinner ans112_2 = (Spinner) findViewById(R.id.ans112_2);
            Spinner ans113 = (Spinner) findViewById(R.id.ans113);
            Spinner ans114 = (Spinner) findViewById(R.id.ans114);
            Spinner ans115 = (Spinner) findViewById(R.id.ans115);
            Spinner ans116 = (Spinner) findViewById(R.id.ans116);
            Spinner ans117 = (Spinner) findViewById(R.id.ans117);
            Spinner ans118 = (Spinner) findViewById(R.id.ans118);
            Spinner ans118_1 = (Spinner) findViewById(R.id.ans118_1);
            Spinner ans118_2 = (Spinner) findViewById(R.id.ans118_2);
            Spinner ans118_4 = (Spinner) findViewById(R.id.ans118_4);
            Spinner ans118_10 = (Spinner) findViewById(R.id.ans118_10);
            Spinner ans119 = (Spinner) findViewById(R.id.ans119);
            Spinner ans120 = (Spinner) findViewById(R.id.ans120);
            Spinner ans123 = (Spinner) findViewById(R.id.ans123);
            Spinner ans124 = (Spinner) findViewById(R.id.ans124);
            Spinner ans126 = (Spinner) findViewById(R.id.ans126);
            Spinner ans127 = (Spinner) findViewById(R.id.ans127);
            Spinner ans128 = (Spinner) findViewById(R.id.ans128);
            Spinner ans128_1 = (Spinner) findViewById(R.id.ans128_1);
            Spinner ans129 = (Spinner) findViewById(R.id.ans129);
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

            EditText ans42_1other = (EditText) findViewById(R.id.ans42_1other);
            EditText ans44other = (EditText) findViewById(R.id.ans44other);
            EditText ans52other = (EditText) findViewById(R.id.ans52other);
            EditText ans64other = (EditText) findViewById(R.id.ans64other);
            EditText ans97other = (EditText) findViewById(R.id.ans97other);
            EditText ans100other = (EditText) findViewById(R.id.ans100other);
            EditText ans102other = (EditText) findViewById(R.id.ans102other);
            EditText ans112_2other = (EditText) findViewById(R.id.ans112_2other);
            EditText ans117other = (EditText) findViewById(R.id.ans117other);
            EditText ans118_1other = (EditText) findViewById(R.id.ans118_1other);

            CheckBox ans64a = (CheckBox) findViewById(R.id.ans64a);
            CheckBox ans64b = (CheckBox) findViewById(R.id.ans64b);
            CheckBox ans64c = (CheckBox) findViewById(R.id.ans64c);
            CheckBox ans64d = (CheckBox) findViewById(R.id.ans64d);
            CheckBox ans64e = (CheckBox) findViewById(R.id.ans64e);
            CheckBox ans64f = (CheckBox) findViewById(R.id.ans64f);
            CheckBox ans64g = (CheckBox) findViewById(R.id.ans64g);
            CheckBox ans97a = (CheckBox) findViewById(R.id.ans97a);
            CheckBox ans97b = (CheckBox) findViewById(R.id.ans97b);
            CheckBox ans97c = (CheckBox) findViewById(R.id.ans97c);
            CheckBox ans97d = (CheckBox) findViewById(R.id.ans97d);
            CheckBox ans97e = (CheckBox) findViewById(R.id.ans97e);
            CheckBox ans97f = (CheckBox) findViewById(R.id.ans97f);
            CheckBox ans97g = (CheckBox) findViewById(R.id.ans97g);
            CheckBox ans97h = (CheckBox) findViewById(R.id.ans97h);
            CheckBox ans97i = (CheckBox) findViewById(R.id.ans97i);
            CheckBox ans97j = (CheckBox) findViewById(R.id.ans97j);
            CheckBox ans97k = (CheckBox) findViewById(R.id.ans97k);
            CheckBox ans104a = (CheckBox) findViewById(R.id.ans104a);
            CheckBox ans104b = (CheckBox) findViewById(R.id.ans104b);
            CheckBox ans104c = (CheckBox) findViewById(R.id.ans104c);
            CheckBox ans104d = (CheckBox) findViewById(R.id.ans104d);
            CheckBox ans104e = (CheckBox) findViewById(R.id.ans104e);
            CheckBox ans104f = (CheckBox) findViewById(R.id.ans104f);

            FileOutputStream fos = new FileOutputStream(myExternalFile,true);

            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans42.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans42_1.getSelectedItemPosition()+1).getBytes());
            fos.write((", " + ans42_1other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans43.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans44.getSelectedItemPosition()+1).getBytes());
            fos.write((", " + ans44other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans45.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans46.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans47.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans48.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans49.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans50.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans51.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans52.getSelectedItemPosition()+1).getBytes());
            fos.write((", " + ans52other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans53.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans54.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans55.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans56.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans57.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans57_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans58.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans59.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans59_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans60.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans60_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans60_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans60_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans60_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans60_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans60_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans60_7.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans60_8.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans61.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans61_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans62.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans62_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans62_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans63.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            if(ans64a.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans64b.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(ans64c.isChecked()){
                fos.write("3, ".getBytes());
            }
            if(ans64d.isChecked()){
                fos.write("4, ".getBytes());
            }
            if(ans64e.isChecked()){
                fos.write("5, ".getBytes());
            }
            if(ans64f.isChecked()){
                fos.write("6, ".getBytes());
            }
            if(ans64g.isChecked()){
                fos.write("7, ".getBytes());
            }
            fos.write((", " + ans64other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans65.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans66.getText().toString().getBytes());
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
            fos.write(Integer.toString(ans85.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans86.getText().toString().getBytes());
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
            if(ans97a.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans97b.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(ans97c.isChecked()){
                fos.write("3, ".getBytes());
            }
            if(ans97d.isChecked()){
                fos.write("4, ".getBytes());
            }
            if(ans97e.isChecked()){
                fos.write("5, ".getBytes());
            }
            if(ans97f.isChecked()){
                fos.write("6, ".getBytes());
            }
            if(ans97g.isChecked()){
                fos.write("7, ".getBytes());
            }
            if(ans97h.isChecked()){
                fos.write("8, ".getBytes());
            }
            if(ans97i.isChecked()){
                fos.write("9, ".getBytes());
            }
            if(ans97j.isChecked()){
                fos.write("10, ".getBytes());
            }
            if(ans97k.isChecked()){
                fos.write("11, ".getBytes());
            }
            fos.write((", " + ans97other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans98.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans99.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans99_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans100.getSelectedItemPosition()+1).getBytes());
            fos.write((", " + ans100other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans101.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans102.getSelectedItemPosition()+1).getBytes());
            fos.write((", " + ans102other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans103.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            if(ans104a.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ans104b.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(ans104c.isChecked()){
                fos.write("3, ".getBytes());
            }
            if(ans104d.isChecked()){
                fos.write("4, ".getBytes());
            }
            if(ans104e.isChecked()){
                fos.write("5, ".getBytes());
            }
            if(ans104f.isChecked()){
                fos.write("6, ".getBytes());
            }
            fos.write("\t".getBytes());
            fos.write(ans105.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans106.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans107.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans108.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans108_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans108_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans108_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans108_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans108_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans108_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans108_7.getSelectedItemPosition()+1).getBytes());
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
            fos.write(ans109_7.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans110.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans110_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans110_2.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans110_3.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans110_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans110_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans110_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans111.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans111_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans111_2.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans112.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans112_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans112_2.getSelectedItemPosition()+1).getBytes());
            fos.write((", " + ans112_2other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans112_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans113.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans113_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans114.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans114_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans115.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans116.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans116_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans117.getSelectedItemPosition()+1).getBytes());
            fos.write((", " + ans117other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans118.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans118_1.getSelectedItemPosition()+1).getBytes());
            fos.write((", " + ans118_1other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans118_2.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans118_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans118_4.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans118_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans118_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans118_7.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans118_8.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans118_9.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans118_10.getItemAtPosition(ans118_10.getSelectedItemPosition()).toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans118_11.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans119.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans120.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans120_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans121.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans122.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans122_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans123.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans124.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans125.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans126.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans127.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans127_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans128.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans128_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans129.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans129_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans130.getSelectedItemPosition()+1).getBytes());
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
            fos.write(ans144.getText().toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}