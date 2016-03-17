package mysecurity.wencheng.com.mysecurity.activity.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import mysecurity.wencheng.com.mysecurity.R;

/**
 * Created by wang on 2016/3/15.
 */
public class FiveFragment extends BaseFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTitle.setText(R.string.fivefragment_title);
        mIconCore.setBackgroundResource(R.drawable.step_5);
        mContainer.addView(getRootView(), LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mForth.setVisibility(View.INVISIBLE);
    }

    private View getRootView() {
        TextView textView = new TextView(getActivity());
        textView.setText("five");

        return textView;


    }
}
