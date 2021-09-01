package com.dargoz.itworks.uiux;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.dargoz.itworks.R;
import com.dargoz.itworks.databinding.UserInterfaceActivityBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;


public class UserInterfaceActivity extends AppCompatActivity {
    private UserInterfaceActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = UserInterfaceActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupView();
    }

    private void setupView() {
        binding.burgerMenu.setOnClickListener(view -> {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.openDrawer(GravityCompat.START);
        });

        NavigationView navigationView = binding.navView;
        navigationView.setItemIconTintList(null);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.ui_ux_nav_host_fragment);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(navigationView, navController);

        binding.fab.setOnClickListener(
                view -> Snackbar.make(view, "This is snackBar", Snackbar.LENGTH_LONG)
                        .setAction("Action", v ->
                                Toast.makeText(v.getContext(),
                                        "This is Toast", Toast.LENGTH_LONG)
                                .show())
                        .show()
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}