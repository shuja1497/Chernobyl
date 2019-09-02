package sarcastic.cule.topdownloader

import android.content.Context
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import kotlin.properties.Delegates

class FeedEntry {
    var name: String = ""
    var artist: String = ""
    var imageURL: String = ""
    var summary: String = ""
    var releaseDate: String = ""

    override fun toString(): String {
        return """
            name : $name
            artist : $artist
            release Date : $releaseDate
            image url : $imageURL
        """.trimIndent()
    }
}

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val downloadData by lazy { DownloadData(this, xmlListView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate")

        downloadData.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topMovies/xml")
        Log.d(TAG, "onCreate done")
    }

    override fun onDestroy() {
        super.onDestroy()
        downloadData.cancel(true)
    }

    companion object {
        // static class
        private class DownloadData(context: Context, listView: ListView) : AsyncTask<String, Void, String>() {
            private val TAG = "DownloadData"

            var context: Context by Delegates.notNull()
            var listView: ListView by Delegates.notNull()

            init {
                this.context = context
                this.listView = listView
            }

            override fun doInBackground(vararg params: String?): String {
                Log.d(TAG, "doInBackground: starts with ${params[0]}")

                val rssFeed = downloadXML(params[0])
                if (rssFeed.isEmpty()) {
                    Log.e(TAG, "doInBackground Error")
                }
                return rssFeed
            }

            override fun onPostExecute(result: String) {
                // runs in the main thread
                super.onPostExecute(result)
//                Log.d(TAG, "onPostExecute: parameter is $result")
                val parseApplications = ParseApplications()
                parseApplications.parse(result)

                val arrayAdapter = ArrayAdapter(context, R.layout.list_item, parseApplications.applications)
                listView.adapter = arrayAdapter

                
            }

            private fun downloadXML(urlPath: String?): String {
                return URL(urlPath).readText()
            }
        }
    }
}
