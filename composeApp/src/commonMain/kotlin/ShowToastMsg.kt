enum class ToastDurationType{
    SHORT,
    LONG
}

expect fun showToastMsg(msg:String,duration:ToastDurationType)