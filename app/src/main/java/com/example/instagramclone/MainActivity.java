package com.example.instagramclone;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.instagramclone.databinding.ActivityMainBinding;
import com.example.instagramclone.ui.bottom.SearchFragment;
import com.example.instagramclone.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView = toolbar.findViewById(R.id.more);
        ImageView message = toolbar.findViewById(R.id.message);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Add More", Toast.LENGTH_SHORT).show();
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Message", Toast.LENGTH_SHORT).show();
            }
        });

        navView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.home)
                {
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment_activity_main, homeFragment);
                    transaction.commit();
                }
                if(item.getItemId() == R.id.search)
                {
                    Toast.makeText(MainActivity.this, "Search coming soon..", Toast.LENGTH_SHORT).show();
//                    SearchFragment searchFragment = new SearchFragment();
//                    FragmentManager manager = getFragmentManager();
//                    android.app.FragmentTransaction transaction = manager.beginTransaction();
//                    transaction.add(R.id.nav_host_fragment_activity_main,searchFragment,"search");
//                    transaction.commit();

                    SearchFragment searchFragment = new SearchFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment_activity_main, searchFragment,"Search");
                    transaction.commit();
                    
                }
                if(item.getItemId() == R.id.reels)
                {
                    Toast.makeText(MainActivity.this, "Video coming soon...", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId() == R.id.heart)
                {
                    Toast.makeText(MainActivity.this, "Notification coming soon...", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId() == R.id.user)
                {
                    Toast.makeText(MainActivity.this, "Account Information coming soon...", Toast.LENGTH_SHORT).show();
                }




            }
        });

    }

}