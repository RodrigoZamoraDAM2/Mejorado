import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool

object AudioPlay {
    lateinit var mp: MediaPlayer
    private var soundPool: SoundPool? = null
    var isplayingAudio = false
    var disabled = false

    fun playAudio(c: Context?, id: Int) {
        mp = MediaPlayer.create(c, id)
        soundPool = SoundPool(4, AudioManager.STREAM_MUSIC, 100)

        if (!mp.isPlaying && !disabled) {
            isplayingAudio = true
            mp.start()
        }
    }

    fun stopAudio() {
        isplayingAudio = false
        mp!!.stop()
    }
}