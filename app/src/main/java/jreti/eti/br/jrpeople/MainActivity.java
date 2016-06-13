package jreti.eti.br.jrpeople;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {


    public static final String CONSTPESSOA = "pessoa";

    private EditText et_nome;
    private EditText et_idade;
    private EditText et_telefone;
    private EditText et_cpf;
    private EditText et_rg;
    private RadioButton rb_sexo_masculino;
    private RadioButton rb_sexo_feminino;
    private EditText et_estadocivil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.et_nome = (EditText) findViewById(R.id.et_nome);
        this.et_idade = (EditText) findViewById(R.id.et_idade);
        this.et_telefone = (EditText) findViewById(R.id.et_telefone);
        this.et_cpf = (EditText) findViewById(R.id.et_cpf);
        this.et_rg = (EditText) findViewById(R.id.et_rg);
        this.rb_sexo_masculino = (RadioButton) findViewById(R.id.rb_masculino);
        this.rb_sexo_feminino = (RadioButton) findViewById(R.id.rb_feminino);
        this.et_estadocivil = (EditText) findViewById(R.id.et_estadocivil);


    }

    public void onClick(View v) {
        String nome = this.et_nome.getText().toString();
        String idade = this.et_idade.getText().toString();
        String telefone = this.et_telefone.getText().toString();
        String cpf = this.et_cpf.getText().toString();
        String rg = this.et_rg.getText().toString();
        String sexo = "Masculino";
        if (this.rb_sexo_feminino.isChecked()) sexo = "Feminino";
        String estadocivil = this.et_estadocivil.getText().toString();


        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setIdade(idade);
        pessoa.setTelefone(telefone);
        pessoa.setCpf(cpf);
        pessoa.setRg(rg);
        pessoa.setSexo(sexo);
        pessoa.setEstadocivil(estadocivil);


        Intent intent = new Intent(this, ResponseActivity.class);
        intent.putExtra(MainActivity.CONSTPESSOA, pessoa);
        startActivity(intent);

    }
}
