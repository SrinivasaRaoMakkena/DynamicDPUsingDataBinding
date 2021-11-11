package com.example.dynamicwidthheight

import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import androidx.databinding.BindingAdapter

class BindingAdapters {

    companion object {
        @BindingAdapter("android:layout_width")
        @JvmStatic
        fun setWidth(view: View, layoutParamValue: LayoutParamValue) {
            val params = view.layoutParams
            params.width = layoutParamValue.value
            view.layoutParams = params
        }

        @BindingAdapter("android:layout_height")
        @JvmStatic
        fun setHeight(view: View, layoutParamValue: LayoutParamValue) {
            val params = view.layoutParams
            params.height = layoutParamValue.value
            view.layoutParams = params
        }

        @BindingAdapter("android:layout_marginLeft")
        @JvmStatic
        fun setLeftMargin(view: View, leftMargin: Float) {
            val layoutParams = view.layoutParams as MarginLayoutParams
            layoutParams.setMargins(
                Math.round(leftMargin), layoutParams.topMargin,
                layoutParams.rightMargin, layoutParams.bottomMargin
            )
            view.layoutParams = layoutParams
        }

        @BindingAdapter("android:layout_marginRight")
        @JvmStatic
        fun setRightMargin(view: View, rightMargin: Float) {
            val layoutParams = view.layoutParams as MarginLayoutParams
            layoutParams.setMargins(
                layoutParams.leftMargin, layoutParams.topMargin,
                Math.round(rightMargin), layoutParams.bottomMargin
            )
            view.layoutParams = layoutParams
        }
    }
}