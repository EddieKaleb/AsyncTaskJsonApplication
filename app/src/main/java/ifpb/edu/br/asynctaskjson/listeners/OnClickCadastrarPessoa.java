package ifpb.edu.br.asynctaskjson.listeners;

import android.content.Intent;
import android.view.View;

import java.util.concurrent.ExecutionException;

import ifpb.edu.br.asynctaskjson.activities.CadastrarActivity;
import ifpb.edu.br.asynctaskjson.activities.MainActivity;
import ifpb.edu.br.asynctaskjson.asynctasks.CadastrarAsyncTask;
import ifpb.edu.br.asynctaskjson.entities.Pessoa;

/**
 * Created by root on 03/10/16.
 */

public class OnClickCadastrarPessoa implements View.OnClickListener{
    CadastrarActivity cadastrarActivity;

    public OnClickCadastrarPessoa(CadastrarActivity cadastrarActivity) {
        this.cadastrarActivity = cadastrarActivity;
    }

    @Override
    public void onClick(View v) {
        Pessoa p = new Pessoa();
        p.setNome(cadastrarActivity.editTxtNome.getText().toString());
        p.setEndereco(cadastrarActivity.editTxtEnd.getText().toString());
        p.setEmail(cadastrarActivity.editTxtEmail.getText().toString());
        p.setCpf(cadastrarActivity.editTxtCpf.getText().toString());

        CadastrarAsyncTask cadastrarAsyncTask = new CadastrarAsyncTask();
        try {
            cadastrarActivity.tvResposta.setText(cadastrarAsyncTask.execute(p).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
