package ifpb.edu.br.asynctaskjson.listeners;

import android.content.Intent;
import android.view.View;

import ifpb.edu.br.asynctaskjson.activities.ListarActivity;
import ifpb.edu.br.asynctaskjson.activities.MainActivity;

/**
 * Created by root on 03/10/16.
 */

public class OnClickListarPessoas implements View.OnClickListener {
    MainActivity main;


    public OnClickListarPessoas(MainActivity main) {
        this.main = main;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(main, ListarActivity.class);
        main.startActivity(intent);
    }
}
