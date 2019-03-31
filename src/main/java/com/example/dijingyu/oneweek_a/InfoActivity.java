package com.example.dijingyu.oneweek_a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;

public class InfoActivity extends AppCompatActivity {

    private ImageView mIv;
    private TextView mTvName;
    private TextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        Bean.T1348654151579Bean data = (Bean.T1348654151579Bean) intent.getSerializableExtra("data");
        mIv = findViewById(R.id.iv);
        mTvName = findViewById(R.id.tv_name);
        mTvTitle = findViewById(R.id.tv_title);
        mTvName.setText(data.getSource());
        mTvTitle.setText(data.getTitle());
        Glide.with(this).load(data.getImgsrc()).into(mIv);
    }
}
