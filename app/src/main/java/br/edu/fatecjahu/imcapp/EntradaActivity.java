package br.edu.fatecjahu.imcapp;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EntradaActivity extends DebugActivity{


    // TextView tLogin;
    // TextView tSenha;
    TextView tpeso, taltura;
    Button btcalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);

        // Atribui ao objeto btLogin do tipo Button e
        // vincula ao botão btnLogin da Activity (tela)
        btcalcular = (Button) findViewById(R.id.btncalcular);

        // Método do botão "Login"
        //  setOnClickListener() => View.OnClickListener() => onClick()
        btcalcular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //log referente  a passagem pelo botao.

                Log.i(TAG, getClassName() + "=> acionamento do botão calcular");
                // Atribui aos objetos tLogin e tSenha seus respectivos
                // vínculos com edtUsuario e edtSenha.
                tpeso = (TextView) findViewById(R.id.edtPeso);
                taltura = (TextView) findViewById(R.id.edtAltura);

                final String PESO = "";   // Constante LOGIN é o nome do usuário.
                final String ALTURA = "";  // Constante SENHA é a senha do usuário.


                // Captura dos textos do peso e da altura
                String peso = tpeso.getText().toString();
                String altura = taltura.getText().toString();

                // validaçao de peso e altura
                Log.i((String) TAG, getClassName() + "testa peso e altura!!!");

                // Validação de peso e altura
                if (PESO.equals(peso) && ALTURA.equals(altura))
                {
                    // log de validacao de peso e altura validado
                    Log.i((String) TAG, getClassName() + " peso e altura validados!!!");

                    // Criar uma intenção de navegar para a próxima tela.
                    Intent intent = new Intent(getContext(), ResultadoActivity.class);

                    // Criar um pacote de dados (Bundle)
                   // Bundle params = new Bundle();
                    // key (chave)  value (valor)
                   // params.putString("nome", "Alex");            //      nome = "Alex";
                   // params.putString("sobrenome", "Batista");    //       sobrenome = "Batista";


                    // Colocar o pacote de dados (params) no objeto intent.
                   // intent.putExtras(params);

                    // Navega para a próxima tela.
                    startActivity(intent);

                    // Mensagem de entrada efetuado com sucesso.
                    alert("Calculo realizado com sucesso!!!");

                } else
                    {
                    // Mensagem de entrada no calcular
                    alert("peso ou altura incorretos!!!");
                }
            }
        });
    }
    @Override
    public void onResume()
    {
        super.onResume();
        tpeso = (TextView) findViewById(R.id.edtPeso) ;
        tpeso.requestFocus(); // aponta o cursor para o campo do login.
    }



    private void alert(String s)
    {
        // A classe Toast mostra um alerta temporário muito comum no Android.
        Toast toast = Toast.makeText(getContext(), s, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();

        // Toast.LENGTH_LONG tem a duração de 3 a 5 segundos da mensagem de TOAST.
        // Toast.LENGTH_SHORT tem a duração de 1 a 3 segundos da mensagem de TOAST.
    }
    private Context getContext()
    {
        return this;
    }
    public void onBackPressed()
    {
        // Instanciação de um objeto alertDialogBuilder (Caixa de Diálogo Personalizada)
        // da classe do tipo AlertDialog.Builder.
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // Configuração de uma Caixa de Diálogo Personalizada.
        alertDialogBuilder.setTitle("Confirmar Saída?");
        alertDialogBuilder.setIcon(R.drawable.ic_exit);
        alertDialogBuilder.setMessage("Você tem certeza que deseja sair ?");
        alertDialogBuilder.setCancelable(false);

        // Configuração do botão Sim da Caixa de Diálogo Personalizada...
        // ...e acionamento do método onClick permitindo a saída do Aplicativo,
        // através do encerramento da Activity.

        // Método do botão Sim
        // setPositiveButton() => DialogInterface.OnClickListener() => onClick()
        alertDialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // Encerra da Activity.
            }
        });

        // Configuração do botão Não da Caixa de Diálogo Personalizada...
        // ...e mostra mensagem de cancelamento de saída do Aplicativo.

        // Método do botão Não
        // setNegativeButton() => DialogInterface.OnClickListener() => onClick()
        alertDialogBuilder.setNegativeButton("Não", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                alert("Você clicou em cancelar!!!");
            }
        });

        // Construção de uma Caixa de Diálogo Personalizada e
        // mostra a Caixa de Diálogo criada para o usuário.
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}

