package mysecurity.wencheng.com.mysecurity.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import mysecurity.wencheng.com.mysecurity.R;

/**
 * Created by wang on 2016/3/15.
 */
public class FourFragment extends BaseFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTitle.setText(R.string.fourfragment_title);
        mIconCore.setBackgroundResource(R.drawable.step_4);
        mContainer.addView(getRootView(), LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


    }

    private View getRootView() {
        TextView textView = new TextView(getActivity());
        textView.setText("four");

        return textView;


    }
}
