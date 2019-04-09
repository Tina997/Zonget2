package es.ulpgc.montesdeoca110.cristina.zonget.editLostPet;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.lostPets.LostPetsListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail.LostPetsDetailActivity;

public class EditLostPetActivity
        extends AppCompatActivity implements EditLostPetContract.View {

    public static String TAG = EditLostPetActivity.class.getSimpleName();

    private EditLostPetContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_lost_pet);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configuracion actionBar y AppBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(R.string.edit_pet_tittle));
        }

        // do the setup
        EditLostPetScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
//        presenter.fetchData();
    }

    @Override
    public void injectPresenter(EditLostPetContract.Presenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.administrator_appbar_buttons_add_edit_pet, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public void displayData(EditLostPetViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_accept:
                presenter.insertNewPet();
                return true;
            default:
                int id = item.getItemId();
                if (id == android.R.id.home) {
                    //TODO matar la activity
                    navigateUpTo(new Intent(this, LostPetsDetailActivity.class));
                    return true;
                }
                return super.onOptionsItemSelected(item);
        }
    }

    public void takePicture(View view) {
        //TODO acceder a la camara o galeria para coger la imagen
    }
}