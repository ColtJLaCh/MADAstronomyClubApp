package coltonlachance.com.madskeletonapplication;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import coltonlachance.com.madskeletonapplication.databinding.ActivityMainBinding;

/**MainActivity
 * Created using Android Studio's Navigation Drawer default layout
 */
public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    NavigationView navigationView;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int state = ClubPicturesManagerFragment.CREATE;

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        navigationView = binding.navView;

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_recycler, R.id.nav_vp_holder,R.id.nav_extra)
                .setOpenableLayout(drawer)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        binding.appBarMain.fab.setImageResource(R.drawable.ic_baseline_add_photo_alternate_24);

        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDestination currentFragment = navController.getCurrentDestination();
                if (currentFragment.getId() == R.id.nav_recycler) {
                    Bundle extra = new Bundle();
                    extra.putInt(ClubPicturesManagerFragment.ACTION_TYPE,
                            ClubPicturesManagerFragment.CREATE);
                    navController
                            .navigate(R.id.nav_manager, extra);
                    binding.appBarMain.fab.hide();
                }

                if (currentFragment.getId() == R.id.nav_manager) {
                    AstronomyDatabase db = new AstronomyDatabase(view.getContext());
                    //Will somehow delete from here
                    db.close();
                }
            }
        });

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination,
                                             @Nullable Bundle arguments) {
                switch (destination.getId()) {
                    case R.id.nav_recycler:
                        binding.appBarMain.fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.primary_lt)));
                        binding.appBarMain.fab.setImageResource(R.drawable.ic_baseline_add_photo_alternate_24);
                        binding.appBarMain.fab.show();
                    break;

                    case R.id.nav_manager:
                        binding.appBarMain.fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                        binding.appBarMain.fab.setImageResource(R.drawable.ic_baseline_delete_forever_24);
                    break;

                    default:
                        binding.appBarMain.fab.hide();
                    break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}