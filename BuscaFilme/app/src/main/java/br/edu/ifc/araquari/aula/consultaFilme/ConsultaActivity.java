package br.edu.ifc.araquari.aula.consultaFilme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import model.Filme;
import service.FilmesService;

public class ConsultaActivity extends AppCompatActivity {

    EditText edtFilmeNome;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(br.edu.ifc.araquari.aula.consultaFilme.R.layout.activity_consulta);


        this.edtFilmeNome = findViewById(br.edu.ifc.araquari.aula.consultaFilme.R.id.edt_consulta_filme);
        this.tvResultado = findViewById(br.edu.ifc.araquari.aula.consultaFilme.R.id.tv_consulta_resultado);

    }

    public void buscarFilme(View view) {

        String filme = edtFilmeNome.getText().toString();

        try {

            Filme filmeRetorno = new FilmesService(filme).execute().get();
            tvResultado.setText(filmeRetorno.toString());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Toast.makeText(ConsultaActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
