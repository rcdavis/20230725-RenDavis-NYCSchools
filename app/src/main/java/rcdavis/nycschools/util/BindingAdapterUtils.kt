package rcdavis.nycschools.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import rcdavis.nycschools.school.Address

object BindingAdapterUtils {
    @BindingAdapter("text")
    @JvmStatic fun setText(textView: TextView, address: Address) {
        textView.text = address.toString()
    }

    @BindingAdapter("phoneNumber")
    @JvmStatic fun setPhoneNumber(textView: TextView, phoneNum: String) {
        val parts = phoneNum.split("-")
        if (parts.size < 3)
            return

        val text = "(" + parts[0] + ") " + parts[1] + "-" + parts[2]
        textView.text = text
    }
}
