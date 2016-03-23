package com.android.yuanxiong.cpapademo2.ui.widget;
import android.support.v4.app.Fragment;
import com.android.yuanxiong.cpapademo2.model.LeftTagModel;
import com.android.yuanxiong.cpapademo2.ui.fragment.AuctionFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.HomeFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.LeftFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.MarketFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.My2016Fragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.NewsFragment;
import com.android.yuanxiong.cpapademo2.ui.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by 李远雄 on 2016/3/22.
 */
public class FragmentContainer {

    private FragmentContainer() {
    }

    private  static Map<String,LeftTagModel> tagModel;
    public static Map<String,LeftTagModel> getTagModel() {
        if (tagModel == null) {
            tagModel = new HashMap<>();
            tagModel.put(HomeFragment.class.getSimpleName(),cteateMoel("视野",new HomeFragment()));
            tagModel.put(NewsFragment.class.getSimpleName(),cteateMoel("新闻",new NewsFragment()));
            tagModel.put(My2016Fragment.class.getSimpleName(),cteateMoel("我的2016",new My2016Fragment()));
            tagModel.put(ShopFragment.class.getSimpleName(),cteateMoel("器材商城",new ShopFragment()));
            tagModel.put(AuctionFragment.class.getSimpleName(),cteateMoel("拍卖收藏",new AuctionFragment()));
            tagModel.put(MarketFragment.class.getSimpleName(),cteateMoel("图片市场",new MarketFragment()));
        }
        return tagModel;
    }

    private static LeftTagModel cteateMoel(String name, Fragment fragment) {
        LeftTagModel model=new LeftTagModel();
        model.setName(name);
        model.setFragment(fragment);
    return model;
    }

}