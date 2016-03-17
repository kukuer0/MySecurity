package mysecurity.wencheng.com.mysecurity.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import mysecurity.wencheng.com.mysecurity.R;

/**
 * Created by wang on 2016/3/16.
 */
public class BaseFragment extends Fragment implements View.OnClickListener {

    private View mView;
    public TextView mTitle;
    public LinearLayout mContainer;
    public ImageView mIconCore;
    public Button mForth;
    public Button mBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = View.inflate(getActivity(), R.layout.activity_zero_basefragment, null);
        initView();


        return mView;
    }

    private void initView() {
        mTitle = (TextView) mView.findViewById(R.id.zero__fragtitle);
        mContainer = (LinearLayout) mView.findViewById(R.id.fagmen_tview_container);
        mIconCore = (ImageView) mView.findViewById(R.id.icon_center);
        mForth = (Button) mView.findViewById(R.id.forth);
        mBack = (Button) mView.findViewById(R.id.back);
        mForth.setOnClickListener(this);
        mBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forth:

                forthClick();
                break;
            case R.id.back:
                backClick();
                break;
        }


    }

    public void backClick() {
    }

    public void forthClick() {

    }


}
