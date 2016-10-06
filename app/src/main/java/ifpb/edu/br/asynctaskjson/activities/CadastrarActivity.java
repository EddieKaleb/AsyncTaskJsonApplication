package ifpb.edu.br.asynctaskjson.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ifpb.edu.br.asynctaskjson.R;
import ifpb.edu.br.asynctaskjson.listeners.OnClickCadastrarPessoa;

public class CadastrarActivity extends Activity {

    public EditText editTxtNome;
    public EditText editTxtEmail;
    public EditText editTxtCpf;
    public EditText editTxtEnd;
    public Button btnCadastrarPessoa;
    public TextView tvResposta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        editTxtNome = (EditText) findViewById(R.id.editTxtNome);
        editTxtEmail = (EditText) findViewById(R.id.editTxtEmail);
        editTxtCpf = (EditText) findViewById(R.id.editTxtCpf);
        editTxtEnd = (EditText) findViewById(R.id.editTxtEnd);
        btnCadastrarPessoa = (Button) findViewById(R.id.btnCadastrarPessoa);
        tvResposta = (TextView) findViewById(R.id.tvResposta);

        btnCadastrarPessoa.setOnClickListener(new OnClickCadastrarPessoa(this));
    }
}
