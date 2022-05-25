package com.example.tamagochi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    public Button btnComida, btnRegistro, btnEstado, btnCurar, btnLimpiar;
    TextView txtAccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComida = findViewById(R.id.btnComida);
        btnCurar = findViewById(R.id.btnCurar);
        btnEstado = findViewById(R.id.btnEstado);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegistro = findViewById(R.id.btnRegistro);
        txtAccion = findViewById(R.id.txtAccion);
    }
    private void ws(){
        String url = "";
        StringRequest postRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    txtAccion.setText(jsonObject.getString("comio"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(postRequest);
    }

    public void darComida(View view) {
    }

    public void limpiarTama(View view) {
    }

    public void registroTama(View view) {
    }

    public void curarTama(View view) {
    }

    public void estadoTama(View view) {
    }
}