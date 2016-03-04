package il.ac.huji.tipcalculator;


/*import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.view.ViewGroup;*/

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class TipCalculatorActivity extends Activity implements View.OnClickListener {

    private RelativeLayout lay;
    private CheckBox round;
    private EditText txtTipRes, inputNum;
    private Button calcButton;
    private double billAmount, tip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        lay = (RelativeLayout) findViewById(R.id.relLay);
        round = (CheckBox) findViewById(R.id.chkRound);
        inputNum = (EditText) findViewById(R.id.inputNum);
        calcButton = (Button) findViewById(R.id.btnCalculate);
        txtTipRes = (EditText)findViewById(R.id.txtTipResult);
        calcButton.setOnClickListener(this);


 /*       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_claculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == calcButton) {
            billAmount = Double.parseDouble(inputNum.getText().toString());
            tip = billAmount * 0.12;
            if (round.isChecked()) {
                tip = Math.round(tip);
            }
            //txtTipResult = new EditText(this);
            //txtTipRes.setText(String.format("%,.2f", tip));
            txtTipRes.setText("Tip: $" + String.format("%,.2f", tip));
            /*txtTipResult.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));*/
            //lay.addView(txtTipRes);

        }

    }


}

