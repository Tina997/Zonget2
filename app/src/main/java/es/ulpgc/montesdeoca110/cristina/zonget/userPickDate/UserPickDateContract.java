package es.ulpgc.montesdeoca110.cristina.zonget.userPickDate;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.HourItem;

interface UserPickDateContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(UserPickDateViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        String getActualThemeName();

        void saveState(String date, long calendarDate);

        void onDateChanged(String date, long calendarDate);
    }

    interface Model {
        List<HourItem> fetchData();

        long fetchDateData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(UserPickDateState state);

        UserPickDateState getDataFromPreviousScreen();

        String getActualThemeName();
    }
}
