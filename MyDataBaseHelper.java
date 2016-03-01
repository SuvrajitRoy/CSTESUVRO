package com.cste.nstu06.suvro.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by mosharrofrubel on 11/27/15.
 */
public class MyDataBaseHelper extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "MyCSEGuidDB";

    // Contacts table name
    private static final String TABLE_CSEDIC = "mycsetable";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TOPIC = "topic";
    private static final String KEY_DETAILS = "details";

    Context c;

    public MyDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating table
        String creating_table = "CREATE TABLE " + TABLE_CSEDIC + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TOPIC + " TEXT,"
                + KEY_DETAILS + " TEXT" + ")";
        db.execSQL(creating_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int j) {
// Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CSEDIC);

        // Create tables again
        onCreate(sqLiteDatabase);
    }




    // adding new data
    void addNewCseTopic(CSEGuide cseGuide) {
        SQLiteDatabase db = this.getWritableDatabase();


      //  This class is used to store a set of values that the ContentResolver can process.
        ContentValues values = new ContentValues();
        values.put(KEY_TOPIC, cseGuide.getTopic()); //  topic
        values.put(KEY_DETAILS, cseGuide.getDetails()); // details

        // Inserting Row
        db.insert(TABLE_CSEDIC, null, values);
        db.close(); // Closing database connection
    }



    //get topic from db
    public String[] getTopics(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_CSEDIC+";", null);
        res.moveToFirst();
        String[] p = new String[res.getCount()];

        if(res.moveToFirst()) {
            int i=0;
            do {
                p[i] = res.getString(res.getColumnIndex("topic"));
                i = i +1;
            } while(res.moveToNext());

        }
        return p;
    }


    public void deleteItem(String t){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CSEDIC, KEY_TOPIC+" =?", new String[] {t});
        db.close();
//        Toast.makeText(c,"Deleted Successfully!", Toast.LENGTH_LONG).show();

    }




}
