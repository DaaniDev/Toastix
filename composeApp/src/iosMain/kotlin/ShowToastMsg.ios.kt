import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.CoreGraphics.CGPointMake
import platform.UIKit.*
import platform.CoreGraphics.CGRectMake
import platform.Foundation.*

@OptIn(ExperimentalForeignApi::class)
actual fun showToastMsg(msg: String, duration: ToastDurationType) {

    val animationDuration = when (duration) {
        ToastDurationType.SHORT -> 6.0
        ToastDurationType.LONG -> 10.0
    }
    val rootViewController = UIApplication.sharedApplication.keyWindow?.rootViewController
    val toastLabel = UILabel(frame = CGRectMake(0.0, 0.0, UIScreen.mainScreen.bounds.useContents { size.width } - 40, 35.0))
    toastLabel.center = CGPointMake(UIScreen.mainScreen.bounds.useContents { size.width } / 2, UIScreen.mainScreen.bounds.useContents { size.height } - 100.0)
    toastLabel.textAlignment = NSTextAlignmentCenter
    toastLabel.backgroundColor = UIColor.blackColor.colorWithAlphaComponent(0.6)
    toastLabel.textColor = UIColor.whiteColor
    toastLabel.text = msg
    toastLabel.alpha = 1.0
    toastLabel.layer.cornerRadius = 15.0
    toastLabel.clipsToBounds = true
    rootViewController?.view?.addSubview(toastLabel)

    UIView.animateWithDuration(
        animationDuration,
        delay = 0.1,
        options = UIViewAnimationOptionCurveEaseOut,
        animations = {
            toastLabel.alpha = 0.0
        },
        completion = {
            if (it)
                toastLabel.removeFromSuperview()
        })
}