package rcdavis.nycschools.util;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import rcdavis.nycschools.school.Address;

public class BindingUtils {
    @BindingAdapter("text")
    public static void setText(final TextView textView, final int val) {
        textView.setText(String.valueOf(val));
    }

    @BindingAdapter("text")
    public static void setText(final TextView textView, final Address address) {
        if (address == null)
            return;

        final String txt = address.getPrimaryAddressLine1() + ",\n" + address.getCity() + ", " +
                address.getStateCode() + " " + address.getZip();
        textView.setText(txt);
    }

    @BindingAdapter("phoneNumber")
    public static void setPhoneNumber(final TextView textView, final String val) {
        if (val == null)
            return;

        final String[] parts = val.split("-");
        if (parts.length < 3)
            return;

        final String finalNum = "(" + parts[0] + ") " + parts[1] + "-" + parts[2];
        textView.setText(finalNum);
    }
}
