package com.example.studentbiblio;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentbiblio.model.StudentInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class StudentDisplay extends AppCompatActivity {

    FirebaseDatabase database = null;
    DatabaseReference myRef = null;
    ImageView imageView;
    TextView name,course,cgpa,rollNumber;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_display);
        imageView = findViewById(R.id.stu_image);
        name = findViewById(R.id.stu_name);
        course = findViewById(R.id.stu_course);
        cgpa = findViewById(R.id.stu_cgpa);
        rollNumber = findViewById(R.id.roll_number);
        sharedPreferences = getSharedPreferences("myfile",MODE_PRIVATE);
        database  = FirebaseDatabase.getInstance();
        myRef = database.getReference("students");

        Intent intent = getIntent();
        StudentInfo stuInfo= (StudentInfo) intent.getSerializableExtra("StudentData");
        Log.i("Stu Info=",""+stuInfo.getPhoto());
        name.setText(stuInfo.getName());
        course.setText(stuInfo.getCourse());
        rollNumber.setText(stuInfo.getRollNumber());
        cgpa.setText(stuInfo.getCGPA().toString());
        Picasso.with(this).load(stuInfo.getPhoto()).placeholder(R.drawable.ic_launcher_background).fit().centerInside().into(imageView);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("StudentName","Name:"+stuInfo.getName()+"\n"+"Regd.No:"+stuInfo.getRollNumber()+"\n"+"CGPA:"+stuInfo.getCGPA());
        editor.apply();

        Intent widget_intent = new Intent(this, NewAppWidget.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        int[] ids = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(),NewAppWidget.class));
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
        sendBroadcast(widget_intent);
    }
}

