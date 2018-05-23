package com.example.roshanakhan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class VideoMainActivity extends AppCompatActivity {

    private LinearLayout lvSerach;
    private List<Video> mVideos = new ArrayList<>();
    private RecyclerView recyclerview;
    private SerachAdapter adapter;
    private TextView tvKeyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initView() {
        lvSerach = (LinearLayout)findViewById(R.id.lv_serach);
        lvSerach. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VideoMainActivity.this,SearchActivity.class);
                startActivityForResult(intent,100);
            }
        });
        tvKeyword = (TextView)findViewById(R.id.tv_keyword);
        recyclerview = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new SerachAdapter(this,dataList);
        recyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(new SerachAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("url",dataList.get(position).getUrl());
                intent.setClass(VideoMainActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        mVideos.add(new Video("https://www.youtube.com/watch?v=JWy2-Dz7vJo","At Home HIIT Video","20 Minute HIIT Workout with Warm Up and Cool Down"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=eQW6z8kFp1Q","Upper Body Exercises for Toning and Strength","10 Minute Upper Body Workout"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=PJh9lPFppuo","HIIT and Strength Workout","HIIT Cardio and Butt and Thigh Workout"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=UJH0BkDdNWA","Fitness  Diet","Fitness Blender Grocery Haul - What Does Fitness Blender's Diet Look Like?"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=YyBcMVQylas","No Equipment Lower Body Workout","10 Minute Butt and Thigh Workout"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=NljaynACdxA","Fat Burning Butt and Thigh Workout","Strength Training Sweatfest for People Who Get Bored Easily"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=4thujUsx9pI","Pilates Abs, Butt and Thigh Workout","Intense Pilates Workout for Lower Body & Core"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=PBHBhvv-Lhg","At Home Workout","1000 Calorie Workout for 2 Million Subscribers! At Home Workout to Burn 1000 Calories"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=W91DKaoiJRk","At Home Upper Body Workout with Dumbbells","Upper Body Strength Training"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=F8UQEnOeotc","Eat Real Food","Harvest bowl with Chickpeas, Greens & Veggies"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=wCsvZwK_e_8","3 Day Flexibility Challenge Day 1","Fluid Full Body Stretches for Flexibility #FBreach"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=xCsETuMdp2w","3 Day Flexibility Challenge Day 2","Pilates Yoga Blend for Flexibility and Toning #FBreach"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=eV7hkrp9nII","3 Day Flexibility Challenge Day 3","Static Stretches for Flexibility & Range of Motion #FBreach"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=iNYoyOW9N6o&list=PL5lPziO_t_VhF3OSTYD6Dxda32DtW1lp2","Healthy packed lunch idea","Veggie & sweet potato quinoa salad"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=I5COzZlxaI4&list=PL5lPziO_t_VihSUj6jvYDHpt4ZcPhV2bg","1000 Calorie Workout Video","84 Min HIIT Cardio, Total Body Strength Training + Abs, Fitness Blender"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=DKZI-aTmH9I","Upper Body and Abs Workout","Compound Upper Body Workout for Strength and Coordination"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=I6pCg2MPr8k","1000 Calorie Workout","HIIT Cardio, Total Body Strength, Core Workout for 5 Million Subs!"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=DKZI-aTmH9I","Upper Body and Abs Workout","Compound Upper Body Workout for Strength and Coordination"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=0yZDVWab_dI","Fitness Blender 15 Minute Abs Workout","At Home Core Training without Equipment"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=Womx4TM6p3A","Leg Slimming Pilates","Leg Slimming Pilates Butt and Thigh Workout to Lift Glutes & Tone Thighs"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=rV-87UCJvoQ","Fat Burning Cardio Step Workout for Butt and Thighs","Step Aerobics Workout Video"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=qNAeuOs866Y","JENNY FORD","Beginner Step Aerobics Fitness Cardio"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=kx6fTrGb6hA","food","How I MEAL PREP my food (Recipes Included)"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=vA86WYkPOUY","Bodybuilding On A Budget","Cheap Bodybuilding Foods"));
        mVideos.add(new Video("https://www.youtube.com/watch?v=TvxNkmjdhMM","Plank","How to Plank"));




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100){
            if (resultCode ==RESULT_OK){
                String keyword = data.getStringExtra("keyword");
                search(keyword);
            }
        }
    }

    private List<Video> dataList = new ArrayList<>();
    private void search(String keyword) {
        tvKeyword.setText(keyword);
        dataList.clear();
        for (Video video : mVideos) {
            if (video.getTitle().toLowerCase().contains(keyword.toLowerCase())|| video.getDes().toLowerCase().contains(keyword.toLowerCase())){
                dataList.add(video);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
