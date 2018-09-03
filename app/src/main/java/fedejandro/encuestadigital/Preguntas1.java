package fedejandro.encuestadigital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Preguntas1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas1);

        String[] departamentos = new String[] {
                "Amazonas","Antioquia","Arauca","Atlántico","Bolívar","Boyacá","Caldas","Caquetá","Casanare","Cauca","Cesar","Chocó","Córdoba","Cundinamarca","Guainía","Guaviare","Huila","La Guajira","Magdalena","Meta","Nariño","Norte de Santander","Putumayo","Quindío","Risaralda","San Andrés y Providencia","Santander","Sucre","Tolima","Valle del Cauca","Vaupés","Vichada"
        };
        String[] tipoDoc = new String[] {
                "Tarjeta de Identidad","Cédula de Ciudadanía","Cédula de Extranjería","Visa de Trabajo"
        };
        String[] gruposEtnicos = new String[] {
                "No Aplica","Afrocolombiano","Indígena","Mestizo","Otro, ¿Cuál?"
        };
        String[] genero = new String[] {
                "Masculino","Femenino","Otro","Prefiero no decirlo"
        };
        String[] tipoPersona = new String[] {
                "Natural","Jurídica"
        };
        String[] sino = new String[] {
                "Sí","No"
        };
        String[] causaDesplazamiento = new String[] {
                "No Aplica","Conflicto Armado","Ambiental","Económica"
        };
        String[] relacionPersonas = new String[] {
                "Cónyuge","Hijo/a","Yerno/Nuera","Nieto/a, Bisnieto/a","Padre o madre del cónyuge","Otro pariente","No emparentado"
        };
        String[] estadoCivil = new String[] {
                "Soltero","Casado","Unión Libre","Separado","Divorciado","Viudo"
        };
        String[] gradoEstudio = new String[] {
                "Ninguno","Básica primaria (1° a 5° grado)","Básica secundaria (6° a 9° grado)","Media (10° a 11° grado)","Técnico","Tecnólogo","Profesional pregrado","Postgrado"
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

        Spinner ans1 = (Spinner) findViewById(R.id.ans1);
        ArrayAdapter<String> adapterAns1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, departamentos);
        adapterAns1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ans1.setAdapter(adapterAns1);

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
    }
}
