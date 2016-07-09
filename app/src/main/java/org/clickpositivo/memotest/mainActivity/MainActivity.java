package org.clickpositivo.memotest.mainActivity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.clickpositivo.memotest.recyclers.PuntajesFragment;
import org.clickpositivo.memotest.R;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {


    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.main, menu);
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
            Toast.makeText(this, "Hecho por Marcelo Gómez", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.drawer_item_familia) {
            setContenido(0);
        } else if (id == R.id.drawer_item_amigos) {
            setContenido(1);
        } else if (id == R.id.drawer_item_peter) {
            setContenido(2);
        } else if (id == R.id.drawer_item_peter_jane) {
            setContenido(3);
        }else if (id == R.id.drawer_puntaje_familia) {
            setContenido(4);
        }else if (id == R.id.drawer_puntaje_amigos) {
            setContenido(5);
        }else if (id == R.id.drawer_puntaje_wendy) {
            setContenido(6);
        }else if (id == R.id.drawer_puntaje_jane) {
            setContenido(7);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //METODO QUE CARGA EL FRAGMENT EN EL CONTENT
    private void setContenido(int numeroContenido)
    {

        FragmentManager fragmentManager = getSupportFragmentManager();
        Bundle args;

        switch (numeroContenido){
            case 0:
                fragment = new BlankFragment();
                args = new Bundle();
                args.putInt("tipo", 1);
                fragment.setArguments(args);
                fragmentManager.beginTransaction()
                        .replace(R.id.contenedor, fragment, "FAMILIA")
                        .commit();
                break;
            case 1:
                fragment = new BlankFragment();
                args = new Bundle();
                args.putInt("tipo", 2);
                fragment.setArguments(args);
                fragmentManager.beginTransaction()
                        .replace(R.id.contenedor, fragment, "AMIGOS")
                        .commit();
                break;
            case 2:
                fragment = new BlankFragment();
                args = new Bundle();
                args.putInt("tipo", 3);
                fragment.setArguments(args);
                fragmentManager.beginTransaction()
                        .replace(R.id.contenedor, fragment, "WENDY")
                        .commit();
                break;
            case 3:
                fragment = new BlankFragment();
                args = new Bundle();
                args.putInt("tipo", 4);
                fragment.setArguments(args);
                fragmentManager.beginTransaction()
                        .replace(R.id.contenedor, fragment, "JANE")
                        .commit();
                break;
            case 4:
                fragment = new PuntajesFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.contenedor, fragment, "PUNTAJE_FAMILIA")
                        .commit();
                break;
            case 5:
                fragment = new PuntajesFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.contenedor, fragment, "PUNTAJE_AMIGOS")
                        .commit();
                break;
            case 6:
                fragment = new PuntajesFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.contenedor, fragment, "PUNTAJE_WENDY")
                        .commit();
                break;
            case 7:
                fragment = new PuntajesFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.contenedor, fragment, "PUNTAJE_JANE")
                        .commit();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        Bundle args;
            if(fragment!=null){
                if (fragment.isVisible()){
                    if (fragment.getTag().equals("FAMILIA")){
                        args = new Bundle();
                        args.putInt("tipo", 1);
                        BlankFragment a = (BlankFragment)fragment;
                        a.reseteo();
                    }
                    if (fragment.getTag().equals("AMIGOS")){
                        args = new Bundle();
                        args.putInt("tipo", 2);
                        BlankFragment a = (BlankFragment)fragment;
                        a.reseteo();
                    }
                    if (fragment.getTag().equals("WENDY")){
                        args = new Bundle();
                        args.putInt("tipo", 3);
                        BlankFragment a = (BlankFragment)fragment;
                        a.reseteo();
                    }
                    if (fragment.getTag().equals("JANE")){
                        args = new Bundle();
                        args.putInt("tipo", 4);
                        BlankFragment a = (BlankFragment)fragment;
                        a.reseteo();
                    }
                    if (fragment.getTag().equals("PUNTAJE_FAMILIA")){
                        Snackbar.make(v, "<-- Elija un juego del Menú Izquierdo", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                    }
                    if (fragment.getTag().equals("PUNTAJE_AMIGOS")){
                        Snackbar.make(v, "<-- Elija un juego del Menú Izquierdo", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                    }
                    if (fragment.getTag().equals("PUNTAJE_WENDY")){
                        Snackbar.make(v, "<-- Elija un juego del Menú Izquierdo", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                    }
                    if (fragment.getTag().equals("PUNTAJE_JANE")){
                        Snackbar.make(v, "<-- Elija un juego del Menú Izquierdo", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                    }

                }
                Snackbar.make(v, "Juego Nuevo", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }else{
                Snackbar.make(v, "<-- Elija un juego del Menú Izquierdo", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }

        }

}
