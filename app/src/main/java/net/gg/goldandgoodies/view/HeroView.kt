package net.gg.goldandgoodies.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.icu.text.MessagePattern
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.widget.ImageView
import net.gg.goldandgoodies.R
import net.gg.goldandgoodies.encounter.Hero
import java.util.jar.Attributes

class HeroView : ImageView {


    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attributeSet, defStyleAttr, defStyleRes)

    var hero = Hero(Hero.HeroType.DWARVEN_AXEBEARER, -1, -1, -1, -1, listOf())
        set(value) {
            field = value
            invalidate()
            requestLayout()
        }

    private var deadLocations: FloatArray = floatArrayOf()
    private val deadPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        style = Paint.Style.STROKE
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawLines(deadLocations, deadPaint)

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        var xpad = (paddingLeft + paddingRight).toFloat()
        val ypad = (paddingTop + paddingBottom).toFloat()

        // Account for the label
        // if (mShowText) xpad += mTextWidth

        val ww = w as Float - xpad
        val hh = h as Float - ypad
        deadLocations = floatArrayOf(
                ww * 0.1F, hh * 0.1F, ww * 0.9F, hh * 0.9F,
                ww * 0.1F, hh * 0.9F, ww * 0.9F, hh * 0.1F
        )

    }
}