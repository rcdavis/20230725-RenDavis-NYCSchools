package rcdavis.nycschools;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import rcdavis.nycschools.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frag_container);
        if (navHostFragment != null) {
            final NavController navController = navHostFragment.getNavController();
            final AppBarConfiguration appBarConfiguration = new AppBarConfiguration
                    .Builder(navController.getGraph())
                    .build();

            NavigationUI.setupActionBarWithNavController(
                    this,
                    navController,
                    appBarConfiguration
            );
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.frag_container).navigateUp() ||
                super.onSupportNavigateUp();
    }
}
