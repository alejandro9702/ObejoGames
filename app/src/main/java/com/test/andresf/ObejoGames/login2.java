package com.test.andresf.ObejoGames;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login2 extends Activity {

    Button btn1, btn2, btn3, btn4;
    TextView textomail,textocontra;

    EditText contraseñabt,gamertagbt,Emailbt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.login);
        //Cuadro de una sola opcion
        AlertDialog.Builder mensajeDialogo = new AlertDialog.Builder(this);
        mensajeDialogo.setTitle("Bienvenido");
        mensajeDialogo.setMessage("Si ya posee una cuenta escriba su email y contraseña.\n" +
                "si no llene todos los campos.");
        //Mostramos un bot�n para poder cerrar el di�logo,con el boton OK
        mensajeDialogo.setPositiveButton("OK",null);
        mensajeDialogo.create();
        mensajeDialogo.show();

        //Llamamos al m�todo setPositiveButton indicando el texto a mostrar en el bot�n y
        //la clase an�nima que capturar� el evento clic del bot�n:
       /* cuadroDialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface cuadroDialogo, int id) {
                aceptar();

            }
        });*/
        textocontra= (TextView) findViewById(R.id.textocontraseña);
        textomail= (TextView) findViewById(R.id.textoemail);
        contraseñabt = (EditText)findViewById(R.id.contraseña);
        gamertagbt = (EditText)findViewById(R.id.gamertag);
        Emailbt = (EditText)findViewById(R.id.email_login);

        btn1 = (Button)findViewById(R.id.BTIngrear);
        btn2 = (Button)findViewById(R.id.BTRegistrarse);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultar();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registrar();
            }
        });




    }

    public void aceptar() {
        Toast mensaje=Toast.makeText(this,"Bienvenido", Toast.LENGTH_SHORT);
        mensaje.show();
    }

    public void registrar(){
        textocontra.setText("");
        textomail.setText("");
        SQLite admin = new SQLite(getApplicationContext(),"administracion", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();

        String contraseña = contraseñabt.getText().toString();
        String gamertag = gamertagbt.getText().toString();
        String email = Emailbt.getText().toString();
        Cursor fila_contraseña = database.rawQuery("select contraseña,gamertag,email from personas where contraseña='"+contraseña+"'",null);
        Cursor fila_email = database.rawQuery("select contraseña,gamertag,email from personas where email='"+email+"'",null);

        if (fila_email.moveToFirst()) {
            textomail.setText("ya existe ese email");


        }
     else  if (fila_contraseña.moveToFirst()) {

            textocontra.setText("ya existe esa contraseña");


        } else{


           ContentValues registrar = new ContentValues();
           registrar.put("contraseña", contraseña);
           registrar.put("gamertag", gamertag);
           registrar.put("email", email);
           database.insert("personas", null, registrar);
           database.close();

           contraseñabt.setText("");
           gamertagbt.setText("");
           Emailbt.setText("");
           Toast.makeText(getApplicationContext(), "Se Registraron los datos de la Persona Correctamente",

                   Toast.LENGTH_SHORT).show();

           sesion s= new sesion();

           s.setId(contraseña);

           Intent intent = new Intent(getApplicationContext(),Splash.class);
           startActivity(intent);

       }




    }
    public void consultar() {
        SQLite admin = new SQLite(getApplicationContext(),"administracion", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();
        String contraseña = contraseñabt.getText().toString();
        String email = Emailbt.getText().toString();
        Cursor fila_contra = database.rawQuery("select contraseña,gamertag,email from personas where email='"+email+"'",null);
        Cursor fila_email = database.rawQuery("select contraseña,gamertag,email from personas where contraseña='"+contraseña+"'",null);

        if (fila_contra.moveToFirst()) {
            Toast.makeText(getApplicationContext(),"bienvenido "+contraseña,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(),Splash.class);
            startActivity(intent);

        } else
            Toast.makeText(getApplicationContext(), "No existe una persona con este nombre",
                    Toast.LENGTH_SHORT).show();
        database.close();

    }


}
