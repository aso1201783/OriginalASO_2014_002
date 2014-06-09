package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MaintenanceActivity extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maintenance);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();

		Button btnMODORU = (Button)findViewById(R.id.btnMODORU);
		Button btnDELETE = (Button)findViewById(R.id.btnDELETE);

		btnMODORU.setOnClickListener(this);
		btnDELETE.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ

		Intent intent = null;

		switch(v.getId()){
		case R.id.btnMODORU:
			intent = new Intent(MaintenanceActivity.this, MainActivity.class);
			break;
		case R.id.btnDELETE:
			intent = new Intent(MaintenanceActivity.this, MaintenanceActivity.class);
			break;
		}
		startActivity(intent);

	}

}
