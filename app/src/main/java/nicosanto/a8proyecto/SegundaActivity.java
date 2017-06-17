package nicosanto.a8proyecto;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
            }
        });

    } //fin onCreate


    private void darBienvenida(){
        //Recupero Parametros
        Bundle parametros = getIntent().getExtras();

        nombre ="Bienvenido "+ parametros.getString("KEY_NOMBRE");

        //Referencia controles de UI
        TextView txtNombre = (TextView) findViewById(R.id.txtNombre);

        //Asignacion parametros recuperados a UI
        txtNombre.setText(nombre);
    }

    private void marcarLLAMADA(){

        edtTelefono = (EditText) findViewById(R.id.edtTelefono);
        String telefono = edtTelefono.getText().toString();
        //***INTENT IMPLICITO*** (Le pones la accion generica)
        //Marcar una LLamada                        Uri:tipo de contenido
        Intent itn = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+telefono));
        //ACTION_DIAL: Abre el dialogo para llamar | ACTION_CALL: Dispara la llamada
        startActivity(itn);
    }

    //Enviar MSJ: Abre el dialogo de msj para que le des enviar (LLama a un componente externo)
    public void componerSMS (String mensaje, String num_telefono){

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:"+num_telefono));
        intent.putExtra("sms_body:",mensaje);   //mensaje contenido del mensaje
        startActivity(intent);
    }

    //Enviar E-MAIL
    public void componerEmail (String email, String mensaje, String asunto){

        Intent intent = new Intent (Intent.ACTION_SEND); //action que voy a realizar.
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        intent.putExtra(Intent.EXTRA_TEXT, mensaje);
        startActivity(intent);
    }

}
