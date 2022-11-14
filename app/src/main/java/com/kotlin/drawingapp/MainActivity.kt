package com.kotlin.drawingapp

import android.app.Dialog
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

  private var drawingView: DrawingView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    drawingView = findViewById(R.id.drawing_view)
    drawingView?.setSizeForBrush(20.toFloat())

    val ibBrush: ImageButton = findViewById(R.id.ib_brush)
    ibBrush.setOnClickListener{
      showBrushSizeChooserDialog()
    }
  }

  private fun showBrushSizeChooserDialog(){
    val brushDialog = Dialog(this)
    brushDialog.setContentView(R.layout.dialog_brush_size)
    brushDialog.setTitle("Brush size :")
    val smallBtn : ImageButton = brushDialog.findViewById(R.id.ib_small_brush)
    smallBtn.setOnClickListener {
      drawingView?.setSizeForBrush(10.toFloat())
      brushDialog.dismiss()
    }
    brushDialog.show()
  }
}