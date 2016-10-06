package ifpb.edu.br.asynctaskjson.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import org.json.JSONException;

import ifpb.edu.br.asynctaskjson.R;
import ifpb.edu.br.asynctaskjson.entities.Pessoa;
import ifpb.edu.br.asynctaskjson.listeners.OnClickCadastrar;
import ifpb.edu.br.asynctaskjson.listeners.OnClickCadastrarPessoa;
import ifpb.edu.br.asynctaskjson.listeners.OnClickListarPessoas;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        Button btnListar    = (Button) findViewById(R.id.btnListar);

        btnCadastrar.setOnClickListener(new OnClickCadastrar(this));
        btnListar.setOnClickListener(new OnClickListarPessoas(this));


    }
}
