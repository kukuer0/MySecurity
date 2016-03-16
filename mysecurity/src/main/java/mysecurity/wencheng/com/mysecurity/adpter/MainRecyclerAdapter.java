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
import mysecurity.wencheng.com.mysecurity.doman.MainInfo;

/**
 * Created by wang on 2016/3/12.
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {

    private final Context mContext;
    private final List<MainInfo> list;

    public interface OnItemClickListener{
        void itemClick(View mainViewHolder, int i);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

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
    public void onBindViewHolder(final MainViewHolder mainViewHolder, final int i) {

        MainInfo mainInfo = list.get(i);
        mainViewHolder.mItemImageView.setBackgroundResource(mainInfo.getIcon());
        mainViewHolder.mItemTitle.setText(mainInfo.getTitle());
        mainViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.itemClick(mainViewHolder.itemView,i);


                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MainViewHolder extends RecyclerView.ViewHolder {

        private  ImageView mItemImageView;
        private  TextView mItemTitle;
        private View itemView;

        public MainViewHolder(View itemView) {
            super(itemView);


            this.itemView = itemView;
            mItemImageView = (ImageView) itemView.findViewById(R.id.act_main_item_icon);
            mItemTitle = (TextView) itemView.findViewById(R.id.act_main_item_title);

        }
    }
}
