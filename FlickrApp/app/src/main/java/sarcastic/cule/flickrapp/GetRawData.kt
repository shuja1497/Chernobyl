package sarcastic.cule.flickrapp

import android.os.AsyncTask
import android.util.Log
import java.io.IOException
import java.lang.Exception
import java.net.MalformedURLException
import java.net.URL

enum class DownloadStatus {
    OK, IDLE, NOT_INITIALIZED, FAILED_OR_EMPTY, PERMISSIONS_ERROR, ERROR
}


class GetRawData : AsyncTask<String, Void, String>() {

    private val TAG = "GetRawData"
    private var downloadstatus  = DownloadStatus.IDLE

    override fun onPostExecute(result: String?) {
        Log.d(TAG, "onPostExecute called with paramters: $result")
    }

    override fun doInBackground(vararg params: String?): String {

        if (params[0] == null) {
            downloadstatus = DownloadStatus.NOT_INITIALIZED
            return "No url specified"
        }

        try {
            downloadstatus = DownloadStatus.OK
            return URL(params[0]).readText()
        } catch (e: Exception) {

            val errorMessage  = when (e) {

                is MalformedURLException -> {
                    downloadstatus = DownloadStatus.NOT_INITIALIZED
                    "doInBackground: Invalid URL ${e.message}"
                }

                is IOException -> {
                    downloadstatus = DownloadStatus.FAILED_OR_EMPTY
                    "doInBackground: IO exception reading data. ${e.message}"
                }

                is SecurityException -> {
                    downloadstatus = DownloadStatus.PERMISSIONS_ERROR
                    "doInBackground: Security exception. ${e.message}"
                }

                else -> {
                    downloadstatus = DownloadStatus.ERROR
                    "doInBackground: Unknown error. ${e.message}"
                }
            }

            Log.e(TAG, errorMessage)
            return errorMessage
        }
    }
}