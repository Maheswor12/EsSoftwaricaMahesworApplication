package com.example.essoftwaricamahesworapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.essoftwaricamahesworapplication.R;
import com.example.essoftwaricamahesworapplication.adapter.StudentAdapter;
import com.example.essoftwaricamahesworapplication.model.Student;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    static List<Student> studentList = new ArrayList<>();

    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);

        Student student = new Student("MAHESH", "KAPAN", "MALE", 34);
        studentList = student.getStudentList();

        if (studentList.isEmpty()) {
            studentList.add(new Student("Maheswor", "Kapan", "Male", 23));
            studentList.add(new Student("Manisha", "Kapan", "Female", 23));
            student.setStudentList(studentList);
        }
        StudentAdapter studentAdapter = new StudentAdapter(getActivity(), studentList);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

}