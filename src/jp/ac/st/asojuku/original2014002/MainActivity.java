package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();

		Button btnOK = (Button)findViewById(R.id.btnOK);
		Button btnMENTE = (Button)findViewById(R.id.btnMENTE);
		Button btnHITOKOTO = (Button)findViewById(R.id.btnHITOKOTO);

		btnOK.setOnClickListener(this);
		btnMENTE.setOnClickListener(this);
		btnHITOKOTO.setOnClickListener(this);

		if(sdb == null) {
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try{
			sdb = helper.getWritableDatabase();
		}catch(SQLiteException e){
			return;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ

		Intent intent = null;

		switch(v.getId()){
		case R.id.btnOK:
			EditText etv = (EditText)findViewById(R.id.edtHITOKOTO);
			String inputMsg = etv.getText().toString();

			if(inputMsg!=null && !inputMsg.isEmpty()){
				helper.insertHitokoto(sdb, inputMsg);
			}

			etv.setText("");
			break;
		case R.id.btnMENTE:
			intent = new Intent(MainActivity.this, MaintenanceActivity.class);
			startActivity(intent);
			break;
		case R.id.btnHITOKOTO:
			String strHitokoto = helper.selectRandomHitokoto(sdb);

			intent = new Intent(MainActivity.this, HitokotoActivity.class);
			intent.putExtra("hitokoto", strHitokoto);

			startActivity(intent);
			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
