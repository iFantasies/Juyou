package com.github.juyou

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.SurfaceHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SurfaceHolder.Callback {
    private lateinit var mHolder: SurfaceHolder
    private lateinit var mPlayer: MediaPlayer
    private lateinit var mDialog: QRCodeDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDialog = QRCodeDialog(this)

        mPlayer = MediaPlayer()
        mPlayer.setDataSource("http://weixin.ugpal.com/static//video/20190221170422_wx4c693292cc475c99.o6zAJs891GEFJQTOImLvX75lBAHc.HkAtJSiTSSahbb9c55f1a0e4dccdc88f382e4464c419.mp4")

        mPlayer.isLooping = true
        mPlayer.prepareAsync()
        mPlayer.setOnPreparedListener {
            mPlayer.start()
        }

        mHolder = vSurfaceView.holder
        mHolder.setKeepScreenOn(true)
        mHolder.addCallback(this)

        //点餐
        rlOrder.setOnClickListener {
            mDialog.show()
        }

        //买单
        rlPayTheBill.setOnClickListener {
            mDialog.show()
        }

        //扫码充电
        rlRecharge.setOnClickListener {
            mDialog.show()
        }

        //社交活动
        rlSocialContact.setOnClickListener {
            mDialog.show()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }


    override fun surfaceDestroyed(holder: SurfaceHolder) {

    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        mPlayer.setDisplay(holder)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPlayer.stop()
        mPlayer.release()
    }
}
