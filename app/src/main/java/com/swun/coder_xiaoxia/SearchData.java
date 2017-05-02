package com.swun.coder_xiaoxia;

/**
 * Created by Administrator on 2016/11/21.
 */
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchData extends Activity {
    /**
     * Called when the activity is first created.
     */
	
	
	private Button mBtnSearch;//搜索按钮
	private TextView textv ;//搜索结果显示窗口
	private EditText searchId;//搜索输入框
	private String Stuid;//搜索字符串
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        mBtnSearch=(Button) findViewById(R.id.search);
        textv=(TextView) findViewById(R.id.textv);
        searchId=(EditText) findViewById(R.id.searchId);
        mBtnSearch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//打开数据库输出流
		        SQLdemo s = new SQLdemo();
		        SQLiteDatabase db = s.openDatabase(getApplicationContext());
		        Stuid=searchId.getText().toString();
		        //查询数据库中的数据
		        Cursor cursor = db.rawQuery("select * from stuinfo where stuid=?", new String[]{Stuid});
		        String name = null;
		        if (cursor.moveToFirst()) {
		            name = cursor.getString(cursor.getColumnIndex("name"));
		        }else{
		        	Toast.makeText(getBaseContext(), "查询失败，数据不存在！", Toast.LENGTH_LONG).show();
		        }
		        //这是一个TextView，把得到的数据库中的name显示出来.
		        textv.setText(name);
		        cursor.close();
			}
		});

        
    }
}