package ifpb.edu.br.asynctaskjson.listeners;

import android.content.Intent;
import android.view.View;

import ifpb.edu.br.asynctaskjson.activities.CadastrarActivity;
import ifpb.edu.br.asynctaskjson.activities.MainActivity;
import ifpb.edu.br.asynctaskjson.asynctasks.CadastrarAsyncTask;
import ifpb.edu.br.asynctaskjson.entities.Pessoa;

/**
 * Created by root on 03/10/16.
 */

public class OnClickCadastrar implements View.OnClickListener{
    MainActivity main;

    public OnClickCadastrar(MainActivity main){
        this.main = main;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(main, CadastrarActivity.class);
        main.startActivity(intent);

    }
}
