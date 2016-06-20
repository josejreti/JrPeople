package jreti.eti.br.jrpeople;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static final String CONSTPESSOA = "pessoa";
    public static final String CONSTNOME = "name";
    public static final String CONSTIDADE = "age";
    public static final String CONSTTELEFONE = "phone";
    public static final String CONSTCPF = "cic";
    public static final String CONSTRG = "id";
    public static final String CONSTSEXO = "gender";
    public static final String CONSTESTADOCIVIL = "maritalstatus";

    private EditText et_nome;
    private EditText et_idade;
    private EditText et_telefone;
    private EditText et_cpf;
    private EditText et_rg;
    private RadioButton rb_sexo_masculino;
    private RadioButton rb_sexo_feminino;
    private RadioButton rb_estadocivil_solteiro;
    private RadioButton rb_estadocivil_casado;
    private RadioButton rb_estadocivil_divorciado;
    private RadioButton rb_estadocivil_viuvo;
    private RadioButton rb_estadocivil_separado;
    private RadioButton rb_estadocivil_companheiro;

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
        this.rb_estadocivil_solteiro = (RadioButton) findViewById(R.id.rb_solteiro);
        this.rb_estadocivil_casado = (RadioButton) findViewById(R.id.rb_casado);
        this.rb_estadocivil_divorciado = (RadioButton) findViewById(R.id.rb_divorciado);
        this.rb_estadocivil_viuvo = (RadioButton) findViewById(R.id.rb_viuvo);
        this.rb_estadocivil_separado = (RadioButton) findViewById(R.id.rb_separado);
        this.rb_estadocivil_companheiro = (RadioButton) findViewById(R.id.rb_companheiro);


    }

    public void onClick(View v) {
        if (this.validar()) {
            String nome = this.et_nome.getText().toString();
            String idade = this.et_idade.getText().toString();
            String telefone = this.et_telefone.getText().toString();
            String cpf = this.et_cpf.getText().toString();
            String rg = this.et_rg.getText().toString();
            String sexo = "Masculino";
            if (this.rb_sexo_feminino.isChecked()) sexo = "Feminino";
            String estadocivil = "Solteiro(a)";
            if (this.rb_estadocivil_casado.isChecked()) estadocivil = "Casado(a)";
            if (this.rb_estadocivil_divorciado.isChecked()) estadocivil = "Divorciado(a)";
            if (this.rb_estadocivil_viuvo.isChecked()) estadocivil = "Viúvo(a)";
            if (this.rb_estadocivil_separado.isChecked()) estadocivil = "Separado(a)";
            if (this.rb_estadocivil_companheiro.isChecked()) estadocivil = "Companheiro(a)";


            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);
            pessoa.setIdade(idade);
            pessoa.setTelefone(telefone);
            pessoa.setCpf(cpf);
            pessoa.setRg(rg);
            pessoa.setSexo(sexo);
            pessoa.setEstadocivil(estadocivil);

            if(this.gravarPessoa(pessoa)){
                Intent intent = new Intent(this, ResponseActivity.class);
                //     intent.putExtra(MainActivity.CONSTPESSOA, pessoa);
                startActivity(intent);
            }else {
                Context context = getApplicationContext();
                Toast.makeText(context, "Erro ao gravar a pessoa!", Toast.LENGTH_LONG).show();
            }

        } else {
            Context context = getApplicationContext();
            Toast.makeText(context, "Você deve preencher todos os campos!", Toast.LENGTH_LONG).show();
        }

    }

    public boolean gravarPessoa(Pessoa pessoa) {
        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences(MainActivity.CONSTPESSOA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(MainActivity.CONSTNOME, pessoa.getNome());
        editor.putString(MainActivity.CONSTIDADE, pessoa.getIdade());
        editor.putString(MainActivity.CONSTTELEFONE, pessoa.getTelefone());
        editor.putString(MainActivity.CONSTCPF, pessoa.getCpf());
        editor.putString(MainActivity.CONSTRG, pessoa.getRg());
        editor.putString(MainActivity.CONSTSEXO, pessoa.getSexo());
        editor.putString(MainActivity.CONSTESTADOCIVIL, pessoa.getEstadocivil());
        return editor.commit();
    }

    public void onClear(View v) {
        this.et_nome.setText("");
        this.et_idade.setText("");
        this.et_telefone.setText("");
        this.et_cpf.setText("");
        this.et_rg.setText("");
        this.rb_sexo_masculino.setChecked(true);
        this.rb_estadocivil_solteiro.setChecked(true);
        this.et_nome.setFocusable(true);
    }

    public boolean validar() {
        String nome = this.et_nome.getText().toString();
        if (nome.equals("")) return false;
        String idade = this.et_idade.getText().toString();
        if (idade.equals("")) return false;
        String telefone = this.et_telefone.getText().toString();
        if (telefone.equals("")) return false;
        String cpf = this.et_cpf.getText().toString();
        if (cpf.equals("")) return false;
        String rg = this.et_rg.getText().toString();
        if (rg.equals("")) return false;
        return true;
    }
}
