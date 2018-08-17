package com.santiago.ws_turisapp.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.santiago.ws_turisapp.R;
import com.santiago.ws_turisapp.Utils.MyCallBacks;
import com.santiago.ws_turisapp.data.Datos;
import com.santiago.ws_turisapp.fragments.HotelesFragment;
import com.santiago.ws_turisapp.fragments.InicioFragment;
import com.santiago.ws_turisapp.fragments.RestaurantesFragment;
import com.santiago.ws_turisapp.fragments.SitiosFragment;
import com.santiago.ws_turisapp.models.Hotel;
import com.santiago.ws_turisapp.models.Restaurante;
import com.santiago.ws_turisapp.models.Sitio;

import java.util.ArrayList;

public class InicioActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,MyCallBacks {

    private ArrayList<Sitio> sitios;
    private ArrayList<Hotel> hotels;
    private ArrayList<Restaurante> restaurantes;
    private Datos datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        datos=new Datos(getApplicationContext());
        insertSitios();
        insertHoteles();
        insertRestaurantes();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState ==null){

            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new InicioFragment()).commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.inicio) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new InicioFragment()).commit();
        } else if (id == R.id.nav_gallery) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new SitiosFragment()).commit();
        } else if (id == R.id.nav_slideshow) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new HotelesFragment()).commit();
        } else if (id == R.id.nav_manage) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new RestaurantesFragment()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void insertRestaurantes() {
        restaurantes=new ArrayList<Restaurante>(){{
            add(new Restaurante("El Roble",getString(R.string.roble_CORTA),"Dirección: Vía Armenia – Pereira",getString(R.string.roble_LARGA),4.545695136892776,-75.67256734597161,R.drawable.r_el_roble));
            add(new Restaurante("La Fogata",getString(R.string.fogata_CORTA),"ubicado en el norte de Armenia. Quindio.",getString(R.string.fogata_LARGA),4.537481262607865,-75.66655919777826,R.drawable.r_la_fogata));
            add(new Restaurante("Dar Papaya",getString(R.string.papaya_CORTA),"Dirección: Av Centenario (Frente al CC Calima). Armenia, Quindío.",getString(R.string.papaya_LARGA),4.5268715367044985,-75.68767354714349,R.drawable.r_dar_papaya));
            add(new Restaurante("Casa Verde",getString(R.string.casa_verde_CORTA),"Dirección:  Vía Armenia – Cali.",getString(R.string.casa_verde_LARGA),4.518144064907527,-75.71059034096673,R.drawable.r_casa_verde));
            add(new Restaurante("Camelia Real",getString(R.string.camelia_CORTA),"Dirección: Vía Montenegro – Pueblo Tapao",getString(R.string.camelia_LARGA),4.566295305869581,-75.75057066111447,R.drawable.r_camelia_real));
            add(new Restaurante("Bosques de Cocora donde Juan B",getString(R.string.cocora_CORTA),"Dirección: Valle de Cocora, Salento, Quindio",getString(R.string.cocora_LARGA),4.637932138866702,-75.57060538862306,R.drawable.r_bosque_cocora));
            add(new Restaurante("El Solar",getString(R.string.solar_CORTA),"Dirección: Vía Armenia – Pereira",getString(R.string.solar_LARGA),4.640840820686086,-75.56895314786989,R.drawable.r_el_solar));

        }};
        datos.guardarRestaurantes(restaurantes);
    }

    private void insertHoteles() {
        hotels=new ArrayList<Hotel>(){{
            add(new Hotel("Hotel Bolivar Plaza",getString(R.string.bolivar_plaza_CORTA),"Dirección: Calle 21a No. 14-17, Armenia",getString(R.string.bolivar_plaza_LARGA),4.45234778794663,-75.78196047823484,R.drawable.h_bolivar_plaza));
            add(new Hotel("Allure Aroma Mocawa Hotel",getString(R.string.mocawa_CORTA),"Dirección: Carrera 14 No. 9N-00, Armenia",getString(R.string.mocawa_LARGA),4.447555758701706,-75.78938483278806,R.drawable.h_mocawa));
            add(new Hotel("Armenia Hotel",getString(R.string.armenia_CORTA),"Dirección: Avenida Bolivar 8",getString(R.string.armenia_LARGA),4.624838213794354,-75.762595160852,R.drawable.h_armenia));
            add(new Hotel("Hotel Zuldemayda",getString(R.string.zuldemayda_CORTA),"Dirección: Calle 20 15-38 Armenia",getString(R.string.zuldemayda_LARGA),4.637932138866702,-75.57060538862306,R.drawable.h_zuldemayda));
            add(new Hotel("Hotel Decameron Panaca",getString(R.string.panaca_hotel_CORTA),"Dirección: Km. 7 Vereda Kerman | Parque Nacional de la Cultura Agropecuaria, Quimbaya, Colombia ",getString(R.string.panaca_hotel_LARGA),4.622357223916545,-75.76650045717768,R.drawable.h_decameron));
            add(new Hotel("Decameron Las Heliconias",getString(R.string.heliconias_CORTA),"Dirección: Km 2 Vía a Panaca, Vereda Kerman, Quimbaya ",getString(R.string.heliconias_LARGA),4.621929466163072,-75.76083563173823,R.drawable.h_heliconias));
            add(new Hotel("Hotel Arrayanes del Quindio",getString(R.string.arrayanes_CORTA),"Dirección: Km 1 Vía Montenegro-Parque del Cafe, Montenegro",getString(R.string.arrayanes_LARGA),4.5659102936329115,-75.75595653681637,R.drawable.h_arrayanes));
            add(new Hotel("Finca Hotel La Esperanza",getString(R.string.esperanza_CORTA),"Dirección: Vereda la esperanza, Montenegro, Colombia ",getString(R.string.esperanza_LARGA),4.566295305869581,-75.75057066111447,R.drawable.h_la_esperanza));
        }};
        datos.guardarHoteles(hotels);
    }

    private void insertSitios() {
        sitios= new ArrayList<Sitio>(){{
            add(new Sitio("Centro comercial portal del quindio",getString(R.string.portal_del_Quindío_CORTA),"Dirección: Av Bolivar # 19 Norte 46 Armenia",getString(R.string.portal_del_Quindío_LARGA),4.545695136892776,-75.67256734597161,R.drawable.s_portal_del_quindio));
            add(new Sitio("Unicentro Armenia",getString(R.string.unicentro_CORTA),"Avenida Bolívar con Calle 4B",getString(R.string.unicentro_LARGA),4.537481262607865,-75.66655919777826,R.drawable.s_unicentro));
            add(new Sitio("Calima Centro Comercial Armenia",getString(R.string.calima_CORTA),"Avenida Centenario # 3 - 180. Armenia",getString(R.string.calima_LARGA),4.5268715367044985,-75.68767354714349,R.drawable.s_calima));
            add(new Sitio("Parque del Café",getString(R.string.parque_cafe_CORTA),"Montenegro Quindio",getString(R.string.parque_cafe_LARGA),4.569482343671689,-75.74745929865719,R.drawable.s_parque_cafe));
            add(new Sitio("Panaca",getString(R.string.panaca_CORTA),"Kilometro 7, Vía Vereda Kerman Quimbaya, Quindío.",getString(R.string.panaca_LARGA),4.622357223916545,-75.76650045717768,R.drawable.s_panaca));
            add(new Sitio("Salento",getString(R.string.salento_CORTA),"Municipio en Colombia",getString(R.string.salento_LARGA),4.621929466163072,-75.76083563173823,R.drawable.s_salento));
            add(new Sitio("Eco Parque Peñas Blancas",getString(R.string.peñas_blancas_CORTA),"Corregimiento la virginia en Calarcá",getString(R.string.peñas_blancas_LARGA),4.62470988694496,-75.7556428750854,R.drawable.s_penas_blancas));
            add(new Sitio("La Pequeña Granja de Mamá Lulú",getString(R.string.mama_lulu_CORTA),"Quimbaya Quindio",getString(R.string.mama_lulu_LARGA),4.640840820686086,-75.56895314786989,R.drawable.s_granja_mama_lulu));
            add(new Sitio("Parque Los Arrieros ",getString(R.string.arrieros_CORTA),"Quimbaya Quindio",getString(R.string.arrieros_LARGA),4.531577482735009,-75.64214036690667,R.drawable.s_los_arrieros));
        }};
        datos.guardarSitio(sitios);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
