package nl.videodock.mediasession;

import android.view.KeyEvent;

public interface OnMediaSessionEventListener {
    void onPlay();
    void onPause();
    void onPlayPause();
    void onStop();
    void onNext();
    void onPrev();
    void onFastForward();
    void onRewind();
}
