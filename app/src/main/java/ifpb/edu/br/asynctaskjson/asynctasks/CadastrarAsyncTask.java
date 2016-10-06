package ifpb.edu.br.asynctaskjson.asynctasks;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

import ifpb.edu.br.asynctaskjson.activities.CadastrarActivity;
import ifpb.edu.br.asynctaskjson.entities.Pessoa;

/**
 * Created by eddie on 03/10/16.
 */

public class CadastrarAsyncTask extends AsyncTask<Pessoa, Void, String>{

    CadastrarActivity cadastrarActivity;
    String resposta = "";


    @Override
    protected String doInBackground(Pessoa... pessoas) {

        try{
            Gson gson = new Gson();
            String pessoaJson = gson.toJson(pessoas[0]);

            URL url = new URL("http://ladoss.info:8773/Convite_SERVICE/convidado/cadastrar");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());

            wr.writeBytes(pessoaJson);
            wr.close();

            if(urlConnection.getResponseCode() == 200){
                resposta = "Cadastrado com sucesso!";
            }else {
                resposta = "Falha no cadastro!";
            }

            urlConnection.disconnect();


        }catch (Exception e){
            e.printStackTrace();
        }
        return resposta;
    }
}
