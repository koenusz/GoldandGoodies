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
import net.gg.goldandgoodies.encounter.isDead
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
    private var attackLocations: FloatArray = floatArrayOf()
    private var defenseLocations: FloatArray = floatArrayOf()
    private var hitpointsLocations: FloatArray = floatArrayOf()
    private var speedLocations: FloatArray = floatArrayOf()

    private val deadPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        style = Paint.Style.STROKE
        strokeWidth = 10F
    }

    private val attackPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        strokeWidth = 10F
        textSize = 55F
    }

    private val speedPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.MAGENTA
        strokeWidth = 10F
        textSize = 55F

    }

    private val defensePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.GRAY
        strokeWidth = 10F
        textSize = 55F

    }

    private val hitpointsPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        strokeWidth = 10F
        textSize = 55F

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (isDead(hero)) {
            canvas.drawLines(deadLocations, deadPaint)
        }
        canvas.drawText("A: " + hero.attack.toString(), attackLocations[0], attackLocations[1], attackPaint)
        canvas.drawText("S: " + hero.speed.toString(), speedLocations[0], speedLocations[1], speedPaint)
        canvas.drawText("HP: " + hero.speed.toString(), hitpointsLocations[0], hitpointsLocations[1], hitpointsPaint)
        canvas.drawText("D: " + hero.speed.toString(), defenseLocations[0], defenseLocations[1], defensePaint)

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        var xpad = (paddingLeft + paddingRight)
        val ypad = (paddingTop + paddingBottom)

        // Account for the label
        // if (mShowText) xpad += mTextWidth

        val ww = w - xpad
        val hh = h - ypad
        deadLocations = floatArrayOf(
                ww * 0.1F, hh * 0.2F, ww * 0.9F, hh * 0.8F,
                ww * 0.1F, hh * 0.8F, ww * 0.9F, hh * 0.2F
        )
        attackLocations = floatArrayOf(0F, hh * 0.1F)
        speedLocations = floatArrayOf(ww * 0.7F, hh * 0.1F)
        hitpointsLocations = floatArrayOf(0F, hh * 0.9F)
        defenseLocations = floatArrayOf(ww * 0.7F, hh * 0.9F)

    }
}