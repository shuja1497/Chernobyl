package sarcastic.cule.youtubeplayer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_standalone.*
import java.lang.IllegalArgumentException

class StandaloneActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_standalone)

        btnPlayVideo.setOnClickListener(this)
        btnPlayList.setOnClickListener(this)

    }

    override fun onClick(view: View) {

        val intent = when (view.id) {

            R.id.btnPlayVideo -> YouTubeStandalonePlayer.createVideoIntent(this,
                getString(R.string.GOOGLE_API_KEY), YOUTUBE_VIDEO_ID, 0, true, false)

            R.id.btnPlayList -> YouTubeStandalonePlayer.createPlaylistIntent(this,
                getString(R.string.GOOGLE_API_KEY), YOUTUBE_PLAYLIST, 0, 0, true, false)

            else -> throw IllegalArgumentException("undefined button click")

        }
        startActivity(intent)
    }
}