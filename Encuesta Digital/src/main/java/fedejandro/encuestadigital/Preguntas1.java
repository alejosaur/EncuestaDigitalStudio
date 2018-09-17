package fedejandro.encuestadigital;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.*;

public class Preguntas1 extends AppCompatActivity {

    Button nextButtonEUPAC, nextButtonUPPA;
    private String filename = "datos.txt";
    private String filepath = "EncuestaDatos";
    File myExternalFile;

    private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 100; // in Meters
    private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000; // in Milliseconds
    protected LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas1);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {

            ActivityCompat.requestPermissions( this, new String[] {  android.Manifest.permission.ACCESS_COARSE_LOCATION  },
                    11);
        }

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(
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
        String[] causaDesplazamiento = new String[] {
                "No Aplica","Conflicto Armado","Ambiental","Económica", "Otra"
        };
        String[] relacionPersonas = new String[] {
                "Cónyuge","Hijo/a","Yerno/Nuera","Nieto/a, Bisnieto/a","Padre o madre del cónyuge","Otro pariente",
                "No emparentado"
        };
        String[] estadoCivil = new String[] {
                "Soltero","Casado","Unión Libre","Separado","Divorciado","Viudo"
        };
        String[] gradoEstudio = new String[] {
                "Básica primaria (1° a 5° grado)","Básica secundaria (6° a 9° grado)","Media (10° a 11° grado)","Técnico",
                "Tecnólogo","Profesional pregrado","Postgrado","Ninguno"
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
                "No Aplica","Empleador","Trabaja por cuenta propia","Trabajador familiar no retribuído",
                "Socio de cooperativa de productores","Otro, ¿cuál?"
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

        EditText ans9other = (EditText) findViewById(R.id.ans9other);
        ans9other.setVisibility(View.GONE);

        EditText ans15_1other = (EditText) findViewById(R.id.ans15_1other);
        ans15_1other.setVisibility(View.GONE);

        EditText ans21_1other = (EditText) findViewById(R.id.ans21_1other);
        ans21_1other.setVisibility(View.GONE);

        EditText ans23other = (EditText) findViewById(R.id.ans23other);
        ans23other.setVisibility(View.GONE);

        EditText ans24other = (EditText) findViewById(R.id.ans24other);
        ans24other.setVisibility(View.GONE);

        EditText ans25other = (EditText) findViewById(R.id.ans25other);
        ans25other.setVisibility(View.GONE);

        EditText ans26other = (EditText) findViewById(R.id.ans26other);
        ans26other.setVisibility(View.GONE);

        EditText ans27other = (EditText) findViewById(R.id.ans27other);
        ans27other.setVisibility(View.GONE);

        EditText ans34other = (EditText) findViewById(R.id.ans34other);
        ans34other.setVisibility(View.GONE);

        EditText ans40_1other = (EditText) findViewById(R.id.ans40_1other);
        ans40_1other.setVisibility(View.GONE);

        EditText ans41_1other = (EditText) findViewById(R.id.ans41_1other);
        ans41_1other.setVisibility(View.GONE);

        EditText ans41_2other = (EditText) findViewById(R.id.ans41_2other);
        ans41_2other.setVisibility(View.GONE);

        EditText ans42_1other = (EditText) findViewById(R.id.ans42_1other);
        ans42_1other.setVisibility(View.GONE);

        EditText ans42_2other = (EditText) findViewById(R.id.ans42_2other);
        ans42_2other.setVisibility(View.GONE);

        CheckBox tieneOtro = (CheckBox) findViewById(R.id.tieneOtro);
        CheckBox ayudaOtro = (CheckBox) findViewById(R.id.ayudaOtro);
        CheckBox formacionOtros = (CheckBox) findViewById(R.id.formacionOtros);

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
                }else if(ans1.getSelectedItemPosition() == 19){
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
                }else if(ans1.getSelectedItemPosition() == 23){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosQuindio);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 24){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosRisaralda);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 25){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosSanAndres);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 26){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosSantander);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 27){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosSucre);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 28){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosTolima);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 29){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosValle);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 30){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas1.this, android.R.layout.simple_spinner_item, municipiosVaupes);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans2.setAdapter(adapterAns2);
                }else if(ans1.getSelectedItemPosition() == 31){
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

        ans21_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans21_1 = (Spinner) findViewById(R.id.ans21_1);
                EditText ans21_1other = (EditText) findViewById(R.id.ans21_1other);
                if(ans21_1.getSelectedItemPosition()==5) {
                    ans21_1other.setVisibility(View.VISIBLE);
                }else{
                    ans21_1other.setVisibility(View.GONE);
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
                if(ans23.getSelectedItemPosition()==4) {
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
                if(ans24.getSelectedItemPosition()==5) {
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

        ans26.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans26 = (Spinner) findViewById(R.id.ans26);
                EditText ans26other = (EditText) findViewById(R.id.ans26other);
                if(ans26.getSelectedItemPosition()==4) {
                    ans26other.setVisibility(View.VISIBLE);
                }else{
                    ans26other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tieneOtro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox tieneOtro = (CheckBox) findViewById(R.id.tieneOtro);
                EditText ans27other = (EditText) findViewById(R.id.ans27other);
                if(tieneOtro.isChecked()){
                    ans27other.setVisibility(View.VISIBLE);
                }
                else {
                    ans27other.setVisibility(View.GONE);
                }
            }
        });

        ans34.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans34 = (Spinner) findViewById(R.id.ans34);
                EditText ans34other = (EditText) findViewById(R.id.ans34other);
                if(ans34.getSelectedItemPosition()==4) {
                    ans34other.setVisibility(View.VISIBLE);
                }else{
                    ans34other.setVisibility(View.GONE);
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
                if(ans40_1.getSelectedItemPosition()==7) {
                    ans40_1other.setVisibility(View.VISIBLE);
                }else{
                    ans40_1other.setVisibility(View.GONE);
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
                if(ans41_1.getSelectedItemPosition()==4) {
                    ans41_1other.setVisibility(View.VISIBLE);
                }else{
                    ans41_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ayudaOtro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ayudaOtro = (CheckBox) findViewById(R.id.ayudaOtro);
                EditText ans41_2other = (EditText) findViewById(R.id.ans41_2other);
                if(ayudaOtro.isChecked()){
                    ans41_2other.setVisibility(View.VISIBLE);
                }
                else {
                    ans41_2other.setVisibility(View.GONE);
                }
            }
        });

        ans42_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans42_1 = (Spinner) findViewById(R.id.ans42_1);
                EditText ans42_1other = (EditText) findViewById(R.id.ans42_1other);
                if(ans42_1.getSelectedItemPosition()==4) {
                    ans42_1other.setVisibility(View.VISIBLE);
                }else{
                    ans42_1other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        formacionOtros.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox formacionOtros = (CheckBox) findViewById(R.id.formacionOtros);
                EditText ans42_2other = (EditText) findViewById(R.id.ans42_2other);
                if(formacionOtros.isChecked()){
                    ans42_2other.setVisibility(View.VISIBLE);
                }
                else {
                    ans42_2other.setVisibility(View.GONE);
                }
            }
        });

        nextButtonEUPAC =  (Button) findViewById(R.id.nextButtonEUPAC);
        nextButtonEUPAC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                escribir("EUPAC");
                Intent preg2 = new Intent(getApplicationContext(), Preguntas2.class);
                startActivity(preg2);
            }
        });

	    nextButtonUPPA =  (Button) findViewById(R.id.nextButtonUPPA);
        nextButtonUPPA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                escribir("UPPA");
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
            EditText ans19 = (EditText) findViewById(R.id.ans19);
            EditText ans19_3 = (EditText) findViewById(R.id.ans19_3);
            EditText ans19_8 = (EditText) findViewById(R.id.ans19_8);
            EditText ans32 = (EditText) findViewById(R.id.ans32);
            EditText ans32_2 = (EditText) findViewById(R.id.ans32_2);
            EditText ans32_3 = (EditText) findViewById(R.id.ans32_3);
            EditText ans33_2 = (EditText) findViewById(R.id.ans33_2);
            EditText ans33_3 = (EditText) findViewById(R.id.ans33_3);
            EditText ans34_1 = (EditText) findViewById(R.id.ans34_1);
            EditText ans34_2 = (EditText) findViewById(R.id.ans34_2);
            EditText ans35 = (EditText) findViewById(R.id.ans35);
            EditText ans36 = (EditText) findViewById(R.id.ans36);
            EditText ans37 = (EditText) findViewById(R.id.ans37);
            EditText ans40_2 = (EditText) findViewById(R.id.ans40_2);
            EditText ans9other = (EditText) findViewById(R.id.ans9other);
            EditText ans21_1other = (EditText) findViewById(R.id.ans21_1other);
            EditText ans23other = (EditText) findViewById(R.id.ans23other);
            EditText ans24other = (EditText) findViewById(R.id.ans24other);
            EditText ans25other = (EditText) findViewById(R.id.ans25other);
            EditText ans26other = (EditText) findViewById(R.id.ans26other);
            EditText ans27other = (EditText) findViewById(R.id.ans27other);
            EditText ans34other = (EditText) findViewById(R.id.ans34other);
            EditText ans40_1other = (EditText) findViewById(R.id.ans40_1other);
            EditText ans41_1other = (EditText) findViewById(R.id.ans41_1other);
            EditText ans42_1other = (EditText) findViewById(R.id.ans42_1other);
            EditText ans42_2other = (EditText) findViewById(R.id.ans42_2other);

            Spinner ans2 = (Spinner) findViewById(R.id.ans2);
            Spinner ans1 = (Spinner) findViewById(R.id.ans1);
            Spinner ans8 = (Spinner) findViewById(R.id.ans8);
            Spinner ans9 = (Spinner) findViewById(R.id.ans9);
            Spinner ans11 = (Spinner) findViewById(R.id.ans11);
            Spinner ans14 = (Spinner) findViewById(R.id.ans14);
            Spinner ans15 = (Spinner) findViewById(R.id.ans15);
            Spinner ans15_1 = (Spinner) findViewById(R.id.ans15_1);
            Spinner ans16 = (Spinner) findViewById(R.id.ans16);
            Spinner ans19_1 = (Spinner) findViewById(R.id.ans19_1);
            Spinner ans19_2 = (Spinner) findViewById(R.id.ans19_2);
            Spinner ans19_4 = (Spinner) findViewById(R.id.ans19_4);
            Spinner ans19_5 = (Spinner) findViewById(R.id.ans19_5);
            Spinner ans19_6 = (Spinner) findViewById(R.id.ans19_6);
            Spinner ans19_7 = (Spinner) findViewById(R.id.ans19_7);
            Spinner ans20 = (Spinner) findViewById(R.id.ans20);
            Spinner ans20_1 = (Spinner) findViewById(R.id.ans20_1);
            Spinner ans20_2 = (Spinner) findViewById(R.id.ans20_2);
            Spinner ans20_3 = (Spinner) findViewById(R.id.ans20_3);
            Spinner ans21 = (Spinner) findViewById(R.id.ans21);
            Spinner ans21_1 = (Spinner) findViewById(R.id.ans21_1);
            Spinner ans22 = (Spinner) findViewById(R.id.ans22);
            Spinner ans23 = (Spinner) findViewById(R.id.ans23);
            Spinner ans24 = (Spinner) findViewById(R.id.ans24);
            Spinner ans25 = (Spinner) findViewById(R.id.ans25);
            Spinner ans26 = (Spinner) findViewById(R.id.ans26);
            Spinner ans28 = (Spinner) findViewById(R.id.ans28);
            Spinner ans29 = (Spinner) findViewById(R.id.ans29);
            Spinner ans30 = (Spinner) findViewById(R.id.ans30);
            Spinner ans31 = (Spinner) findViewById(R.id.ans31);
            Spinner ans32_1 = (Spinner) findViewById(R.id.ans32_1);
            Spinner ans33 = (Spinner) findViewById(R.id.ans33);
            Spinner ans33_1 = (Spinner) findViewById(R.id.ans33_1);
            Spinner ans34 = (Spinner) findViewById(R.id.ans34);
            Spinner ans39 = (Spinner) findViewById(R.id.ans39);
            Spinner ans40 = (Spinner) findViewById(R.id.ans40);
            Spinner ans40_1 = (Spinner) findViewById(R.id.ans40_1);
            Spinner ans41 = (Spinner) findViewById(R.id.ans41);
            Spinner ans41_1 = (Spinner) findViewById(R.id.ans41_1);
            Spinner ans41_3 = (Spinner) findViewById(R.id.ans41_3);
            Spinner ans41_4 = (Spinner) findViewById(R.id.ans41_4);
            Spinner ans42 = (Spinner) findViewById(R.id.ans42);
            Spinner ans42_1 = (Spinner) findViewById(R.id.ans42_1);
            Spinner ans42_3 = (Spinner) findViewById(R.id.ans42_3);
            Spinner ans42_4 = (Spinner) findViewById(R.id.ans42_4);

            CheckBox tieneAcueducto = (CheckBox) findViewById(R.id.tieneAcueducto);
            CheckBox tieneAseo = (CheckBox) findViewById(R.id.tieneAseo);
            CheckBox tieneAlcantarillado = (CheckBox) findViewById(R.id.tieneAlcantarillado);
            CheckBox tienePozoSeptico = (CheckBox) findViewById(R.id.tienePozoSeptico);
            CheckBox tieneLetrina = (CheckBox) findViewById(R.id.tieneLetrina);
            CheckBox tieneElectricidad = (CheckBox) findViewById(R.id.tieneElectricidad);
            CheckBox tieneGas = (CheckBox) findViewById(R.id.tieneGas);
            CheckBox tieneTelefono = (CheckBox) findViewById(R.id.tieneTelefono);
            CheckBox tieneInternet = (CheckBox) findViewById(R.id.tieneInternet);
            CheckBox tieneOtro = (CheckBox) findViewById(R.id.tieneOtro);
            CheckBox isTerrestre = (CheckBox) findViewById(R.id.isTerrestre);
            CheckBox isFluvial = (CheckBox) findViewById(R.id.isFluvial);
            CheckBox isAereo = (CheckBox) findViewById(R.id.isAereo);
            CheckBox isTerrestreHosp = (CheckBox) findViewById(R.id.isTerrestreHosp);
            CheckBox isFluvialHosp = (CheckBox) findViewById(R.id.isFluvialHosp);
            CheckBox isAereoHosp = (CheckBox) findViewById(R.id.isAereoHosp);
            CheckBox isTerrestreInst = (CheckBox) findViewById(R.id.isTerrestreInst);
            CheckBox isFluvialInst = (CheckBox) findViewById(R.id.isFluvialInst);
            CheckBox isAereoInst = (CheckBox) findViewById(R.id.isAereoInst);
            CheckBox isTerrestreServ = (CheckBox) findViewById(R.id.isTerrestreServ);
            CheckBox isFluvialServ = (CheckBox) findViewById(R.id.isFluvialServ);
            CheckBox isAereoServ = (CheckBox) findViewById(R.id.isAereoServ);
            CheckBox ayudaGestion = (CheckBox) findViewById(R.id.ayudaGestion);
            CheckBox ayudaInsumos = (CheckBox) findViewById(R.id.ayudaInsumos);
            CheckBox ayudaCredito = (CheckBox) findViewById(R.id.ayudaCredito);
            CheckBox ayudaTecnificacion = (CheckBox) findViewById(R.id.ayudaTecnificacion);
            CheckBox ayudaSaludAnimal = (CheckBox) findViewById(R.id.ayudaSaludAnimal);
            CheckBox ayudaDesarrolloSostenible = (CheckBox) findViewById(R.id.ayudaDesarrolloSostenible);
            CheckBox ayudaAgremiacion = (CheckBox) findViewById(R.id.ayudaAgremiacion);
            CheckBox ayudaComercializacion = (CheckBox) findViewById(R.id.ayudaComercializacion);
            CheckBox ayudaOtro = (CheckBox) findViewById(R.id.ayudaOtro);
            CheckBox formacionAmbiental = (CheckBox) findViewById(R.id.formacionAmbiental);
            CheckBox formacionEmpresarial = (CheckBox) findViewById(R.id.formacionEmpresarial);
            CheckBox formacionAcuicola = (CheckBox) findViewById(R.id.formacionAcuicola);
            CheckBox formacionPesquero = (CheckBox) findViewById(R.id.formacionPesquero);
            CheckBox formacionTecnologica = (CheckBox) findViewById(R.id.formacionTecnologica);
            CheckBox formacionBuenasPracticas = (CheckBox) findViewById(R.id.formacionBuenasPracticas);
            CheckBox formacionOtros = (CheckBox) findViewById(R.id.formacionOtros);

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
            fos.write(("," + ans9other.getText().toString()).getBytes());
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
            fos.write(ans19.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans19_1.getSelectedItemPosition()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans19_2.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans19_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans19_4.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans19_5.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans19_6.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans19_7.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans19_8.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans20.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans20_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans20_2.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans20_3.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans21.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans21_1.getSelectedItemPosition()).getBytes());
            fos.write(("," + ans21_1other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans22.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans23.getSelectedItemPosition()+1).getBytes());
            fos.write(("," + ans23other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans24.getSelectedItemPosition()+1).getBytes());
            fos.write(("," + ans24other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans25.getSelectedItemPosition()+1).getBytes());
            fos.write(("," + ans25other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans26.getSelectedItemPosition()+1).getBytes());
            fos.write(("," + ans26other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            if(tieneAcueducto.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(tieneAseo.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(tieneAlcantarillado.isChecked()){
                fos.write("3, ".getBytes());
            }
            if(tienePozoSeptico.isChecked()){
                fos.write("4, ".getBytes());
            }
            if(tieneLetrina.isChecked()){
                fos.write("5, ".getBytes());
            }
            if(tieneElectricidad.isChecked()){
                fos.write("6, ".getBytes());
            }
            if(tieneGas.isChecked()){
                fos.write("7, ".getBytes());
            }
            if(tieneTelefono.isChecked()){
                fos.write("8, ".getBytes());
            }
            if(tieneInternet.isChecked()){
                fos.write("9, ".getBytes());
            }
            if(tieneOtro.isChecked()){
                fos.write("10, ".getBytes());
            }
            fos.write(("," + ans27other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans28.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans29.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans30.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans31.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans32.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans32_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans32_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans32_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            if(isTerrestre.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(isFluvial.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(isAereo.isChecked()){
                fos.write("3 ".getBytes());
            }
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans33.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans33_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans33_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans33_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            if(isTerrestreHosp.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(isFluvialHosp.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(isAereoHosp.isChecked()){
                fos.write("3 ".getBytes());
            }
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans34.getSelectedItemPosition()+1).getBytes());
            fos.write(("," + ans34other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans34_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans34_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            if(isTerrestreInst.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(isFluvialInst.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(isAereoInst.isChecked()){
                fos.write("3 ".getBytes());
            }
            fos.write("\t".getBytes());
            fos.write(ans35.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans36.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans37.getText().toString().getBytes());
            fos.write("\t".getBytes());
            if(isTerrestreServ.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(isFluvialServ.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(isAereoServ.isChecked()){
                fos.write("3 ".getBytes());
            }
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans39.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans40.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans40_1.getSelectedItemPosition()).getBytes());
            fos.write(("," + ans40_1other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans40_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans41.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans41_1.getSelectedItemPosition()).getBytes());
            fos.write(("," + ans41_1other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            if(ayudaGestion.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(ayudaInsumos.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(ayudaCredito.isChecked()){
                fos.write("3 ".getBytes());
            }
            if(ayudaTecnificacion.isChecked()){
                fos.write("4, ".getBytes());
            }
            if(ayudaSaludAnimal.isChecked()){
                fos.write("5, ".getBytes());
            }
            if(ayudaDesarrolloSostenible.isChecked()){
                fos.write("6 ".getBytes());
            }
            if(ayudaAgremiacion.isChecked()){
                fos.write("7, ".getBytes());
            }
            if(ayudaComercializacion.isChecked()){
                fos.write("8, ".getBytes());
            }
            if(ayudaOtro.isChecked()){
                fos.write("9 ".getBytes());
            }
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans41_3.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans41_4.getSelectedItemPosition()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans42.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans42_1.getSelectedItemPosition()).getBytes());
            fos.write(("," + ans42_1other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            if(formacionAmbiental.isChecked()){
                fos.write("1, ".getBytes());
            }
            if(formacionEmpresarial.isChecked()){
                fos.write("2, ".getBytes());
            }
            if(formacionAcuicola.isChecked()){
                fos.write("3 ".getBytes());
            }
            if(formacionPesquero.isChecked()){
                fos.write("4, ".getBytes());
            }
            if(formacionTecnologica.isChecked()){
                fos.write("5, ".getBytes());
            }
            if(formacionBuenasPracticas.isChecked()){
                fos.write("6 ".getBytes());
            }
            if(formacionOtros.isChecked()){
                fos.write("7, ".getBytes());
            }
            fos.write(("," + ans42_2other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans42_3.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans42_4.getSelectedItemPosition()).getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void showCurrentLocation(){

        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {

            ActivityCompat.requestPermissions( this, new String[] {  android.Manifest.permission.ACCESS_COARSE_LOCATION  },
                    11);
        }

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if(location != null){

        }else{

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
            Toast.makeText(Preguntas1.this, "Provider status changed",
                    Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderEnabled(String provider) {
            Toast.makeText(Preguntas1.this, "Provider enabled by the user. GPS turned on",
                    Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(Preguntas1.this, "Provider enabled by the user. GPS turned off",
                    Toast.LENGTH_LONG).show();
        }
    }
}
