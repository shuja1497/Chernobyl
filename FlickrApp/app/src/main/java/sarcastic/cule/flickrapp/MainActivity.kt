package sarcastic.cule.flickrapp

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GetRawData.OnDownloadComplete {

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val url = "https://api.flickr.com/services/feeds/photos_public.gne?tags=android,oreo&format=json&nojsoncallback=1"
        val getRawData = GetRawData(this)
        getRawData.execute(url)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.menu_settings -> true
            else ->  super.onOptionsItemSelected(item)
        }
    }

    override fun onDownloadComplete( data: String, status: DownloadStatus) {

        if (status == DownloadStatus.OK) {
            Log.d(TAG, "onDownloadComplete called , data is: $data")
        } else {
            Log.d(TAG, "onDownloadComplete failed with status : $status , error is: $data")
        }

    }

}
