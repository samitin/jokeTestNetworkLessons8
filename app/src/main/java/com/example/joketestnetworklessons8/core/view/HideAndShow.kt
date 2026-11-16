package com.example.joketestnetworklessons8.core.view

interface HideAndShow {
    fun hide()
    fun show()
}
interface ShowText : HideAndShow{
    fun showText(text : String)
}