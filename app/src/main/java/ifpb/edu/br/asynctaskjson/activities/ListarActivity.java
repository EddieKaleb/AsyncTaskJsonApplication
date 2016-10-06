package ifpb.edu.br.asynctaskjson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.asynctaskjson.R;
import ifpb.edu.br.asynctaskjson.asynctasks.ListarAsyncTask;
import ifpb.edu.br.asynctaskjson.entities.Pessoa;

public class ListarActivity extends AppCompatActivity {
    ListView lvPessoas;
    List<Pessoa> pessoas;
    ArrayAdapter<Pessoa> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        lvPessoas = (ListView) findViewById(R.id.lvPessoas);

        ListarAsyncTask listarAsyncTask = new ListarAsyncTask();

        try {
            pessoas = listarAsyncTask.execute("http://ladoss.info:8773/Convite_SERVICE/convidado/listar").get();
            adapter = new ArrayAdapter<Pessoa>(this, android.R.layout.simple_list_item_1, pessoas);
            lvPessoas.setAdapter(adapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
