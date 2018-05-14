package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
	ListView lv;
	ArrayList<Note> al;
	ArrayAdapter aa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO implement the Custom ListView
		lv = (ListView)findViewById(R.id.lv);
		DBHelper db = new DBHelper(SecondActivity.this);

		// Insert a task
		ArrayList<String> data = db.getNoteContent();
		db.close();

		DBHelper db2 = new DBHelper(SecondActivity.this);
		al = db2.getAllNotes();
		db2.close();

		aa = new RevisionNotesArrayAdapter(SecondActivity.this,R.layout.row, al);
		lv.setAdapter(aa);

	}


}
