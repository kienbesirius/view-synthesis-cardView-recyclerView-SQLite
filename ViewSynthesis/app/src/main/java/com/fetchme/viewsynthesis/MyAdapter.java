package com.fetchme.viewsynthesis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    // 1 - Data Source
    private Context context;
    private ArrayList<Student> studentList;

    // 2 - Constructor
    public MyAdapter(Context context, ArrayList<Student> list) {
        this.context = context;
        this.studentList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Link the custom view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view_item_cardview_for_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = studentList.get(position);
        String name = "Name: " + student.getName();
        String birth = "DoB: " + student.getBirth();
        String university = "University: " + student.getUniversity();
        String sex = "Sex: " + student.getSex();
        String hobbies = "Hobby: " + student.getHobbies();
        int IMG = student.getIMG();
        holder.name.setText(name);
        holder.birth.setText(birth);
        holder.university.setText(university);
        holder.sex.setText(sex);
        holder.hobbies.setText(hobbies);
        Glide.with(holder.itemView).load(IMG).into(holder.IMG);

        holder.itemView.setOnClickListener(view -> {
            Toast.makeText(context, name.replace("Name: ", "") + " xin chào!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    // 3 - ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView IMG;
        private TextView name;
        private TextView birth;
        private TextView university;
        private TextView sex;
        private TextView hobbies;

        public ViewHolder(View itemView) {
            super(itemView);
            IMG = itemView.findViewById(R.id.imageVew_avatar);
            name = itemView.findViewById(R.id.textView_NAME);
            birth = itemView.findViewById(R.id.textView_BIRTH);
            university = itemView.findViewById(R.id.textView_UNIVERSITY);
            sex = itemView.findViewById(R.id.textView_SEX);
            hobbies = itemView.findViewById(R.id.textView_HOBBIES);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
