package nicosanto.a8proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Creo variable global vacia (Buena practica de programacion: Coincida nombre con ID)
    private EditText edtNombre;
    private EditText edtClave;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  //2 lineas default setea la vista.
        setContentView(R.layout.activity_main);

        //text=(TextView)findViewById(R.id.tv1);
        edtNombre = (EditText) findViewById(R.id.txtNombre);
        edtClave = (EditText) findViewById(R.id.txtClave);
        //R: compila y pone la referencia de todos los que tengo generados.
        //LE PASO DEL CONTROL SU ID

        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        //Metodo para gestion del evento click del boton
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtNombre.getText().toString();
                String clave = edtClave.getText().toString();
                if (nombre.equals("ites") && clave.equals("1234")) {      //XQ NO FUNCIONA "@string/usuarioCorrecto"??
                    //Toast.makeText(MainActivity.this, "Datos Correctos", Toast.LENGTH_SHORT).show(); //Bandera

                    //Llamo a la funcion
                    mostrarActividad();
                }
                else {
                    //Mensaje en pantalla
                    Toast.makeText(MainActivity.this,"Datos Incorrectos de Usuario o Clave",Toast.LENGTH_LONG).show();
                    //Vaciar los Controles
                    edtNombre.setText("");
                    edtClave.setText("");
                }
            }
        });

    }

    private void mostrarActividad(){

        //Intent Explicito
        Intent intent = new Intent(this, SegundaActivity.class);

        //Le paso la variable global con el dato del control
        intent.putExtra("KEY_NOMBRE", edtNombre.getText().toString() );

        //Llamado a activity
        startActivity(intent);
    }

}
