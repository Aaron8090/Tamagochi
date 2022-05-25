package com.example.tamagochi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity {

    Button btnActualizar;
    TextView comida,limpieza,curacion,estado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnActualizar = findViewById(R.id.btnActualizar);
        comida = findViewById(R.id.comida);
        estado = findViewById(R.id.estado);
        limpieza = findViewById(R.id.limpieza);
        curacion = findViewById(R.id.curacion);

    }

    public void btnActualizar(View view) {
        consultarws();
    }

    private void consultarws(){
        String url = "";
        StringRequest postRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    comida.setText(jsonObject.getString(""));
                    estado.setText(jsonObject.getString(""));
                    limpieza.setText(jsonObject.getString(""));
                    curacion.setText(jsonObject.getString(""));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postRequest);
    }
}