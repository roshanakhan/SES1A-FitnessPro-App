package com.example.roshanakhan.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class SearchActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private String[] recordArray;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private EditText etSearch;
    private Button btSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach);

        initView();

        // 获取搜索记录文件内容
        sp = PreferenceManager
                .getDefaultSharedPreferences(this);
        String records = sp.getString("records", "");
        // 用逗号分割内容返回数组
        recordArray = records.split(",");
        // 新建适配器，适配器数据为搜索历史文件内容
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, recordArray);
        listView.setAdapter(adapter);
    }

    private void initView() {
        listView = (ListView)findViewById(R.id.listview);
        etSearch = (EditText)findViewById(R.id.et_search);
        btSearch = (Button)findViewById(R.id.bt_search);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String keyword = recordArray[i];
                Intent data = new Intent();
                //返回数据写入到Intent中
                data.putExtra("keyword",keyword);
                //调用setResult接口
                setResult(RESULT_OK, data);
                finish();
            }
        });
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }
    private void save() {
        int n = 1;
        String text = etSearch.getText().toString().trim();
        if (TextUtils.isEmpty(text)){

            return;
        }
        String[] history_arr = new String[20];
        history_arr [0]=text;
        for (int i = 0; i < recordArray.length; i++) {
            if (!text.equals(recordArray[i])&&!"".equals(recordArray[i])) {
                if(n<19) {
                    history_arr[n] = recordArray[i];
                    n = n + 1;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < history_arr.length; i++) {
            if(history_arr[i]==null) {
                i=20;
            }else {
                sb.append(history_arr[i] + ",");
            }
        }
        sp.edit().putString("records", sb.toString()).commit();
        Intent data = new Intent();
        //返回数据写入到Intent中
        data.putExtra("keyword",text);
        //调用setResult接口
        setResult(RESULT_OK, data);
        finish();
    }
}

