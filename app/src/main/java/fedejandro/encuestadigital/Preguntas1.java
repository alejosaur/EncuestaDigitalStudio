package fedejandro.encuestadigital;

import android.content.Intent;
import android.os.Environment;
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
                "Masculino","Femenino"
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
                "Básica primaria (1° a 5° grado)","Básica secundaria (6° a 9° grado)","Media (10° a 11° grado)","Técnico","Tecnólogo","Profesional pregrado","Postgrado","Ninguno"
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
                "No Aplica","Empleador","Trabaja por cuenta propia","Trabajador familiar no retribuído","Socio de cooperativa de productores","Otro, ¿cuál?"
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
                "No Aplica","Banco comercial","Sociedad o cooperativas de crédito","Prestamista","Proveedores de insumos","Familiares o amigos","Gobierno","Otro, ¿cuál?"
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

        EditText ans9Other = (EditText) findViewById(R.id.ans9Other);
        ans9Other.setVisibility(View.GONE);
        EditText ans21_1Other = (EditText) findViewById(R.id.ans21_1Other);
        ans21_1Other.setVisibility(View.GONE);
        EditText ans23Other = (EditText) findViewById(R.id.ans23Other);
        ans23Other.setVisibility(View.GONE);
        EditText ans24Other = (EditText) findViewById(R.id.ans24Other);
        ans24Other.setVisibility(View.GONE);
        EditText ans25Other = (EditText) findViewById(R.id.ans25Other);
        ans25Other.setVisibility(View.GONE);
        EditText ans26Other = (EditText) findViewById(R.id.ans26Other);
        ans26Other.setVisibility(View.GONE);
        EditText ans27Other = (EditText) findViewById(R.id.ans27Other);
        ans27Other.setVisibility(View.GONE);
        EditText ans34Other = (EditText) findViewById(R.id.ans34Other);
        ans34Other.setVisibility(View.GONE);
        EditText ans40_1Other = (EditText) findViewById(R.id.ans40_1Other);
        ans40_1Other.setVisibility(View.GONE);
        EditText ans41_1Other = (EditText) findViewById(R.id.ans41_1Other);
        ans41_1Other.setVisibility(View.GONE);
        EditText ans42_1Other = (EditText) findViewById(R.id.ans42_1Other);
        ans42_1Other.setVisibility(View.GONE);
        EditText ans42_2Other = (EditText) findViewById(R.id.ans42_2Other);
        ans42_2Other.setVisibility(View.GONE);
        CheckBox tieneOtro = (CheckBox) findViewById(R.id.tieneOtro);
        CheckBox formacionOtros = (CheckBox) findViewById(R.id.formacionOtros);

        ans9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans9 = (Spinner) findViewById(R.id.ans9);
                EditText ans9Other = (EditText) findViewById(R.id.ans9Other);
                if(ans9.getSelectedItemPosition()==4) {
                    ans9Other.setVisibility(View.VISIBLE);
                }else{
                    ans9Other.setVisibility(View.GONE);
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
                EditText ans21_1Other = (EditText) findViewById(R.id.ans21_1Other);
                if(ans21_1.getSelectedItemPosition()==5) {
                    ans21_1Other.setVisibility(View.VISIBLE);
                }else{
                    ans21_1Other.setVisibility(View.GONE);
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
                EditText ans23Other = (EditText) findViewById(R.id.ans23Other);
                if(ans23.getSelectedItemPosition()==4) {
                    ans23Other.setVisibility(View.VISIBLE);
                }else{
                    ans23Other.setVisibility(View.GONE);
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
                EditText ans24Other = (EditText) findViewById(R.id.ans24Other);
                if(ans24.getSelectedItemPosition()==5) {
                    ans24Other.setVisibility(View.VISIBLE);
                }else{
                    ans24Other.setVisibility(View.GONE);
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
                EditText ans25Other = (EditText) findViewById(R.id.ans25Other);
                if(ans25.getSelectedItemPosition()==4) {
                    ans25Other.setVisibility(View.VISIBLE);
                }else{
                    ans25Other.setVisibility(View.GONE);
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
                EditText ans26Other = (EditText) findViewById(R.id.ans26Other);
                if(ans26.getSelectedItemPosition()==4) {
                    ans26Other.setVisibility(View.VISIBLE);
                }else{
                    ans26Other.setVisibility(View.GONE);
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
                EditText ans27Other = (EditText) findViewById(R.id.ans27Other);
                if(tieneOtro.isChecked()){
                    ans27Other.setVisibility(View.VISIBLE);
                }
                else {
                    ans27Other.setVisibility(View.VISIBLE);
                }
            }
        });

        ans34.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans34 = (Spinner) findViewById(R.id.ans34);
                EditText ans34Other = (EditText) findViewById(R.id.ans34Other);
                if(ans34.getSelectedItemPosition()==4) {
                    ans34Other.setVisibility(View.VISIBLE);
                }else{
                    ans34Other.setVisibility(View.GONE);
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
                EditText ans40_1Other = (EditText) findViewById(R.id.ans40_1Other);
                if(ans40_1.getSelectedItemPosition()==7) {
                    ans40_1Other.setVisibility(View.VISIBLE);
                }else{
                    ans40_1Other.setVisibility(View.GONE);
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
                EditText ans41_1Other = (EditText) findViewById(R.id.ans41_1Other);
                if(ans41_1.getSelectedItemPosition()==4) {
                    ans41_1Other.setVisibility(View.VISIBLE);
                }else{
                    ans41_1Other.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ans42_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner ans42_1 = (Spinner) findViewById(R.id.ans42_1);
                EditText ans42_1Other = (EditText) findViewById(R.id.ans42_1Other);
                if(ans42_1.getSelectedItemPosition()==4) {
                    ans42_1Other.setVisibility(View.VISIBLE);
                }else{
                    ans42_1Other.setVisibility(View.GONE);
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
                EditText ans42_2Other = (EditText) findViewById(R.id.ans42_2Other);
                if(formacionOtros.isChecked()){
                    ans42_2Other.setVisibility(View.VISIBLE);
                }
                else {
                    ans42_2Other.setVisibility(View.VISIBLE);
                }
            }
        });

        nextButtonEUPAC =  (Button) findViewById(R.id.nextButtonEUPAC);
        nextButtonEUPAC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {

                    EditText ans2 = (EditText) findViewById(R.id.ans2);
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
                    EditText ans9Other = (EditText) findViewById(R.id.ans9Other);
                    EditText ans21_1Other = (EditText) findViewById(R.id.ans21_1Other);
                    EditText ans23Other = (EditText) findViewById(R.id.ans23Other);
                    EditText ans24Other = (EditText) findViewById(R.id.ans24Other);
                    EditText ans25Other = (EditText) findViewById(R.id.ans25Other);
                    EditText ans26Other = (EditText) findViewById(R.id.ans26Other);
                    EditText ans27Other = (EditText) findViewById(R.id.ans27Other);
                    EditText ans34Other = (EditText) findViewById(R.id.ans34Other);
                    EditText ans40_1Other = (EditText) findViewById(R.id.ans40_1Other);
                    EditText ans41_1Other = (EditText) findViewById(R.id.ans41_1Other);
                    EditText ans42_1Other = (EditText) findViewById(R.id.ans42_1Other);
                    EditText ans42_2Other = (EditText) findViewById(R.id.ans42_2Other);

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
                    fos.write(ans1.getItemAtPosition(ans1.getSelectedItemPosition()).toString().getBytes());
                    fos.write("\t".getBytes());
                    fos.write(ans2.getText().toString().getBytes());
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
                    fos.write(("," + ans9Other.getText().toString()).getBytes());
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
                    fos.write(("," + ans21_1Other.getText().toString()).getBytes());
                    fos.write("\t".getBytes());
                    fos.write(Integer.toString(ans22.getSelectedItemPosition()+1).getBytes());
                    fos.write("\t".getBytes());
                    fos.write(Integer.toString(ans23.getSelectedItemPosition()+1).getBytes());
                    fos.write(("," + ans23Other.getText().toString()).getBytes());
                    fos.write("\t".getBytes());
                    fos.write(Integer.toString(ans24.getSelectedItemPosition()+1).getBytes());
                    fos.write(("," + ans24Other.getText().toString()).getBytes());
                    fos.write("\t".getBytes());
                    fos.write(Integer.toString(ans25.getSelectedItemPosition()+1).getBytes());
                    fos.write(("," + ans25Other.getText().toString()).getBytes());
                    fos.write("\t".getBytes());
                    fos.write(Integer.toString(ans26.getSelectedItemPosition()+1).getBytes());
                    fos.write(("," + ans26Other.getText().toString()).getBytes());
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
                    fos.write(("," + ans27Other.getText().toString()).getBytes());
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
                    fos.write(("," + ans34Other.getText().toString()).getBytes());
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
                    fos.write(("," + ans40_1Other.getText().toString()).getBytes());
                    fos.write("\t".getBytes());
                    fos.write(ans40_2.getText().toString().getBytes());
                    fos.write("\t".getBytes());
                    fos.write(Integer.toString(ans41.getSelectedItemPosition()+1).getBytes());
                    fos.write("\t".getBytes());
                    fos.write(Integer.toString(ans41_1.getSelectedItemPosition()).getBytes());
                    fos.write(("," + ans41_1Other.getText().toString()).getBytes());
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
                    fos.write("\t".getBytes());
                    fos.write(("," + ans42_1Other.getText().toString()).getBytes());
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
                    fos.write(("," + ans42_2Other.getText().toString()).getBytes());
                    fos.write("\t".getBytes());
                    fos.write(Integer.toString(ans42_3.getSelectedItemPosition()+1).getBytes());
                    fos.write("\t".getBytes());
                    fos.write(Integer.toString(ans42_4.getSelectedItemPosition()).getBytes());


                    Intent preg2 = new Intent(getApplicationContext(), Preguntas2.class);
                    startActivity(preg2);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

	nextButtonUPPA =  (Button) findViewById(R.id.nextButtonUPPA);
        nextButtonUPPA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //try {
                Intent preg3 = new Intent(getApplicationContext(), Preguntas3.class);
                startActivity(preg3);

                /*} catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
        });

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            nextButton.setEnabled(false);
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

}
