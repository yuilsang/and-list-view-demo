package com.yuilsang.listviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 데이터 구성
        var demo1DataList = arrayListOf("Demo 0", "Demo 1", "Demo 2", "Demo 3")

        for (i in 4..100) {
            demo1DataList.add("Demo $i")
        }

        // 어댑터 설정
        val demo1DataListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, demo1DataList)

        // 리스트 뷰 설정
        val listView = findViewById<ListView>(R.id.list_view)
        listView.adapter = demo1DataListAdapter
    }
}
