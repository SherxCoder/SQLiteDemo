package com.swun.coder_xiaoxia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{
	private Button mSerach,mDelete,mInsert;//搜索、删除、插入按钮
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mSerach=(Button) findViewById(R.id.search);
        mDelete=(Button) findViewById(R.id.delete);
        mInsert=(Button) findViewById(R.id.insert);
        
        //搜索
        mSerach.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this, SearchData.class);
				startActivity(intent);
			}
		
		});
        
        //插入
        mInsert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this, InsertData.class);
				startActivity(intent);
			}
		});
        //删除
        mDelete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this, DeleteData.class);
				startActivity(intent);
			}
		});
	}	
}
