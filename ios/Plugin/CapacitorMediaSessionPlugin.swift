import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(CapacitorMediaSessionPlugin)
public class CapacitorMediaSessionPlugin: CAPPlugin {
    private let implementation;

    @objc func initMediaSession(_ call: CAPPluginCall) {
        implementation = NowPlayableBehavior()
        
        implementation.setNowPlayingMetadata(
            NowPlayableStaticMetadata(
                assetURL: URL.init(string: call.getString("test") ?? <#default value#>!),
                mediaType: .video,
                isLiveStream: <#T##Bool#>,
                title: <#T##String#>,
                artist: <#T##String?#>,
                artwork: <#T##MPMediaItemArtwork?#>,
                albumArtist: <#T##String?#>,
                albumTitle: <#T##String?#>));
    }
    
    @objc func releaseMediaSession(_ call: CAPPluginCall) {
        call.unimplemented();
    }
    
    @objc func setMediaState(_ call: CAPPluginCall) {
        call.unimplemented();
    }
}
