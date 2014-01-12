package view.demoActivity.inputFragment;

import pmezykowski.androlegs.demo.R;

import event.AddEvent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androlegs.mvcs.view.fragment.BaseAndrolegsFragment;

public class InputFragment extends BaseAndrolegsFragment {

	private EditText editTextView;
	private Button addButton;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_input, container, false);
		
		addButton = (Button) view.findViewById(R.id.addButton);
		editTextView = (EditText) view.findViewById(R.id.addingTextInput);
		
		addButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				add();
			}
		});
		
		return view;
	}
	
	private void add() {
		this.sendEventToMediator(new AddEvent(AddEvent.ADD_TEXT_ELEMENT, editTextView.getText().toString()));
	}

	public void clearTextField() {
		editTextView.setText("");
		
	}
}
