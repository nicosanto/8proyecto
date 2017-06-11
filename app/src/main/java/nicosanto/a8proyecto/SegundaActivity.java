package nicosanto.a8proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private String nombre="Hola";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        //recupero parametros
        Bundle parametros = getIntent().getExtras();

        nombre ="Bienvenido "+ parametros.getString("KEY_NOMBRE");


        //referencia controles de UI
        TextView txtNombre = (TextView) findViewById(R.id.txtNombre);

        //asignacion parametros recuperados a UI
        txtNombre.setText(nombre);

    }
}
