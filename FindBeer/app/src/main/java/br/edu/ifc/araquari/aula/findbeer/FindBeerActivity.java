package br.edu.ifc.araquari.aula.findbeer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    public Spinner spn_find_beer;
    public Button btn_find_beer_seleciona;
    public TextView tv_find_beer_exibe;
    public BeerExpert beerExpert = new BeerExpert();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_find_beer);

        this.spn_find_beer = findViewById(R.id.spn_find_beer);
        this.btn_find_beer_seleciona = findViewById(R.id.btn_find_beer_seleciona);
        this.tv_find_beer_exibe = findViewById(R.id.tv_find_beer_exibe);
    }

    public void onClickFindBeer(View view) {
        String beer = this.spn_find_beer.getSelectedItem().toString();

        List<String> beerBrands = this.beerExpert.getBeers(beer);

        StringBuilder stringBrands = new StringBuilder();

        for (String brand: beerBrands){
            stringBrands.append(brand).append('\n');
        }

        this.tv_find_beer_exibe.setText(stringBrands);
    }
}
