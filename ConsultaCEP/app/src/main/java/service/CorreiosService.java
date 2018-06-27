package service;

import android.os.AsyncTask;

import model.CEP;

public class CorreiosService extends AsyncTask<Void, Void, CEP>{

    private String cep;

    public CorreiosService(String cep){

    }

    @Override
    protected CEP doInBackground(Void... voids) {
        return null;
    }
}
