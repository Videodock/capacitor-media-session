package nl.videodock.mediasession;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "CapacitorMediaSession")
public class CapacitorMediaSessionPlugin extends Plugin {

    private CapacitorMediaSession implementation = new CapacitorMediaSession();

    public void triggerPluginEvent(String eventName) {
        bridge.triggerWindowJSEvent("mediaSessionEvent", "{ 'eventName': '"+eventName+"' }");

        JSObject eventData = new JSObject();
        eventData.put("eventName", eventName);

        notifyListeners("mediaSessionEvent", eventData);
    }

    @PluginMethod
    public void initMediaSession(PluginCall call) {
        JSObject params = call.getData();

        implementation.initMediaSession(getContext(), params, new MediaSessionCallback.OnMediaSessionEventListener() {
            @Override
            public void onPlay() {
                triggerPluginEvent("onPlay");
            }

            @Override
            public void onPause() {
                triggerPluginEvent("onPause");
            }

            @Override
            public void onPlayPause() {
                triggerPluginEvent("onPlayPause");
            }

            @Override
            public void onStop() {
                triggerPluginEvent("onStop");
            }

            @Override
            public void onNext() {
                triggerPluginEvent("onNext");
            }

            @Override
            public void onPrev() {
                triggerPluginEvent("onPrev");
            }

            @Override
            public void onFastForward() {
                triggerPluginEvent("onFastForward");
            }

            @Override
            public void onRewind() {
                triggerPluginEvent("onRewind");
            }
        });

        call.resolve();
    }

    @PluginMethod
    public void releaseMediaSession(PluginCall call) {
        implementation.releaseMediaSession();

        call.resolve();
    }

    @PluginMethod
    public void setMediaState(PluginCall call) {
        JSObject params = call.getData();

        implementation.setMediaState(params);

        call.resolve();
    }
}
