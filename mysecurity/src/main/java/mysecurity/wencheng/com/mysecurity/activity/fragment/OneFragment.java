package mysecurity.wencheng.com.mysecurity.activity.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import mysecurity.wencheng.com.mysecurity.R;

/**
 * Created by wang on 2016/3/15.
 */
public class OneFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTitle.setText(R.string.onefragment_title);
        mIconCore.setBackgroundResource(R.drawable.step_1);
        mContainer.addView(getRootView(), LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mBack.setVisibility(View.INVISIBLE);

    }

    private View getRootView() {
        View view = View.inflate(getActivity(), R.layout.one_fragment_core_view, null);

        return view;

    }


}
