package jreti.eti.br.jrpeople;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ResponseActivity extends AppCompatActivity {

    private EditText et_nome;
    private EditText et_idade;
    private EditText et_telefone;
    private EditText et_cpf;
    private EditText et_rg;
    private EditText et_sexo;
    private EditText et_estadocivil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        this.et_nome = (EditText) findViewById(R.id.et_nome);
        this.et_idade = (EditText) findViewById(R.id.et_idade);
        this.et_telefone = (EditText) findViewById(R.id.et_telefone);
        this.et_cpf = (EditText) findViewById(R.id.et_cpf);
        this.et_rg = (EditText) findViewById(R.id.et_rg);
        this.et_sexo = (EditText) findViewById(R.id.et_sexo);
        this.et_estadocivil = (EditText) findViewById(R.id.et_estadocivil);

        this.et_nome.setEnabled(false);
        this.et_idade.setEnabled(false);
        this.et_telefone.setEnabled(false);
        this.et_cpf.setEnabled(false);
        this.et_rg.setEnabled(false);
        this.et_sexo.setEnabled(false);
        this.et_estadocivil.setEnabled(false);

        Intent intent = getIntent();
        Pessoa pessoa = (Pessoa) intent.getSerializableExtra(MainActivity.CONSTPESSOA);

        this.et_nome.setText(pessoa.getNome());
        this.et_idade.setText(pessoa.getIdade());
        this.et_telefone.setText(pessoa.getTelefone());
        this.et_cpf.setText(pessoa.getCpf());
        this.et_rg.setText(pessoa.getRg());
        this.et_sexo.setText(pessoa.getSexo());
        this.et_estadocivil.setText(pessoa.getEstadocivil());
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
