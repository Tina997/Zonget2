package es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorUserEditPetPresenter
        implements AdministratorUserEditPetContract.Presenter {

  public static String TAG = AdministratorUserEditPetPresenter.class.getSimpleName();

  private AdministratorUserEditPetContract.Model model;
  private AdministratorUserEditPetContract.Router router;

  public AdministratorUserEditPetPresenter(AdministratorUserEditPetState state) {
    AdministratorUserEditPetViewModel viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AdministratorUserEditPetContract.View> view) {
    WeakReference<AdministratorUserEditPetContract.View> view1 = view;
  }

  @Override
  public void injectModel(AdministratorUserEditPetContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AdministratorUserEditPetContract.Router router) {
    this.router = router;
  }


  @Override
  public void insertNewPet(UserPetItem userPetItem) {
    model.editPet(userPetItem, new RepositoryContract.Accounts.UpdateUserPetCallback(){
      @Override
      public void onUserPetUpdate() {
        router.navigateToNextScreen();
      }
    });

  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void onBackButtonPressed() {
    router.onBackButtonPressed();
  }

  @Override
  public UserPetItem fetchPetData() {
    return router.getDataFromPreviousScreen();
  }


}
