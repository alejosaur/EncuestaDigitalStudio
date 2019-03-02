package fedejandro.encuestadigital;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.*;

import java.io.*;

public class Preguntas1 extends AppCompatActivity {

    Button nextButtonECUPAC, nextButtonECUPPA;
    private String filename = "datos.txt";
    private String filepath = "EncuestaDatos";
    File myExternalFile;

    private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 0; // in Meters
    private static final long MINIMUM_TIME_BETWEEN_UPDATES = 10; // in Milliseconds
    protected LocationManager locationManager;
    protected LocationManager locationManagerGPS;

    public int ans26code = 0;
    public int ans31_4code = 0;
    public int ans32_4code = 0;
    public int ans33_3code = 0;
    public int ans37code = 0;
    public int ans40_2code = 0;
    public int ans41_2code = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas1);

        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {

            ActivityCompat.requestPermissions( this, new String[] {  android.Manifest.permission.ACCESS_FINE_LOCATION  },
                    11);
        }

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                MINIMUM_TIME_BETWEEN_UPDATES,
                MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
                new MyLocationListener()
        );

        locationManagerGPS = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManagerGPS.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                MINIMUM_TIME_BETWEEN_UPDATES,
                MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
                new MyLocationListener()
        );

        String[] departamentos = new String[] {
                "Amazonas","Antioquia","Arauca","Atlántico","Bolívar","Boyacá","Caldas","Caquetá","Casanare","Cauca","Cesar",
                "Chocó","Córdoba","Cundinamarca","Guainía","Guaviare","Huila","La Guajira","Magdalena","Meta","Nariño",
                "Norte de Santander","Putumayo","Quindío","Risaralda","San Andrés y Providencia","Santander","Sucre","Tolima",
                "Valle del Cauca","Vaupés","Vichada"
        };
        final String[] municipiosAmazonas = new String[]{
                "Leticia", "Puerto Nariño"
        };
        final String[] municipiosAntioquia = new String[] {
                "Medellín", "Abejorral", "Abriaqui", "Alejandría", "Amaga", "Amalfi", "Andes", "Angelopolis", "Angostura",
                "Anorí", "Anza", "Apartado", "Arboletes", "Argelia", "Armenia", "Barbosa", "Bello", "Belmira", "Betania",
                "Betulia", "Bolívar", "Briceño", "Buritica", "Cáceres", "Caicedo", "Caldas", "Campamento", "Cañasgordas",
                "Caracolí", "Caramanta", "Carepa", "Carmen De Viboral", "Carolina", "Caucasia", "Chigorodó", "Cisneros",
                "Cocorná", "Concepción", "Concordia", "Copacabana", "Dabeiba", "Don Matías", "Ebejico", "El Bagre",
                "Entrerrios", "Envigado", "Fredonia", "Frontino", "Giraldo", "Girardota", "Gómez Plata", "Granada",
                "Guadalupe", "Guarne", "Guatapé", "Heliconia", "Hispania", "Itagui", "Ituango", "Jardín", "Jericó", "La Ceja",
                "La Estrella", "La Pintada", "La Unión", "Liborina", "Maceo", "Marinilla", "Montebello", "Murindó", "Mutatá",
                "Nariño", "Nechí", "Necoclí", "Olaya", "Peñol", "Peque", "Pueblorrico", "Puerto Berrío", "Puerto Nare",
                "Puerto Triunfo", "Remedios", "Retiro", "Rionegro", "Sabanalarga", "Sabaneta", "Salgar", "San Andrés",
                "San Carlos", "San Francisco", "San Pedro De Uraba", "San José De La Montaña", "San Juan De Uraba",
                "Santa Rosa De Osos", "San Pedro", "San Jerónimo", "San Rafael", "San Roque", "San Vicente", "Santa Bárbara",
                "San Luis", "Santafé de Antioquia", "Santo Domingo", "Santuario", "Segovia", "Sonson", "Sopetrán", "Támesis",
                "Taraza", "Tarso", "Titiribí", "Toledo", "Turbo", "Uramita", "Urrao", "Valdivia", "Valparaíso", "Vegachi",
                "Venecia", "Vigía Del Fuerte", "Yali", "Yarumal", "Yolombó", "Yondó", "Zaragoza"
        };
        final String[] municipiosArauca = new String[] {
                "Arauca", "Arauquita", "Cravo Norte", "Fortul", "Puerto Rondón", "Saravena", "Tame"
        };
        final String[] municipiosAtlantico = new String[]{
                "Baranoa", "Barranquilla", "Campo De La Cruz", "Candelaria", "Galapa", "Juan De Acosta", "Luruaco", "Malambo",
                "Manatí", "Palmar De Varela", "Piojó", "Polonuevo", "Ponedera", "Puerto Colombia", "Repelón", "Sabanagrande",
                "Sabanalarga", "Santa Lucía", "Santo Tomás", "Soledad", "Suan", "Tubará", "Usiacurí"
        };
        final String[] municipiosBolivar = new String[]{
                "Achí", "Altos Del Rosario", "Arenal", "Arjona", "Arroyohondo", "Barranco De Loba", "Calamar", "Cantagallo",
                "Cartagena", "Cicuco", "Clemencia", "Córdoba", "El Carmen De Bolívar", "El Guamo", "El Peñón", "Hatillo De Loba",
                "Magangué", "Mahates", "Margarita", "María La Baja", "Mompós", "Montecristo", "Morales", "Pinillos", "Regidor",
                "Río Viejo", "San Cristóbal", "San Estanislao", "San Fernando", "San Jacinto", "San Jacinto Del Cauca",
                "San Juan Nepomuceno", "San Martín De Loba", "San Pablo", "Santa Catalina", "Santa Rosa", "Santa Rosa Del Sur",
                "Simití", "Soplaviento", "Talaigua Nuevo", "Tiquisio", "Turbaco", "Turbaná", "Villanueva", "Zambrano"
        };
        final String[] municipiosBoyaca = new String[]{
                "Almeida", "Aquitania", "Arcabuco", "Belén", "Berbeo", "Betéitiva", "Boavita", "Boyacá", "Briceño", "Buenavista",
                "Busbanzá", "Caldas", "Campohermoso", "Cerinza", "Chinavita", "Chiquinquirá", "Chíquiza", "Chiscas", "Chita",
                "Chitaraque", "Chivatá", "Chivor", "Ciénega", "Cómbita", "Coper", "Corrales", "Covarachía", "Cubará", "Cucaita",
                "Cuítiva", "Duitama", "El Cocuy", "El Espino", "Firavitoba", "Floresta", "Gachantivá", "Gameza", "Garagoa",
                "Guacamayas", "Guateque", "Guayatá", "Güicán", "Iza", "Jenesano", "Jericó", "La Capilla", "La Uvita",
                "La Victoria", "Labranzagrande", "Macanal", "Maripí", "Miraflores", "Mongua", "Monguí", "Moniquirá", "Motavita",
                "Muzo", "Nobsa", "Nuevo Colón", "Oicatá", "Otanche", "Pachavita", "Páez", "Paipa", "Pajarito", "Panqueba",
                "Pauna", "Paya", "Paz De Río", "Pesca", "Pisba", "Puerto Boyacá", "Quípama", "Ramiriquí", "Ráquira", "Rondón",
                "Saboyá", "Sáchica", "Samacá", "San Eduardo", "San José De Pare", "San Luis De Gaceno", "San Mateo",
                "San Miguel De Sema", "San Pablo De Borbur", "Santa María", "Santa Rosa De Viterbo", "Santa Sofía", "Santana",
                "Sativanorte", "Sativasur", "Siachoque", "Soatá", "Socha", "Socotá", "Sogamoso", "Somondoco", "Sora", "Soracá",
                "Sotaquirá", "Susacón", "Sutamarchán", "Sutatenza", "Tasco", "Tenza", "Tibaná", "Tibasosa", "Tinjacá",
                "Tipacoque", "Toca", "Togüí", "Tópaga", "Tota", "Tunja", "Tununguá", "Turmequé", "Tuta", "Tutazá", "Umbita",
                "Ventaquemada", "Villa De Leyva", "Viracachá", "Zetaquira"
        };
        final String[] municipiosCaldas = new String[]{
                "Aguadas", "Anserma", "Aranzazu", "Belalcázar", "Chinchiná", "Filadelfia", "La Dorada", "La Merced", "Manizales",
                "Manzanares", "Marmato", "Marquetalia", "Marulanda", "Neira", "Norcasia", "Pácora", "Palestina", "Pensilvania",
                "Riosucio", "Risaralda", "Salamina", "Samaná", "San José", "Supía", "Victoria", "Villamaría", "Viterbo"
        };
        final String[] municipiosCaqueta = new String[]{
                "Albania", "Belén De Los Andaquies", "Cartagena Del Chairá", "Curillo", "El Doncello", "El Paujil", "Florencia",
                "La Montañita", "Milán", "Morelia", "Puerto Rico", "San José Del Fragua", "San Vicente Del Caguán", "Solano",
                "Solita", "Valparaíso"
        };
        final String[] municipiosCasanare = new String[]{
                "Aguazul", "Chameza", "Hato Corozal", "La Salina", "Maní", "Monterrey", "Nunchía", "Orocué", "Paz De Ariporo",
                "Pore", "Recetor", "Sabanalarga", "Sácama", "San Luis De Palenque", "Támara", "Tauramena", "Trinidad",
                "Villanueva", "Yopal"
        };
        final String[] municipiosCauca = new String[]{
                "Almaguer", "Argelia", "Balboa", "Bolívar", "Buenos Aires", "Cajibío", "Caldonó", "Caloto", "Corinto",
                "El Tambo", "Florencia", "Guapi", "Inzá", "Jambaló", "La Sierra", "La Vega", "López de Micay", "Mercaderes",
                "Miranda", "Morales", "Padilla", "Paez", "Patía", "Piamonte", "Piendamó", "Popayán", "Puerto Tejada", "Puracé",
                "Rosas", "San Sebastián", "Santa Rosa", "Santander De Quilichao", "Silvia", "Sotará", "Suárez", "Sucre",
                "Timbío", "Timbiquí", "Toribío", "Totoró", "Villa Rica"
        };
        final String[] municipiosCesar = new String[]{
                "Aguachica", "Agustín Codazzi", "Astrea", "Becerril", "Bosconia", "Chimichagua", "Chiriguaná", "Curumaní",
                "El Copey", "El Paso", "Gamarra", "González", "La Gloria", "La Jagua De Ibirico", "La Paz", "Manaure",
                "Pailitas", "Pelaya", "Pueblo Bello", "Río De Oro", "San Alberto", "San Diego", "San Martín", "Tamalameque",
                "Valledupar"
        };
        final String[] municipiosChoco = new String[]{
                "Acandí", "Alto Baudó", "Atrato", "Bagadó", "Bahía Solano", "Bajo Baudó", "Bojaya", "Carmen Del Darién",
                "Cértegui", "Condoto", "El Cantón Del San Pablo", "El Carmen De Atrato", "El Litoral Del San Juan", "Istmina",
                "Juradó", "Lloró", "Medio Atrato", "Medio Baudó", "Medio San Juan", "Nóvita", "Nuquí", "Quibdó", "Río Iro",
                "Río Quito", "Riosucio", "San José Del Palmar", "Sipí", "Tadó", "Unguía", "Unión Panamericana"
        };
        final String[] municipiosCordoba = new String[]{
                "Ayapel", "Buenavista", "Canalete", "Cereté", "Chimá", "Chinú", "Ciénaga De Oro", "Cotorra", "La Apartada",
                "Los Córdobas", "Momil", "Moñitos", "Montelíbano", "Montería", "Planeta Rica", "Pueblo Nuevo",
                "Puerto Escondido", "Puerto Libertador", "Purísima", "Sahagún", "San Andrés de Sotavento", "San Antero",
                "San Bernardo Del Viento", "San Carlos", "San Pelayo", "Santa Cruz de Lorica", "Tierralta", "Tuchín", "Valencia"
        };
        final String[] municipiosCundinamarca = new String[]{
                "Agua De Dios", "Albán", "Anapoima", "Anolaima", "Apulo", "Arbeláez", "Beltrán", "Bituima", "Bogotá", "Bojacá",
                "Cabrera", "Cachipay", "Cajicá", "Caparrapí", "Cáqueza", "Carmen De Carupa", "Chaguaní", "Chía", "Chipaque",
                "Choachí", "Chocontá", "Cogua", "Cota", "Cucunubá", "El Colegio", "El Peñón", "El Rosal", "Facatativá", "Fomeque",
                "Fosca", "Funza", "Fúquene", "Fusagasugá", "Gachalá", "Gachancipá", "Gachetá", "Gama", "Girardot", "Granada",
                "Guachetá", "Guaduas", "Guasca", "Guataquí", "Guatavita", "Guayabal De Siquima", "Guayabetal", "Gutiérrez",
                "Jerusalén", "Junín", "La Calera", "La Mesa", "La Palma", "La Peña", "La Vega", "Lenguazaque", "Macheta",
                "Madrid", "Manta", "Medina", "Mosquera", "Nariño", "Nemocón", "Nilo", "Nimaima", "Nocaima", "Pacho", "Paime",
                "Pandi", "Paratebueno", "Pasca", "Puerto Salgar", "Pulí", "Quebradanegra", "Quetame", "Quipile", "Ricaurte",
                "San Antonio Del Tequendama", "San Bernardo", "San Cayetano", "San Francisco", "San Juan De Río Seco", "Sasaima",
                "Sesquilé", "Sibaté", "Silvania", "Simijaca", "Soacha", "Sopó", "Subachoque", "Suesca", "Supatá", "Susa",
                "Sutatausa", "Tabio", "Tausa", "Tena", "Tenjo", "Tibacuy", "Tibirita", "Tocaima", "Tocancipá", "Topaipí",
                "Ubalá", "Ubaque", "Ubaté", "Une", "Útica", "Venecia", "Vergara", "Vianí", "Villagómez", "Villapinzón", "Villeta",
                "Viotá", "Yacopí", "Zipacón", "Zipaquirá"
        };
        final String[] municipiosGuainia = new String[]{
                "Inírida"
        };
        final String[] municipiosGuaviare = new String[]{
                "Calamar", "El Retorno", "Miraflores", "San José Del Guaviare"
        };
        final String[] municipiosHuila = new String[]{
                "Acevedo", "Agrado", "Aipe", "Algeciras", "Altamira", "Baraya", "Campoalegre", "Colombia", "Elías", "Garzón",
                "Gigante", "Guadalupe", "Hobo", "Iquira", "Isnos", "La Argentina", "La Plata", "Nátaga", "Neiva", "Oporapa",
                "Paicol", "Palermo", "Palestina", "Pital", "Pitalito", "Rivera", "Saladoblanco", "San Agustín", "Santa María",
                "Suaza", "Tarqui", "Tello", "Teruel", "Tesalia", "Timaná", "Villavieja", "Yaguará"
        };
        final String[] municipiosGuajira = new String[]{
                "Albania", "Barrancas", "Dibulla", "Distracción", "El Molino", "Fonseca", "Hatonuevo", "La Jagua Del Pilar",
                "Maicao", "Manaure", "Riohacha", "San Juan Del Cesar", "Uribia", "Urumita", "Villanueva"
        };
        final String[] municipiosMagdalena = new String[]{
                "Algarrobo", "Aracataca", "Ariguaní", "Cerro de San Antonio", "Chibolo", "Ciénaga", "Concordia", "El Banco",
                "El Piñon", "El Retén", "Fundación", "Guamal", "Nueva Granada", "Pedraza", "Pijiño Del Carmen", "Pivijay",
                "Plato", "Puebloviejo", "Remolino", "Sabanas De San Angel", "Salamina", "San Sebastián De Buenavista",
                "San Zenón", "Santa Ana", "Santa Bárbara De Pinto", "Santa Marta", "Sitionuevo", "Tenerife", "Zapayán",
                "Zona Bananera"
        };
        final String[] municipiosMeta = new String[]{
                "Acacías", "Barranca De Upía", "Cabuyaro", "Castilla La Nueva", "Cubarral", "Cumaral", "El Calvario",
                "El Castillo", "El Dorado", "Fuente De Oro", "Granada", "Guamal", "La Macarena", "Lejanías", "Mapiripán",
                "Mesetas", "Puerto Concordia", "Puerto Gaitán", "Puerto Lleras", "Puerto López", "Puerto Rico", "Restrepo",
                "San Carlos De Guaroa", "San Juan De Arama", "San Juanito", "San Martín", "Uribe", "Villavicencio",
                "Vistahermosa"
        };
        final String[] municipiosNarino = new String[]{
                "Albán", "Aldana", "Ancuyá", "Arboleda", "Barbacoas", "Belén", "Buesaco", "Chachagüí", "Colón", "Consacá",
                "Contadero", "Córdoba", "Cuaspud", "Cumbal", "Cumbitara", "El Charco", "El Peñol", "El Rosario",
                "El Tablón De Gómez", "El Tambo", "Francisco Pizarro", "Funes", "Guachucal", "Guaitarilla", "Gualmatán", "Iles",
                "Imués", "Ipiales", "La Cruz", "La Florida", "La Llanada", "La Tola", "La Unión", "Leiva", "Linares", "Los Andes",
                "Magüi Payán", "Mallama", "Mosquera", "Nariño", "Olaya Herrera", "Ospina", "Pasto", "Policarpa", "Potosí",
                "Providencia", "Puerres", "Pupiales", "Ricaurte", "Roberto Payán", "Samaniego", "San Bernardo", "San Lorenzo",
                "San Pablo", "San Pedro De Cartago", "Sandoná", "Santa Bárbara", "Santacruz", "Sapuyes", "Taminango", "Tangua",
                "Tumaco", "Túquerres", "Yacuanquer"
        };
        final String[] municipiosNdeSantander = new String[]{
                "Abrego", "Arboledas", "Bochalema", "Bucarasica", "Cachirá", "Cácota", "Chinácota", "Chitagá", "Convención",
                "Cúcuta", "Cucutilla", "Durania", "El Carmen", "El Tarra", "El Zulia", "Gramalote", "Hacarí", "Herrán",
                "La Esperanza", "La Playa", "Labateca", "Los Patios", "Lourdes", "Mutiscua", "Ocaña", "Pamplona", "Pamplonita",
                "Puerto Santander", "Ragonvalia", "Salazar de las palmas", "San Calixto", "San Cayetano", "Santiago", "Sardinata",
                "Silos", "Teorama", "Tibú", "Toledo", "Villa Caro", "Villa Del Rosario"
        };
        final String[] municipiosPutumayo = new String[]{
                "Colón", "Mocoa", "Orito", "Puerto Asís", "Puerto Caicedo", "Puerto Guzmán", "Puerto Leguízamo", "San Francisco",
                "San Miguel", "Santiago", "Sibundoy", "Valle Del Guamuez", "Villagarzón"
        };
        final String[] municipiosQuindio = new String[]{
                "Armenia", "Buenavista", "Calarcá", "Circasia", "Córdoba", "Filandia", "Génova", "La Tebaida", "Montenegro",
                "Pijao", "Quimbaya", "Salento"
        };
        final String[] municipiosRisaralda = new String[]{
                "Apía", "Balboa", "Belén De Umbría", "Dosquebradas", "Guática", "La Celia", "La Virginia", "Marsella", "Mistrató",
                "Pereira", "Pueblo Rico", "Quinchía", "Santa Rosa De Cabal", "Santuario"
        };
        final String[] municipiosSanAndres = new String[]{
                "San Andrés", "Providencia y Santa Catalina"
        };
        final String[] municipiosSantander = new String[]{
                "Aguada", "Albania", "Aratoca", "Barbosa", "Barichara", "Barrancabermeja", "Betulia", "Bolívar", "Bucaramanga",
                "Cabrera", "California", "Capitanejo", "Carcasí", "Cepitá", "Cerrito", "Charalá", "Charta", "Chima", "Chipatá",
                "Cimitarra", "Concepción", "Confines", "Contratación", "Coromoro", "Curití", "El Carmen De Chucurí",
                "El Guacamayo", "El Peñón", "El Playón", "Encino", "Enciso", "Florián", "Floridablanca", "Galán", "Gámbita",
                "Girón", "Guaca", "Guadalupe", "Guapotá", "Guavatá", "Güepsa", "Hato", "Jesús María", "Jordán", "La Belleza",
                "La Paz", "Landázuri", "Lebríja", "Los Santos", "Macaravita", "Málaga", "Matanza", "Mogotes", "Molagavita",
                "Ocamonte", "Oiba", "Onzaga", "Palmar", "Palmas Del Socorro", "Páramo", "Piedecuesta", "Pinchote",
                "Puente Nacional", "Puerto Parra", "Puerto Wilches", "Rionegro", "Sabana De Torres", "San Andrés", "San Benito",
                "San Gil", "San Joaquín", "San José De Miranda", "San Miguel", "San Vicente De Chucurí", "Santa Bárbara",
                "Santa Helena Del Opón", "Simacota", "Socorro", "Suaita", "Sucre", "Suratá", "Tona", "Valle De San José",
                "Vélez", "Vetas", "Villanueva", "Zapatoca"
        };
        final String[] municipiosSucre = new String[]{
                "Buenavista", "Caimito", "Chalán", "Colosó", "Corozal", "Coveñas", "El Roble", "Galeras", "Guaranda", "La Unión",
                "Los Palmitos", "Majagual", "Morroa", "Ovejas", "Palmito", "Sampués", "San Benito Abad", "San Juan De Betulia",
                "San Marcos", "San Onofre", "San Pedro", "Santiago De Tolú", "Sincé", "Sincelejo", "Sucre", "Tolú Viejo"
        };
        final String[] municipiosTolima = new String[]{
                "Alpujarra", "Alvarado", "Ambalema", "Anzoátegui", "Armero Guayabal", "Ataco", "Cajamarca", "Carmen De Apicalá",
                "Casabianca", "Chaparral", "Coello", "Coyaima", "Cunday", "Dolores", "Espinal", "Falan", "Flandes", "Fresno",
                "Guamo", "Herveo", "Honda", "Ibagué", "Icononzo", "Lérida", "Líbano", "Mariquita", "Melgar", "Murillo",
                "Natagaima", "Ortega", "Palocabildo", "Piedras", "Planadas", "Prado", "Purificación", "Rioblanco", "Roncesvalles",
                "Rovira", "Saldaña", "San Antonio", "San Luis", "Santa Isabel", "Suárez", "Valle De San Juan", "Venadillo",
                "Villahermosa", "Villarrica"
        };
        final String[] municipiosValle = new String[]{
                "Alcalá", "Andalucía", "Ansermanuevo", "Argelia", "Bolívar", "Buenaventura", "Bugalagrande", "Caicedonia", "Cali",
                "Calima el Darién", "Candelaria", "Cartago", "Dagua", "El Águila", "El Cairo", "El Cerrito", "El Dovio",
                "Florida", "Ginebra", "Guacarí", "Guadalajara De Buga", "Jamundí", "La Cumbre", "La Unión", "La Victoria",
                "Obando", "Palmira", "Pradera", "Restrepo", "Riofrío", "Roldanillo", "San Pedro", "Sevilla", "Toro", "Trujillo",
                "Tuluá", "Ulloa", "Versalles", "Vijes", "Yotoco", "Yumbo", "Zarzal"
        };
        final String[] municipiosVaupes = new String[]{
                "Taruru", "Mitú", "Taraira"
        };
        final String[] municipiosVichada = new String[]{
                "Cumaribo", "La Primavera", "Puerto Carreño", "Santa Rosalía"
        };
        String[] tipoDoc = new String[] {
                "Tarjeta de Identidad","Cédula de Ciudadanía","Cédula de Extranjería","Visa de Trabajo"
        };
        String[] gruposEtnicos = new String[] {
                "No Aplica","Afrocolombiano","Indígena","Mestizo","Otro, ¿Cuál?"
        };
        String[] genero = new String[] {
                "Masculino","Femenino"
        };
        String[] tipoPersona = new String[] {
                "Natural","Jurídica"
        };
        String[] sino = new String[] {
                "Sí","No"
        };
        String[] siNoNoAplica = new String[] {
                "No aplica", "Si", "No"
        };
        String[] causaDesplazamiento = new String[] {
                "No Aplica","Conflicto Armado","Ambiental","Económica", "Otra"
        };
        String[] relacionPersonas = new String[] {
                "Cónyuge","Hijo/a","Yerno/Nuera","Nieto/a, Bisnieto/a","Padre o madre del cónyuge","Otro pariente",
                "No emparentado", "Encuestado"
        };
        String[] estadoCivil = new String[] {
                "Soltero","Casado","Unión Libre","Separado","Divorciado","Viudo"
        };
        String[] gradoEstudio = new String[] {
                "Básica primaria (1° a 5° grado)","Básica secundaria (6° a 9° grado)","Media (10° a 11° grado)","Técnico",
                "Tecnólogo","Profesional pregrado","Postgrado", "Ninguno"
        };
        String[] estadoEmpleo = new String[] {
                "Empleado","Desempleado"
        };
        String[] fijoIndependiente = new String[] {
                "No Aplica","Empleado fijo (algún tipo de contrato)","Trabajador independiente"
        };
        String[] tipoIndependiente = new String[] {
                "No Aplica","Empleador","Trabaja por cuenta propia","Trabajador familiar no retribuído",
                "Socio de cooperativa de productores","Otro, ¿cuál?"
        };
        String[] gastosIngresos = new String[] {
                " ≤  $250.000","$250.000 - $1´000.000","≥ $1´000.000"
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
        String[] nivelEducacion = new String[] {
                "No aplica", "Básica primaria","Básica secundaria","Media","Técnica", "Tecnólogico",
                "Profesional pregrado","Postgrado"
        };
        String[] afiliacionSalud = new String[] {
                "Régimen Contributivo (EPS)","Régimen Subsidiado","Régimen Especial","No afiliado","No sabe"
        };
        String[] establecimientoSalud = new String[] {
                "No aplica", "Hospital","Clínica","Centro de Salud","Puesto de Salud"
        };
        String[] entidadesAcuicolas = new String[] {
                "AUNAP","ICA","CAR-CORPOCESAR","UMATA","Otras", "Ninguna"
        };
        String[] periodicaPermanente = new String[] {
                "Periódica","Permanente"
        };
        String[] entidadesCredito = new String[] {
                "No Aplica","Banco comercial","Sociedad o cooperativas de crédito","Prestamista","Proveedores de insumos",
                "Familiares o amigos","Gobierno","Otro, ¿cuál?"
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

        Spinner ans2 = (Spinner) findViewById(R.id.ans2);
        ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, municipiosAmazonas);
        adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans2.setAdapter(adapterAns2);

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

        Spinner ans18_1 = (Spinner) findViewById(R.id.ans18_1);
        ArrayAdapter<String> adapterAns18_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, relacionPersonas);
        adapterAns18_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans18_1.setAdapter(adapterAns18_1);

        Spinner ans18_2 = (Spinner) findViewById(R.id.ans18_2);
        ArrayAdapter<String> adapterAns18_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genero);
        adapterAns18_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans18_2.setAdapter(adapterAns18_2);

        Spinner ans18_4 = (Spinner) findViewById(R.id.ans18_4);
        ArrayAdapter<String> adapterAns18_4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estadoCivil);
        adapterAns18_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans18_4.setAdapter(adapterAns18_4);

        Spinner ans18_5 = (Spinner) findViewById(R.id.ans18_5);
        ArrayAdapter<String> adapterAns18_5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns18_5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans18_5.setAdapter(adapterAns18_5);

        Spinner ans18_6 = (Spinner) findViewById(R.id.ans18_6);
        ArrayAdapter<String> adapterAns18_6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns18_6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans18_6.setAdapter(adapterAns18_6);

        Spinner ans18_7 = (Spinner) findViewById(R.id.ans18_7);
        ArrayAdapter<String> adapterAns18_7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gradoEstudio);
        adapterAns18_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans18_7.setAdapter(adapterAns18_7);

        Spinner ans19 = (Spinner) findViewById(R.id.ans19);
        ArrayAdapter<String> adapterAns19 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estadoEmpleo);
        adapterAns19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans19.setAdapter(adapterAns19);

        Spinner ans20 = (Spinner) findViewById(R.id.ans20);
        ArrayAdapter<String> adapterAns20 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fijoIndependiente);
        adapterAns20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans20.setAdapter(adapterAns20);

        Spinner ans20_1 = (Spinner) findViewById(R.id.ans20_1);
        ArrayAdapter<String> adapterAns20_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoIndependiente);
        adapterAns20_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans20_1.setAdapter(adapterAns20_1);

        Spinner ans21_1 = (Spinner) findViewById(R.id.ans21_1);
        ArrayAdapter<String> adapterAns21_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gastosIngresos);
        adapterAns21_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans21_1.setAdapter(adapterAns21_1);

        Spinner ans21_2 = (Spinner) findViewById(R.id.ans21_2);
        ArrayAdapter<String> adapterAns21_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gastosIngresos);
        adapterAns21_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans21_2.setAdapter(adapterAns21_1);

        Spinner ans22 = (Spinner) findViewById(R.id.ans22);
        ArrayAdapter<String> adapterAns22 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoVivienda);
        adapterAns22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans22.setAdapter(adapterAns22);

        Spinner ans23 = (Spinner) findViewById(R.id.ans23);
        ArrayAdapter<String> adapterAns23 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, materialTecho);
        adapterAns23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans23.setAdapter(adapterAns23);

        Spinner ans24 = (Spinner) findViewById(R.id.ans24);
        ArrayAdapter<String> adapterAns24 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, materialPiso);
        adapterAns24.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans24.setAdapter(adapterAns24);

        Spinner ans25 = (Spinner) findViewById(R.id.ans25);
        ArrayAdapter<String> adapterAns25 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, materialPared);
        adapterAns25.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans25.setAdapter(adapterAns25);

        Spinner ans27 = (Spinner) findViewById(R.id.ans27);
        ArrayAdapter<String> adapterAns27 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns27.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans27.setAdapter(adapterAns27);

        Spinner ans28 = (Spinner) findViewById(R.id.ans28);
        ArrayAdapter<String> adapterAns28 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans28.setAdapter(adapterAns28);

        Spinner ans29 = (Spinner) findViewById(R.id.ans29);
        ArrayAdapter<String> adapterAns29 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns29.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans29.setAdapter(adapterAns29);

        Spinner ans30 = (Spinner) findViewById(R.id.ans30);
        ArrayAdapter<String> adapterAns30 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoEducacion);
        adapterAns30.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans30.setAdapter(adapterAns30);

        Spinner ans31_1 = (Spinner) findViewById(R.id.ans31_1);
        ArrayAdapter<String> adapterAns31_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nivelEducacion);
        adapterAns31_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans31_1.setAdapter(adapterAns31_1);

        Spinner ans32 = (Spinner) findViewById(R.id.ans32);
        ArrayAdapter<String> adapterAns32 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, afiliacionSalud);
        adapterAns32.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans32.setAdapter(adapterAns32);

        Spinner ans32_1 = (Spinner) findViewById(R.id.ans32_1);
        ArrayAdapter<String> adapterAns32_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, establecimientoSalud);
        adapterAns32_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans32_1.setAdapter(adapterAns32_1);

        Spinner ans33 = (Spinner) findViewById(R.id.ans33);
        ArrayAdapter<String> adapterAns33 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, entidadesAcuicolas);
        adapterAns33.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans33.setAdapter(adapterAns33);

        Spinner ans38 = (Spinner) findViewById(R.id.ans38);
        ArrayAdapter<String> adapterAns38 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, periodicaPermanente);
        adapterAns38.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans38.setAdapter(adapterAns38);

        Spinner ans39 = (Spinner) findViewById(R.id.ans39);
        ArrayAdapter<String> adapterAns39 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns39.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans39.setAdapter(adapterAns39);

        Spinner ans39_1 = (Spinner) findViewById(R.id.ans39_1);
        ArrayAdapter<String> adapterAns39_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, entidadesCredito);
        adapterAns39_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans39_1.setAdapter(adapterAns39_1);

        Spinner ans40 = (Spinner) findViewById(R.id.ans40);
        ArrayAdapter<String> adapterAns40 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns40.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans40.setAdapter(adapterAns40);

        Spinner ans40_1 = (Spinner) findViewById(R.id.ans40_1);
        ArrayAdapter<String> adapterAns40_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, entidadesAsistencia);
        adapterAns40_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans40_1.setAdapter(adapterAns40_1);

        Spinner ans40_3 = (Spinner) findViewById(R.id.ans40_3);
        ArrayAdapter<String> adapterAns40_3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNoNoAplica);
        adapterAns40_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans40_3.setAdapter(adapterAns40_3);

        Spinner ans40_4 = (Spinner) findViewById(R.id.ans40_4);
        ArrayAdapter<String> adapterAns40_4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gratisPago);
        adapterAns40_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans40_4.setAdapter(adapterAns40_4);

        Spinner ans41 = (Spinner) findViewById(R.id.ans41);
        ArrayAdapter<String> adapterAns41 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sino);
        adapterAns41.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans41.setAdapter(adapterAns41);

        Spinner ans41_1 = (Spinner) findViewById(R.id.ans41_1);
        ArrayAdapter<String> adapterAns41_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, entidadesAsistencia);
        adapterAns41_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans41_1.setAdapter(adapterAns41_1);

        Spinner ans41_3 = (Spinner) findViewById(R.id.ans41_3);
        ArrayAdapter<String> adapterAns41_3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNoNoAplica);
        adapterAns41_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans41_3.setAdapter(adapterAns41_3);

        Spinner ans41_4 = (Spinner) findViewById(R.id.ans41_4);
        ArrayAdapter<String> adapterAns41_4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gratisPago);
        adapterAns41_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans41_4.setAdapter(adapterAns41_4);

        EditText ans9other = (EditText) findViewById(R.id.ans9other);
        ans9other.setVisibility(View.GONE);

        EditText ans15_1other = (EditText) findViewById(R.id.ans15_1other);
        ans15_1other.setVisibility(View.GONE);

        EditText ans20_1other = (EditText) findViewById(R.id.ans20_1other);
        ans20_1other.setVisibility(View.GONE);

        EditText ans22other = (EditText) findViewById(R.id.ans22other);
        ans22other.setVisibility(View.GONE);

        EditText ans23other = (EditText) findViewById(R.id.ans23other);
        ans23other.setVisibility(View.GONE);

        EditText ans24other = (EditText) findViewById(R.id.ans24other);
        ans24other.setVisibility(View.GONE);

        EditText ans25other = (EditText) findViewById(R.id.ans25other);
        ans25other.setVisibility(View.GONE);

        EditText ans26other = (EditText) findViewById(R.id.ans26other);
        ans26other.setVisibility(View.GONE);

        EditText ans33other = (EditText) findViewById(R.id.ans33other);
        ans33other.setVisibility(View.GONE);

        EditText ans39_1other = (EditText) findViewById(R.id.ans39_1other);
        ans39_1other.setVisibility(View.GONE);

        EditText ans40_1other = (EditText) findViewById(R.id.ans40_1other);
        ans40_1other.setVisibility(View.GONE);

        EditText ans40_2other = (EditText) findViewById(R.id.ans40_2other);
        ans40_2other.setVisibility(View.GONE);

        EditText ans41_1other = (EditText) findViewById(R.id.ans41_1other);
        ans41_1other.setVisibility(View.GONE);

        EditText ans41_2other = (EditText) findViewById(R.id.ans41_2other);
        ans41_2other.setVisibility(View.GONE);

        CheckBox ans26a = (CheckBox) findViewById(R.id.ans26a);
        CheckBox ans26b = (CheckBox) findViewById(R.id.ans26b);
        CheckBox ans26c = (CheckBox) findViewById(R.id.ans26c);
        CheckBox ans26d = (CheckBox) findViewById(R.id.ans26d);
        CheckBox ans26e = (CheckBox) findViewById(R.id.ans26e);
        CheckBox ans26f = (CheckBox) findViewById(R.id.ans26f);
        CheckBox ans26g = (CheckBox) findViewById(R.id.ans26g);
        CheckBox ans26h = (CheckBox) findViewById(R.id.ans26h);
        CheckBox ans26i = (CheckBox) findViewById(R.id.ans26i);
        CheckBox ans26j = (CheckBox) findViewById(R.id.ans26j);
        CheckBox ans31_4a = (CheckBox) findViewById(R.id.ans31_4a);
        CheckBox ans31_4b = (CheckBox) findViewById(R.id.ans31_4b);
        CheckBox ans31_4c = (CheckBox) findViewById(R.id.ans31_4c);
        CheckBox ans32_4a = (CheckBox) findViewById(R.id.ans32_4a);
        CheckBox ans32_4b = (CheckBox) findViewById(R.id.ans32_4b);
        CheckBox ans32_4c = (CheckBox) findViewById(R.id.ans32_4c);
        CheckBox ans33_3a = (CheckBox) findViewById(R.id.ans33_3a);
        CheckBox ans33_3b = (CheckBox) findViewById(R.id.ans33_3b);
        CheckBox ans33_3c = (CheckBox) findViewById(R.id.ans33_3c);
        CheckBox ans37a = (CheckBox) findViewById(R.id.ans37a);
        CheckBox ans37b = (CheckBox) findViewById(R.id.ans37b);
        CheckBox ans37c = (CheckBox) findViewById(R.id.ans37c);
        CheckBox ans40_2a = (CheckBox) findViewById(R.id.ans40_2a);
        CheckBox ans40_2b = (CheckBox) findViewById(R.id.ans40_2b);
        CheckBox ans40_2c = (CheckBox) findViewById(R.id.ans40_2c);
        CheckBox ans40_2d = (CheckBox) findViewById(R.id.ans40_2d);
        CheckBox ans40_2e = (CheckBox) findViewById(R.id.ans40_2e);
        CheckBox ans40_2f = (CheckBox) findViewById(R.id.ans40_2f);
        CheckBox ans40_2g = (CheckBox) findViewById(R.id.ans40_2g);
        CheckBox ans40_2h = (CheckBox) findViewById(R.id.ans40_2h);
        CheckBox ans40_2i = (CheckBox) findViewById(R.id.ans40_2i);
        CheckBox ans41_2a = (CheckBox) findViewById(R.id.ans41_2a);
        CheckBox ans41_2b = (CheckBox) findViewById(R.id.ans41_2b);
        CheckBox ans41_2c = (CheckBox) findViewById(R.id.ans41_2c);
        CheckBox ans41_2d = (CheckBox) findViewById(R.id.ans41_2d);
        CheckBox ans41_2e = (CheckBox) findViewById(R.id.ans41_2e);
        CheckBox ans41_2f = (CheckBox) findViewById(R.id.ans41_2f);
        CheckBox ans41_2g = (CheckBox) findViewById(R.id.ans41_2g);

        ans1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans2 = (Spinner) findViewById(R.id.ans2);
                Spinner ans1 = (Spinner) findViewById(R.id.ans1);
                if(ans1.getSelectedItemPosition() == 0){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosAmazonas);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 1){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosAntioquia);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 2){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosArauca);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 3){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosAtlantico);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 4){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosBolivar);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 5){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosBoyaca);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 6){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosCaldas);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 7){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosCaqueta);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 8){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosCasanare);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 9){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosCauca);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 10){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosCesar);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 11){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosChoco);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 12){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosCordoba);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 13){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosCundinamarca);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 14){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosGuainia);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 15){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosGuaviare);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 16){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosHuila);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 17){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosGuajira);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 18){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosMagdalena);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 18){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosMeta);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 20){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosNarino);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 21){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosNdeSantander);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 22){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosPutumayo);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 22){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosQuindio);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 23){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosRisaralda);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 24){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosSanAndres);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 25){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosSantander);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 26){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosSucre);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 27){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosTolima);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 28){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosValle);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 29){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosVaupes);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 30){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosVichada);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }
             }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans9 = (Spinner) findViewById(R.id.ans9);
                EditText ans9other = (EditText) findViewById(R.id.ans9other);
                if(ans9.getSelectedItemPosition()==4) {
                    ans9other.setVisibility(View.VISIBLE);
                }else{
                    ans9other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans15.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans15 = (Spinner) findViewById(R.id.ans15);
                TextView ques15_1 = (TextView) findViewById(R.id.ques15_1);
                Spinner ans15_1 = (Spinner) findViewById(R.id.ans15_1);
                if(ans15.getSelectedItemPosition()==1) {
                    ques15_1.setVisibility(View.GONE);
                    ans15_1.setVisibility(View.GONE);
                }else{
                    ques15_1.setVisibility(View.VISIBLE);
                    ans15_1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans15_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans15_1 = (Spinner) findViewById(R.id.ans15_1);
                EditText ans15_1other = (EditText) findViewById(R.id.ans15_1other);
                if(ans15_1.getSelectedItemPosition()==4) {
                    ans15_1other.setVisibility(View.VISIBLE);
                }else{
                    ans15_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans18_7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans18_7 = (Spinner) findViewById(R.id.ans18_7);
                TextView ques18_8 = (TextView) findViewById(R.id.ques18_8);
                EditText ans18_8 = (EditText) findViewById(R.id.ans18_8);
                if(ans18_7.getSelectedItemPosition()==0 || ans18_7.getSelectedItemPosition()==1 || ans18_7.getSelectedItemPosition()==2 || ans18_7.getSelectedItemPosition()==7) {
                    ques18_8.setVisibility(View.GONE);
                    ans18_8.setVisibility(View.GONE);
                }else{
                    ques18_8.setVisibility(View.VISIBLE);
                    ans18_8.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans19.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans19 = (Spinner) findViewById(R.id.ans19);
                TextView ques20 = (TextView) findViewById(R.id.ques20);
                Spinner ans20 = (Spinner) findViewById(R.id.ans20);
                TextView ques20_1 = (TextView) findViewById(R.id.ques20_1);
                Spinner ans20_1 = (Spinner) findViewById(R.id.ans20_1);
                if(ans19.getSelectedItemPosition()==1) {
                    ques20.setVisibility(View.GONE);
                    ans20.setVisibility(View.GONE);
                    ques20_1.setVisibility(View.GONE);
                    ans20_1.setVisibility(View.GONE);
                }else{
                    ques20.setVisibility(View.VISIBLE);
                    ans20.setVisibility(View.VISIBLE);
                    ques20_1.setVisibility(View.VISIBLE);
                    ans20_1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans20_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans20_1 = (Spinner) findViewById(R.id.ans20_1);
                EditText ans20_1other = (EditText) findViewById(R.id.ans20_1other);
                if(ans20_1.getSelectedItemPosition()==5) {
                    ans20_1other.setVisibility(View.VISIBLE);
                }else{
                    ans20_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans22.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans22 = (Spinner) findViewById(R.id.ans22);
                EditText ans22other = (EditText) findViewById(R.id.ans22other);
                if(ans22.getSelectedItemPosition()==4) {
                    ans22other.setVisibility(View.VISIBLE);
                }else{
                    ans22other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans23.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans23 = (Spinner) findViewById(R.id.ans23);
                EditText ans23other = (EditText) findViewById(R.id.ans23other);
                if(ans23.getSelectedItemPosition()==5) {
                    ans23other.setVisibility(View.VISIBLE);
                }else{
                    ans23other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans24.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans24 = (Spinner) findViewById(R.id.ans24);
                EditText ans24other = (EditText) findViewById(R.id.ans24other);
                if(ans24.getSelectedItemPosition()==4) {
                    ans24other.setVisibility(View.VISIBLE);
                }else{
                    ans24other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans25.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans25 = (Spinner) findViewById(R.id.ans25);
                EditText ans25other = (EditText) findViewById(R.id.ans25other);
                if(ans25.getSelectedItemPosition()==4) {
                    ans25other.setVisibility(View.VISIBLE);
                }else{
                    ans25other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans26a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans26a = (CheckBox) findViewById(R.id.ans26a);
                if(ans26a.isChecked()){
                    ans26code += 1;
                }
                else {
                    ans26code -= 1;
                }
            }
        });

        ans26b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans26b = (CheckBox) findViewById(R.id.ans26b);
                if(ans26b.isChecked()){
                    ans26code += 2;
                }
                else {
                    ans26code -= 2;
                }
            }
        });

        ans26c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans26c = (CheckBox) findViewById(R.id.ans26c);
                if(ans26c.isChecked()){
                    ans26code += 4;
                }
                else {
                    ans26code -= 4;
                }
            }
        });

        ans26d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans26d = (CheckBox) findViewById(R.id.ans26d);
                if(ans26d.isChecked()){
                    ans26code += 8;
                }
                else {
                    ans26code -= 8;
                }
            }
        });

        ans26e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans26e = (CheckBox) findViewById(R.id.ans26e);
                if(ans26e.isChecked()){
                    ans26code += 16;
                }
                else {
                    ans26code -= 16;
                }
            }
        });

        ans26f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans26f = (CheckBox) findViewById(R.id.ans26f);
                if(ans26f.isChecked()){
                    ans26code += 32;
                }
                else {
                    ans26code -= 32;
                }
            }
        });

        ans26g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans26g = (CheckBox) findViewById(R.id.ans26g);
                if(ans26g.isChecked()){
                    ans26code += 64;
                }
                else {
                    ans26code -= 64;
                }
            }
        });

        ans26h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans26h = (CheckBox) findViewById(R.id.ans26h);
                if(ans26h.isChecked()){
                    ans26code += 128;
                }
                else {
                    ans26code -= 128;
                }
            }
        });

        ans26i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans26i = (CheckBox) findViewById(R.id.ans26i);
                if(ans26i.isChecked()){
                    ans26code += 256;
                }
                else {
                    ans26code -= 256;

                }
            }
        });

        ans26j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans26j = (CheckBox) findViewById(R.id.ans26j);
                EditText ans26other = (EditText) findViewById(R.id.ans26other);
                if(ans26j.isChecked()){
                    ans26other.setVisibility(View.VISIBLE);
                    ans26code += 512;

                }
                else {
                    ans26other.setVisibility(View.GONE);
                    ans26code -= 512;

                }
            }
        });

        ans30.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans30 = (Spinner) findViewById(R.id.ans30);
                TextView ques31 = (TextView) findViewById(R.id.ques31);
                EditText ans31 = (EditText) findViewById(R.id.ans31);
                TextView ques31_1 = (TextView) findViewById(R.id.ques31_1);
                Spinner ans31_1 = (Spinner) findViewById(R.id.ans31_1);
                TextView ques31_2 = (TextView) findViewById(R.id.ques31_2);
                EditText ans31_2 = (EditText) findViewById(R.id.ans31_2);
                TextView ques31_3 = (TextView) findViewById(R.id.ques31_3);
                EditText ans31_3 = (EditText) findViewById(R.id.ans31_3);
                TextView ques31_4 = (TextView) findViewById(R.id.ques31_4);
                CheckBox ans31_4a = (CheckBox) findViewById(R.id.ans31_4a);
                CheckBox ans31_4b = (CheckBox) findViewById(R.id.ans31_4b);
                CheckBox ans31_4c = (CheckBox) findViewById(R.id.ans31_4c);
                if(ans30.getSelectedItemPosition()==2) {
                    ques31.setVisibility(View.GONE);
                    ans31.setVisibility(View.GONE);
                    ques31_1.setVisibility(View.GONE);
                    ans31_1.setVisibility(View.GONE);
                    ques31_2.setVisibility(View.GONE);
                    ans31_2.setVisibility(View.GONE);
                    ques31_3.setVisibility(View.GONE);
                    ans31_3.setVisibility(View.GONE);
                    ques31_4.setVisibility(View.GONE);
                    ans31_4a.setVisibility(View.GONE);
                    ans31_4b.setVisibility(View.GONE);
                    ans31_4c.setVisibility(View.GONE);
                }else{
                    ques31.setVisibility(View.VISIBLE);
                    ans31.setVisibility(View.VISIBLE);
                    ques31_1.setVisibility(View.VISIBLE);
                    ans31_1.setVisibility(View.VISIBLE);
                    ques31_2.setVisibility(View.VISIBLE);
                    ans31_2.setVisibility(View.VISIBLE);
                    ques31_3.setVisibility(View.VISIBLE);
                    ans31_3.setVisibility(View.VISIBLE);
                    ques31_4.setVisibility(View.VISIBLE);
                    ans31_4a.setVisibility(View.VISIBLE);
                    ans31_4b.setVisibility(View.VISIBLE);
                    ans31_4c.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans31_4a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans31_4a = (CheckBox) findViewById(R.id.ans31_4a);
                if(ans31_4a.isChecked()){
                    ans31_4code += 1;
                }
                else {
                    ans31_4code -= 1;
                }
            }
        });

        ans31_4b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans31_4b = (CheckBox) findViewById(R.id.ans31_4b);
                if(ans31_4b.isChecked()){
                    ans31_4code += 2;
                }
                else {
                    ans31_4code -= 2;
                }
            }
        });

        ans31_4c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans31_4c = (CheckBox) findViewById(R.id.ans31_4c);
                if(ans31_4c.isChecked()){
                    ans31_4code += 4;
                }
                else {
                    ans31_4code -= 4;
                }
            }
        });

        ans32_4a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans32_4a = (CheckBox) findViewById(R.id.ans32_4a);
                if(ans32_4a.isChecked()){
                    ans32_4code += 1;
                }
                else {
                    ans32_4code -= 1;
                }
            }
        });

        ans32_4b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans32_4b = (CheckBox) findViewById(R.id.ans32_4b);
                if(ans32_4b.isChecked()){
                    ans32_4code += 2;
                }
                else {
                    ans32_4code -= 2;
                }
            }
        });

        ans32_4c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans32_4c = (CheckBox) findViewById(R.id.ans32_4c);
                if(ans32_4c.isChecked()){
                    ans32_4code += 4;
                }
                else {
                    ans32_4code -= 4;
                }
            }
        });

        ans33_3a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans33_3a = (CheckBox) findViewById(R.id.ans33_3a);
                if(ans33_3a.isChecked()){
                    ans33_3code += 1;
                }
                else {
                    ans33_3code -= 1;
                }
            }
        });

        ans33_3b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans33_3b = (CheckBox) findViewById(R.id.ans33_3b);
                if(ans33_3b.isChecked()){
                    ans33_3code += 2;
                }
                else {
                    ans33_3code -= 2;
                }
            }
        });

        ans33_3c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans33_3c = (CheckBox) findViewById(R.id.ans33_3c);
                if(ans33_3c.isChecked()){
                    ans33_3code += 4;
                }
                else {
                    ans33_3code -= 4;
                }
            }
        });

        ans37a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans37a = (CheckBox) findViewById(R.id.ans37a);
                if(ans37a.isChecked()){
                    ans37code += 1;
                }
                else {
                    ans37code -= 1;
                }
            }
        });

        ans37b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans37b = (CheckBox) findViewById(R.id.ans37b);
                if(ans37b.isChecked()){
                    ans37code += 2;
                }
                else {
                    ans37code -= 2;
                }
            }
        });

        ans37c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans37c = (CheckBox) findViewById(R.id.ans37c);
                if(ans37c.isChecked()){
                    ans37code += 4;
                }
                else {
                    ans37code -= 4;
                }
            }
        });
        
        ans32.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans32 = (Spinner) findViewById(R.id.ans32);
                TextView ques32_1 = (TextView) findViewById(R.id.ques32_1);
                Spinner ans32_1 = (Spinner) findViewById(R.id.ans32_1);
                TextView ques32_2 = (TextView) findViewById(R.id.ques32_2);
                EditText ans32_2 = (EditText) findViewById(R.id.ans32_2);
                TextView ques32_3 = (TextView) findViewById(R.id.ques32_3);
                EditText ans32_3 = (EditText) findViewById(R.id.ans32_3);
                TextView ques32_4 = (TextView) findViewById(R.id.ques32_4);
                CheckBox ans32_4a = (CheckBox) findViewById(R.id.ans32_4a);
                CheckBox ans32_4b = (CheckBox) findViewById(R.id.ans32_4b);
                CheckBox ans32_4c = (CheckBox) findViewById(R.id.ans32_4c);
                if(ans32.getSelectedItemPosition()==3) {
                    ques32_1.setVisibility(View.GONE);
                    ans32_1.setVisibility(View.GONE);
                    ques32_2.setVisibility(View.GONE);
                    ans32_2.setVisibility(View.GONE);
                    ques32_3.setVisibility(View.GONE);
                    ans32_3.setVisibility(View.GONE);
                    ques32_4.setVisibility(View.GONE);
                    ans32_4a.setVisibility(View.GONE);
                    ans32_4b.setVisibility(View.GONE);
                    ans32_4c.setVisibility(View.GONE);
                }else{
                    ques32_1.setVisibility(View.VISIBLE);
                    ans32_1.setVisibility(View.VISIBLE);
                    ques32_2.setVisibility(View.VISIBLE);
                    ans32_2.setVisibility(View.VISIBLE);
                    ques32_3.setVisibility(View.VISIBLE);
                    ans32_3.setVisibility(View.VISIBLE);
                    ques32_4.setVisibility(View.VISIBLE);
                    ans32_4a.setVisibility(View.VISIBLE);
                    ans32_4b.setVisibility(View.VISIBLE);
                    ans32_4c.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        TextView textoAccesoServiciosAgri = (TextView)findViewById(R.id.textoAccesoServiciosAgri);
        String normalText1 = "Indique las condiciones de acceso a ";
        String boldText = "servicios de apoyo";
        String normalText2 = " para la acuicultura/pesca artesanal de acuerdo con los siguientes ítems:";
        SpannableString str = new SpannableString(normalText1 + boldText + normalText2);
        str.setSpan(new StyleSpan(Typeface.BOLD), normalText1.length(), normalText1.length()+boldText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textoAccesoServiciosAgri.setText(str);

        ans33.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans33 = (Spinner) findViewById(R.id.ans33);
                EditText ans33other = (EditText) findViewById(R.id.ans33other);
                TextView ques33_1 = (TextView) findViewById(R.id.ques33_1);
                EditText ans33_1 = (EditText) findViewById(R.id.ans33_1);
                TextView ques33_2 = (TextView) findViewById(R.id.ques33_2);
                EditText ans33_2 = (EditText) findViewById(R.id.ans33_2);
                TextView ques33_3 = (TextView) findViewById(R.id.ques33_3);
                CheckBox ans33_3a = (CheckBox) findViewById(R.id.ans33_3a);
                CheckBox ans33_3b = (CheckBox) findViewById(R.id.ans33_3b);
                CheckBox ans33_3c = (CheckBox) findViewById(R.id.ans33_3c);
                if(ans33.getSelectedItemPosition()==4) {
                    ans33other.setVisibility(View.VISIBLE);
                }else{
                    ans33other.setVisibility(View.GONE);
                }

                if(ans33.getSelectedItemPosition()==5) {
                    ques33_1.setVisibility(View.GONE);
                    ans33_1.setVisibility(View.GONE);
                    ques33_2.setVisibility(View.GONE);
                    ans33_2.setVisibility(View.GONE);
                    ques33_3.setVisibility(View.GONE);
                    ans33_3a.setVisibility(View.GONE);
                    ans33_3b.setVisibility(View.GONE);
                    ans33_3c.setVisibility(View.GONE);

                }else{
                    ques33_1.setVisibility(View.VISIBLE);
                    ans33_1.setVisibility(View.VISIBLE);
                    ques33_2.setVisibility(View.VISIBLE);
                    ans33_2.setVisibility(View.VISIBLE);
                    ques33_3.setVisibility(View.VISIBLE);
                    ans33_3a.setVisibility(View.VISIBLE);
                    ans33_3b.setVisibility(View.VISIBLE);
                    ans33_3c.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans39.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans39 = (Spinner) findViewById(R.id.ans39);
                TextView ques39_1 = (TextView) findViewById(R.id.ques39_1);
                Spinner ans39_1 = (Spinner) findViewById(R.id.ans39_1);
                TextView ques39_2 = (TextView) findViewById(R.id.ques39_2);
                EditText ans39_2 = (EditText) findViewById(R.id.ans39_2);
                if(ans39.getSelectedItemPosition()==1) {
                    ques39_1.setVisibility(View.GONE);
                    ans39_1.setVisibility(View.GONE);
                    ques39_2.setVisibility(View.GONE);
                    ans39_2.setVisibility(View.GONE);
                }else{
                    ques39_1.setVisibility(View.VISIBLE);
                    ans39_1.setVisibility(View.VISIBLE);
                    ques39_2.setVisibility(View.VISIBLE);
                    ans39_2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans39_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans39_1 = (Spinner) findViewById(R.id.ans39_1);
                EditText ans39_1other = (EditText) findViewById(R.id.ans39_1other);
                if(ans39_1.getSelectedItemPosition()==7) {
                    ans39_1other.setVisibility(View.VISIBLE);
                }else{
                    ans39_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans40.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans40 = (Spinner) findViewById(R.id.ans40);
                TextView ques40_1 = (TextView) findViewById(R.id.ques40_1);
                Spinner ans40_1 = (Spinner) findViewById(R.id.ans40_1);
                TextView ques40_2 = (TextView) findViewById(R.id.ques40_2);
                CheckBox ans40_2a = (CheckBox) findViewById(R.id.ans40_2a);
                CheckBox ans40_2b = (CheckBox) findViewById(R.id.ans40_2b);
                CheckBox ans40_2c = (CheckBox) findViewById(R.id.ans40_2c);
                CheckBox ans40_2d = (CheckBox) findViewById(R.id.ans40_2d);
                CheckBox ans40_2e = (CheckBox) findViewById(R.id.ans40_2e);
                CheckBox ans40_2f = (CheckBox) findViewById(R.id.ans40_2f);
                CheckBox ans40_2g = (CheckBox) findViewById(R.id.ans40_2g);
                CheckBox ans40_2h = (CheckBox) findViewById(R.id.ans40_2h);
                CheckBox ans40_2i = (CheckBox) findViewById(R.id.ans40_2i);
                TextView ques40_3 = (TextView) findViewById(R.id.ques40_3);
                Spinner ans40_3 = (Spinner) findViewById(R.id.ans40_3);
                TextView ques40_4 = (TextView) findViewById(R.id.ques40_4);
                Spinner ans40_4 = (Spinner) findViewById(R.id.ans40_4);
                if(ans40.getSelectedItemPosition()==1) {
                    ques40_1.setVisibility(View.GONE);
                    ans40_1.setVisibility(View.GONE);
                    ques40_2.setVisibility(View.GONE);
                    ans40_2a.setVisibility(View.GONE);
                    ans40_2b.setVisibility(View.GONE);
                    ans40_2c.setVisibility(View.GONE);
                    ans40_2d.setVisibility(View.GONE);
                    ans40_2e.setVisibility(View.GONE);
                    ans40_2f.setVisibility(View.GONE);
                    ans40_2g.setVisibility(View.GONE);
                    ans40_2h.setVisibility(View.GONE);
                    ans40_2i.setVisibility(View.GONE);
                    ques40_3.setVisibility(View.GONE);
                    ans40_3.setVisibility(View.GONE);
                    ques40_4.setVisibility(View.GONE);
                    ans40_4.setVisibility(View.GONE);
                }else{
                    ques40_1.setVisibility(View.VISIBLE);
                    ans40_1.setVisibility(View.VISIBLE);
                    ques40_2.setVisibility(View.VISIBLE);
                    ans40_2a.setVisibility(View.VISIBLE);
                    ans40_2b.setVisibility(View.VISIBLE);
                    ans40_2c.setVisibility(View.VISIBLE);
                    ans40_2d.setVisibility(View.VISIBLE);
                    ans40_2e.setVisibility(View.VISIBLE);
                    ans40_2f.setVisibility(View.VISIBLE);
                    ans40_2g.setVisibility(View.VISIBLE);
                    ans40_2h.setVisibility(View.VISIBLE);
                    ans40_2i.setVisibility(View.VISIBLE);
                    ques40_3.setVisibility(View.VISIBLE);
                    ans40_3.setVisibility(View.VISIBLE);
                    ques40_4.setVisibility(View.VISIBLE);
                    ans40_4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans40_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans40_1 = (Spinner) findViewById(R.id.ans40_1);
                EditText ans40_1other = (EditText) findViewById(R.id.ans40_1other);
                if(ans40_1.getSelectedItemPosition()==2 || ans40_1.getSelectedItemPosition()==4) {
                    ans40_1other.setVisibility(View.VISIBLE);
                }else{
                    ans40_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans40_2a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans40_2a = (CheckBox) findViewById(R.id.ans40_2a);
                if(ans40_2a.isChecked()){
                    ans40_2code += 1;
                }
                else {
                    ans40_2code -= 1;
                }
            }
        });

        ans40_2b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans40_2b = (CheckBox) findViewById(R.id.ans40_2b);
                if(ans40_2b.isChecked()){
                    ans40_2code += 2;
                }
                else {
                    ans40_2code -= 2;
                }
            }
        });

        ans40_2c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans40_2c = (CheckBox) findViewById(R.id.ans40_2c);
                if(ans40_2c.isChecked()){
                    ans40_2code += 4;
                }
                else {
                    ans40_2code -= 4;
                }
            }
        });

        ans40_2d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans40_2d = (CheckBox) findViewById(R.id.ans40_2d);
                if(ans40_2d.isChecked()){
                    ans40_2code += 8;
                }
                else {
                    ans40_2code -= 8;
                }
            }
        });

        ans40_2e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans40_2e = (CheckBox) findViewById(R.id.ans40_2e);
                if(ans40_2e.isChecked()){
                    ans40_2code += 16;
                }
                else {
                    ans40_2code -= 16;
                }
            }
        });

        ans40_2f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans40_2f = (CheckBox) findViewById(R.id.ans40_2f);
                if(ans40_2f.isChecked()){
                    ans40_2code += 32;
                }
                else {
                    ans40_2code -= 32;
                }
            }
        });

        ans40_2g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans40_2g = (CheckBox) findViewById(R.id.ans40_2g);
                if(ans40_2g.isChecked()){
                    ans40_2code += 64;
                }
                else {
                    ans40_2code -= 64;
                }
            }
        });

        ans40_2h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans40_2h = (CheckBox) findViewById(R.id.ans40_2h);
                if(ans40_2h.isChecked()){
                    ans40_2code += 128;
                }
                else {
                    ans40_2code -= 128;
                }
            }
        });

        ans40_2i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans40_2i = (CheckBox) findViewById(R.id.ans40_2i);
                EditText ans40_2other = (EditText) findViewById(R.id.ans40_2other);
                if(ans40_2i.isChecked()){
                    ans40_2other.setVisibility(View.VISIBLE);
                    ans40_2code += 256;
                }
                else {
                    ans40_2other.setVisibility(View.GONE);
                    ans40_2code -= 256;

                }
            }
        });

        ans41.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans41 = (Spinner) findViewById(R.id.ans41);
                TextView ques41_1 = (TextView) findViewById(R.id.ques41_1);
                Spinner ans41_1 = (Spinner) findViewById(R.id.ans41_1);
                TextView ques41_2 = (TextView) findViewById(R.id.ques41_2);
                CheckBox ans41_2a = (CheckBox) findViewById(R.id.ans41_2a);
                CheckBox ans41_2b = (CheckBox) findViewById(R.id.ans41_2b);
                CheckBox ans41_2c = (CheckBox) findViewById(R.id.ans41_2c);
                CheckBox ans41_2d = (CheckBox) findViewById(R.id.ans41_2d);
                CheckBox ans41_2e = (CheckBox) findViewById(R.id.ans41_2e);
                CheckBox ans41_2f = (CheckBox) findViewById(R.id.ans41_2f);
                CheckBox ans41_2g = (CheckBox) findViewById(R.id.ans41_2g);
                TextView ques41_3 = (TextView) findViewById(R.id.ques41_3);
                Spinner ans41_3 = (Spinner) findViewById(R.id.ans41_3);
                TextView ques41_4 = (TextView) findViewById(R.id.ques41_4);
                Spinner ans41_4 = (Spinner) findViewById(R.id.ans41_4);
                if(ans41.getSelectedItemPosition()==1) {
                    ques41_1.setVisibility(View.GONE);
                    ans41_1.setVisibility(View.GONE);
                    ques41_2.setVisibility(View.GONE);
                    ans41_2a.setVisibility(View.GONE);
                    ans41_2b.setVisibility(View.GONE);
                    ans41_2c.setVisibility(View.GONE);
                    ans41_2d.setVisibility(View.GONE);
                    ans41_2e.setVisibility(View.GONE);
                    ans41_2f.setVisibility(View.GONE);
                    ans41_2g.setVisibility(View.GONE);
                    ques41_3.setVisibility(View.GONE);
                    ans41_3.setVisibility(View.GONE);
                    ques41_4.setVisibility(View.GONE);
                    ans41_4.setVisibility(View.GONE);
                }else{
                    ques41_1.setVisibility(View.VISIBLE);
                    ans41_1.setVisibility(View.VISIBLE);
                    ques41_2.setVisibility(View.VISIBLE);
                    ans41_2a.setVisibility(View.VISIBLE);
                    ans41_2b.setVisibility(View.VISIBLE);
                    ans41_2c.setVisibility(View.VISIBLE);
                    ans41_2d.setVisibility(View.VISIBLE);
                    ans41_2e.setVisibility(View.VISIBLE);
                    ans41_2f.setVisibility(View.VISIBLE);
                    ans41_2g.setVisibility(View.VISIBLE);
                    ques41_3.setVisibility(View.VISIBLE);
                    ans41_3.setVisibility(View.VISIBLE);
                    ques41_4.setVisibility(View.VISIBLE);
                    ans41_4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans41_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans41_1 = (Spinner) findViewById(R.id.ans41_1);
                EditText ans41_1other = (EditText) findViewById(R.id.ans41_1other);
                if(ans41_1.getSelectedItemPosition()==2 || ans41_1.getSelectedItemPosition()==4) {
                    ans41_1other.setVisibility(View.VISIBLE);
                }else{
                    ans41_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans41_2a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans41_2a = (CheckBox) findViewById(R.id.ans41_2a);
                if(ans41_2a.isChecked()){
                    ans41_2code += 1;
                }
                else {
                    ans41_2code -= 1;
                }
            }
        });

        ans41_2b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans41_2b = (CheckBox) findViewById(R.id.ans41_2b);
                if(ans41_2b.isChecked()){
                    ans41_2code += 2;
                }
                else {
                    ans41_2code -= 2;
                }
            }
        });

        ans41_2c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans41_2c = (CheckBox) findViewById(R.id.ans41_2c);
                if(ans41_2c.isChecked()){
                    ans41_2code += 4;
                }
                else {
                    ans41_2code -= 4;
                }
            }
        });

        ans41_2d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans41_2d = (CheckBox) findViewById(R.id.ans41_2d);
                if(ans41_2d.isChecked()){
                    ans41_2code += 8;
                }
                else {
                    ans41_2code -= 8;
                }
            }
        });

        ans41_2e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans41_2e = (CheckBox) findViewById(R.id.ans41_2e);
                if(ans41_2e.isChecked()){
                    ans41_2code += 16;
                }
                else {
                    ans41_2code -= 16;
                }
            }
        });

        ans41_2f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans41_2f = (CheckBox) findViewById(R.id.ans41_2f);
                if(ans41_2f.isChecked()){
                    ans41_2code += 32;
                }
                else {
                    ans41_2code -= 32;
                }
            }
        });

        ans41_2g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans41_2g = (CheckBox) findViewById(R.id.ans41_2g);
                EditText ans41_2other = (EditText) findViewById(R.id.ans41_2other);
                if(ans41_2g.isChecked()){
                    ans41_2other.setVisibility(View.VISIBLE);
                    ans41_2code += 64;
                }
                else {
                    ans41_2other.setVisibility(View.GONE);
                    ans41_2code -= 64;

                }
            }
        });

        nextButtonECUPAC =  (Button) findViewById(R.id.nextButtonECUPAC);
        nextButtonECUPAC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                escribir("ECUPAC");
                Intent preg2 = new Intent(getApplicationContext(), Preguntas2.class);
                startActivity(preg2);
            }
        });

	    nextButtonECUPPA =  (Button) findViewById(R.id.nextButtonECUPPA);
        nextButtonECUPPA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                escribir("ECUPPA");
                Intent preg3 = new Intent(getApplicationContext(), Preguntas3.class);
                startActivity(preg3);

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

    private void escribir(String destino){
        try {

            EditText ans3 = (EditText) findViewById(R.id.ans3);
            EditText ans4 = (EditText) findViewById(R.id.ans4);
            EditText ans5 = (EditText) findViewById(R.id.ans5);
            EditText ans6 = (EditText) findViewById(R.id.ans6);
            EditText ans7 = (EditText) findViewById(R.id.ans7);
            EditText ans8_1 = (EditText) findViewById(R.id.ans8_1);
            EditText ans10 = (EditText) findViewById(R.id.ans10);
            EditText ans12 = (EditText) findViewById(R.id.ans12);
            EditText ans13 = (EditText) findViewById(R.id.ans13);
            EditText ans17 = (EditText) findViewById(R.id.ans17);
            EditText ans18 = (EditText) findViewById(R.id.ans18);
            EditText ans18_3 = (EditText) findViewById(R.id.ans18_3);
            EditText ans18_8 = (EditText) findViewById(R.id.ans18_8);
            EditText ans21 = (EditText) findViewById(R.id.ans21);
            EditText ans31 = (EditText) findViewById(R.id.ans31);
            EditText ans31_2 = (EditText) findViewById(R.id.ans31_2);
            EditText ans31_3 = (EditText) findViewById(R.id.ans31_3);
            EditText ans32_2 = (EditText) findViewById(R.id.ans32_2);
            EditText ans32_3 = (EditText) findViewById(R.id.ans32_3);
            EditText ans33_1 = (EditText) findViewById(R.id.ans33_1);
            EditText ans33_2 = (EditText) findViewById(R.id.ans33_2);
            EditText ans34 = (EditText) findViewById(R.id.ans34);
            EditText ans35 = (EditText) findViewById(R.id.ans35);
            EditText ans36 = (EditText) findViewById(R.id.ans36);
            EditText ans39_2 = (EditText) findViewById(R.id.ans39_2);
            EditText ans9other = (EditText) findViewById(R.id.ans9other);
            EditText ans20_1other = (EditText) findViewById(R.id.ans20_1other);
            EditText ans22other = (EditText) findViewById(R.id.ans22other);
            EditText ans23other = (EditText) findViewById(R.id.ans23other);
            EditText ans24other = (EditText) findViewById(R.id.ans24other);
            EditText ans25other = (EditText) findViewById(R.id.ans25other);
            EditText ans26other = (EditText) findViewById(R.id.ans26other);
            EditText ans33other = (EditText) findViewById(R.id.ans33other);
            EditText ans39_1other = (EditText) findViewById(R.id.ans39_1other);
            EditText ans40_1other = (EditText) findViewById(R.id.ans40_1other);
            EditText ans40_2other = (EditText) findViewById(R.id.ans40_2other);
            EditText ans41_1other = (EditText) findViewById(R.id.ans41_1other);
            EditText ans41_2other = (EditText) findViewById(R.id.ans41_2other);

            Spinner ans2 = (Spinner) findViewById(R.id.ans2);
            Spinner ans1 = (Spinner) findViewById(R.id.ans1);
            Spinner ans8 = (Spinner) findViewById(R.id.ans8);
            Spinner ans9 = (Spinner) findViewById(R.id.ans9);
            Spinner ans11 = (Spinner) findViewById(R.id.ans11);
            Spinner ans14 = (Spinner) findViewById(R.id.ans14);
            Spinner ans15 = (Spinner) findViewById(R.id.ans15);
            Spinner ans15_1 = (Spinner) findViewById(R.id.ans15_1);
            Spinner ans16 = (Spinner) findViewById(R.id.ans16);
            Spinner ans18_1 = (Spinner) findViewById(R.id.ans18_1);
            Spinner ans18_2 = (Spinner) findViewById(R.id.ans18_2);
            Spinner ans18_4 = (Spinner) findViewById(R.id.ans18_4);
            Spinner ans18_5 = (Spinner) findViewById(R.id.ans18_5);
            Spinner ans18_6 = (Spinner) findViewById(R.id.ans18_6);
            Spinner ans18_7 = (Spinner) findViewById(R.id.ans18_7);
            Spinner ans19 = (Spinner) findViewById(R.id.ans19);
            Spinner ans20 = (Spinner) findViewById(R.id.ans20);
            Spinner ans20_1 = (Spinner) findViewById(R.id.ans20_1);
            Spinner ans21_1 = (Spinner) findViewById(R.id.ans21_1);
            Spinner ans21_2 = (Spinner) findViewById(R.id.ans21_2);
            Spinner ans22 = (Spinner) findViewById(R.id.ans22);
            Spinner ans23 = (Spinner) findViewById(R.id.ans23);
            Spinner ans24 = (Spinner) findViewById(R.id.ans24);
            Spinner ans25 = (Spinner) findViewById(R.id.ans25);
            Spinner ans27 = (Spinner) findViewById(R.id.ans27);
            Spinner ans28 = (Spinner) findViewById(R.id.ans28);
            Spinner ans29 = (Spinner) findViewById(R.id.ans29);
            Spinner ans30 = (Spinner) findViewById(R.id.ans30);
            Spinner ans31_1 = (Spinner) findViewById(R.id.ans31_1);
            Spinner ans32 = (Spinner) findViewById(R.id.ans32);
            Spinner ans32_1 = (Spinner) findViewById(R.id.ans32_1);
            Spinner ans33 = (Spinner) findViewById(R.id.ans33);
            Spinner ans38 = (Spinner) findViewById(R.id.ans38);
            Spinner ans39 = (Spinner) findViewById(R.id.ans39);
            Spinner ans39_1 = (Spinner) findViewById(R.id.ans39_1);
            Spinner ans40 = (Spinner) findViewById(R.id.ans40);
            Spinner ans40_1 = (Spinner) findViewById(R.id.ans40_1);
            Spinner ans40_3 = (Spinner) findViewById(R.id.ans40_3);
            Spinner ans40_4 = (Spinner) findViewById(R.id.ans40_4);
            Spinner ans41 = (Spinner) findViewById(R.id.ans41);
            Spinner ans41_1 = (Spinner) findViewById(R.id.ans41_1);
            Spinner ans41_3 = (Spinner) findViewById(R.id.ans41_3);
            Spinner ans41_4 = (Spinner) findViewById(R.id.ans41_4);
            
            CheckBox ans26j = (CheckBox) findViewById(R.id.ans26j);
            CheckBox ans40_2i = (CheckBox) findViewById(R.id.ans40_2i);
            CheckBox ans41_2g = (CheckBox) findViewById(R.id.ans41_2g);

            FileOutputStream fos = new FileOutputStream(myExternalFile,true);

            fos.write("\t".getBytes());
            fos.write(destino.getBytes());
            fos.write("\t".getBytes());
            fos.write(ans1.getItemAtPosition(ans1.getSelectedItemPosition()).toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans2.getItemAtPosition(ans2.getSelectedItemPosition()).toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans7.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans8.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans8_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans9.getSelectedItemPosition()).getBytes());
            if(ans9.getSelectedItemPosition()==4){
                fos.write(", ".getBytes());
            }
            fos.write(ans9other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans10.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans11.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans12.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans13.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans14.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans15.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans15_1.getSelectedItemPosition()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans16.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans17.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans18.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans18_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans18_2.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans18_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans18_4.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans18_5.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans18_6.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans18_7.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans18_8.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans19.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans20.getSelectedItemPosition()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans20_1.getSelectedItemPosition()).getBytes());
            if(ans20_1.getSelectedItemPosition()==5){
                fos.write(", ".getBytes());
            }
            fos.write(ans20_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans21.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans21_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans21_2.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans22.getSelectedItemPosition()+1).getBytes());
            if(ans22.getSelectedItemPosition()==4){
                fos.write(", ".getBytes());
            }
            fos.write(ans22other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans23.getSelectedItemPosition()+1).getBytes());
            if(ans23.getSelectedItemPosition()==5){
                fos.write(", ".getBytes());
            }
            fos.write(ans23other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans24.getSelectedItemPosition()+1).getBytes());
            if(ans24.getSelectedItemPosition()==4){
                fos.write(", ".getBytes());
            }
            fos.write(ans24other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans25.getSelectedItemPosition()+1).getBytes());
            if(ans25.getSelectedItemPosition()==4){
                fos.write(", ".getBytes());
            }
            fos.write(ans25other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans26code).getBytes());
            if(ans26j.isChecked()){
                fos.write(", ".getBytes());
            }
            fos.write(ans26other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans27.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans28.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans29.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans30.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans31.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans31_1.getSelectedItemPosition()).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans31_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans31_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans31_4code).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans32.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans32_1.getSelectedItemPosition()).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans32_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans32_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans32_4code).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans33.getSelectedItemPosition()+1).getBytes());
            if(ans33.getSelectedItemPosition()==5){
                fos.write(", ".getBytes());
            }
            fos.write(ans33other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans33_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans33_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans33_3code).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans34.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans35.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans36.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans37code).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans38.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans39.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans39_1.getSelectedItemPosition()).getBytes());
            if(ans39_1.getSelectedItemPosition()==7){
                fos.write(", ".getBytes());
            }
            fos.write(ans39_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans39_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans40.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans40_1.getSelectedItemPosition()).getBytes());
            if(ans40_1.getSelectedItemPosition()==4){
                fos.write(", ".getBytes());
            }
            fos.write(ans40_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans40_2code).getBytes());
            if(ans40_2i.isChecked()){
                fos.write(", ".getBytes());
            }
            fos.write(ans40_2other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans40_3.getSelectedItemPosition()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans40_4.getSelectedItemPosition()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans41.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans41_1.getSelectedItemPosition()).getBytes());
            if(ans41_1.getSelectedItemPosition()==2 || ans41_1.getSelectedItemPosition()==4){
                fos.write(", ".getBytes());
            }
            fos.write(ans41_1other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            if(ans41_2g.isChecked()){
                fos.write(", ".getBytes());
            }
            fos.write(ans41_2other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans41_3.getSelectedItemPosition()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans41_4.getSelectedItemPosition()).getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private class MyLocationListener implements LocationListener{

        @Override
        public void onLocationChanged(Location location) {
            EditText ans5 = (EditText) findViewById(R.id.ans5);
            ans5.setText(Double.toString(location.getLatitude()) + ", " + Double.toString(location.getLongitude()));
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            //Toast.makeText(Preguntas1.this, "Provider status changed",
            //        Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderEnabled(String provider) {
            //Toast.makeText(Preguntas1.this, "Provider enabled by the user. GPS turned on",
            //        Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderDisabled(String provider) {
            //Toast.makeText(Preguntas1.this, "Provider enabled by the user. GPS turned off",
            //        Toast.LENGTH_LONG).show();
        }
    }
}
