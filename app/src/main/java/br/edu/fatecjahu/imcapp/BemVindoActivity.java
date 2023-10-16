package br.edu.fatecjahu.imcapp;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class BemVindoActivity extends DebugActivity {

    TextView tSaudacao;
     Button btIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);


        // Recebe o pacote vindo da intent de MainActivity.
        Bundle args = getIntent().getExtras();

        // Recebe o nome e sobrenome enviado por parâmetro.         // key (chave)   value (valor)
        String nome = args.getString("nome");                  //   nome = "Alex ";
        String sobrenome = args.getString("sobrenome");       //    nome = " Batista";

        String login = args.getString("acesso");
        setTitle("Bem-Vindo: " + login);


        tSaudacao = (TextView) findViewById(R.id.tvSaudacao);
        tSaudacao.setLines(2); // Define duas linhas dentro do objeto text1.
        tSaudacao.setText("Olá " + nome + sobrenome + ",\n seja Bem-Vindo!!!"); // Quebra em duas linhas o conteúdo
        // dessa mensagem com uso do \n.

        btIniciar = (Button) findViewById(R.id.btncalcular);
        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getBaseContext(),EntradaActivity.class));
                finish();   // Encerrar a BemvindoActivity.

            }
        });

    }}
