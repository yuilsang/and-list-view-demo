package com.yuilsang.listviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    /**
     * 데모2 모델
     */
    data class Demo2Model(var title: String, var desc: String, var code: Int)

    /**
     * 데모2 어댑터
     */
    class Demo2DataListAdapter(var dataList: List<Demo2Model>): BaseAdapter() {
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val myListItemView = LayoutInflater.from(p2!!.context).inflate(R.layout.demo2_list_item, p2, false)
            myListItemView.findViewById<TextView>(R.id.title).text = dataList[p0].title
            myListItemView.findViewById<TextView>(R.id.desc).text = dataList[p0].desc
            return myListItemView
        }

        override fun getItem(p0: Int): Any {
            return dataList[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return dataList.size
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 데이터 구성
        var demo2ModelList = arrayListOf(
            Demo2Model("데모 1", "demo 0부터 100 까지 리스트뷰에 노출", 1),
            Demo2Model("데모 2", "data model 을 만들고 리스트뷰에 노출", 2)
        )

        // 어댑터 설정
        val demo2DataListAdapter = Demo2DataListAdapter(demo2ModelList)

        // 리스트 뷰 설정
        val listView = findViewById<ListView>(R.id.list_view)
        listView.adapter = demo2DataListAdapter

        // 이벤트 설정
        listView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(applicationContext, "${demo2ModelList[i].title} 선택됨", Toast.LENGTH_LONG).show()
        }
    }
}
