package com.example.circle

import android.content.Context
import android.graphics.*
import android.view.View

class Cir(context: Context?) : View(context) {
var pointA:PointF= PointF(500f,2800f)
    var pointB:PointF= PointF(500f,2800f)
   var ch='S'
    var ang=0f
    var dashed=false
    var ss=false
    var star=true
    var mdash= arrayOf(5f,10f,15f,20f,25f)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if(star)
        {
            var paint = Paint()
            paint.color = Color.BLACK
            paint.strokeWidth = 17.5f
            canvas!!.drawCircle(pointB.x,pointB.y,35f,paint)


            star=false
        }
     run {
            var paint = Paint()
            paint.color = Color.BLACK
            paint.strokeWidth = 5f
             if(ch=='S') {
                 canvas!!.rotate(ang, pointA.x, pointA.y)
                 ss=true
             }

            canvas!!.drawCircle(pointB.x, pointB.y, 20f, paint)
        }

        if(!dashed) {
            var paint = Paint()
            paint.color = Color.RED
            paint.strokeWidth = 20f
//            if(ch=='S')
//                canvas!!.rotate(ang,pointA.x,pointA.y)
            canvas!!.drawLine(pointA.x, pointA.y, pointB.x, pointB.y, paint)
            paint.color=Color.YELLOW
            canvas!!.drawCircle(pointB.x,pointB.y,15f,paint)
            if(ss) {
             ss=false
                canvas!!.rotate(-ang, pointB.x, pointB.y)
            }
        }
        else if(dashed){
            var dash=Paint()
            dash.color=Color.BLUE
            dash.strokeWidth=10f
            dash.setPathEffect(DashPathEffect(mdash.toFloatArray(),0f))

            canvas!!.drawLine(pointA.x, pointA.y, pointB.x, pointB.y, dash)
            dash.color=Color.YELLOW

            canvas!!.drawCircle(pointB.x,pointB.y,15f,dash)




        }
    }
    fun setPoint(  p:PointF,canvas: Canvas?,alt:Boolean,c:Char,angle:Float){
        pointA=pointB
        pointB=p
        dashed=alt
        ch=c
        ang=angle
        draw(canvas)


    }


}