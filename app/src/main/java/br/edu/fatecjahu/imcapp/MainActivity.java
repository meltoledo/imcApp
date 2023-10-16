package br.edu.fatecjahu.imcapp;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends DebugActivity {


    // TextView tLogin;
    // TextView tSenha;
    TextView tLogin, tSenha;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Atribui ao objeto btLogin do tipo Button e
        // vincula ao botão btnLogin da Activity (tela)
        btLogin = (Button) findViewById(R.id.btnLogin);

        // Método do botão "Login"
        //  setOnClickListener() => View.OnClickListener() => onClick()
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //log referente  a passagem pelo botao.

                Log.i(TAG, getClassName() + "=> acionamento do botão Login");
                // Atribui aos objetos tLogin e tSenha seus respectivos
                // vínculos com edtUsuario e edtSenha.
                tLogin = (TextView) findViewById(R.id.edtUsuario);
                tSenha = (TextView) findViewById(R.id.edtSenha);

                final String LOGIN = "alex";   // Constante LOGIN é o nome do usuário.
                final String SENHA = "12345";  // Constante SENHA é a senha do usuário.

                // Captura dos textos do login e da senha.
                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();

                // validaçao de usuario e senha.
                Log.i((String) TAG, getClassName() + "testa usuario e senha!!!");

                // Validação de usuário e senha.
                if (LOGIN.equals(login) && SENHA.equals(senha)) {
                    // log de validacao e senha validado
                    Log.i((String) TAG, getClassName() + " usuario e senha validados!!!");

                    // Criar uma intenção de navegar para a próxima tela.
                    Intent intent = new Intent(getContext(), BemVindoActivity.class);

                    // Criar um pacote de dados (Bundle)
                    Bundle params = new Bundle();
                    // key (chave)  value (valor)
                    params.putString("nome", "Alex");            //      nome = "Alex";
                   params.putString("sobrenome", "Batista");    //       sobrenome = "Batista";
                    params.putString("acesso", login);         //        acesso = login;

                    // Colocar o pacote de dados (params) no objeto intent.
                    intent.putExtras(params);

                    // Navega para a próxima tela.
                    startActivity(intent);

                    // Mensagem de login efetuado com sucesso.
                    alert("Bem-vindo, login realizado com sucesso!!!");

                } else {
                    // Mensagem de falha no login.
                    alert("Login ou senha incorretos!!!");
                }
            }
        });
    }
    @Override
    public void onResume()
    {
        super.onResume();
        tLogin = (TextView) findViewById(R.id.edtUsuario) ;
        tLogin.requestFocus(); // aponta o cursor para o campo do login.
    }



    private void alert(String s) {
        // A classe Toast mostra um alerta temporário muito comum no Android.
        Toast toast = Toast.makeText(getContext(), s, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();

        // Toast.LENGTH_LONG tem a duração de 3 a 5 segundos da mensagem de TOAST.
        // Toast.LENGTH_SHORT tem a duração de 1 a 3 segundos da mensagem de TOAST.
    }

    // private MainActivity getContext() {
    private Context getContext() {

        return this;
    }

    public void onBackPressed() {
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
        alertDialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // Encerra da Activity.
            }
        });

        // Configuração do botão Não da Caixa de Diálogo Personalizada...
        // ...e mostra mensagem de cancelamento de saída do Aplicativo.

        // Método do botão Não
        // setNegativeButton() => DialogInterface.OnClickListener() => onClick()
        alertDialogBuilder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert("Você clicou em cancelar!!!");
            }
        });

        // Construção de uma Caixa de Diálogo Personalizada e
        // mostra a Caixa de Diálogo criada para o usuário.
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}

/*

 * */