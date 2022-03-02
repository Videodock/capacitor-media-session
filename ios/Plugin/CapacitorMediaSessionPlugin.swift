import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(CapacitorMediaSessionPlugin)
public class CapacitorMediaSessionPlugin: CAPPlugin {
    private let implementation = CapacitorMediaSession()

    @objc func initMediaSession(_ call: CAPPluginCall) {
        call.unimplemented();
    }
    
    @objc func releaseMediaSession(_ call: CAPPluginCall) {
        call.unimplemented();
    }
    
    @objc func setMediaState(_ call: CAPPluginCall) {
        call.unimplemented();
    }
}
