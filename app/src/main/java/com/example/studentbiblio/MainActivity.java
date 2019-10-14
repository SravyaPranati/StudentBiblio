package com.example.studentbiblio;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentbiblio.model.FacultyInfo;
import com.example.studentbiblio.model.StudentInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = null;
    DatabaseReference myRef = null;
    DatabaseReference faRef = null;
    List<StudentInfo> stuRoll;
    List<FacultyInfo> facultyInfo;
    EditText userName, passWord;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.edit_userid);
        passWord = findViewById(R.id.edit_passid);
        button  = findViewById(R.id.type);

        stuRoll = new ArrayList<>();
        facultyInfo = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("students");
        faRef = database.getReference("faculty");




        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                StudentInfo si = null;
                Toast.makeText(MainActivity.this, "" + dataSnapshot.getChildrenCount(), Toast.LENGTH_LONG).show();
                Log.i("Student Info:", "" + dataSnapshot.getChildrenCount());

                for (DataSnapshot dataSnapshotStu : dataSnapshot.getChildren()) {
                    si = dataSnapshotStu.getValue(StudentInfo.class);
                    stuRoll.add(si);
                    Log.i("Student Info:", si.toString());
                }

            }



                @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        faRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                FacultyInfo fa = null;
                Toast.makeText(MainActivity.this, "" + dataSnapshot.getChildrenCount(), Toast.LENGTH_LONG).show();
                Log.i("Faculty Info:", "" + dataSnapshot.getChildrenCount());

                for (DataSnapshot dataSnapshotFac:dataSnapshot.getChildren())
                {
                    fa = dataSnapshotFac.getValue(FacultyInfo.class);
                    facultyInfo.add(fa);
                    Log.i("Faculty Info:",fa.getString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void Type(View view) {

        for (StudentInfo rNumber : stuRoll) {
            if (userName.getText().toString().equals(rNumber.getRollNumber()) && passWord.getText().toString().equals(rNumber.getRollNumber())) {
                Intent intent = new Intent(this, StudentDisplay.class);
                intent.putExtra("StudentData",rNumber);
                startActivity(intent);
            }
        }
        for (FacultyInfo fNumber : facultyInfo) {
            if (userName.getText().toString().equals(fNumber.getFacultyId()) && passWord.getText().toString().equals(fNumber.getFacultyId())) {
                Intent intent = new Intent(this, FacultyDisplay.class);
                intent.putExtra("FacultyData",fNumber);
                startActivity(intent);
            }
        }
        Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
    }

}
