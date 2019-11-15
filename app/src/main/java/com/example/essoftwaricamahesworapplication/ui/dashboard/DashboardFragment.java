package com.example.essoftwaricamahesworapplication.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.essoftwaricamahesworapplication.LoginActivity;
import com.example.essoftwaricamahesworapplication.MainActivity;
import com.example.essoftwaricamahesworapplication.R;
import com.example.essoftwaricamahesworapplication.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    EditText txtName, txtAge, txtAddress;
    Button btnSubmit;
    RadioGroup gender_radio_group;
    RadioButton radioMale, radioFemale, radioOthers;
    String Gender;
    static List<Student> studentList = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        txtName = view.findViewById(R.id.txtName);
        txtAge = view.findViewById(R.id.txtAge);
        txtAddress = view.findViewById(R.id.txtAddress);
        gender_radio_group = view.findViewById(R.id.gender_radio_group);
        radioMale = view.findViewById(R.id.radioMale);
        radioFemale = view.findViewById(R.id.radioFemale);
        radioOthers = view.findViewById(R.id.radioOthers);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSubmit) {
            if (TextUtils.isEmpty(txtName.getText().toString())) {
                txtName.setError("Enter Username");
                txtName.requestFocus();
                return;
            } else if (txtName.length() < 3) {
                txtName.setError("at least 3 characters");
                txtName.requestFocus();
                return;
            } else if (TextUtils.isEmpty(txtAge.getText().toString())) {
                txtAge.setError("Enter your age");
                txtAge.requestFocus();
                return;
            } else if (TextUtils.isEmpty(txtAddress.getText().toString())) {
                txtAddress.setError("Enter address");
                txtAddress.requestFocus();
                return;
            }

            String Fullname = txtName.getText().toString().trim();
            String Age = txtAge.getText().toString().trim();
            String Address = txtAddress.getText().toString().trim();


            if (radioMale.isChecked()) {
                Gender = "Male";
            }
            if (radioFemale.isChecked()) {
                Gender = "Female";
            }
            if (radioOthers.isChecked()) {
                Gender = "Others";
            }

            Student student = new Student(Fullname, Address, Gender, Integer.parseInt(Age));
            studentList = student.getStudentList();
            studentList.add(student);
            student.setStudentList(studentList);
            Toast.makeText(getActivity(), "Added Successfully: " + Fullname, Toast.LENGTH_SHORT).show();
        }


    }
}

