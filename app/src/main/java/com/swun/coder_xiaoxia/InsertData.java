package com.swun.coder_xiaoxia;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertData extends Activity {
	
	private EditText edtInsertId,edtInsertName,edtInsertSex;
	private String insertId,insertName,insertSex;//接受输入的信息
	private Button insertAll;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
        edtInsertId=(EditText) findViewById(R.id.insertId);
        edtInsertName=(EditText) findViewById(R.id.insertName);
        edtInsertSex=(EditText) findViewById(R.id.insertSex);
        insertAll=(Button) findViewById(R.id.insertAll);
        insertAll.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//获取向相应的参数值
				insertId=edtInsertId.getText().toString();
				insertName=edtInsertName.getText().toString();
				insertSex=edtInsertSex.getText().toString();
				//打开数据库输出流
		        SQLdemo s = new SQLdemo();
		        SQLiteDatabase db = s.openDatabase(getApplicationContext());
		        //执行SQL语句
		        db.execSQL("insert into stuinfo(stuId,name,sex)values(?,?,?)",
		        		new String[]{insertId,insertName,insertSex});
		        //下面的语句不能证明是否真的添加成功了 ，只是多一个显示效果而已
		        Toast.makeText(InsertData.this, "添加成功", Toast.LENGTH_LONG).show();
			}
		});
        

}
}
