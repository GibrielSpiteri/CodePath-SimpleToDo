package gibrielspiteri.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static gibrielspiteri.com.MainActivity.ITEM_POSITION;
import static gibrielspiteri.com.MainActivity.ITEM_TEXT;
public class EditItemActivity extends AppCompatActivity {

    //track edit text
    EditText etItemText;
    //position of edited item
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        //resolve edit text from layout
        etItemText =  findViewById(R.id.etItemText);
        etItemText.setText(getIntent().getStringExtra(ITEM_TEXT));
        position = getIntent().getIntExtra(ITEM_POSITION, 0);
        //update the title bar of the activity
        try {
            getSupportActionBar().setTitle("Edit Item");
        }catch(NullPointerException e){
            Log.e("EditItemActivity", "Null Pointer", e);
        }
    }

    public void onSaveItem(View v){
        //prepare new intent for result
        Intent i = new Intent();
        //pass updated item text as extra
        i.putExtra(ITEM_TEXT, etItemText.getText().toString());
        //pass original position as extra
        i.putExtra(ITEM_POSITION, position);
        //set the intent as the result of the activity
        setResult(RESULT_OK, i);
        //close the activity and redirect to main
        finish();
    }
}
