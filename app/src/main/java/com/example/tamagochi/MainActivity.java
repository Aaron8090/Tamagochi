package com.example.tamagochi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
    private void consultarws(){
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
                Log.e("error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postRequest);
    }

    private void Modificarws(){
        String url = "";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    txtAccion.setText(jsonObject.getString("comio"));
                    Toast.makeText(MainActivity.this,"ID" + jsonObject.getString("id"),Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.getMessage());
            }
        })
        {
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();
                params.put("","POST");
                return params;
            }
        };
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