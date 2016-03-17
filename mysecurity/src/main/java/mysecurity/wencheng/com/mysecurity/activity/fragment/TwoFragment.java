package mysecurity.wencheng.com.mysecurity.activity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import mysecurity.wencheng.com.mysecurity.R;
import mysecurity.wencheng.com.mysecurity.utils.Constant;
import mysecurity.wencheng.com.mysecurity.utils.SharedPrefUtils;

/**
 * Created by wang on 2016/3/15.
 */
public class TwoFragment extends BaseFragment {

    private boolean state;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTitle.setText(R.string.twofragment_title);
        mIconCore.setBackgroundResource(R.drawable.step_2);
        mContainer.addView(getRootView(), LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

    }

    private View getRootView() {
        View view = View.inflate(getActivity(), R.layout.two_fragment_core_view, null);

        RelativeLayout mBandSim = (RelativeLayout) view.findViewById(R.id.band_sim_click);
        final ImageView mBandState = (ImageView) view.findViewById(R.id.band_state);

        String value = SharedPrefUtils.getString(getActivity(), Constant.SIM_INFO, "");
        if (TextUtils.isEmpty(value)) {

            mBandState.setBackgroundResource(R.drawable.unlock);
        }

        mBandSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = SharedPrefUtils.getString(getActivity(), Constant.SIM_INFO, "");

                if (TextUtils.isEmpty(result)) {
                    mBandState.setBackgroundResource(R.drawable.lock);
                    SharedPrefUtils.putString(getActivity(), Constant.SIM_INFO, getSim());

                } else {
                    mBandState.setBackgroundResource(R.drawable.unlock);
                    SharedPrefUtils.putString(getActivity(), Constant.SIM_INFO, "");

                }


            }
        });

        return view;

    }

    private String getSim() {
        TelephonyManager telephonyManager = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        String simSerialNumber = telephonyManager.getSimSerialNumber();
        return TextUtils.isEmpty(simSerialNumber) ? "hava no sim" : simSerialNumber;
    }
}
