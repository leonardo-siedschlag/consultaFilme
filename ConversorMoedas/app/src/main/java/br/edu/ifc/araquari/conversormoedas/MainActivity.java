package br.edu.ifc.araquari.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder viewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.viewHolder.ed_real_value = findViewById(R.id.et_valor_real);
        this.viewHolder.tv_dollar = findViewById(R.id.tv_valor_dollar);
        this.viewHolder.tv_euro = findViewById(R.id.tv_valor_euro);
        this.viewHolder.btn_calcular = (Button) findViewById(R.id.btn_calcular);

        this.viewHolder.btn_calcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.btn_calcular:

                Double valorReal = Double.parseDouble(viewHolder.ed_real_value.getText().toString());
                viewHolder.tv_dollar.setText(String.format("%.2f", valorReal * 3.3));
                viewHolder.tv_euro.setText(String.format("%.2f", valorReal * 4));

                break;
            default:

        }
    }

    private static class ViewHolder {
        EditText ed_real_value;
        TextView tv_dollar;
        TextView tv_euro;
        Button btn_calcular;
    }

}
