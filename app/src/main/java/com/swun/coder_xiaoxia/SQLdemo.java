package com.swun.coder_xiaoxia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;

/**
 * 这个类就是实现从assets目录读取数据库文件然后写入SDcard中,如果在SDcard中存在，就打开数据库，不存在就从assets目录下复制过去
 * @author Coder_xiaoxia
 *
 */
public class SQLdemo {

    //数据库存储路径
    private String filePath = "data/data/com.swun.coder_xiaoxia/Stu_repaired.db";
    private final String dbName="Stu_repaired.db";//数据库名字

    public SQLiteDatabase database;
    public  SQLiteDatabase openDatabase(Context context){
    	//根据filePath创建File实例，将filePath转化为虚拟目录
        File dbPath=new File(filePath);
        
        //查看数据库文件是否存在
        if(dbPath.exists()){
            //存在则直接返回打开的数据库
            return SQLiteDatabase.openOrCreateDatabase(dbPath, null);
        }else try {
                //得到资源
                AssetManager am= context.getAssets();
                //得到数据库的输入流
                InputStream is=am.open(dbName);
                //用输出流写到SDcard上面
                FileOutputStream fos=new FileOutputStream(dbPath);
                //创建byte数组  用于1KB写一次
                byte[] buffer=new byte[1024];
                int count = 0;
                while((count = is.read(buffer))>0){
                    fos.write(buffer,0,count);
                }
                //最后关闭就可以了
                fos.flush();
                fos.close();
                is.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
            //如果没有这个数据库  我们已经把他写到SD卡上了，然后在执行一次这个方法 就可以返回数据库了
            return openDatabase(context);
        }
    
}