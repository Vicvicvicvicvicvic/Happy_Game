package com.example.happygame

import android.content.Context
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View

open class OnSwipeListener(context: Context?) :View.OnTouchListener{

    var gestureDetector:GestureDetector

    override fun onTouch(p0: View?, motionEvent: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(motionEvent)
    }
    inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        var SWIPE_THRESOLD = 100
        var SWIPE_VELOCITY_THRESOLD = 100
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            var result = false

            var yDiff = e2.y -e1.y
            var xDiff = e2.x -e1.x

            if(Math.abs(xDiff) > Math.abs(yDiff)){

                if(Math.abs(xDiff) > SWIPE_THRESOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESOLD){
                    if(xDiff > 0){
                        onSwipeRight()
                    }
                    else{
                        onSwipeLeft()
                    }
                    result = true
                }
                }
            else if(Math.abs(yDiff) > SWIPE_THRESOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESOLD){
                if(yDiff < 0){
                    onSwipeTop()
                }
                else{
                    onSwipeBottom()
                }

                result = true
            }

            return result
        }

    }
    init {
        gestureDetector = GestureDetector(context,GestureListener())
    }

    open fun onSwipeBottom() {}

    open fun onSwipeTop() {}

    open fun onSwipeLeft() {}

    open fun onSwipeRight() {}


}