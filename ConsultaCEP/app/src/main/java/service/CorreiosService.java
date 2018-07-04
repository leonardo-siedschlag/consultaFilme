package service;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import model.CEP;

public class CorreiosService extends AsyncTask<Void, Void, CEP>{

    private String cep;

    public CorreiosService(String cep){

        Log.d("AST", "construtor");

        if (cep != null && cep.length() == 8){
            this.cep = cep;
        } else {
            throw new IllegalArgumentException("CEP invalido");
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.i("AST", "onPreExecute");

    }

    @Override
    protected void onPostExecute(CEP cep) {
        super.onPostExecute(cep);
        Log.i("AST", "onPostExecute");

    }

    @Override
    protected CEP doInBackground(Void... voids) {
        Log.i("AST", "doInBackground");

        StringBuilder resposta = new StringBuilder();

        try{
            URL url = new URL("https://viacep.com.br/ws/"+this.cep+"/json/");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()){
                resposta.append(scanner.next());
            }

        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return new Gson().fromJson(resposta.toString(), CEP.class);
    }
}
