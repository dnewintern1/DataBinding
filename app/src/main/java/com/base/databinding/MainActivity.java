package com.base.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.base.databinding.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ClickEventHandler mClickEventHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        activityMainBinding.setMyviewmodel(new MyViewModel());
        activityMainBinding.getMyviewmodel().taskname = "Programming";

        activityMainBinding.setTaskCategory("Bussiness");

        activityMainBinding.txtTaskColor.setText("RED");

        activityMainBinding.setClickEventHandler(mClickEventHandler);


    }



    public class ClickEventHandler {

        private Context mContext;

        public ClickEventHandler(Context context) {

            this.mContext = context;
        }

        public void textViewClick(View view) {

            Toast.makeText(mContext, "TextView clicked", Toast.LENGTH_SHORT).show();

        }

        public void textViewClickWithParams(View view, String category) {
            Toast.makeText(mContext, category, Toast.LENGTH_SHORT).show();

        }

    }
}