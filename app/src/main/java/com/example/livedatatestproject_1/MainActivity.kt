package com.example.livedatatestproject_1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.livedatatestproject_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var number:Int = 0 //버튼을 클릭할 시 textView의 값을 1씩 증가시키기 위한 변수
    private lateinit var dataBinding : ActivityMainBinding //databinding 을 사용하여 MainActivity의 layout을 바인딩객체화.
    private val liveData:MutableLiveData<String> = MutableLiveData()  // liveData의 선언 및 초기화
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main) // databinding을 사용하여 view를 바인딩 시켜준다.

        //livedata의 변경을 감지하기 위한 옵저버 설정.
        //observer를 통해서 변경된 값을 얻어올 수 있다.
        //it은 liveData를 선언 및 생성할때 타입을 지정해주었던 형태의 값이다.
        liveData.observe(this, Observer {
            dataBinding.textTest.setText(it)
        })


        dataBinding.btnChange.setOnClickListener(View.OnClickListener {
            liveData.value = "highl ${++number}" //liveData의 값을 변경한다.
        })
    }
}