package com.example.joketestnetworklessons8.core_ui

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.example.joketestnetworklessons8.core.view.HideAndShow

class CustomButton : AppCompatButton, HideAndShow {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context,attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context,attrs,defStyleAttr)

    override fun onSaveInstanceState(): Parcelable? = super.onSaveInstanceState()?.let{
        val visibilityState = VisibilityState(it)
        visibilityState.visible = visibility
        return visibilityState
    }
    override fun onRestoreInstanceState(state: Parcelable?) {
        val visibilityState = state as VisibilityState?
        super.onRestoreInstanceState(visibilityState?.superState)
        visibilityState?.let {
            visibility = it.visible
        }
    }
    override fun hide() {
        visibility = GONE
    }

    override fun show() {
        visibility = VISIBLE
    }
}