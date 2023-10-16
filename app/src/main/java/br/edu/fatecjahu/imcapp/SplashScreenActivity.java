package br.edu.fatecjahu.imcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {

    // Variável spPRIMEIRA_VEZ com um conteúdo primeiraVez
    // (SharedPreferences serve para gravar uma quantidade mínima de dados).
    private static String spPRIMERA_VEZ = "primeiraVez";

    final int miliseconds = 1000; // tempo de 1 segundo em milisegundos.
    final int seconds = 5; // tempo em segundos.
    int time; // resultado do tempo em segundos.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Chamada ao método executaSplashUmaUnicaVez() diretamente
        // no evento onCreate da classe SplashScreenActivity.
        executaSplashUmaUnicaVez();

    }

    private void executaSplashUmaUnicaVez()
        {

            // Definindo para a variável primeiraVez o valor true
             // informando a váriavel spPRIMEIRA_VEZ (SharedPreferences) que seu valor é true.
            boolean primeiraVez = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext())
                .getBoolean(spPRIMERA_VEZ, true);

            // Se a váriavel primeiraVez é true, executa o bloco abaixo, e define spPRIMEIRA_VEZ como false.
            // Em seguida imprime uma mensagem no Toast, somente uma única vez quando o aplicativo é instalado no dispositivo móvel.
            // A partir da segunda vez que o aplicativo é executado o bloco de instrução if não é processado.
            if (primeiraVez) {
            PreferenceManager
                    .getDefaultSharedPreferences(getApplicationContext())
                    .edit()
                    .putBoolean(spPRIMERA_VEZ, false)
                    .commit();

                // 1º Passo - Chamar a View (activity_splash_screen) e iniciar um tempo em segundos.
                setContentView(R.layout.activity_splash_screen);

                // 2º Passo - Cálculo do tempo de exibição do SplashScreen.
                time = seconds * miliseconds;

                // 3º Passo - Esconder a ActionBar (Barra de Título do Aplicativo).
                getSupportActionBar().hide();

                // 4º Passo - Exibir a tela em Modo FullScreen (Modo Tela Cheia).
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);

                // 5º Passo - Método para Execução da SplashScreen e acionamento para a próxima tela.
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                        startActivity(new Intent(getBaseContext(), MainActivity.class));
                        finish();   // Encerrar a SplashScreenActivity.
                    }
                }, time);

                Toast.makeText(this, "Bem-vindo ao Aplicativo SplashScreen!!!", Toast.LENGTH_SHORT).show();
            }
            else
                { // Se a variável "spPRIMERA_VEZ" foi carregada executa o bloco else.

                    // Criar uma intent para direcionar a classe SplashScreenActivity para MainActivity.
                    Intent goToMainActivity = new Intent(getBaseContext(), MainActivity.class);

                    // Definir que a classe LoginActivity esteja no topo da Pilha de Atividades (Stack Activities),
                    // através da definição da flag da intent chamada  FLAG_ACTIVITY_REORDER_TO_FRONT.
                    // Essa flag da intent reorganiza a classe LoginActivity de tal forma que ela fique no topo
                    // da Pilha de Atividades, no lugar da classe SplashScreenActivity.
                    goToMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                    // Vai para a próxima tela (da SplashScreenActivity para a MainActivity),
                    // e por fim encerra a SplashScreenActivity.
                    startActivity(goToMainActivity);
                    finish();
                }



            }


}