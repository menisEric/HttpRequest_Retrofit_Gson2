package com.ericmenis.application.Activitie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ericmenis.application.API.API;
import com.ericmenis.application.API.APIService.WeatherService;
import com.ericmenis.application.Models.City;
import com.ericmenis.application.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText EditTextsearch;
    private TextView textViewcity;
    private TextView textViewDescription;
    private TextView textViewTemp;
    private ImageView img;
    private Button btn;

    private WeatherService service;
    private Call<City> cityCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();

        service = API.getApi().create(WeatherService.class);

        btn.setOnClickListener(this);


        Call<City> cityCall = service.getCity("London,uk", API.APPKEY);

        cityCall.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                City city = response.body();
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setUI() {
        EditTextsearch = (EditText) findViewById(R.id.editTextSearch);
        textViewcity = (TextView) findViewById(R.id.textViewCity);
        textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        textViewTemp = (TextView) findViewById(R.id.textViewTemperature);
        img = (ImageView) findViewById(R.id.imageViewIcon);
        btn = (Button) findViewById(R.id.buttonSearch);
    }

    @Override
    public void onClick(View v) {
        String city = EditTextsearch.getText().toString();
        if (city != "") {
            cityCall = service.getCity(city, API.APPKEY);
            cityCall.enqueue(new Callback<City>() {
                @Override
                public void onResponse(Call<City> call, Response<City> response) {
                    City city = response.body();
                    setResult(city);
                }

                @Override
                public void onFailure(Call<City> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void setResult(City city) {
        textViewcity.setText(city.getName() + ", " + city.getCountry());
        textViewDescription.setText(city.getDescription());
        //Temperatura en kelvin
        textViewTemp.setText(city.getTemp() + "ºK");
        Picasso.with(this).load(API.BASE_ICONS + city.getIcon() + API.EXTENSION_ICONS).into(img);
    }
}
