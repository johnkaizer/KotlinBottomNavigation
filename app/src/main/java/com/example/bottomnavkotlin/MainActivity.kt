package com.example.bottomnavkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setUpTabBar()
        drawerLayout  = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when(it.itemId){
                R.id.nav_home -> replaceFragment(it.title.toString())
                R.id.nav_share -> Toast.makeText(applicationContext, "Clicked share",Toast.LENGTH_SHORT).show()
                R.id.nav_settings -> replaceFragment(SettFragment(),it.title.toString())
                R.id.nav_profile -> replaceFragment(ProfFragment(),it.title.toString())
                R.id.rate_us -> Toast.makeText(applicationContext, "Clicked rate us",Toast.LENGTH_SHORT).show()
                R.id.login -> replaceFragment(LoginFragment(),it.title.toString())
                R.id.nav_history -> replaceFragment(HistoryFragment(),it.title.toString())
            }
            true
        }

    }

    private fun replaceFragment(title: String) {

    }

    private fun replaceFragment(fragment: Fragment, title: String){

        val fragmentManager= supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.linear,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)


    }

    override  fun onOptionsItemSelected(item: MenuItem):Boolean{

        if (toggle.onOptionsItemSelected(item)){

            return true
        }

        return super.onOptionsItemSelected(item)
    }


// Tab layout code/ FRAGMENTS CODE has been commented out


//    private fun setUpTabBar() {
//        val adapter= TabPageAdapter(this,tabLayout.tabCount)
//        viewpager.adapter = adapter
//
//        viewpager.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback()
//        {
//            override fun onPageSelected(position: Int) {
//                tabLayout.selectTab(tabLayout.getTabAt(position))
//            }
//
//        })
//        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                if (tab != null) {
//                    viewpager.currentItem=tab.position
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//
//            }
//        })
//    }

}