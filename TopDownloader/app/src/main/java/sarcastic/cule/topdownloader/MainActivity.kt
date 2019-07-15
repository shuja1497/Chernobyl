package sarcastic.cule.topdownloader

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate")

        val downloadData = DownloadData()
        downloadData.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=10/xml")
        Log.d(TAG, "onCreate done")
    }

    companion object {
        // static class
        private class DownloadData : AsyncTask<String, Void, String>() {
            private val TAG = "DownloadData"

            override fun doInBackground(vararg params: String?): String {
                Log.d(TAG, "doInBackground: starts with ${params[0]}")

                val rssFeed = downloadXML(params[0])
                if (rssFeed.isEmpty()) {
                    Log.e(TAG, "doInBackground Error")
                }
                return rssFeed
            }

            override fun onPostExecute(result: String?) {
                // runs in the main thread
                super.onPostExecute(result)
                Log.d(TAG, "onPostExecute: parameter is $result")
            }

            private fun downloadXML(urlPath: String?): String {
                val xmlResult = StringBuilder()

                try {
                    val url = URL(urlPath)
                    val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
                    val response = connection.responseCode
                    Log.d(TAG, "downloadXml: Response code is $response")

//                    val reader = BufferedReader(InputStreamReader(connection.inputStream))
//                    // buffered reader reads characters
//                    val inputBuffer = CharArray(500)
//                    var charRead = 0
//
//                    while (charRead >= 0) {
//                        charRead = reader.read(inputBuffer) // no. of chars read from the stream
//                        if (charRead > 0) {
//                            xmlResult.append(String(inputBuffer, 0, charRead))
//                        }
//                    }
//                    reader.close() // close the buffer reader

                    connection.inputStream.buffered().reader().use { xmlResult.append(it.readText()) }

                    Log.d(TAG, "Received ${xmlResult.length} bytes")
                    return xmlResult.toString()

//                } catch (e: MalformedURLException) {
//                    Log.e(TAG, "downloadXml: Invalid url ${e.message}")
//                } catch (e: IOException) {
//                    Log.e(TAG, "downloadXml: IO Exception reading data: ${e.message}")
//                } catch (e: SecurityException) {
//                    Log.e(TAG, "Security exception. Needs Permission? : ${e.message}")
//                }
//                catch (e: Exception) {
//                    Log.e(TAG, "downloadXml: Unknown error ${e.message}")
//                }
                } catch (e: Exception) {

                    return when (e) {

                        is MalformedURLException -> "downloadXml: Invalid url ${e.message}"

                        is IOException -> "downloadXml: IO Exception reading data: ${e.message}"

                        is SecurityException -> {
                            e.printStackTrace()
                            "downloadXml: Security exception. Needs Permission? : ${e.message}"
                        }
                        else -> "downloadXml: Unknown error ${e.message}"
                    }
                }
            }
        }
    }
}
