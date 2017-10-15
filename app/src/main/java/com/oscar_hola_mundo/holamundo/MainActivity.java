package com.oscar_hola_mundo.holamundo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private EditText txtNombre,txtEdad, txtEmail;
    private Button btnSaludar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre=(EditText)findViewById(R.id.txtNombre);
        txtEdad=(EditText)findViewById(R.id.txtEdad);
        txtEmail=(EditText)findViewById(R.id.txtEmail);

        btnSaludar=(Button)findViewById(R.id.btnSaludar);
        btnSaludar.setOnClickListener(this);

    }
    private  void saludame(){
        String nombre= txtNombre.getText().toString();
        String email=txtEmail.getText().toString();
        String edad= txtEdad.getText().toString();

        if(nombre.isEmpty()){
            txtNombre.setError("Por favor ingresa tu nombre");
            txtNombre.requestFocus();
        }

        else if(email.isEmpty()){
            txtEmail.setError("Por favor ingresa tu email");
            txtEmail.requestFocus();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            txtEmail.setError("El email no es válido");
            txtEdad.requestFocus();
        }
        else if(edad.isEmpty()){
            txtEdad.setError("Ingresa tu edad");
            txtEdad.requestFocus();
        }
        else if(Integer.parseInt(edad)<=0){
            txtEdad.setError("La edad no puede ser negativa");
            txtEdad.requestFocus();
        }
        else  if(Integer.parseInt(edad)>100){
            txtEdad.setError("Eres demasiado grande");
            txtEdad.requestFocus();

        }


        else{
            Toast.makeText(this,"Hola "+nombre,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSaludar:
                saludame();
                break;
        }
    }
}
