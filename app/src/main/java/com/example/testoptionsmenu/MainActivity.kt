package com.example.testoptionsmenu

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.library.googlematerial.GoogleMaterial
import com.mikepenz.iconics.utils.IconicsMenuInflaterUtil
import com.mikepenz.iconics.utils.colorInt
import com.mikepenz.iconics.utils.sizeDp


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        Iconics.init(this)
    }

    // IF FOR SOME REASON THE ICONS DON'T APPEAR WITH 5.0.3, add IconicsDrawable fn for one icon, then rotate the screen.  This seems to make them appear.
    // Looking at IconicsDrawable it calls Iconics.init, which initialises the fonts, so maybe that's why.
    // Probably in CycleStreets this fn is called elsewhere prior to OptionsMenu being set up.
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        //Context context = getContext(inflater)
        IconicsMenuInflaterUtil.inflate(inflater, this, R.menu.hn_options_menu, menu, true)
        // Iconics Helper (this app, then to Iconics)
        //inflate(inflater, R.menu.hn_options_menu, menu, this) //baseContext)
        //super.onCreateOptionsMenu(menu)
        // Non Iconics inflater
        //inflater.inflate(R.menu.hn_options_menu, menu)

        //if (context != null) {
        val item = menu.findItem(R.id.ic_menu_liveride)

            //item.icon = IconicsDrawable(this)
            /* item.icon = IconicsDrawable(this, GoogleMaterial.Icon.gmd_directions).apply {
                colorInt = Color.WHITE
                sizeDp = 24
                //respectFontBounds = true
            } */
        //}
        menu.findItem(R.id.ic_menu_liveride).isVisible = true
        /*menu.findItem(R.id.ic_menu_liveride).icon = IconicsDrawable(this, GoogleMaterial.Icon.gmd_navigation).apply {
            colorInt = Color.WHITE
            sizeDp = 24
            //respectFontBounds = true
        }
        menu.findItem(R.id.ic_menu_directions).icon = IconicsDrawable(this, GoogleMaterial.Icon.gmd_directions).apply {
            colorInt = Color.WHITE
            sizeDp = 24
            //respectFontBounds = true
        }*/
        return true
    }
    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        val mi = menu.findItem(R.id.ic_menu_liveride)
        if (mi != null) mi.isVisible = true
        return true
    }
}