package com.example.example2pm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener { //para llamar a la interfaz onclick se agrega eso, luego alt+enter sobre la linea roja y enter
    //aprenderemos a pedir al usuario daotos poer pantalla
    //derivados de text
    //en un plain text mejor es borrarlo
    //escribir hint y configurar

    // ATRIBUTOS --> VARIABLES

    //ATRIBUTOS QUE REPRESETAN CADA ELEMENTO VISUALQUE SIEÑAN
    //NOTA: ELEMENTO VISUAL QUE VAMOS A USAR

    private TextView txtResultado;
    private Button btninvertir;
    private EditText tbnombre, tbcelular;

    //atributos de clase
    private String nombre;
    private int celular;


    // METODOS --> FUNCIONES
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVista(); //alt + enter para crear funcion
        /*Para configuarra el boton y decirle que este pediente al evento click que se ahaga sobre el boton usamos un metodo del tipo SETTER....
        * y en realidad ustedes quieren configurar un concepto llamado Listener ->algo que esta pendiente a que pase cierto*/

        btninvertir.setOnClickListener(this); //llamamos a esta misma clase y le decimos al listener que todo lo que necesita ejecutar esta en esta clase
        //busca un override que tenga el nombre OnClick

    }
    private void inicializarVista() {
        /*definimos el enlace de las variables o atribitos con sus componentes vvisuales
        * que ha se a diseñadoe n pantalla.
        * Inicializando vistas -> referencia de una view a una variable*/

        txtResultado = findViewById(R.id.txtRESUL);
        btninvertir = findViewById(R.id.btnInvertir);
        tbcelular = findViewById(R.id.tbCelular);
        tbnombre = findViewById(R.id.tbNombre);
    }
    private void obtenerInformacionUsuario() {
        /*para obtener a informacion que el ususario introduce el los campos de texto uts van a obtener
         * esos valores del atributo text que est presente en el diseñador  de ese componenete y paar obtener algo en
         * POO con JAVA se usa su buen amigo GETTER
         * obtener texto de Editext -> .getText*/
        nombre = tbnombre.getText().toString(); //de todo lo enviado de tbNombre solo ineresa el valor
        String celulartext = tbcelular.getText().toString();
        celular = Integer.parseInt(celulartext); //de esta forma es uq eparseamos un string a un int o entero
    }
    private void invertirNumero() {
        //si cel es 12345 invertido tiene que ser 54321
        int resto = 0, invertido = 0;
        while (this.celular > 0){
            resto = this.celular % 10;
            invertido = invertido * 10 + resto;
            this.celular = this.celular / 10;
        }
        txtResultado.setText("Valor invertido: "+invertido);
    }

    @Override
    public void onClick(View view) {
        obtenerInformacionUsuario();
        invertirNumero();
        //listener es mardar una informacion a mi boton
    }
}