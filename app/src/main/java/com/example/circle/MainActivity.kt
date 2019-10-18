package com.example.circle

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.PointF
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
var mcircle:Cir?=null

    var p:PointF=PointF(500f,2800f)
    lateinit var mcontext:Context
    lateinit var mresource:Resources
    lateinit var bitmap:Bitmap
   lateinit var mcanvas:Canvas
    lateinit var img:ImageView
    var wid=3000
    var height=3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mcontext=applicationContext
        mresource=resources
         bitmap= Bitmap.createBitmap(wid,height,Bitmap.Config.ARGB_8888)
        img=findViewById(R.id.img)
         mcanvas=Canvas(bitmap)
      mcircle=Cir(this)
       mcircle!!.draw(mcanvas)
       img.setImageBitmap(bitmap)


    }


    fun callDraw(v: View){

var dis=0.0f
        var c:Char='S'
        var ang=0.0f

            p=PointF(p.x,p.y)
        if(dist!!.text!!.toString()!=null && dist!!.text!!.toString()!=null && angle!!.text!!.toString()!=null ) {
             dis = dist!!.text!!.toString().toFloat()
             var ss = direc!!.text!!.toString().toCharArray()
            c=ss[0]
             ang = angle!!.text!!.toString().toFloat()
        }
         var alt=false
        when(c.toUpperCase()){
            'S'->{
                p.x=p.x
                p.y=p.y-dis

            }
             'D'->{
                 p.x=p.x
                 p.y=p.y+dis

             }
            'L'->{
                p.x=p.x-dis
                p.y=p.y

            }
            'R'->{
                p.x=p.x+dis
                p.y=p.y

            }
            'A'->{
                p.x=p.x
                p.y=p.y-dis
                alt=true
            }
        }

        mcircle!!.setPoint(p,mcanvas,alt,c,ang)

        img.setImageBitmap(bitmap)
    }





    }


