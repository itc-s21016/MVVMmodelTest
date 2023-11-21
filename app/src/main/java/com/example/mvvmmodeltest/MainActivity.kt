package com.example.mvvmmodeltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.mvvmmodeltest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val blankViewModel: BlankViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DataBindingを行う場合はDataBindingUtilを使用します。
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        // ここで、xmlのdataタグで定義したnameが使えるようになります。
        // xml側でスネークケースで定義したnameが、こちら側ではキャメルケースで参照できます。
        // ex)「view_model」->「viewModel」
        binding.viewModel = blankViewModel

        //viewModelのプロパティ変更を監視する(observer)
        val observer = Observer<String> {
            binding.textView2.text = it
        }
        blankViewModel.hogeLiveData.observe(this, observer)
    }
}