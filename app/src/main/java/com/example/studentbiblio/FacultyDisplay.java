package com.example.studentbiblio;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentbiblio.model.FacultyInfo;
import com.squareup.picasso.Picasso;

public class FacultyDisplay extends AppCompatActivity {

    TextView fView,dView;
    ImageView imageView;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_display);
        fView = findViewById(R.id.fac_name);
        dView = findViewById(R.id.fac_des);
        imageView = findViewById(R.id.fac_image);
        sharedPreferences = getSharedPreferences("file",MODE_PRIVATE);
        Intent intent = getIntent();
        FacultyInfo facultyInfo = (FacultyInfo) intent.getSerializableExtra("FacultyData");
        fView.setText(facultyInfo.getFacultyName());
        dView.setText(facultyInfo.getDesignation());
        Picasso.with(this).load(facultyInfo.getPhoto()).placeholder(R.drawable.ic_launcher_background).fit().centerInside().into(imageView);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("FacultyName",facultyInfo.getFacultyName()+"\n"+facultyInfo.getFacultyId()+facultyInfo.getDesignation());
        editor.apply();

        Intent widget_intent = new Intent(this, NewAppWidget.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        int[] ids = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(),NewAppWidget.class));
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
        sendBroadcast(widget_intent);
    }

    public void search(View view) {
        Intent intent = new Intent(this,StudentSearch.class);
        startActivity(intent);
    }
}
