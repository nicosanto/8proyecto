package nicosanto.a8proyecto;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    private String nombre="";
    private EditText edtTelefono;
    private Button btnMarcar;
    private Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        //LLamo a la funcion
        darBienvenida();

        // Boton Marcar
        btnMarcar = (Button) findViewById(R.id.btnMarcar);
        btnMarcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(SegundaActivity.this, "boton marcar", Toast.LENGTH_LONG).show(); //Bandera
                //LLamo a la funcion
                marcarLLAMADA();
            }
        });

        //Boton Finalizar
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Finalizar actividad actual
                finish();

                //this.finish(); //Cerrar la aplicacion completa

                //Falta vaciar los controles de la actividad principal ??
            }
        });

    } //fin onCreate


    private void darBienvenida(){
        //Recupero Parametros
        Bundle parametros = getIntent().getExtras();

        nombre ="Bienvenido "+ parametros.getString("KEY_NOMBRE");  //CALLBACK??

        //Referencia controles de UI
        TextView txtNombre = (TextView) findViewById(R.id.txtNombre);

        //Asignacion parametros recuperados a UI
        txtNombre.setText(nombre);
    }

    private void marcarLLAMADA(){

        // Se debe incluir un botón para marcar la llamada, según el numero de teléfono que ingreso el usuario,
        // para lo cual se debe desarrollar un método de usuario a tal efecto y enlazado al evento click del boton.
        //Intent Implicito - CALL_DIAL
        edtTelefono = (EditText) findViewById(R.id.edtTelefono);
        String telefono = edtTelefono.getText().toString();
        Intent itn = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+telefono));
        startActivity(itn);

    }

}
