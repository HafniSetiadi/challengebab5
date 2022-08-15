package com.setiadi.myapplicationbab5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.setiadi.myapplicationbab5.databinding.ActivityMainBinding
import me.relex.circleindicator.CircleIndicator3

val KEY_MESSAGE = "message"

class MainActivity: AppCompatActivity(), Communicator {
    private var layout : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = ActivityMainBinding.inflate(layoutInflater)
        setContentView(layout.root)

        val fragmentA = FragmentA()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragmentA).commit()

//android:id="@+id/view_pager" utk SLIDER
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)

        val fragment: ArrayList<Fragment> = arrayListOf(
            Fragment1(),
            Fragment2(),
            FragmentA(),
            FragmentA2(),
            )

        val adapter = ViewPagerAdapter(fragment, this@MainActivity)
        viewPager.adapter = adapter

        val indicator: CircleIndicator3 = findViewById(R.id.indicator)
        indicator.setViewPager(viewPager)
    }

    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString(KEY_MESSAGE, editTextInput)

        val transaction = this@MainActivity.supportFragmentManager.beginTransaction()
        val fragmentB = FragmentA2()
        fragmentB.arguments = bundle

        transaction.replace(R.id.fragment_container,fragmentB)
            transaction.commit()
    }
    override  fun navigateActivity() {
        startActivity(Intent(this@MainActivity, MainActivity2::class.java))
    }
}



