package me.ibrahimsn.smoothbottombar

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.text.Layout
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class GradientTextView(context: Context, attrs: AttributeSet) : AppCompatTextView(context, attrs) {
    private val startColor: Int
    private val endColor: Int
    private val strokeWidth: Float = 1f // Adjust this value for the glow effect

    init {
        // Obtain the custom attributes for startColor and endColor
        val typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.GradientTextView)

        // Get the start and end colors from the attributes
        startColor = typedArray.getColor(R.styleable.GradientTextView_startColor, 0)
        endColor = typedArray.getColor(R.styleable.GradientTextView_endColor, 0)

        // Recycle the typed array to avoid memory leaks
        typedArray.recycle()
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        // Create a Paint object for the text
        val textPaint = paint
        textPaint.color = currentTextColor
        textPaint.textSize = textSize

        // Get the layout to obtain text bounds
        val layout: Layout = layout

        // Draw the text multiple times with a slightly larger stroke to create a glow effect
        for (i in 0 until 2) { // You can adjust the number of passes as needed
            val glowPaint = Paint(textPaint)
            glowPaint.strokeWidth = strokeWidth + i * 2
            glowPaint.style = Paint.Style.STROKE
            glowPaint.shader = LinearGradient(
                0f, 0f, width.toFloat(), height.toFloat(),
                startColor, endColor, Shader.TileMode.CLAMP
            )

            // Calculate the text position based on the layout
            val x = layout.getLineLeft(0)
            val y = layout.getLineBaseline(0)

            // Draw the text on the canvas with the glow
            canvas?.drawText(text.toString(), x, y.toFloat(), glowPaint)
        }
        super.onDraw(canvas)
    }
}
