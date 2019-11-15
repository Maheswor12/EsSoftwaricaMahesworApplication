package com.example.essoftwaricamahesworapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.essoftwaricamahesworapplication.R;
import com.example.essoftwaricamahesworapplication.model.Student;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    Context mContext;
    List<Student> studentList;
    int imageid;

    public StudentAdapter(Context mContext, List<Student> studentList) {
        this.mContext = mContext;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.conten_list, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, final int position) {
        Student student = studentList.get(position);

        String gender = student.getGender();
        if (gender.equals("Female")) {
            imageid = R.drawable.noimage;
        } else if (gender.equals("Male")) {
            imageid = R.drawable.noimage;
        } else if (gender.equals("Others")) {
            imageid = R.drawable.noimage;
        }
        int age = student.getAge();
        holder.fullname.setText(student.getName());
        holder.age.setText(String.valueOf(age));
        holder.address.setText(student.getAddress());
        holder.gender.setText(student.getGender());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        public TextView fullname, age, address, gender;
        public Button btnDelete;
        CircleImageView imgProfile;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imageView);
            fullname = itemView.findViewById(R.id.textName);
            age = itemView.findViewById(R.id.textAge);
            address = itemView.findViewById(R.id.textAddress);
            gender = itemView.findViewById(R.id.txtGender);
            btnDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }
}
