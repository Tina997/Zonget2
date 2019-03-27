package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AdministratorUsersAddPetRouter implements AdministratorUsersAddPetContract.Router {

    public static String TAG = AdministratorUsersAddPetRouter.class.getSimpleName();

    private AppMediator mediator;

    public AdministratorUsersAddPetRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorUsersAddPetActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AdministratorUsersAddPetState state) {
      //  mediator.setAdministratorUsersAddPetState(state);
    }

    @Override
    public AdministratorUsersAddPetState getDataFromPreviousScreen() {
      //  AdministratorUsersAddPetState state = mediator.getAdministratorUsersAddPetState();
       // return state;
        return null;
    }
}