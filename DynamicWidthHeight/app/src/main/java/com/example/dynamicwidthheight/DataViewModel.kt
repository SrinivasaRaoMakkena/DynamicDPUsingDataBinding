package com.example.dynamicwidthheight

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import java.util.*

object DataViewModel {
    fun getItems(): List<Data> {
        var items = ArrayList<Data>()
        items.add(
            Data(
                title = "Item1",
                description = "This is the first item on the list",
                index = 1
            )
        )
        items.add(
            Data(
                title = "Item2",
                description = "This is the second item on the list",
                index = 2
            )
        )
        return items
    }

    fun getSingleItem(): List<Data> {
        var items = ArrayList<Data>()
        items.add(Data(title = "Item1", description = "This is the first item on the list"))
        return items
    }
}


data class Data(
    val title: String,
    val description: String,
    val index: Int = 1
) {

    val width: LayoutParamValue = if (index == 1) {
        LayoutParamValue((Resources.getSystem().displayMetrics.widthPixels - 32.toPx()))
    } else LayoutParamValue(240.toPx())

    val imageHeight: LayoutParamValue = if (index == 1) {
        LayoutParamValue(343.toPx())
    } else LayoutParamValue(300.toPx())

}

data class LayoutParamValue(val value: Int)

/**
 * Extension method to convert dip to pixel.
 */
fun Int.toPx(): Int {
    val displayMetrics = Resources.getSystem().displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), displayMetrics)
        .toInt()
}


/**
 * This method converts device specific pixels to density independent pixels.
 */
fun Int.toDp(): Int {
    return this / (Resources.getSystem().displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
}