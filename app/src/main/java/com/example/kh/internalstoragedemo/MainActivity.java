package com.example.kh.internalstoragedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kh.internalstoragedemo.Module.InternalOperationHelper;
import com.example.kh.internalstoragedemo.ViewHolder.View_Holder_main;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME ="MYDATA" ;
    View_Holder_main holder ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        holder = new View_Holder_main();
        holder.txt = (TextView) findViewById(R.id.txtdata);
        holder.btnInternalStoreage = (Button) findViewById(R.id.btninternalstorage);
        holder.btnShowdata = (Button) findViewById(R.id.btnshowdata);
        holder.etdataflow = (EditText) findViewById(R.id.etdataflow);
        holder.btnInternalStoreage.setOnClickListener(onclicklistener);
        holder.btnShowdata.setOnClickListener(onclicklistener);

    }
    private View.OnClickListener onclicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btninternalstorage:
                    try {
                        InternalOperationHelper.getInstance().setData(holder.etdataflow.getText().toString().trim(), FILE_NAME,getApplicationContext());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.btnshowdata:
                    try {
                     String data=   InternalOperationHelper.getInstance().getData(FILE_NAME,getApplicationContext());
                        holder.txt.setText(data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };
}
