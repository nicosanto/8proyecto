package nicosanto.a8proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtNombre;  //Creo variable global vacia
    private EditText edtClave; //(Buena practica de programacion: Coincida nombre con ID)
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  //2 lineas default setea la vista.
        setContentView(R.layout.activity_main);

        //text=(TextView)findViewById(R.id.tv1);
        edtNombre = (EditText) findViewById(R.id.txtNombre);
        edtClave = (EditText) findViewById(R.id.txtClave);
        //R: compila y pone la referencia de todos los que tengo generados.
        //LE PASO DEL CONTROL EL ID: txtNombre

               //Asignar Texto
        //edtNombre.setText("Hola");

        btnAceptar = (Button) findViewById(R.id.btnAceptar);

        //Metodo para gestion del evento click del boton
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarActividad();
            }
        });  //Llamo a la funcion

    }

    private void mostrarActividad(){

        //intent explicito
        Intent intent = new Intent(this, SegundaActivity.class);

        //Le paso la variable global con el dato del control
        intent.putExtra("KEY_NOMBRE", edtNombre.getText().toString() );

        //llamado a activity
        startActivity(intent);

        //MENSAJE PANTALLA
        //  Toast.makeText(this,"El mayor es: "+mayor, Toast.LENGTH_SHORT ).show();
    }

}
