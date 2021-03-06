package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption;

import android.content.Context;
import android.content.Intent;
import es.ulpgc.montesdeoca110.cristina.zonget.addPetForAdoption.AddPetForAdoptionActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail.PetsForAdoptionDetailActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListActivity;

public class PetsForAdoptionRouter implements PetsForAdoptionContract.Router {

  public static String TAG = PetsForAdoptionRouter.class.getSimpleName();

  private final AppMediator mediator;

  public PetsForAdoptionRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, PetsForAdoptionDetailActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void passDataToDetailScreen(PetForAdoptionItem petForAdoptionItem) {
    mediator.setPetForAdoptionItem(petForAdoptionItem);
  }

  @Override
  public PetsForAdoptionState getDataFromPreviousScreen() {
    return mediator.getPetsForAdoptionState();
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void onBackButtonPressed() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserButtonsMenuListActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void navigateToAddPetForAdoptionScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AddPetForAdoptionActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
