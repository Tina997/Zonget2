package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import java.lang.ref.WeakReference;

interface UserAgendaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(UserAgendaViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(UserAgendaState state);

        UserAgendaState getDataFromPreviousScreen();
    }
}
