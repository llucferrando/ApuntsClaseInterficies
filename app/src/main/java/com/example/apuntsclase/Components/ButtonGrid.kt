package com.example.apuntsclase.Components;

import android.content.Context
import android.widget.Button
import android.widget.LinearLayout;
import com.example.apuntsclase.R

public class ButtonGrid(val context: Context, val parent: LinearLayout) {
    class ButtonsRow (val context: Context,val parent: LinearLayout){
        var buttons: MutableList<Button> = mutableListOf()
        private val _linearLayout: LinearLayout = LinearLayout(context)
        init{
            _linearLayout.orientation = LinearLayout.HORIZONTAL
            _linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1.0f

            )
            _linearLayout.setBackgroundColor(context.getColor(R.color.teal_200))
            parent.addView(_linearLayout)
        }
        fun AddNewButton(text:String) : Button {
            var _bt = Button(context)
            _bt.text = text
            _bt.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1.0f
            )
            _linearLayout.addView(_bt)
            buttons.add(_bt)

            return _bt
        }


    }

    private var rows: MutableList<ButtonsRow> = mutableListOf()
    fun AddNewRow() : ButtonsRow {
        val btRow = ButtonsRow(context,parent)
        rows.add(btRow)

        return btRow
    }

    fun GetRow(index: Int): ButtonsRow? {
        if (index >= rows.count() || index < 0) {
            return null

        }

        return rows[index]
    }

}