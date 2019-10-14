package com.example.studentbiblio;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentbiblio.model.StudentInfo;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StudentSearch extends AppCompatActivity {

   /* private EditText mSearchField;
    private ImageButton mSearchBtn;
    FirebaseDatabase database = null;
    DatabaseReference myRe = null;
    private RecyclerView mResultList;
    private LinearLayoutManager linearLayoutManager;
    private FirebaseRecyclerAdapter adapter;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_search);
        /*database = FirebaseDatabase.getInstance();
        myRe = database.getReference("students");
        mSearchField = findViewById(R.id.search_field);
        mSearchBtn = findViewById(R.id.search_btn);
        mResultList = findViewById(R.id.result_list);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(this));

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String searchText = mSearchField.getText().toString();

               // firebaseUserSearch(searchText);

            }
        });
*/
    }

   /* private void firebaseUserSearch(String searchText) {

        Toast.makeText(StudentSearch.this, "Started Search", Toast.LENGTH_LONG).show();

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("RollNumber");

        FirebaseRecyclerOptions<StudentInfo> options =
                new FirebaseRecyclerOptions.Builder<StudentInfo>()
                        .setQuery(query, new SnapshotParser<StudentInfo>() {
                            @NonNull
                            @Override
                            public StudentInfo parseSnapshot(@NonNull DataSnapshot snapshot) {
                                return new StudentInfo(snapshot.child("RollNumber").getValue().toString());
                            }
                        })
                        .build();

        adapter = new FirebaseRecyclerAdapter<StudentInfo, ViewHolder>(options) {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.search_view, parent, false);

                return new ViewHolder(view);
            }


            @Override
            protected void onBindViewHolder(ViewHolder holder, final int position, StudentInfo model) {
                holder.setNumber(model.getRollNumber());

            }

        };
        mResultList.setAdapter(adapter);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView rollNumber;


        public ViewHolder(View itemView) {
            super(itemView);
            rollNumber = itemView.findViewById(R.id.number_text);
        }

        public void setNumber(String string) {
          rollNumber.setText(string);
        }

    }*/
}