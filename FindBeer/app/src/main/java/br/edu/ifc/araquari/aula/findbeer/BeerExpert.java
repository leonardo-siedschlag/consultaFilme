package br.edu.ifc.araquari.aula.findbeer;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {

    public List<String> getBeers(String type){

        List<String> beers = new ArrayList<String>();

        switch (type){
            case "Pilsen":
                beers.add("Baden");
                beers.add("Eisenbahn");
                break;

            case "Bock":
                beers.add("Hausen");
                beers.add("Colorado");
                break;
        }

        return beers;

    }

}
