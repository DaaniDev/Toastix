import android.widget.Toast
import org.daanidev.toastix.MyApplication

actual fun showToastMsg(msg: String, duration: ToastDurationType) {

    val mContext = MyApplication.instance
    mContext?.let {
        when(duration){
            ToastDurationType.SHORT -> Toast.makeText(it,msg,Toast.LENGTH_SHORT).show()
            ToastDurationType.LONG -> Toast.makeText(it,msg,Toast.LENGTH_LONG).show()
        }
    }
}