package com.test.andresf.ObejoGames;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonaFr extends Fragment {

    Button btn1, btn2, btn3, btn4;
    EditText Nombre,Telefono,Email;
    TextView correo,gametarg ;
    private static final String ARG_SECTION_NUMBER_2 = "section_number_2";

    // Regresa una nueva instancia de este Fragment

    public static PersonaFr newInstance(int sectionNumber) {

        PersonaFr fragment = new PersonaFr();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER_2, sectionNumber);
        fragment.setArguments(args);

        return fragment;



    }

    public PersonaFr() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_persona, container, false);
        Nombre = (EditText) rootView.findViewById(R.id.nombre);
        Telefono = (EditText) rootView.findViewById(R.id.telefono);
        Email = (EditText) rootView.findViewById(R.id.email);

        btn1 = (Button)rootView.findViewById(R.id.button1);
        btn2 = (Button)rootView.findViewById(R.id.Button01);
        btn3 = (Button) rootView.findViewById(R.id.Button02);
        btn4 = (Button) rootView.findViewById(R.id.Button03);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultar();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modificar();
            }
        });

        View rootView2 = inflater.inflate(R.layout.nav_header_main, container, false);
         correo =(TextView)rootView2.findViewById(R.id.txtcorreo);
        gametarg=(TextView)rootView2.findViewById(R.id.gametagname);


        return rootView;
    }

    public void guardar(){
        SQLite admin = new SQLite(getActivity(),"administracion", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();
        String nombre = Nombre.getText().toString();
        String telefono = Telefono.getText().toString();
        String email = Email.getText().toString();
        ContentValues registrar = new ContentValues();
        registrar.put("nombre", nombre);
        registrar.put("telefono", telefono);
        registrar.put("email", email);
        database.insert("personas", null, registrar);
        correo.setText("mariquita");
        //gametarg.setText(nombre);
        database.close();

        Nombre.setText("");
        Telefono.setText("");
        Email.setText("");
        Toast.makeText(getActivity(), "Se Registraron los datos de la Persona Correctamente",

                Toast.LENGTH_SHORT).show();

    }
    public void consultar() {


        SQLite admin = new SQLite(getActivity(),"administracion", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();
        String nombre = Nombre.getText().toString();
        Cursor fila = database.rawQuery("select nombre,telefono,email from personas where nombre='"+nombre+"'",null);
        if (fila.moveToFirst()) {
            Nombre.setText(fila.getString(0));
            Telefono.setText(fila.getString(1));
            Email.setText(fila.getString(2));
            String email=Email.getText().toString();
            Toast.makeText(getActivity(), "Bienvenido "+nombre,

                    Toast.LENGTH_SHORT).show();

          correo.setText(email);




        } else
            Toast.makeText(getActivity(), "No existe una persona con este nombre",
                    Toast.LENGTH_SHORT).show();
        database.close();



    }



        public void eliminar () {
            SQLite admin = new SQLite(getActivity(), "administracion", null, 1);
            SQLiteDatabase database = admin.getWritableDatabase();
            String nombre = Nombre.getText().toString();
            int eliminar = database.delete("personas", "nombre='" + nombre + "'", null);
            database.close();
            Nombre.setText("");
            Telefono.setText("");
            Email.setText("");
            if (eliminar == 1)
                Toast.makeText(getActivity(), "Se Elimino la persona Correctamente",
                        Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getActivity(), "No existe una persona con dicho Nombre",
                        Toast.LENGTH_SHORT).show();
        }

        public void modificar () {
            SQLite admin = new SQLite(getActivity(), "administracion", null, 1);
            SQLiteDatabase database = admin.getWritableDatabase();
            String nombre = Nombre.getText().toString();
            String telefono = Telefono.getText().toString();
            String email = Email.getText().toString();
            ContentValues modificar = new ContentValues();
            modificar.put("nombre", nombre);
            modificar.put("telefono", telefono);
            modificar.put("email", email);
            int actualizar = database.update("personas", modificar, "nombre='" + nombre + "'", null);
            database.close();
            Nombre.setText("");
            Telefono.setText("");
            Email.setText("");
            if (actualizar == 1)
                Toast.makeText(getActivity(), "Se modificaron los datos de la persona", Toast.LENGTH_SHORT)
                        .show();
            else
                Toast.makeText(getActivity(), "No existe una persona con este nombre",
                        Toast.LENGTH_SHORT).show();
        }

        }

