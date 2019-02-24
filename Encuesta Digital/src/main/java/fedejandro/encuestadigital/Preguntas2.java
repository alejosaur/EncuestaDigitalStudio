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

    public int ans44code = 0;
    public int ans47code = 0;
    public int ans48code = 0;
    public int ans58code = 0;
    public int ans62code = 0;
    public int ans71code = 0;
    public int ans76code = 0;
    public int ans77code = 0;
    public int ans78code = 0;
    public int ans79code = 0;
    public int ans82code = 0;
    public int ans84_1code = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas2);

        String[] tipoActividad = new String[] {
                "Principal", "Complementaria"
        };
        String[] siNo = new String[] {
                "Sí", "No"
        };
        String[] destinoProd = new String[] {
                "Autoconsumo", "Comercialización", "Ambas"
        };
        String[] tipoProd = new String[] {
                "Animales de engorde", "Producción de crías", "Ciclo completo", "Producción de animales ornamentales", "Producción de plantas", "Producción combinda de plantas y animales","Procesamiento y/o transformación de productos", "Fines recreativos", "Otro, ¿Cuál?"
        };
        String[] unidadVenta = new String[] {
                "Gramos", "Kilogramos", "Arrobas", "Individuos"
        };
        String[] obtencionRepro = new String[] {
                "Pesca", "Compra"
        };
        String[] perdidas = new String[] {
                "No aplica", "Menor al 20% (Pérdidas mínimas)", "Entre el 20% y el 40% (Pérdidas moderadas)", "Vientos Mayor al 40% (Perdidas graves)"
        };
        String[] maquinas = new String[] {
                "Propios", "Propios en sociedad con otras UPAC", "Alquilados", "Proporcionada  por una cooperativa", "Proporcionada por  una entidad del estado", "Otro tipo de tenencia, ¿Cuál?"
        };
        String[] tipoProduccion = new String[] {
                "Extensivo", "Semi intensivo", "Intensivo", "Super intensivo"
        };
        String[] materialTanque = new String[] {
                "Tierra", "Cemento", "Geomembrana", "Vidrio", "Baldosa", "Plástico"
        };
        String[] alimentoPrincipal = new String[] {
                "Alimentos balanceados", "Subproductos agrícolas", "Biofloc", "Materias primas no convencionales (bore, ñame, yuca, ahuyama)", "Alimento natural"
        };
        String[] unidadCompra = new String[] {
                "Gramos", "Kilogramos", "Bultos", "Toneladas", "Otro, ¿Cuál?"
        };
        String[] frecuenciaCompra = new String[] {
                "Semanal", "Quincenal", "Mensual", "Otro, ¿Cuál?"
        };
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
                "No aplica", "Cooperativa", "Asociacion", "Sindicato", "Otro, ¿Cuál?"
        };
        String[] siNoNoAplica = new String[] {
                "No aplica", "Sí", "No"
        };
        String[] cargoAsociacion = new String[] {
                "No aplica", "Directivo"
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

        Spinner ans52 = (Spinner) findViewById(R.id.ans52);
        ArrayAdapter<String> adapterAns52 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns52.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans52.setAdapter(adapterAns52);

        Spinner ans54 = (Spinner) findViewById(R.id.ans54);
        ArrayAdapter<String> adapterAns54 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns54.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans54.setAdapter(adapterAns54);

        Spinner ans55 = (Spinner) findViewById(R.id.ans55);
        ArrayAdapter<String> adapterAns55 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns55.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans55.setAdapter(adapterAns55);

        Spinner ans56 = (Spinner) findViewById(R.id.ans56);
        ArrayAdapter<String> adapterAns56 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns56.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans56.setAdapter(adapterAns56);

        Spinner ans57 = (Spinner) findViewById(R.id.ans57);
        ArrayAdapter<String> adapterAns57 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, destinoProd);
        adapterAns57.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans57.setAdapter(adapterAns57);

        Spinner ans59 = (Spinner) findViewById(R.id.ans59);
        ArrayAdapter<String> adapterAns59 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoProd);
        adapterAns59.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans59.setAdapter(adapterAns59);

        Spinner ans69_1 = (Spinner) findViewById(R.id.ans69_1);
        ArrayAdapter<String> adapterAns69_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, unidadVenta);
        adapterAns69_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans69_1.setAdapter(adapterAns69_1);

        Spinner ans70 = (Spinner) findViewById(R.id.ans70);
        ArrayAdapter<String> adapterAns70 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns70.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans70.setAdapter(adapterAns70);

        Spinner ans73 = (Spinner) findViewById(R.id.ans73);
        ArrayAdapter<String> adapterAns73 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns73.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans73.setAdapter(adapterAns73);

        Spinner ans73_1 = (Spinner) findViewById(R.id.ans73_1);
        ArrayAdapter<String> adapterAns73_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, obtencionRepro);
        adapterAns73_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans73_1.setAdapter(adapterAns73_1);

        Spinner ans74 = (Spinner) findViewById(R.id.ans74);
        ArrayAdapter<String> adapterAns74 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns74.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans74.setAdapter(adapterAns74);

        Spinner ans76_1 = (Spinner) findViewById(R.id.ans76_1);
        ArrayAdapter<String> adapterAns76_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, perdidas);
        adapterAns76_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans76_1.setAdapter(adapterAns76_1);

        Spinner ans77_1 = (Spinner) findViewById(R.id.ans77_1);
        ArrayAdapter<String> adapterAns77_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, perdidas);
        adapterAns77_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans77_1.setAdapter(adapterAns77_1);

        Spinner ans78_1 = (Spinner) findViewById(R.id.ans78_1);
        ArrayAdapter<String> adapterAns78_1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, perdidas);
        adapterAns78_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans78_1.setAdapter(adapterAns78_1);

        Spinner ans75 = (Spinner) findViewById(R.id.ans75);
        ArrayAdapter<String> adapterAns75 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNo);
        adapterAns75.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans75.setAdapter(adapterAns75);

        Spinner ans80 = (Spinner) findViewById(R.id.ans80);
        ArrayAdapter<String> adapterAns80 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, maquinas);
        adapterAns80.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans80.setAdapter(adapterAns80);

        Spinner ans81 = (Spinner) findViewById(R.id.ans81);
        ArrayAdapter<String> adapterAns81 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoProduccion);
        adapterAns81.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans81.setAdapter(adapterAns81);

        Spinner ans82_3 = (Spinner) findViewById(R.id.ans82_3);
        ArrayAdapter<String> adapterAns108_7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, materialTanque);
        adapterAns108_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans82_3.setAdapter(adapterAns108_7);

        Spinner ans84 = (Spinner) findViewById(R.id.ans84);
        ArrayAdapter<String> adapterAns84 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, alimentoPrincipal);
        adapterAns84.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans84.setAdapter(adapterAns84);

        Spinner ans84_3 = (Spinner) findViewById(R.id.ans84_3);
        ArrayAdapter<String> adapterAns84_3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, departamentos);
        adapterAns84_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans84_3.setAdapter(adapterAns84_3);

        Spinner ans84_4 = (Spinner) findViewById(R.id.ans84_4);
        ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, municipiosAmazonas);
        adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans84_4.setAdapter(adapterAns84_4);

        Spinner ans84_6 = (Spinner) findViewById(R.id.ans84_6);
        ArrayAdapter<String> adapterAns84_6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, unidadCompra);
        adapterAns84_6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans84_6.setAdapter(adapterAns84_6);

        Spinner ans84_8 = (Spinner) findViewById(R.id.ans84_8);
        ArrayAdapter<String> adapterAns84_8 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frecuenciaCompra);
        adapterAns84_8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans84_8.setAdapter(adapterAns84_8);

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
        ArrayAdapter<String> adapterAns118_2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, siNoNoAplica);
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

        Spinner ans118_11 = (Spinner) findViewById(R.id.ans118_11);
        ArrayAdapter<String> adapterAns118_11 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, municipiosAmazonas);
        adapterAns118_11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans118_11.setAdapter(adapterAns118_11);

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

        EditText ans44other = (EditText) findViewById(R.id.ans44other);
        ans44other.setVisibility(View.GONE);

        EditText ans47other = (EditText) findViewById(R.id.ans47other);
        ans47other.setVisibility(View.GONE);

        EditText ans48other = (EditText) findViewById(R.id.ans48other);
        ans48other.setVisibility(View.GONE);

        EditText ans58other = (EditText) findViewById(R.id.ans58other);
        ans58other.setVisibility(View.GONE);

        EditText ans76other = (EditText) findViewById(R.id.ans76other);
        ans76other.setVisibility(View.GONE);

        EditText ans78other = (EditText) findViewById(R.id.ans78other);
        ans78other.setVisibility(View.GONE);

        TextView ques82_1 = (TextView) findViewById(R.id.ques82_1);
        ques82_1.setVisibility(View.GONE);

        EditText ans82_1 = (EditText) findViewById(R.id.ans82_1);
        ans82_1.setVisibility(View.GONE);

        TextView ques82_2 = (TextView) findViewById(R.id.ques82_2);
        ques82_2.setVisibility(View.GONE);

        EditText ans82_2 = (EditText) findViewById(R.id.ans82_2);
        ans82_2.setVisibility(View.GONE);

        TextView ques82_3 = (TextView) findViewById(R.id.ques82_3);
        ques82_3.setVisibility(View.GONE);

        ans82_3.setVisibility(View.GONE);

        TextView ques83 = (TextView) findViewById(R.id.ques83);
        ques83.setVisibility(View.GONE);

        EditText ans83 = (EditText) findViewById(R.id.ans83);
        ans83.setVisibility(View.GONE);

        TextView ques83_1 = (TextView) findViewById(R.id.ques83_1);
        ques83_1.setVisibility(View.GONE);

        EditText ans83_1 = (EditText) findViewById(R.id.ans83_1);
        ans83_1.setVisibility(View.GONE);

        TextView ques83_2 = (TextView) findViewById(R.id.ques83_2);
        ques83_2.setVisibility(View.GONE);

        EditText ans83_2 = (EditText) findViewById(R.id.ans83_2);
        ans83_2.setVisibility(View.GONE);

        EditText ans112_2other = (EditText) findViewById(R.id.ans112_2other);
        ans112_2other.setVisibility(View.GONE);

        EditText ans117other = (EditText) findViewById(R.id.ans117other);
        ans117other.setVisibility(View.GONE);

        EditText ans118_1other = (EditText) findViewById(R.id.ans118_1other);
        ans118_1other.setVisibility(View.GONE);

        CheckBox ans44a = (CheckBox) findViewById(R.id.ans44a);
        CheckBox ans44b = (CheckBox) findViewById(R.id.ans44b);
        CheckBox ans44c = (CheckBox) findViewById(R.id.ans44c);
        CheckBox ans44d = (CheckBox) findViewById(R.id.ans44d);
        CheckBox ans44e = (CheckBox) findViewById(R.id.ans44e);
        CheckBox ans47a = (CheckBox) findViewById(R.id.ans47a);
        CheckBox ans47b = (CheckBox) findViewById(R.id.ans47b);
        CheckBox ans47c = (CheckBox) findViewById(R.id.ans47c);
        CheckBox ans47d = (CheckBox) findViewById(R.id.ans47d);
        CheckBox ans47e = (CheckBox) findViewById(R.id.ans47e);
        CheckBox ans47f = (CheckBox) findViewById(R.id.ans47f);
        CheckBox ans47g = (CheckBox) findViewById(R.id.ans47g);
        CheckBox ans47h = (CheckBox) findViewById(R.id.ans47h);
        CheckBox ans47i = (CheckBox) findViewById(R.id.ans47i);
        CheckBox ans48a = (CheckBox) findViewById(R.id.ans48a);
        CheckBox ans48b = (CheckBox) findViewById(R.id.ans48b);
        CheckBox ans48c = (CheckBox) findViewById(R.id.ans48c);
        CheckBox ans48d = (CheckBox) findViewById(R.id.ans48d);
        CheckBox ans58a = (CheckBox) findViewById(R.id.ans58a);
        CheckBox ans58b = (CheckBox) findViewById(R.id.ans58b);
        CheckBox ans58c = (CheckBox) findViewById(R.id.ans58c);
        CheckBox ans58d = (CheckBox) findViewById(R.id.ans58d);
        CheckBox ans58e = (CheckBox) findViewById(R.id.ans58e);
        CheckBox ans58f = (CheckBox) findViewById(R.id.ans58f);
        CheckBox ans58g = (CheckBox) findViewById(R.id.ans58g);
        CheckBox ans62a = (CheckBox) findViewById(R.id.ans62a);
        CheckBox ans62b = (CheckBox) findViewById(R.id.ans62b);
        CheckBox ans62c = (CheckBox) findViewById(R.id.ans62c);
        CheckBox ans62d = (CheckBox) findViewById(R.id.ans62d);
        CheckBox ans62e = (CheckBox) findViewById(R.id.ans62e);
        CheckBox ans62f = (CheckBox) findViewById(R.id.ans62f);
        CheckBox ans62g = (CheckBox) findViewById(R.id.ans62g);
        CheckBox ans62h = (CheckBox) findViewById(R.id.ans62h);
        CheckBox ans62i = (CheckBox) findViewById(R.id.ans62i);
        CheckBox ans62j = (CheckBox) findViewById(R.id.ans62j);
        CheckBox ans71a = (CheckBox) findViewById(R.id.ans71a);
        CheckBox ans71b = (CheckBox) findViewById(R.id.ans71b);
        CheckBox ans71c = (CheckBox) findViewById(R.id.ans71c);
        CheckBox ans71d = (CheckBox) findViewById(R.id.ans71d);
        CheckBox ans71e = (CheckBox) findViewById(R.id.ans71e);
        CheckBox ans71f = (CheckBox) findViewById(R.id.ans71f);
        CheckBox ans71g = (CheckBox) findViewById(R.id.ans71g);
        CheckBox ans71h = (CheckBox) findViewById(R.id.ans71h);
        CheckBox ans71i = (CheckBox) findViewById(R.id.ans71i);
        CheckBox ans76a = (CheckBox) findViewById(R.id.ans76a);
        CheckBox ans76b = (CheckBox) findViewById(R.id.ans76b);
        CheckBox ans76c = (CheckBox) findViewById(R.id.ans76c);
        CheckBox ans76d = (CheckBox) findViewById(R.id.ans76d);
        CheckBox ans76e = (CheckBox) findViewById(R.id.ans76e);
        CheckBox ans76f = (CheckBox) findViewById(R.id.ans76f);
        CheckBox ans77a = (CheckBox) findViewById(R.id.ans77a);
        CheckBox ans77b = (CheckBox) findViewById(R.id.ans77b);
        CheckBox ans77c = (CheckBox) findViewById(R.id.ans77c);
        CheckBox ans77d = (CheckBox) findViewById(R.id.ans77d);
        CheckBox ans77e = (CheckBox) findViewById(R.id.ans77e);
        CheckBox ans77f = (CheckBox) findViewById(R.id.ans77f);
        CheckBox ans78a = (CheckBox) findViewById(R.id.ans78a);
        CheckBox ans78b = (CheckBox) findViewById(R.id.ans78b);
        CheckBox ans78c = (CheckBox) findViewById(R.id.ans78c);
        CheckBox ans78d = (CheckBox) findViewById(R.id.ans78d);
        CheckBox ans78e = (CheckBox) findViewById(R.id.ans78e);
        CheckBox ans78f = (CheckBox) findViewById(R.id.ans78f);
        CheckBox ans78g = (CheckBox) findViewById(R.id.ans78g);
        CheckBox ans79a = (CheckBox) findViewById(R.id.ans79a);
        CheckBox ans79b = (CheckBox) findViewById(R.id.ans79b);
        CheckBox ans79c = (CheckBox) findViewById(R.id.ans79c);
        CheckBox ans79d = (CheckBox) findViewById(R.id.ans79d);
        CheckBox ans79e = (CheckBox) findViewById(R.id.ans79e);
        CheckBox ans79f = (CheckBox) findViewById(R.id.ans79f);
        CheckBox ans79g = (CheckBox) findViewById(R.id.ans79g);
        CheckBox ans82a = (CheckBox) findViewById(R.id.ans82a);
        CheckBox ans82b = (CheckBox) findViewById(R.id.ans82b);
        CheckBox ans82c = (CheckBox) findViewById(R.id.ans82c);
        CheckBox ans82d = (CheckBox) findViewById(R.id.ans82d);
        CheckBox ans84_1a = (CheckBox) findViewById(R.id.ans84_1a);
        CheckBox ans84_1b = (CheckBox) findViewById(R.id.ans84_1b);
        CheckBox ans84_1c = (CheckBox) findViewById(R.id.ans84_1c);
        CheckBox ans84_1d = (CheckBox) findViewById(R.id.ans84_1d);
        CheckBox ans84_1e = (CheckBox) findViewById(R.id.ans84_1e);
        CheckBox ans84_1f = (CheckBox) findViewById(R.id.ans84_1f);

        ans44a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans44a = (CheckBox) findViewById(R.id.ans44a);
                if(ans44a.isChecked()){
                    ans44code += 1;
                }
                else {
                    ans44code -= 1;
                }
            }
        });

        ans44b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans44b = (CheckBox) findViewById(R.id.ans44b);
                if(ans44b.isChecked()){
                    ans44code += 2;
                }
                else {
                    ans44code -= 2;
                }
            }
        });

        ans44c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans44c = (CheckBox) findViewById(R.id.ans44c);
                if(ans44c.isChecked()){
                    ans44code += 4;
                }
                else {
                    ans44code -= 4;
                }
            }
        });

        ans44d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans44d = (CheckBox) findViewById(R.id.ans44d);
                if(ans44d.isChecked()){
                    ans44code += 8;
                }
                else {
                    ans44code -= 8;
                }
            }
        });

        ans44e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans44e = (CheckBox) findViewById(R.id.ans44e);
                EditText ans44other = (EditText) findViewById(R.id.ans44other);
                if(ans44e.isChecked()){
                    ans44other.setVisibility(View.VISIBLE);
                    ans44code += 16;
                }
                else {
                    ans44other.setVisibility(View.GONE);
                    ans44code -= 16;

                }
            }
        });

        ans47a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans47a = (CheckBox) findViewById(R.id.ans47a);
                if(ans47a.isChecked()){
                    ans47code += 1;
                }
                else {
                    ans47code -= 1;
                }
            }
        });

        ans47b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans47b = (CheckBox) findViewById(R.id.ans47b);
                if(ans47b.isChecked()){
                    ans47code += 2;
                }
                else {
                    ans47code -= 2;
                }
            }
        });

        ans47c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans47c = (CheckBox) findViewById(R.id.ans47c);
                if(ans47c.isChecked()){
                    ans47code += 4;
                }
                else {
                    ans47code -= 4;
                }
            }
        });

        ans47d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans47d = (CheckBox) findViewById(R.id.ans47d);
                if(ans47d.isChecked()){
                    ans47code += 8;
                }
                else {
                    ans47code -= 8;
                }
            }
        });

        ans47e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans47e = (CheckBox) findViewById(R.id.ans47e);
                if(ans47e.isChecked()){
                    ans47code += 16;
                }
                else {
                    ans47code -= 16;
                }
            }
        });

        ans47f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans47f = (CheckBox) findViewById(R.id.ans47f);
                if(ans47f.isChecked()){
                    ans47code += 32;
                }
                else {
                    ans47code -= 32;
                }
            }
        });

        ans47g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans47g = (CheckBox) findViewById(R.id.ans47g);
                if(ans47g.isChecked()){
                    ans47code += 64;
                }
                else {
                    ans47code -= 64;
                }
            }
        });

        ans47h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans47h = (CheckBox) findViewById(R.id.ans47h);
                if(ans47h.isChecked()){
                    ans47code += 128;
                }
                else {
                    ans47code -= 128;
                }
            }
        });

        ans47i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans47i = (CheckBox) findViewById(R.id.ans47i);
                EditText ans47other = (EditText) findViewById(R.id.ans47other);
                if(ans47i.isChecked()){
                    ans47other.setVisibility(View.VISIBLE);
                    ans47code += 256;
                }
                else {
                    ans47other.setVisibility(View.GONE);
                    ans47code -= 256;

                }
            }
        });

        ans48a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans48a = (CheckBox) findViewById(R.id.ans48a);
                if(ans48a.isChecked()){
                    ans48code += 1;
                }
                else {
                    ans48code -= 1;
                }
            }
        });

        ans48b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans48b = (CheckBox) findViewById(R.id.ans48b);
                if(ans48b.isChecked()){
                    ans48code += 2;
                }
                else {
                    ans48code -= 2;
                }
            }
        });

        ans48c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans48c = (CheckBox) findViewById(R.id.ans48c);
                if(ans48c.isChecked()){
                    ans48code += 4;
                }
                else {
                    ans48code -= 4;
                }
            }
        });

        ans48d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans48d = (CheckBox) findViewById(R.id.ans48d);
                EditText ans48other = (EditText) findViewById(R.id.ans48other);
                if(ans48d.isChecked()){
                    ans48other.setVisibility(View.VISIBLE);
                    ans48code += 8;
                }
                else {
                    ans48other.setVisibility(View.GONE);
                    ans48code -= 8;
                }
            }
        });

        ans52.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans52 = (Spinner) findViewById(R.id.ans52);
                TextView ques52_1 = (TextView) findViewById(R.id.ques52_1);
                EditText ans52_1 = (EditText) findViewById(R.id.ans52_1);
                if(ans52.getSelectedItemPosition()==1) {
                    ques52_1.setVisibility(View.GONE);
                    ans52_1.setVisibility(View.GONE);
                }else{
                    ques52_1.setVisibility(View.VISIBLE);
                    ans52_1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans54.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans54 = (Spinner) findViewById(R.id.ans54);
                TextView ques54_1 = (TextView) findViewById(R.id.ques54_1);
                EditText ans54_1 = (EditText) findViewById(R.id.ans54_1);
                if(ans54.getSelectedItemPosition()==1) {
                    ques54_1.setVisibility(View.GONE);
                    ans54_1.setVisibility(View.GONE);
                }else{
                    ques54_1.setVisibility(View.VISIBLE);
                    ans54_1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans55.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans55 = (Spinner) findViewById(R.id.ans55);
                TextView ques55_1 = (TextView) findViewById(R.id.ques55_1);
                EditText ans55_1 = (EditText) findViewById(R.id.ans55_1);
                TextView ques55_2 = (TextView) findViewById(R.id.ques55_2);
                EditText ans55_2 = (EditText) findViewById(R.id.ans55_2);
                TextView ques55_3 = (TextView) findViewById(R.id.ques55_3);
                EditText ans55_3 = (EditText) findViewById(R.id.ans55_3);
                TextView ques55_4 = (TextView) findViewById(R.id.ques55_4);
                EditText ans55_4 = (EditText) findViewById(R.id.ans55_4);
                TextView ques55_5 = (TextView) findViewById(R.id.ques55_5);
                EditText ans55_5 = (EditText) findViewById(R.id.ans55_5);
                TextView ques55_6 = (TextView) findViewById(R.id.ques55_6);
                EditText ans55_6 = (EditText) findViewById(R.id.ans55_6);
                TextView ques55_7 = (TextView) findViewById(R.id.ques55_7);
                EditText ans55_7 = (EditText) findViewById(R.id.ans55_7);
                if(ans55.getSelectedItemPosition()==1) {
                    ques55_1.setVisibility(View.GONE);
                    ans55_1.setVisibility(View.GONE);
                    ques55_2.setVisibility(View.GONE);
                    ans55_2.setVisibility(View.GONE);
                    ques55_3.setVisibility(View.GONE);
                    ans55_3.setVisibility(View.GONE);
                    ques55_4.setVisibility(View.GONE);
                    ans55_4.setVisibility(View.GONE);
                    ques55_5.setVisibility(View.GONE);
                    ans55_5.setVisibility(View.GONE);
                    ques55_6.setVisibility(View.GONE);
                    ans55_6.setVisibility(View.GONE);
                    ques55_7.setVisibility(View.GONE);
                    ans55_7.setVisibility(View.GONE);
                }else{
                    ques55_1.setVisibility(View.VISIBLE);
                    ans55_1.setVisibility(View.VISIBLE);
                    ques55_2.setVisibility(View.VISIBLE);
                    ans55_2.setVisibility(View.VISIBLE);
                    ques55_3.setVisibility(View.VISIBLE);
                    ans55_3.setVisibility(View.VISIBLE);
                    ques55_4.setVisibility(View.VISIBLE);
                    ans55_4.setVisibility(View.VISIBLE);
                    ques55_5.setVisibility(View.VISIBLE);
                    ans55_5.setVisibility(View.VISIBLE);
                    ques55_6.setVisibility(View.VISIBLE);
                    ans55_6.setVisibility(View.VISIBLE);
                    ques55_7.setVisibility(View.VISIBLE);
                    ans55_7.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans56.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans56 = (Spinner) findViewById(R.id.ans56);
                TextView ques56_1 = (TextView) findViewById(R.id.ques56_1);
                EditText ans56_1 = (EditText) findViewById(R.id.ans56_1);
                if(ans56.getSelectedItemPosition()==1) {
                    ques56_1.setVisibility(View.GONE);
                    ans56_1.setVisibility(View.GONE);
                }else{
                    ques56_1.setVisibility(View.VISIBLE);
                    ans56_1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans58a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans58a = (CheckBox) findViewById(R.id.ans58a);
                if(ans58a.isChecked()){
                    ans58code += 1;
                }
                else {
                    ans58code -= 1;
                }
            }
        });

        ans58b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans58b = (CheckBox) findViewById(R.id.ans58b);
                if(ans58b.isChecked()){
                    ans58code += 2;
                }
                else {
                    ans58code -= 2;
                }
            }
        });

        ans58c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans58c = (CheckBox) findViewById(R.id.ans58c);
                if(ans58c.isChecked()){
                    ans58code += 4;
                }
                else {
                    ans58code -= 4;
                }
            }
        });

        ans58d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans58d = (CheckBox) findViewById(R.id.ans58d);
                if(ans58d.isChecked()){
                    ans58code += 8;
                }
                else {
                    ans58code -= 8;
                }
            }
        });

        ans58e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans58e = (CheckBox) findViewById(R.id.ans58e);
                if(ans58e.isChecked()){
                    ans58code += 16;
                }
                else {
                    ans58code -= 16;
                }
            }
        });

        ans58f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans58f = (CheckBox) findViewById(R.id.ans58f);
                if(ans58f.isChecked()){
                    ans58code += 32;
                }
                else {
                    ans58code -= 32;
                }
            }
        });

        ans58g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans58g = (CheckBox) findViewById(R.id.ans58g);
                EditText ans58other = (EditText) findViewById(R.id.ans58other);
                if(ans58g.isChecked()){
                    ans58other.setVisibility(View.VISIBLE);
                    ans58code += 64;
                }
                else {
                    ans58other.setVisibility(View.GONE);
                    ans58code -= 64;
                }
            }
        });

        ans62a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans62a = (CheckBox) findViewById(R.id.ans62a);
                if(ans62a.isChecked()){
                    ans62code += 1;
                }
                else {
                    ans62code -= 1;
                }
            }
        });

        ans62b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans62b = (CheckBox) findViewById(R.id.ans62b);
                if(ans62b.isChecked()){
                    ans62code += 2;
                }
                else {
                    ans62code -= 2;
                }
            }
        });

        ans62c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans62c = (CheckBox) findViewById(R.id.ans62c);
                if(ans62c.isChecked()){
                    ans62code += 4;
                }
                else {
                    ans62code -= 4;
                }
            }
        });

        ans62d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans62d = (CheckBox) findViewById(R.id.ans62d);
                if(ans62d.isChecked()){
                    ans62code += 8;
                }
                else {
                    ans62code -= 8;
                }
            }
        });

        ans62e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans62e = (CheckBox) findViewById(R.id.ans62e);
                if(ans62e.isChecked()){
                    ans62code += 16;
                }
                else {
                    ans62code -= 16;
                }
            }
        });

        ans62f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans62f = (CheckBox) findViewById(R.id.ans62f);
                if(ans62f.isChecked()){
                    ans62code += 32;
                }
                else {
                    ans62code -= 32;
                }
            }
        });

        ans62g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans62g = (CheckBox) findViewById(R.id.ans62g);
                if(ans62g.isChecked()){
                    ans62code += 64;
                }
                else {
                    ans62code -= 64;
                }
            }
        });

        ans62h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans62h = (CheckBox) findViewById(R.id.ans62h);
                if(ans62h.isChecked()){
                    ans62code += 128;
                }
                else {
                    ans62code -= 128;
                }
            }
        });

        ans62i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans62i = (CheckBox) findViewById(R.id.ans62i);
                if(ans62i.isChecked()){
                    ans62code += 256;
                }
                else {
                    ans62code -= 256;
                }
            }
        });

        ans62j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans62j = (CheckBox) findViewById(R.id.ans62j);
                EditText ans62other = (EditText) findViewById(R.id.ans62other);
                if(ans62j.isChecked()){
                    ans62other.setVisibility(View.VISIBLE);
                    ans62code += 512;
                }
                else {
                    ans62other.setVisibility(View.GONE);
                    ans62code -= 512;
                }
            }
        });

        ans71a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans71a = (CheckBox) findViewById(R.id.ans71a);
                if(ans71a.isChecked()){
                    ans71code += 1;
                }
                else {
                    ans71code -= 1;
                }
            }
        });

        ans71b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans71b = (CheckBox) findViewById(R.id.ans71b);
                if(ans71b.isChecked()){
                    ans71code += 2;
                }
                else {
                    ans71code -= 2;
                }
            }
        });

        ans71c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans71c = (CheckBox) findViewById(R.id.ans71c);
                if(ans71c.isChecked()){
                    ans71code += 4;
                }
                else {
                    ans71code -= 4;
                }
            }
        });

        ans71d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans71d = (CheckBox) findViewById(R.id.ans71d);
                if(ans71d.isChecked()){
                    ans71code += 8;
                }
                else {
                    ans71code -= 8;
                }
            }
        });

        ans71e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans71e = (CheckBox) findViewById(R.id.ans71e);
                if(ans71e.isChecked()){
                    ans71code += 16;
                }
                else {
                    ans71code -= 16;
                }
            }
        });

        ans71f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans71f = (CheckBox) findViewById(R.id.ans71f);
                if(ans71f.isChecked()){
                    ans71code += 32;
                }
                else {
                    ans71code -= 32;
                }
            }
        });

        ans71g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans71g = (CheckBox) findViewById(R.id.ans71g);
                if(ans71g.isChecked()){
                    ans71code += 58;
                }
                else {
                    ans71code -= 58;
                }
            }
        });

        ans71h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans71h = (CheckBox) findViewById(R.id.ans71h);
                if(ans71h.isChecked()){
                    ans71code += 128;
                }
                else {
                    ans71code -= 128;
                }
            }
        });

        ans71i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans71i = (CheckBox) findViewById(R.id.ans71i);
                EditText ans71other = (EditText) findViewById(R.id.ans71other);
                if(ans71i.isChecked()){
                    ans71other.setVisibility(View.VISIBLE);
                    ans71code += 256;
                }
                else {
                    ans71other.setVisibility(View.GONE);
                    ans71code -= 256;

                }
            }
        });

        ans73_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans73_1 = (Spinner) findViewById(R.id.ans73_1);
                TextView ques73_2 = (TextView) findViewById(R.id.ques73_2);
                EditText ans73_2 = (EditText) findViewById(R.id.ans73_2);
                if(ans73_1.getSelectedItemPosition()==0) {
                    ques73_2.setVisibility(View.GONE);
                    ans73_2.setVisibility(View.GONE);
                }else{
                    ques73_2.setVisibility(View.VISIBLE);
                    ans73_2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans74.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans74 = (Spinner) findViewById(R.id.ans74);
                TextView ques74_1 = (TextView) findViewById(R.id.ques74_1);
                EditText ans74_1 = (EditText) findViewById(R.id.ans74_1);
                if(ans74.getSelectedItemPosition()==1) {
                    ques74_1.setVisibility(View.GONE);
                    ans74_1.setVisibility(View.GONE);
                }else{
                    ques74_1.setVisibility(View.VISIBLE);
                    ans74_1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans76a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans76a = (CheckBox) findViewById(R.id.ans76a);
                if(ans76a.isChecked()){
                    ans76code += 1;
                }
                else {
                    ans76code -= 1;
                }
            }
        });

        ans76b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans76b = (CheckBox) findViewById(R.id.ans76b);
                if(ans76b.isChecked()){
                    ans76code += 2;
                }
                else {
                    ans76code -= 2;
                }
            }
        });

        ans76c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans76c = (CheckBox) findViewById(R.id.ans76c);
                if(ans76c.isChecked()){
                    ans76code += 4;
                }
                else {
                    ans76code -= 4;
                }
            }
        });

        ans76d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans76d = (CheckBox) findViewById(R.id.ans76d);
                if(ans76d.isChecked()){
                    ans76code += 8;
                }
                else {
                    ans76code -= 8;
                }
            }
        });

        ans76e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans76e = (CheckBox) findViewById(R.id.ans76e);
                EditText ans76other = (EditText) findViewById(R.id.ans76other);
                if(ans76e.isChecked()){
                    ans76other.setVisibility(View.VISIBLE);
                    ans76code += 16;

                }
                else {
                    ans76other.setVisibility(View.GONE);
                    ans76code -= 16;
                }
            }
        });

        ans76f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans76f = (CheckBox) findViewById(R.id.ans76f);
                if(ans76f.isChecked()){
                    ans76code += 32;
                }
                else {
                    ans76code -= 32;
                }
            }
        });

        ans77a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans77a = (CheckBox) findViewById(R.id.ans77a);
                if(ans77a.isChecked()){
                    ans77code += 1;
                }
                else {
                    ans77code -= 1;
                }
            }
        });

        ans77b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans77b = (CheckBox) findViewById(R.id.ans77b);
                if(ans77b.isChecked()){
                    ans77code += 2;
                }
                else {
                    ans77code -= 2;
                }
            }
        });

        ans77c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans77c = (CheckBox) findViewById(R.id.ans77c);
                if(ans77c.isChecked()){
                    ans77code += 4;
                }
                else {
                    ans77code -= 4;
                }
            }
        });

        ans77d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans77d = (CheckBox) findViewById(R.id.ans77d);
                if(ans77d.isChecked()){
                    ans77code += 8;
                }
                else {
                    ans77code -= 8;
                }
            }
        });

        ans77e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans77e = (CheckBox) findViewById(R.id.ans77e);
                if(ans77e.isChecked()){
                    ans77code += 16;

                }
                else {
                    ans77code -= 16;
                }
            }
        });

        ans77f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans77f = (CheckBox) findViewById(R.id.ans77f);
                if(ans77f.isChecked()){
                    ans77code += 32;
                }
                else {
                    ans77code -= 32;
                }
            }
        });

        ans78a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans78a = (CheckBox) findViewById(R.id.ans78a);
                if(ans78a.isChecked()){
                    ans78code += 1;
                }
                else {
                    ans78code -= 1;
                }
            }
        });

        ans78b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans78b = (CheckBox) findViewById(R.id.ans78b);
                if(ans78b.isChecked()){
                    ans78code += 2;
                }
                else {
                    ans78code -= 2;
                }
            }
        });

        ans78c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans78c = (CheckBox) findViewById(R.id.ans78c);
                if(ans78c.isChecked()){
                    ans78code += 4;
                }
                else {
                    ans78code -= 4;
                }
            }
        });

        ans78d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans78d = (CheckBox) findViewById(R.id.ans78d);
                if(ans78d.isChecked()){
                    ans78code += 8;
                }
                else {
                    ans78code -= 8;
                }
            }
        });

        ans78e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans78e = (CheckBox) findViewById(R.id.ans78e);
                if(ans78e.isChecked()){
                    ans78code += 16;

                }
                else {
                    ans78code -= 16;
                }
            }
        });

        ans78f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans78f = (CheckBox) findViewById(R.id.ans78f);
                EditText ans78other = (EditText) findViewById(R.id.ans78other);
                if(ans78f.isChecked()){
                    ans78other.setVisibility(View.VISIBLE);
                    ans78code += 32;

                }
                else {
                    ans78other.setVisibility(View.GONE);
                    ans78code -= 32;
                }
            }
        });

        ans78g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans78g = (CheckBox) findViewById(R.id.ans78g);
                if(ans78g.isChecked()){
                    ans78code += 64;
                }
                else {
                    ans78code -= 64;
                }
            }
        });

        ans79a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans79a = (CheckBox) findViewById(R.id.ans79a);
                if(ans79a.isChecked()){
                    ans79code += 1;
                }
                else {
                    ans79code -= 1;
                }
            }
        });

        ans79b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans79b = (CheckBox) findViewById(R.id.ans79b);
                if(ans79b.isChecked()){
                    ans79code += 2;
                }
                else {
                    ans79code -= 2;
                }
            }
        });

        ans79c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans79c = (CheckBox) findViewById(R.id.ans79c);
                if(ans79c.isChecked()){
                    ans79code += 4;
                }
                else {
                    ans79code -= 4;
                }
            }
        });

        ans79d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans79d = (CheckBox) findViewById(R.id.ans79d);
                if(ans79d.isChecked()){
                    ans79code += 8;
                }
                else {
                    ans79code -= 8;
                }
            }
        });

        ans79e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans79e = (CheckBox) findViewById(R.id.ans79e);
                if(ans79e.isChecked()){
                    ans79code += 16;

                }
                else {
                    ans79code -= 16;
                }
            }
        });

        ans79f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans79f = (CheckBox) findViewById(R.id.ans79f);
                if(ans79f.isChecked()){
                    ans79code += 32;
                }
                else {
                    ans79code -= 32;
                }
            }
        });

        ans79g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans79g = (CheckBox) findViewById(R.id.ans79g);
                EditText ans79other = (EditText) findViewById(R.id.ans79other);
                if(ans79g.isChecked()){
                    ans79other.setVisibility(View.VISIBLE);
                    ans79code += 64;
                }
                else {
                    ans79other.setVisibility(View.GONE);
                    ans79code -= 64;
                }
            }
        });

        ans80.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans80 = (Spinner) findViewById(R.id.ans80);
                EditText ans80other = (EditText) findViewById(R.id.ans80other);
                if(ans80.getSelectedItemPosition()==5) {
                    ans80other.setVisibility(View.VISIBLE);
                }else{
                    ans80other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans82a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans82a = (CheckBox) findViewById(R.id.ans82a);
                TextView ques82_1 = (TextView) findViewById(R.id.ques82_1);
                EditText ans82_1 = (EditText) findViewById(R.id.ans82_1);
                TextView ques82_2 = (TextView) findViewById(R.id.ques82_2);
                EditText ans82_2 = (EditText) findViewById(R.id.ans82_2);
                TextView ques82_3 = (TextView) findViewById(R.id.ques82_3);
                Spinner ans82_3 = (Spinner) findViewById(R.id.ans82_3);
                if(ans82a.isChecked()){
                    ans82code += 1;
                    ques82_1.setVisibility(View.VISIBLE);
                    ans82_1.setVisibility(View.VISIBLE);
                    ques82_2.setVisibility(View.VISIBLE);
                    ans82_2.setVisibility(View.VISIBLE);
                    ques82_3.setVisibility(View.VISIBLE);
                    ans82_3.setVisibility(View.VISIBLE);
                }
                else {
                    ans82code -= 1;
                    ques82_1.setVisibility(View.GONE);
                    ans82_1.setVisibility(View.GONE);
                    ques82_2.setVisibility(View.GONE);
                    ans82_2.setVisibility(View.GONE);
                    ques82_3.setVisibility(View.GONE);
                    ans82_3.setVisibility(View.GONE);
                }
            }
        });

        ans82b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans82b = (CheckBox) findViewById(R.id.ans82b);
                TextView ques83 = (TextView) findViewById(R.id.ques83);
                EditText ans83 = (EditText) findViewById(R.id.ans83);
                TextView ques83_1 = (TextView) findViewById(R.id.ques83_1);
                EditText ans83_1 = (EditText) findViewById(R.id.ans83_1);
                TextView ques83_2 = (TextView) findViewById(R.id.ques83_2);
                EditText ans83_2 = (EditText) findViewById(R.id.ans83_2);
                if(ans82b.isChecked()){
                    ans82code += 2;
                    ques83.setVisibility(View.VISIBLE);
                    ans83.setVisibility(View.VISIBLE);
                    ques83_1.setVisibility(View.VISIBLE);
                    ans83_1.setVisibility(View.VISIBLE);
                    ques83_2.setVisibility(View.VISIBLE);
                    ans83_2.setVisibility(View.VISIBLE);
                }
                else {
                    ans82code -= 2;
                    ques83.setVisibility(View.GONE);
                    ans83.setVisibility(View.GONE);
                    ques83_1.setVisibility(View.GONE);
                    ans83_1.setVisibility(View.GONE);
                    ques83_2.setVisibility(View.GONE);
                    ans83_2.setVisibility(View.GONE);
                }
            }
        });

        //TODO Adjust the conditionals so unchecking 82a doesn't hide the answers if 82c is still checked.
        ans82c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans82c = (CheckBox) findViewById(R.id.ans82c);
                TextView ques82_1 = (TextView) findViewById(R.id.ques82_1);
                EditText ans82_1 = (EditText) findViewById(R.id.ans82_1);
                TextView ques82_2 = (TextView) findViewById(R.id.ques82_2);
                EditText ans82_2 = (EditText) findViewById(R.id.ans82_2);
                TextView ques82_3 = (TextView) findViewById(R.id.ques82_3);
                Spinner ans82_3 = (Spinner) findViewById(R.id.ans82_3);
                if(ans82c.isChecked()){
                    ans82code += 4;
                    ques82_1.setVisibility(View.VISIBLE);
                    ans82_1.setVisibility(View.VISIBLE);
                    ques82_2.setVisibility(View.VISIBLE);
                    ans82_2.setVisibility(View.VISIBLE);
                    ques82_3.setVisibility(View.VISIBLE);
                    ans82_3.setVisibility(View.VISIBLE);
                }
                else {
                    ans82code -= 4;
                    ques82_1.setVisibility(View.GONE);
                    ans82_1.setVisibility(View.GONE);
                    ques82_2.setVisibility(View.GONE);
                    ans82_2.setVisibility(View.GONE);
                    ques82_3.setVisibility(View.GONE);
                    ans82_3.setVisibility(View.GONE);
                }
            }
        });

        ans82d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans82d = (CheckBox) findViewById(R.id.ans82d);
                EditText ans82other = (EditText) findViewById(R.id.ans82other);
                if(ans82d.isChecked()){
                    ans82code += 8;
                    ans82other.setVisibility(View.VISIBLE);
                }
                else {
                    ans82code -= 8;
                    ans82other.setVisibility(View.GONE);
                }
            }
        });

        ans84_1a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans84_1a = (CheckBox) findViewById(R.id.ans84_1a);
                if(ans84_1a.isChecked()){
                    ans84_1code += 1;
                }
                else {
                    ans84_1code -= 1;
                }
            }
        });

        ans84_1b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans84_1b = (CheckBox) findViewById(R.id.ans84_1b);
                if(ans84_1b.isChecked()){
                    ans84_1code += 2;
                }
                else {
                    ans84_1code -= 2;
                }
            }
        });

        ans84_1c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans84_1c = (CheckBox) findViewById(R.id.ans84_1c);
                if(ans84_1c.isChecked()){
                    ans84_1code += 4;
                }
                else {
                    ans84_1code -= 4;
                }
            }
        });

        ans84_1d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans84_1d = (CheckBox) findViewById(R.id.ans84_1d);
                if(ans84_1d.isChecked()){
                    ans84_1code += 8;
                }
                else {
                    ans84_1code -= 8;
                }
            }
        });

        ans84_1e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans84_1e = (CheckBox) findViewById(R.id.ans84_1e);
                if(ans84_1e.isChecked()){
                    ans84_1code += 16;

                }
                else {
                    ans84_1code -= 16;
                }
            }
        });

        ans84_1f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox ans84_1f = (CheckBox) findViewById(R.id.ans84_1f);
                if(ans84_1f.isChecked()){
                    ans84_1code += 32;
                }
                else {
                    ans84_1code -= 32;
                }
            }
        });

        ans84_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans84_4 = (Spinner) findViewById(R.id.ans84_4);
                Spinner ans84_3 = (Spinner) findViewById(R.id.ans84_3);
                if(ans84_3.getSelectedItemPosition() == 0){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosAmazonas);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 1){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosAntioquia);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 2){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosArauca);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 3){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosAtlantico);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 4){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosBolivar);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 5){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosBoyaca);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 6){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosCaldas);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 7){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosCaqueta);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 8){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosCasanare);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 9){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosCauca);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 10){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosCesar);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 11){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosChoco);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 12){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosCordoba);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 13){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosCundinamarca);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 14){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosGuainia);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 15){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosGuaviare);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 16){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosHuila);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 17){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosGuajira);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 18){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosMagdalena);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 18){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosMeta);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 20){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosNarino);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 21){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosNdeSantander);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 22){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosPutumayo);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 22){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosQuindio);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 23){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosRisaralda);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 24){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosSanAndres);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 25){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosSantander);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 26){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosSucre);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 27){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosTolima);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 28){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosValle);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 29){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosVaupes);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }else if(ans84_3.getSelectedItemPosition() == 30){
                    ArrayAdapter<String> adapterAns84_4 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosVichada);
                    adapterAns84_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans84_4.setAdapter(adapterAns84_4);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans84_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans84_6 = (Spinner) findViewById(R.id.ans84_6);
                EditText ans84_6other = (EditText) findViewById(R.id.ans84_6other);
                if(ans84_6.getSelectedItemPosition()==4) {
                    ans84_6other.setVisibility(View.VISIBLE);
                }else{
                    ans84_6other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans84_8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans84_8 = (Spinner) findViewById(R.id.ans84_8);
                EditText ans84_8other = (EditText) findViewById(R.id.ans84_8other);
                if(ans84_8.getSelectedItemPosition()==3) {
                    ans84_8other.setVisibility(View.VISIBLE);
                }else{
                    ans84_8other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans111.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans111 = (Spinner) findViewById(R.id.ans111);
                TextView ques111_1 = (TextView) findViewById(R.id.ques111_1);
                EditText ans111_1 = (EditText) findViewById(R.id.ans111_1);
                TextView ques111_2 = (TextView) findViewById(R.id.ques111_2);
                Spinner ans111_2 = (Spinner) findViewById(R.id.ans111_2);
                if(ans111.getSelectedItemPosition()==1) {
                    ques111_1.setVisibility(View.GONE);
                    ans111_1.setVisibility(View.GONE);
                    ques111_2.setVisibility(View.GONE);
                    ans111_2.setVisibility(View.GONE);
                }else{
                    ques111_1.setVisibility(View.VISIBLE);
                    ans111_1.setVisibility(View.VISIBLE);
                    ques111_2.setVisibility(View.VISIBLE);
                    ans111_2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans112.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans112 = (Spinner) findViewById(R.id.ans112);
                TextView ques112_1 = (TextView) findViewById(R.id.ques112_1);
                EditText ans112_1 = (EditText) findViewById(R.id.ans112_1);
                TextView ques112_2 = (TextView) findViewById(R.id.ques112_2);
                Spinner ans112_2 = (Spinner) findViewById(R.id.ans112_2);
                if(ans112.getSelectedItemPosition()==1) {
                    ques112_1.setVisibility(View.GONE);
                    ans112_1.setVisibility(View.GONE);
                    ques112_2.setVisibility(View.GONE);
                    ans112_2.setVisibility(View.GONE);
                }else{
                    ques112_1.setVisibility(View.VISIBLE);
                    ans112_1.setVisibility(View.VISIBLE);
                    ques112_2.setVisibility(View.VISIBLE);
                    ans112_2.setVisibility(View.VISIBLE);
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

        ans113.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans113 = (Spinner) findViewById(R.id.ans113);
                TextView ques113_1 = (TextView) findViewById(R.id.ques113_1);
                EditText ans113_1 = (EditText) findViewById(R.id.ans113_1);
                if(ans113.getSelectedItemPosition()==1) {
                    ques113_1.setVisibility(View.GONE);
                    ans113_1.setVisibility(View.GONE);
                }else{
                    ques113_1.setVisibility(View.VISIBLE);
                    ans113_1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans114.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans114 = (Spinner) findViewById(R.id.ans114);
                TextView ques114_1 = (TextView) findViewById(R.id.ques114_1);
                EditText ans114_1 = (EditText) findViewById(R.id.ans114_1);
                if(ans114.getSelectedItemPosition()==1) {
                    ques114_1.setVisibility(View.GONE);
                    ans114_1.setVisibility(View.GONE);
                }else{
                    ques114_1.setVisibility(View.VISIBLE);
                    ans114_1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans116.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans116 = (Spinner) findViewById(R.id.ans116);
                TextView ques116_1 = (TextView) findViewById(R.id.ques116_1);
                EditText ans116_1 = (EditText) findViewById(R.id.ans116_1);
                if(ans116.getSelectedItemPosition()==1) {
                    ques116_1.setVisibility(View.GONE);
                    ans116_1.setVisibility(View.GONE);
                }else{
                    ques116_1.setVisibility(View.VISIBLE);
                    ans116_1.setVisibility(View.VISIBLE);
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

        ans118.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans118 = (Spinner) findViewById(R.id.ans118);
                TextView ques118_1 = (TextView) findViewById(R.id.ques118_1);
                Spinner ans118_1 = (Spinner) findViewById(R.id.ans118_1);
                TextView ques118_2 = (TextView) findViewById(R.id.ques118_2);
                Spinner ans118_2 = (Spinner) findViewById(R.id.ans118_2);
                TextView ques118_3 = (TextView) findViewById(R.id.ques118_3);
                EditText ans118_3 = (EditText) findViewById(R.id.ans118_3);
                TextView ques118_4 = (TextView) findViewById(R.id.ques118_4);
                Spinner ans118_4 = (Spinner) findViewById(R.id.ans118_4);
                TextView ques118_5 = (TextView) findViewById(R.id.ques118_5);
                EditText ans118_5 = (EditText) findViewById(R.id.ans118_5);
                TextView ques118_6 = (TextView) findViewById(R.id.ques118_6);
                EditText ans118_6 = (EditText) findViewById(R.id.ans118_6);
                TextView ques118_7 = (TextView) findViewById(R.id.ques118_7);
                EditText ans118_7 = (EditText) findViewById(R.id.ans118_7);
                TextView ques118_8 = (TextView) findViewById(R.id.ques118_8);
                EditText ans118_8 = (EditText) findViewById(R.id.ans118_8);
                TextView ques118_9 = (TextView) findViewById(R.id.ques118_9);
                EditText ans118_9 = (EditText) findViewById(R.id.ans118_9);
                TextView ques118_10 = (TextView) findViewById(R.id.ques118_10);
                Spinner ans118_10 = (Spinner) findViewById(R.id.ans118_10);
                TextView ques118_11 = (TextView) findViewById(R.id.ques118_11);
                Spinner ans118_11 = (Spinner) findViewById(R.id.ans118_11);
                if(ans118.getSelectedItemPosition()==1) {
                    ques118_1.setVisibility(View.GONE);
                    ans118_1.setVisibility(View.GONE);
                    ques118_2.setVisibility(View.GONE);
                    ans118_2.setVisibility(View.GONE);
                    ques118_3.setVisibility(View.GONE);
                    ans118_3.setVisibility(View.GONE);
                    ques118_4.setVisibility(View.GONE);
                    ans118_4.setVisibility(View.GONE);
                    ques118_5.setVisibility(View.GONE);
                    ans118_5.setVisibility(View.GONE);
                    ques118_6.setVisibility(View.GONE);
                    ans118_6.setVisibility(View.GONE);
                    ques118_7.setVisibility(View.GONE);
                    ans118_7.setVisibility(View.GONE);
                    ques118_8.setVisibility(View.GONE);
                    ans118_8.setVisibility(View.GONE);
                    ques118_9.setVisibility(View.GONE);
                    ans118_9.setVisibility(View.GONE);
                    ques118_10.setVisibility(View.GONE);
                    ans118_10.setVisibility(View.GONE);
                    ques118_11.setVisibility(View.GONE);
                    ans118_11.setVisibility(View.GONE);
                }else{
                    ques118_1.setVisibility(View.VISIBLE);
                    ans118_1.setVisibility(View.VISIBLE);
                    ques118_2.setVisibility(View.VISIBLE);
                    ans118_2.setVisibility(View.VISIBLE);
                    ques118_3.setVisibility(View.VISIBLE);
                    ans118_3.setVisibility(View.VISIBLE);
                    ques118_4.setVisibility(View.VISIBLE);
                    ans118_4.setVisibility(View.VISIBLE);
                    ques118_5.setVisibility(View.VISIBLE);
                    ans118_5.setVisibility(View.VISIBLE);
                    ques118_6.setVisibility(View.VISIBLE);
                    ans118_6.setVisibility(View.VISIBLE);
                    ques118_7.setVisibility(View.VISIBLE);
                    ans118_7.setVisibility(View.VISIBLE);
                    ques118_8.setVisibility(View.VISIBLE);
                    ans118_8.setVisibility(View.VISIBLE);
                    ques118_9.setVisibility(View.VISIBLE);
                    ans118_9.setVisibility(View.VISIBLE);
                    ques118_10.setVisibility(View.VISIBLE);
                    ans118_10.setVisibility(View.VISIBLE);
                    ques118_11.setVisibility(View.VISIBLE);
                    ans118_11.setVisibility(View.VISIBLE);
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

        ans118_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans118_2 = (Spinner) findViewById(R.id.ans118_2);
                TextView ques118_3 = (TextView) findViewById(R.id.ques118_3);
                EditText ans118_3 = (EditText) findViewById(R.id.ans118_3);
                if(ans118_2.getSelectedItemPosition()==2) {
                    ques118_3.setVisibility(View.GONE);
                    ans118_3.setVisibility(View.GONE);
                }else{
                    ques118_3.setVisibility(View.VISIBLE);
                    ans118_3.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans118_10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans118_11 = (Spinner) findViewById(R.id.ans118_11);
                Spinner ans118_10 = (Spinner) findViewById(R.id.ans118_10);
                if(ans118_10.getSelectedItemPosition() == 0){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosAmazonas);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 1){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosAntioquia);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 2){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosArauca);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 3){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosAtlantico);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 4){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosBolivar);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 5){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosBoyaca);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 6){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosCaldas);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 7){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosCaqueta);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 8){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosCasanare);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 9){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosCauca);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 10){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosCesar);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 11){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosChoco);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 12){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosCordoba);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 13){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosCundinamarca);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 14){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosGuainia);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 15){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosGuaviare);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 16){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosHuila);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 17){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosGuajira);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 18){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosMagdalena);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 18){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosMeta);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 20){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosNarino);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 21){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosNdeSantander);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 22){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosPutumayo);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 22){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosQuindio);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 23){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosRisaralda);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 24){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosSanAndres);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 25){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosSantander);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 26){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosSucre);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 27){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosTolima);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 28){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosValle);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 29){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosVaupes);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }else if(ans118_10.getSelectedItemPosition() == 30){
                    ArrayAdapter<String> adapterAns2 = new ArrayAdapter<String>(Preguntas2.this, android.R.layout.simple_spinner_item, municipiosVichada);
                    adapterAns2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    ans118_11.setAdapter(adapterAns2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans120.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans120 = (Spinner) findViewById(R.id.ans120);
                TextView ques120_1 = (TextView) findViewById(R.id.ques120_1);
                EditText ans120_1 = (EditText) findViewById(R.id.ans120_1);
                if(ans120.getSelectedItemPosition()==1) {
                    ques120_1.setVisibility(View.GONE);
                    ans120_1.setVisibility(View.GONE);
                }else{
                    ques120_1.setVisibility(View.VISIBLE);
                    ans120_1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans127.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans127 = (Spinner) findViewById(R.id.ans127);
                TextView ques127_1 = (TextView) findViewById(R.id.ques127_1);
                EditText ans127_1 = (EditText) findViewById(R.id.ans127_1);
                if(ans127.getSelectedItemPosition()==1) {
                    ques127_1.setVisibility(View.GONE);
                    ans127_1.setVisibility(View.GONE);
                }else{
                    ques127_1.setVisibility(View.VISIBLE);
                    ans127_1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans129.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans129 = (Spinner) findViewById(R.id.ans129);
                TextView ques129_1 = (TextView) findViewById(R.id.ques129_1);
                EditText ans129_1 = (EditText) findViewById(R.id.ans129_1);
                if(ans129.getSelectedItemPosition()==1) {
                    ques129_1.setVisibility(View.GONE);
                    ans129_1.setVisibility(View.GONE);
                }else{
                    ques129_1.setVisibility(View.VISIBLE);
                    ans129_1.setVisibility(View.VISIBLE);
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
            EditText ans45 = (EditText) findViewById(R.id.ans45);
            EditText ans46 = (EditText) findViewById(R.id.ans46);
            EditText ans49 = (EditText) findViewById(R.id.ans49);
            EditText ans52_1 = (EditText) findViewById(R.id.ans52_1);
            EditText ans53 = (EditText) findViewById(R.id.ans53);
            EditText ans54_1 = (EditText) findViewById(R.id.ans54_1);
            EditText ans55_1 = (EditText) findViewById(R.id.ans55_1);
            EditText ans55_2 = (EditText) findViewById(R.id.ans55_2);
            EditText ans55_3 = (EditText) findViewById(R.id.ans55_3);
            EditText ans55_4 = (EditText) findViewById(R.id.ans55_4);
            EditText ans55_5 = (EditText) findViewById(R.id.ans55_5);
            EditText ans55_6 = (EditText) findViewById(R.id.ans55_6);
            EditText ans55_7 = (EditText) findViewById(R.id.ans55_7);
            EditText ans56_1 = (EditText) findViewById(R.id.ans56_1);
            EditText ans57_1 = (EditText) findViewById(R.id.ans57_1);
            EditText ans57_2 = (EditText) findViewById(R.id.ans57_2);
            EditText ans60 = (EditText) findViewById(R.id.ans60);
            EditText ans61 = (EditText) findViewById(R.id.ans61);
            EditText ans63 = (EditText) findViewById(R.id.ans63);
            EditText ans64 = (EditText) findViewById(R.id.ans64);
            EditText ans65 = (EditText) findViewById(R.id.ans65);
            EditText ans66 = (EditText) findViewById(R.id.ans66);
            EditText ans67 = (EditText) findViewById(R.id.ans67);
            EditText ans68 = (EditText) findViewById(R.id.ans68);
            EditText ans69 = (EditText) findViewById(R.id.ans69);
            EditText ans69_2 = (EditText) findViewById(R.id.ans69_2);
            EditText ans70_1 = (EditText) findViewById(R.id.ans70_1);
            EditText ans71_1 = (EditText) findViewById(R.id.ans71_1);
            EditText ans71_2 = (EditText) findViewById(R.id.ans71_2);
            EditText ans72 = (EditText) findViewById(R.id.ans72);
            EditText ans73_2 = (EditText) findViewById(R.id.ans73_2);
            EditText ans73_3 = (EditText) findViewById(R.id.ans73_3);
            EditText ans73_4 = (EditText) findViewById(R.id.ans73_4);
            EditText ans73_5 = (EditText) findViewById(R.id.ans73_5);
            EditText ans73_6 = (EditText) findViewById(R.id.ans73_6);
            EditText ans74_1 = (EditText) findViewById(R.id.ans74_1);
            EditText ans82_1 = (EditText) findViewById(R.id.ans82_1);
            EditText ans82_2 = (EditText) findViewById(R.id.ans82_2);
            EditText ans83 = (EditText) findViewById(R.id.ans83);
            EditText ans83_1 = (EditText) findViewById(R.id.ans83_1);
            EditText ans83_2 = (EditText) findViewById(R.id.ans83_2);
            EditText ans84_2 = (EditText) findViewById(R.id.ans84_2);
            EditText ans84_5 = (EditText) findViewById(R.id.ans84_5);
            EditText ans84_7 = (EditText) findViewById(R.id.ans84_7);
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
            EditText ans120_1 = (EditText) findViewById(R.id.ans120_1);
            EditText ans121 = (EditText) findViewById(R.id.ans121);
            EditText ans122 = (EditText) findViewById(R.id.ans122);
            EditText ans122_1 = (EditText) findViewById(R.id.ans122_1);
            EditText ans125 = (EditText) findViewById(R.id.ans125);
            EditText ans127_1 = (EditText) findViewById(R.id.ans127_1);
            EditText ans129_1 = (EditText) findViewById(R.id.ans129_1);
            EditText ans144 = (EditText) findViewById(R.id.ans144);

            Spinner ans42 = (Spinner) findViewById(R.id.ans42);
            Spinner ans52 = (Spinner) findViewById(R.id.ans52);
            Spinner ans54 = (Spinner) findViewById(R.id.ans54);
            Spinner ans55 = (Spinner) findViewById(R.id.ans55);
            Spinner ans56 = (Spinner) findViewById(R.id.ans56);
            Spinner ans57 = (Spinner) findViewById(R.id.ans57);
            Spinner ans59 = (Spinner) findViewById(R.id.ans59);
            Spinner ans69_1 = (Spinner) findViewById(R.id.ans69_1);
            Spinner ans70 = (Spinner) findViewById(R.id.ans70);
            Spinner ans73 = (Spinner) findViewById(R.id.ans73);
            Spinner ans73_1 = (Spinner) findViewById(R.id.ans73_1);
            Spinner ans74 = (Spinner) findViewById(R.id.ans74);
            Spinner ans76_1 = (Spinner) findViewById(R.id.ans76_1);
            Spinner ans77_1 = (Spinner) findViewById(R.id.ans77_1);
            Spinner ans78_1 = (Spinner) findViewById(R.id.ans78_1);
            Spinner ans75 = (Spinner) findViewById(R.id.ans75);
            Spinner ans80 = (Spinner) findViewById(R.id.ans80);
            Spinner ans81 = (Spinner) findViewById(R.id.ans81);
            Spinner ans82_3 = (Spinner) findViewById(R.id.ans82_3);
            Spinner ans84 = (Spinner) findViewById(R.id.ans84);
            Spinner ans84_3 = (Spinner) findViewById(R.id.ans84_3);
            Spinner ans84_4 = (Spinner) findViewById(R.id.ans84_4);
            Spinner ans84_6 = (Spinner) findViewById(R.id.ans84_6);
            Spinner ans84_8 = (Spinner) findViewById(R.id.ans84_8);
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
            Spinner ans118_11 = (Spinner) findViewById(R.id.ans118_11);
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

            EditText ans44other = (EditText) findViewById(R.id.ans44other);
            EditText ans47other = (EditText) findViewById(R.id.ans47other);
            EditText ans48other = (EditText) findViewById(R.id.ans48other);
            EditText ans58other = (EditText) findViewById(R.id.ans58other);
            EditText ans62other = (EditText) findViewById(R.id.ans62other);
            EditText ans71other = (EditText) findViewById(R.id.ans71other);
            EditText ans76other = (EditText) findViewById(R.id.ans76other);
            EditText ans78other = (EditText) findViewById(R.id.ans78other);
            EditText ans79other = (EditText) findViewById(R.id.ans79other);
            EditText ans80other = (EditText) findViewById(R.id.ans80other);
            EditText ans82other = (EditText) findViewById(R.id.ans82other);
            EditText ans84_6other = (EditText) findViewById(R.id.ans84_6other);
            EditText ans84_8other = (EditText) findViewById(R.id.ans84_8other);
            EditText ans112_2other = (EditText) findViewById(R.id.ans112_2other);
            EditText ans117other = (EditText) findViewById(R.id.ans117other);
            EditText ans118_1other = (EditText) findViewById(R.id.ans118_1other);

            CheckBox ans44e = (CheckBox) findViewById(R.id.ans44e);
            CheckBox ans47i = (CheckBox) findViewById(R.id.ans47i);
            CheckBox ans48d = (CheckBox) findViewById(R.id.ans48d);
            CheckBox ans58g = (CheckBox) findViewById(R.id.ans58g);
            CheckBox ans62j = (CheckBox) findViewById(R.id.ans62j);
            CheckBox ans71i = (CheckBox) findViewById(R.id.ans71i);
            CheckBox ans76e = (CheckBox) findViewById(R.id.ans76e);
            CheckBox ans78f = (CheckBox) findViewById(R.id.ans78f);
            CheckBox ans79g = (CheckBox) findViewById(R.id.ans79g);
            CheckBox ans82d = (CheckBox) findViewById(R.id.ans82d);

            FileOutputStream fos = new FileOutputStream(myExternalFile,true);

            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans42.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans43.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans44code).getBytes());
            if(ans44e.isChecked()){
                fos.write(", ".getBytes());
            }
            fos.write(ans44other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans45.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans46.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans47code).getBytes());
            if(ans47i.isChecked()){
                fos.write(", ".getBytes());
            }
            fos.write(ans47other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans48code).getBytes());
            if(ans48d.isChecked()){
                fos.write(", ".getBytes());
            }
            fos.write(ans48other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans49.getText().toString().getBytes());
            fos.write("\t".getBytes());
            // TODO Answer 50 goes here
            // TODO Answer 51 goes here
            fos.write(Integer.toString(ans52.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans52_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans53.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans54.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans54_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans55.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans55_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans55_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans55_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans55_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans55_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans55_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans55_7.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans56.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans56_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans57.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans57_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans57_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans58code).getBytes());
            if(ans58g.isChecked()){
                fos.write(", ".getBytes());
            }
            fos.write(ans58other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans59.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans60.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans61.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans62code).getBytes());
            if(ans62j.isChecked()){
                fos.write(", ".getBytes());
            }
            fos.write(ans62other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans63.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans64.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans65.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans66.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans67.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans68.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans69.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans69_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans69_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans70.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans70_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans71code).getBytes());
            if(ans71i.isChecked()){
                fos.write(", ".getBytes());
            }
            fos.write(ans71other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans71_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans71_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans72.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans73.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans73_1.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans73_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans73_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans73_4.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans73_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans73_6.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans74.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans74_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans75.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans76code).getBytes());
            if(ans76e.isChecked()){
                fos.write(", ".getBytes());
            }
            fos.write(ans76other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans76_1.getSelectedItemPosition()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans77code).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans77_1.getSelectedItemPosition()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans78code).getBytes());
            if(ans78f.isChecked()){
                fos.write(", ".getBytes());
            }
            fos.write(ans78other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans78_1.getSelectedItemPosition()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans79code).getBytes());
            if(ans79g.isChecked()){
                fos.write(", ".getBytes());
            }
            fos.write(ans79other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans80.getSelectedItemPosition()+1).getBytes());
            if(ans80.getSelectedItemPosition()==5) {
                fos.write(", ".getBytes());
            }
            fos.write(ans80other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans81.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans82code).getBytes());
            if(ans82d.isChecked()){
                fos.write(", ".getBytes());
            }
            fos.write(ans82other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans82_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans82_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans82_3.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_1.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans83_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans84.getSelectedItemPosition()+1).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans84_1code).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_2.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_3.getItemAtPosition(ans84_3.getSelectedItemPosition()).toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_4.getItemAtPosition(ans84_4.getSelectedItemPosition()).toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_5.getText().toString().getBytes());
            fos.write("\t".getBytes());
            if(ans84_6.getSelectedItemPosition()==4) {
                fos.write(", ".getBytes());
            }
            fos.write(ans84_6other.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(ans84_7.getText().toString().getBytes());
            fos.write("\t".getBytes());
            if(ans84_8.getSelectedItemPosition()==3) {
                fos.write(", ".getBytes());
            }
            fos.write(ans84_8other.getText().toString().getBytes());
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
            fos.write(Integer.toString(ans118_1.getSelectedItemPosition()).getBytes());
            fos.write((", " + ans118_1other.getText().toString()).getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans118_2.getSelectedItemPosition()).getBytes());
            fos.write("\t".getBytes());
            fos.write(ans118_3.getText().toString().getBytes());
            fos.write("\t".getBytes());
            fos.write(Integer.toString(ans118_4.getSelectedItemPosition()).getBytes());
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
            fos.write(ans118_11.getItemAtPosition(ans118_11.getSelectedItemPosition()).toString().getBytes());
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