package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class UserQueriesMenuActivity extends AppCompatActivity
        implements UserQueriesMenuContract.View {

  private UserQueriesMenuContract.Presenter presenter;

  private CardView pendingQueriesCardView;
  private TextView pendingQueriesCounter;
  private CardView finishedQueriesCardView;
  private TextView finishedQueriesCounter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    UserQueriesMenuScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }

    setContentView(R.layout.activity_user_queries_menu);

    //Configuracion de la toolBar/actionBar
    //Elementos de la vista
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    actionBar.setTitle("Consultas");
    actionBar.setDisplayHomeAsUpEnabled(true);

    //Búsqueda de los elementos de la vista
    LinearLayout newQueryButton = findViewById(R.id.user_queries_menu_new_query_linear_layout);
    LinearLayout pendingQueriesButton = findViewById(R.id.user_queries_menu_pending_queries_linear_layout);
    pendingQueriesCardView = findViewById(R.id.user_queries_menu_pending_queries_counter_cardView);
    pendingQueriesCounter = findViewById(R.id.user_queries_menu_pending_queries_counter_textView);
    LinearLayout finishedQueriesButton = findViewById(R.id.user_queries_menu_finished_queries_linear_layout);
    finishedQueriesCardView = findViewById(R.id.user_queries_menu_finished_queries_counter_cardView);
    finishedQueriesCounter = findViewById(R.id.user_queries_menu_finished_queries_counter_textView);

    //Listeners
    newQueryButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.newQueryButtonPressed();
      }
    });

    pendingQueriesButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.pendingQueriesButtonPressed();
      }
    });

    finishedQueriesButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.finishedQueriesButtonPressed();
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();

    presenter.fetchUserQueriesMenuData();
  }

  @Override
  public void injectPresenter(UserQueriesMenuContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayUserQueriesMenuData(final UserQueriesMenuViewModel viewModel) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        pendingQueriesCardView.setVisibility(viewModel.penndingQueriesCardViewVisibility);
        pendingQueriesCounter.setText(String.valueOf(viewModel.pendingQueriesCounter));
        finishedQueriesCardView.setVisibility(viewModel.finishedQueriesCardViewVisibility);
        finishedQueriesCounter.setText(String.valueOf(viewModel.finishedQueriesCounter));
      }
    });
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle presses on the action bar items
    switch (item.getItemId()) {
      case android.R.id.home:
        presenter.backButtonPressed();
        finish();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
