package com.android.yuanxiong.cpapademo2.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.yuanxiong.cpapademo2.R;
import com.android.yuanxiong.cpapademo2.model.LeftTagModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by 李远雄 on 2016/3/18.
 */
public class LeftFragmentAdapter extends BaseAdapter {
    private int choosePosition = -1;
    private Context context;
    private List<LeftTagModel> models;

    public LeftFragmentAdapter(List<LeftTagModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    public void setChoosePosition(int choosePosition) {
        this.choosePosition = choosePosition;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        LeftTagModel model = models.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        }
        holder= (ViewHolder) convertView.getTag();
        initChange(holder,model,position);
        return convertView;
    }

    private void initChange(ViewHolder holder, LeftTagModel model, int position) {
        holder.text.setText(model.getName());
        if (position == choosePosition) {
            holder.text.setTextColor(Color.parseColor("#000000"));
            holder.content.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.img.setImageResource(R.mipmap.cllection_btn_slet);
        }else {
            holder.text.setTextColor(Color.parseColor("#ffffff"));
            holder.content.setBackgroundColor(Color.parseColor("#242424"));
            holder.img.setImageResource(R.mipmap.cllection_btn_no);
        }
    }


    static class ViewHolder {
        @Bind(R.id.img)
        ImageView img;
        @Bind(R.id.text)
        TextView text;
        @Bind(R.id.content)
        RelativeLayout content;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
