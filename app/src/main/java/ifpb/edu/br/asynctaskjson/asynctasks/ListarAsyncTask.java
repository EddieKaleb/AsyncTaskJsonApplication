package ifpb.edu.br.asynctaskjson.asynctasks;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.asynctaskjson.entities.Pessoa;

/**
 * Created by root on 03/10/16.
 */


public class ListarAsyncTask  extends AsyncTask<String, Void, List<Pessoa>> {

    @Override
    protected List<Pessoa> doInBackground(String... params) {
        List<Pessoa> pessoas = null;
        try {
            String urlParam = params[0];
            URL url = new URL(urlParam);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            InputStream input = urlConnection.getInputStream();

            JsonReader reader = new JsonReader(new InputStreamReader(input, "UTF-8"));

            pessoas = getPessoas(reader);

            input.close();
            urlConnection.disconnect();
            Log.i("AsyncTask", "Resp: " + urlConnection.getResponseCode());
            Log.i("AsyncTask", "Resp: " + urlConnection.getResponseMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public List<Pessoa> getPessoas(JsonReader reader) throws IOException {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        reader.beginArray();
        while (reader.hasNext()) {
            pessoas.add(getPessoa(reader));
        }
        reader.endArray();
        return pessoas;
    }

    public Pessoa getPessoa(JsonReader reader) throws IOException {

        String nome = null;
        String email = null;
        String endereco = null;
        String cpf = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("nome")) {
                nome = reader.nextString();
            } else if (name.equals("email")) {
                email = reader.nextString();
            } else if (name.equals("endereco")) {
                endereco = reader.nextString();
            } else if (name.equals("cpf")) {
                cpf = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Pessoa(nome, email,endereco, cpf);
    }


}

