package mysecurity.wencheng.com.mysecurity.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import mysecurity.wencheng.com.mysecurity.R;

/**
 * Created by wang on 2016/3/15.
 */
public class TreeFragment extends BaseFragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTitle.setText(R.string.treefragment_title);
        mIconCore.setBackgroundResource(R.drawable.step_3);
        mContainer.addView(getRootView(), LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

    }

    private View getRootView() {
        TextView textView = new TextView(getActivity());
        textView.setText("three");

        return textView;


    }
}
