package service;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import model.Filme;

public class FilmesService extends AsyncTask<Void, Void, Filme>{

    private String filme;

    public FilmesService(String filme){
        this.filme = filme;

    }

    @Override
    protected Filme doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();

        try{
            URL url = new URL("http://www.omdbapi.com/?t="+this.filme+"&apikey=7210c16b");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()){
                resposta.append(scanner.next());
            }

            Log.d("RETORNO", resposta.toString());

        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return new Gson().fromJson(resposta.toString(), Filme.class);
    }
}
