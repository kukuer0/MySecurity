package mysecurity.wencheng.com.mysecurity.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mysecurity.wencheng.com.mysecurity.R;
import mysecurity.wencheng.com.mysecurity.activity.MainActivity;
import mysecurity.wencheng.com.mysecurity.doman.MainInfo;

/**
 * Created by wang on 2016/3/12.
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {

    private final Context mContext;
    private final List<MainInfo> list;

    public MainRecyclerAdapter(Context context, List<MainInfo> mainInfoList) {
        this.mContext = context;
        this.list = mainInfoList;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main_item, viewGroup, false);


        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder mainViewHolder, int i) {

        MainInfo mainInfo = list.get(i);
        mainViewHolder.mItemImageView.setBackgroundResource(mainInfo.getIcon());
        mainViewHolder.mItemTitle.setText(mainInfo.getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MainViewHolder extends RecyclerView.ViewHolder {

        private  ImageView mItemImageView;
        private  TextView mItemTitle;

        public MainViewHolder(View itemView) {
            super(itemView);

            mItemImageView = (ImageView) itemView.findViewById(R.id.act_main_item_icon);
            mItemTitle = (TextView) itemView.findViewById(R.id.act_main_item_title);

        }
    }
}
