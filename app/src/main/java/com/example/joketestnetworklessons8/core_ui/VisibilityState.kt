package com.example.joketestnetworklessons8.core_ui

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.View.BaseSavedState

class VisibilityState : BaseSavedState {

    var visible : Int = View.VISIBLE

    constructor(superState : Parcelable) : super(superState)

    private constructor(parcelIn: Parcel) : super(parcelIn){
        visible = parcelIn.readInt()
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeInt(visible)
    }
    companion object CREATOR : Parcelable.Creator<VisibilityState>{

        override fun createFromParcel(source: Parcel): VisibilityState = VisibilityState(source)

        override fun newArray(size: Int): Array<VisibilityState?> = arrayOfNulls(size)

    }
}