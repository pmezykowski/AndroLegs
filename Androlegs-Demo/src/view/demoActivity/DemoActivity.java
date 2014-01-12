package view.demoActivity;

import java.util.ArrayList;

import pmezykowski.androlegs.demo.R;

import event.DeleteEvent;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androlegs.mvcs.view.activity.BaseAndrolegsActivity;

public class DemoActivity extends BaseAndrolegsActivity {

	private Button deleteAllButton;
	private Button deleteButton;

	private ListView listView;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_demo);
		deleteAllButton = (Button) findViewById(R.id.deleteAllButton);
		deleteButton = (Button) findViewById(R.id.deleteButton);
		
		listView = (ListView) findViewById(R.id.listView);
		
		
		deleteAllButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				removeAll();
			}
		});
		
		deleteButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				remove();
			}
		});
		
	}
	
	private void removeAll() {
		this.sendEventToMediator(new DeleteEvent(DeleteEvent.DELETE_ALL_ELEMENTS));
	}
	
	
	private void remove() {
		//TODO: implement something with sense
	}
	
	public void refresh(ArrayList<String> data) {
		listView.setAdapter(new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, data));
	}
}
