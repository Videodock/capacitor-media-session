import Foundation

@objc
public class CapacitorMediaSession: NSObject {
    
    @objc
    public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
