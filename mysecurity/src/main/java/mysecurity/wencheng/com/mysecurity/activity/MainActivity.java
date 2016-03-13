package mysecurity.wencheng.com.mysecurity.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mysecurity.wencheng.com.mysecurity.R;
import mysecurity.wencheng.com.mysecurity.adpter.MainRecyclerAdapter;
import mysecurity.wencheng.com.mysecurity.doman.MainInfo;

/**
 * Created by wang on 2016/3/11.
 */
public class MainActivity extends Activity {

    private ImageView mLogo;
    private TextView mSubTitle;
    private RecyclerView mRecyclerView;
    private List<MainInfo> mainInfoList;
    // 初始化图片
    private int[] ICONID = new int[]{R.drawable.sjfd, R.drawable.srlj,
            R.drawable.rjgj, R.drawable.jcgl, R.drawable.lltj, R.drawable.sjsd,
            R.drawable.hcql, R.drawable.cygj, R.drawable.szzx};
    // 标题
    private String[] TITLES = new String[]{"手机防盗", "骚扰拦截", "软件管理", "进程管理",
            "流量统计 ", "手机杀毒", "缓存清理", "常用工具", "常用设置"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAdapter();
        initView();
        initRecyclerView();

    }

    private void initView() {
        mLogo = (ImageView) findViewById(R.id.logo);
        mRecyclerView = (RecyclerView) findViewById(R.id.acti_main_recyclerview);
        mSubTitle = (TextView) findViewById(R.id.subtitle);

        setLogoAnimator();
    }

    private void initAdapter() {

        MainInfo mainInfo;
        mainInfoList = new ArrayList<MainInfo>();
        for (int i = 0; i < ICONID.length; i++) {
            mainInfo = new MainInfo(ICONID[i], TITLES[i]);
            mainInfoList.add(mainInfo);
        }

    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        MainRecyclerAdapter mainRecyclerAdapter = new MainRecyclerAdapter(this, mainInfoList);

        mRecyclerView.setAdapter(mainRecyclerAdapter);
    }

    private void setLogoAnimator() {
        ObjectAnimator anim = ObjectAnimator.ofFloat(mLogo, "rotationY", 0, 90, 270, 360);
        anim.setDuration(3000);
        anim.setRepeatCount(ObjectAnimator.INFINITE);
        anim.start();
    }


}
