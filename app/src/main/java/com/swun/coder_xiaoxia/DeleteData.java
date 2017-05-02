package com.swun.coder_xiaoxia;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteData extends Activity {
	private EditText edtDeleteData;
	private String strDeleteData;//接收要删除的数据
	private Button btuDeleteData;//删除按钮
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        edtDeleteData=(EditText) findViewById(R.id.edtDeletedata);
        btuDeleteData=(Button) findViewById(R.id.btuDeleteData);
        btuDeleteData.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				strDeleteData=edtDeleteData.getText().toString();//接受要删除的信息
				//打开数据库输出流
		        SQLdemo s = new SQLdemo();
		        SQLiteDatabase db = s.openDatabase(getApplicationContext());
		        //执行SQL语句
		        db.execSQL("delete from stuinfo where stuid=?",new String[]{strDeleteData});
		        //下面的语句不能证明是否真的删除成功了 ，只是多一个显示效果而已
		        Toast.makeText(DeleteData.this, "删除成功", Toast.LENGTH_LONG).show();
			}
		});

}
}
