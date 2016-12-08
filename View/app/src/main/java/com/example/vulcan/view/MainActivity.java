package com.example.vulcan.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
{
    Student student;
    List<String> mGrade;
    List<String> mName;
    RecyclerView mRecyclerView;
    HomeAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter());

    }

    protected void initData()
    {
        //实例化学生
        student = new Student();
        //添加学生信息
        student.add();
        //新建学生姓名、学号两个集合
        mGrade = new ArrayList<>();
        mName = new ArrayList<>();
        //把student里的信息导入到两个集合里
        for(int i = 0;i<student.grade.size();i++) {
            mName.add(student.name.get(i));
            mGrade.add(student.grade.get(i));
        }
    }


    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
    {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    MainActivity.this).inflate(R.layout.item, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position)
        {
            holder.tva.setText(mName.get(position));
            holder.tvb.setText(mGrade.get(position));
        }

        @Override
        public int getItemCount()
        {
            return mName.size();
        }

        class MyViewHolder extends ViewHolder
        {

            TextView tva;
            TextView tvb;

            public MyViewHolder(View view)
            {
                super(view);
                tva = (TextView) view.findViewById(R.id.id_num);
                tvb = (TextView)view.findViewById(R.id.id_gra);
            }
        }
    }

}