package com.example.dijingyu.oneweek_a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * 邸靖宇   130627200002041235
 */
public class MainActivity extends AppCompatActivity implements IView{

    private TextView mTv;
    private Toolbar mToolbar;
    private RecyclerView mRlv1;
    private RecyclerView mRlv2;
    private RlvAdapter mRlvAdapter;
    private RlvAdapter2 mRlvAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTv = findViewById(R.id.tv);
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mTv.setText("生活");
        mRlv1 = findViewById(R.id.rlv1);
        mRlv2 = findViewById(R.id.rlv2);
        mRlv1.setLayoutManager(new LinearLayoutManager(this));
        mRlv2.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Bean.T1348654151579Bean> list = new ArrayList<>();
        mRlvAdapter = new RlvAdapter(list);
        mRlvAdapter2 = new RlvAdapter2(list);

        mRlv1.setAdapter(mRlvAdapter);
        mRlv2.setAdapter(mRlvAdapter2);
        IPresenter iPresenter = new IPresenter(this);
        iPresenter.start();
        mRlvAdapter.setOnClickListener(new RlvAdapter.OnClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this,InfoActivity.class);
                intent.putExtra("data",mRlvAdapter.getList().get(position));
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });


        mRlvAdapter2.setOnClickListener(new RlvAdapter2.OnClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this,InfoActivity.class);
                intent.putExtra("data",mRlvAdapter2.getList().get(position));
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });
    }

    @Override
    public void success(Bean bean) {
        List<Bean.T1348654151579Bean> results = bean.getT1348654151579();
        ArrayList<Bean.T1348654151579Bean> list1 = new ArrayList<>();
        ArrayList<Bean.T1348654151579Bean> list2 = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            if (i>10){
                list1.add(results.get(i));
            }else {
                list2.add(results.get(i));
            }
        }
        mRlvAdapter.addData(list1);
        mRlvAdapter2.addData(list2);
    }

    @Override
    public void fail(String tips) {

    }
}
