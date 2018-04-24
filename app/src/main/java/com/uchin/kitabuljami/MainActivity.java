package com.uchin.kitabuljami;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.uchin.kitabuljami.utils.Hadits;

import java.util.ArrayList;
import java.util.List;

import static com.uchin.kitabuljami.TabFragment.viewPager;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    List<Hadits> haditsList = new ArrayList<>();
    private static final String TAG = "MyActivity";

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    ListFragment mListFragment;
    AppBarLayout appBarLayout;

    MaterialSearchView searchViewq;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //setTheme(R.style.AppTheme2);

        super.onCreate(savedInstanceState);

        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        searchViewCode();

        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        mListFragment = new ListFragment();
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
        appBarLayout = findViewById(R.id.appbarlayout);

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else if (searchViewq.isSearchOpen()) {
            //handleMenuSearch();
            searchViewq.closeSearch();

        } else if (viewPager.getCurrentItem() != 0){
            viewPager.setCurrentItem(0);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item=menu.findItem(R.id.action_search);
        searchViewq.setMenuItem(item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_detail: {
                Intent r = new Intent(MainActivity.this, HaditsDetail.class);
                startActivity(r);
            }
            return true;
            case R.id.action_search:

            return true;
            case R.id.action_settings: {
                Intent r = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(r);
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.pengantar) {
            viewPager.setCurrentItem(3);
        } else if (id == R.id.biografi) {
            Intent r = new Intent(MainActivity.this, BiografiActivity.class);
            startActivity(r);
        } else if (id == R.id.reference) {
            Intent r = new Intent(MainActivity.this, ReferenceActivity.class);
            startActivity(r);
        } else if (id == R.id.bookmark) {
            viewPager.setCurrentItem(1);
        } else if (id == R.id.maintopics1) {
            Intent r = new Intent(MainActivity.this, MainTopics1.class);
            startActivity(r);
        } else if (id == R.id.maintopics2) {
            Intent r = new Intent(MainActivity.this, MainTopics2.class);
            startActivity(r);
        } else if (id == R.id.maintopics3) {
            Intent r = new Intent(MainActivity.this, MainTopics3.class);
            startActivity(r);
        } else if (id == R.id.maintopics4) {
            Intent r = new Intent(MainActivity.this, MainTopics4.class);
            startActivity(r);
        } else if (id == R.id.maintopics5) {
            Intent r = new Intent(MainActivity.this, MainTopics5.class);
            startActivity(r);
        } else if (id == R.id.shareapp) {
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Kitab Al Jami'");
                String sAux = "\nSaya sangat merekomendasikan aplikasi islami ini, Tuntunan Adab dan Akhlaq\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=Orion.Soft\n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "choose one"));
            } catch (Exception e) {
                //e.toString();
            }
        } else if (id == R.id.about) {
            Intent r = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(r);
        } else if (id == R.id.setting) {
            Intent r = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(r);
        }

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private void searchViewCode(){
        searchViewq= findViewById(R.id.search_view);
        searchViewq.setSuggestions(getResources().getStringArray(R.array.query_sugestions));
        searchViewq.setEllipsize(true);
        searchViewq.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(),query,Toast.LENGTH_SHORT).show();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchViewq.setOnSearchViewListener(new MaterialSearchView.SearchViewListener(){
            @Override
            public void onSearchViewShown() {
                //scroll up appbar
                appBarLayout.setExpanded(false,true);

            }

            @Override
            public void onSearchViewClosed() {
                //collapse it
                appBarLayout.setExpanded(true,true);
            }
        });
    }
}
