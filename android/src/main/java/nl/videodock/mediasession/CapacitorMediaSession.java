package nl.videodock.mediasession;

import android.content.Context;
import android.media.MediaMetadata;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;

import com.getcapacitor.JSObject;

import org.json.JSONException;

public class CapacitorMediaSession {

    private MediaSessionCompat mMediaSession;
    private MediaSessionCallback mMediaSessionCallback;

    public void initMediaSession(Context context, JSObject params, MediaSessionCallback.OnMediaSessionEventListener listener) {
        mMediaSession = new MediaSessionCompat(context, "CapacitorMediaSession");
        mMediaSessionCallback = new MediaSessionCallback();

        mMediaSession.setFlags(MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS | MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS);
        mMediaSessionCallback.setMediaSessionEventListener(listener);

        mMediaSession.setCallback(mMediaSessionCallback);
        mMediaSession.setActive(true);

        setMediaState(params);
    }

    public void releaseMediaSession() {
        if (mMediaSession != null) {
            mMediaSession.setActive(false);
            mMediaSession.release();

            mMediaSession = null;
            mMediaSessionCallback = null;
        }
    }

    public void setMediaState(JSObject params) {
        if (mMediaSession == null) {
            return;
        }

        try {
            final boolean isPlaying = params.getBoolean("isPlaying");
            final boolean isActive = params.optBoolean("isActive", true);
            final long position = params.optLong("position", PlaybackStateCompat.PLAYBACK_POSITION_UNKNOWN);
            final String title = params.getString("title");
            final String subtitle = params.getString("subtitle");
            final String artworkUri = params.getString("artworkUri");

            mMediaSession.setActive(isActive);

            long actions = PlaybackStateCompat.ACTION_PLAY_PAUSE;

            actions |= isPlaying ? PlaybackStateCompat.ACTION_PAUSE : PlaybackStateCompat.ACTION_PLAY;

            actions |= PlaybackStateCompat.ACTION_FAST_FORWARD |
                    PlaybackStateCompat.ACTION_REWIND;

            PlaybackStateCompat.Builder stateBuilder = new PlaybackStateCompat.Builder()
                    .setActions(actions);

            stateBuilder.setState(
                    isPlaying ? PlaybackStateCompat.STATE_PLAYING : PlaybackStateCompat.STATE_PAUSED,
                    position,
                    1.0f
            );

            mMediaSession.setPlaybackState(stateBuilder.build());

            MediaMetadataCompat.Builder metadataBuilder = new MediaMetadataCompat.Builder();

            metadataBuilder.putString(MediaMetadata.METADATA_KEY_DISPLAY_TITLE, title);
            metadataBuilder.putString(MediaMetadata.METADATA_KEY_DISPLAY_SUBTITLE, subtitle);
            metadataBuilder.putString(MediaMetadata.METADATA_KEY_ART_URI, artworkUri);

            mMediaSession.setMetadata(metadataBuilder.build());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
