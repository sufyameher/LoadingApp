package com.example.loadingapp


import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.loadingapp.databinding.LoadingButtonBinding

class LoadingButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: LoadingButtonBinding =
         LoadingButtonBinding.inflate(LayoutInflater.from(context),this, true)

    private var loadingText: String = "Loading..."
    private var completeText: String = "Download Complete"

    init {
        // Apply custom attributes if available
        attrs?.let { applyCustomAttributes(it) }

        // Set up initial state
        binding.buttonText.text = "Start Loading"
        binding.progressBar.visibility = GONE
    }

    private fun applyCustomAttributes(attributeSet: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.LoadingButton)

        loadingText = typedArray.getString(R.styleable.LoadingButton_loadingText) ?: loadingText
        completeText = typedArray.getString(R.styleable.LoadingButton_completeText) ?: completeText

        typedArray.recycle()
    }

    fun startLoading() {
        binding.buttonText.text = loadingText
        binding.progressBar.visibility = VISIBLE
    }

    fun completeLoading() {
        binding.buttonText.text = completeText
        binding.progressBar.visibility = GONE
    }
}



//    private var widthSize = 0
//    private var heightSize = 0
//    private var txt = context.getString(R.string.download)
//    private var isClick = false
//    private var backgroundColorBtn = 0
//    private var btnLoadingColor = 0
//    private var tempColor = 0
//    private var animator: ValueAnimator? = null
//    private var currentSweepAngle = 0
//    private var textColor = 0
//    private var textSize = 0
//    private val rect: RectF = RectF(0f, 0f, 0f, 0f)

//    private val valueAnimator = ValueAnimator()
//
//    private var isLoading = false
//
//    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
//        style = Paint.Style.FILL
//        textAlign = Paint.Align.CENTER
//        typeface = Typeface.create("", Typeface.BOLD)
//    }

//    init {
//        isClick = true
//        context.withStyledAttributes(attrs, R.styleable.LoadingButton, defStyleAttr, 0).apply {
//            try {
//                textColor = getColor(R.styleable.LoadingButton_textColor, 0)
//                backgroundColorBtn = getColor(R.styleable.LoadingButton_backgroundColor, 0)
//                btnLoadingColor = getColor(R.styleable.LoadingButton_buttonLoadingColor, 0)
//                tempColor = backgroundColorBtn
//                textSize = getDimensionPixelSize(R.styleable.LoadingButton_textSize, 0)
//            } finally {
//                recycle()
//            }
//        }
//    }

//    private fun startAnimationCircle() {
//        animator?.cancel()
//        animator = ValueAnimator.ofInt(0, 360).apply {
//            duration = 2000
//            interpolator = LinearInterpolator()
//            addUpdateListener { valueAnimator ->
//                currentSweepAngle = valueAnimator.animatedValue as Int
//                invalidate()
//            }
//        }
//        animator?.start()
//    }

//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        paint.color = backgroundColorBtn
//        canvas?.drawRect(0.0F, 0.0F, widthSize.toFloat(), heightSize.toFloat(), paint)
//        paint.color = textColor
//        paint.textSize = textSize.toFloat()
//        canvas?.drawText(txt, widthSize / 2f, heightSize / 2 * 1.2f, paint)
//        // loading button
//        paint.color = btnLoadingColor
//        canvas?.drawRect(0f, 0f, widthSize * currentSweepAngle / 360f, heightSize.toFloat(), paint)
//        if (isClick) {
//            paint.color = textColor
//            rect.set(64f, heightSize / 3f, widthSize / 6f, heightSize / 2f)
//            canvas?.drawArc(
//                rect,
//                225f,
//                currentSweepAngle.toFloat(),
//                true,
//                paint
//            )
//        }
//    }

//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        val minw: Int = paddingLeft + paddingRight + suggestedMinimumWidth
//        val w: Int = resolveSizeAndState(minw, widthMeasureSpec, 1)
//        val h: Int = resolveSizeAndState(
//            MeasureSpec.getSize(w),
//            heightMeasureSpec,
//            0
//        )
//        widthSize = w
//        heightSize = h
//        setMeasuredDimension(w, h)
//    }

//    fun setLoading(loading: Boolean) {
//        isLoading = loading
//        if (loading) {
//            txt = context.getString(R.string.we_are_loading)
//            isClick = true
//            backgroundColorBtn = ContextCompat.getColor(context, R.color.purple_700)
//            startAnimationCircle()
//        } else {
//            backgroundColorBtn = tempColor
//            txt = context.getString(R.string.download)
//            isClick = false
//        }
//        invalidate()
//    }
//}



