package nl.videodock.mediasession;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;

public class MediaSessionCallback extends MediaSessionCompat.Callback {

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

    OnMediaSessionEventListener mListener;

    public void setMediaSessionEventListener(OnMediaSessionEventListener listener) {
        mListener = listener;
    }

    @Override
    public void onPlay() {
        super.onPlay();
        if (mListener != null) mListener.onPlay();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mListener != null) mListener.onPause();
    }

    @Override
    public void onSkipToNext() {
        super.onSkipToNext();
        if (mListener != null) mListener.onNext();
    }

    @Override
    public void onSkipToPrevious() {
        super.onSkipToPrevious();
        if (mListener != null) mListener.onPrev();
    }

    @Override
    public void onPlayFromMediaId(String mediaId, Bundle extras) {
        super.onPlayFromMediaId(mediaId, extras);
    }

    @Override
    public boolean onMediaButtonEvent(Intent mediaButtonIntent) {
        final KeyEvent event = (KeyEvent) mediaButtonIntent.getExtras().get(Intent.EXTRA_KEY_EVENT);

        if (event == null) {
            return super.onMediaButtonEvent(mediaButtonIntent);
        }

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            final int keyCode = event.getKeyCode();
            switch (keyCode) {
                case KeyEvent.KEYCODE_MEDIA_PAUSE:
                    if (mListener != null) mListener.onPause();
                    break;
                case KeyEvent.KEYCODE_MEDIA_PLAY:
                    if (mListener != null) mListener.onPlay();
                    break;
                case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
                    if (mListener != null) mListener.onPrev();
                    break;
                case KeyEvent.KEYCODE_MEDIA_NEXT:
                    if (mListener != null) mListener.onNext();
                    break;
                case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
                    if (mListener != null) mListener.onPlayPause();
                    break;
                case KeyEvent.KEYCODE_MEDIA_STOP:
                    if (mListener != null) mListener.onStop();
                    break;
                case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD:
                    if (mListener != null) mListener.onFastForward();
                    break;
                case KeyEvent.KEYCODE_MEDIA_REWIND:
                    if (mListener != null) mListener.onRewind();
                    break;
                default:
                    return super.onMediaButtonEvent(mediaButtonIntent);
            }
        }

        return true;
    }
}
