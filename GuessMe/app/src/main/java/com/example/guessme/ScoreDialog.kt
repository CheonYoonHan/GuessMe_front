package com.example.guessme

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class ScoreDialog(context : Context) {
    private val dlg = Dialog(context)   //부모 액티비티의 context 가 들어감
    private lateinit var lblDesc : TextView
    private lateinit var btnOK : ImageButton
    private lateinit var listener : MyDialogOKClickedListener

    fun start(content : String) {
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        dlg.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dlg.setContentView(R.layout.dialog_score)     //다이얼로그에 사용할 xml 파일을 불러옴
        dlg.setCancelable(false)    //다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함



        lblDesc = dlg.findViewById(R.id.tv_score)
        lblDesc.text = content

        btnOK = dlg.findViewById(R.id.btn_score_enter)
        btnOK.setOnClickListener {
            dlg.dismiss()

        }


        dlg.show()
    }


//    fun setOnOKClickedListener(listener: (String) -> Unit) {
//        this.listener = object: MyDialogOKClickedListener {
//            override fun onOKClicked(content: String) {
//                listener(content)
//            }
//        }
//    }


    interface MyDialogOKClickedListener {
        fun onOKClicked(content : String)
    }
}