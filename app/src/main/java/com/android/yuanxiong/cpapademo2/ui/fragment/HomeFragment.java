package com.android.yuanxiong.cpapademo2.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.yuanxiong.cpapademo2.R;
import com.android.yuanxiong.cpapademo2.model.LeftTagModel;
import com.android.yuanxiong.cpapademo2.ui.activity.MainActivity;
import com.android.yuanxiong.cpapademo2.ui.widget.FragmentContainer;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 李远雄 on 2016/3/18.
 */
public class HomeFragment extends BaseFragment {
    @Bind(R.id.mainViewPager)
    ViewPager mainViewPager;
    @Bind(R.id.mainImage)
    ImageView mainImage;
    @Bind(R.id.mainProgressBar)
    ContentLoadingProgressBar mainProgressBar;
    @Bind(R.id.mainText)
    TextView mainText;
    @Bind(R.id.mainTime)
    TextView mainTime;
    @Bind(R.id.mainMy2015)
    RadioButton mainMy2015;
    @Bind(R.id.mainShop)
    RadioButton mainShop;
    @Bind(R.id.mainAuction)
    RadioButton mainAuction;
    @Bind(R.id.mainMarket)
    RadioButton mainMarket;
    @Bind(R.id.mainCheck)
    CheckBox mainCheck;
    @Bind(R.id.mainGroup)
    RadioGroup mainGroup;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_home, container, false);
        }
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initChange();
    }

    private void initChange() {

        mainGroup.setOnCheckedChangeListener(mChangeListener);
    }

    private RadioGroup.OnCheckedChangeListener mChangeListener=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            LeftTagModel model=null;
            switch (checkedId) {
                case R.id.mainMy2015:
                    model = FragmentContainer.getTagModel().get(My2016Fragment.class.getSimpleName());
                    break;
                case R.id.mainShop:
                    model = FragmentContainer.getTagModel().get(ShopFragment.class.getSimpleName());
                    break;
                case R.id.mainAuction:
                    model = FragmentContainer.getTagModel().get(AuctionFragment.class.getSimpleName());
                    break;
                case R.id.mainMarket:
                    model = FragmentContainer.getTagModel().get(MarketFragment.class.getSimpleName());
                    break;
            }
            ((MainActivity)getActivity()).switchContentFragment(model);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.mainViewPager, R.id.mainImage, R.id.mainProgressBar, R.id.mainText, R.id.mainTime, R.id.mainMy2015, R.id.mainShop, R.id.mainAuction, R.id.mainMarket, R.id.mainCheck, R.id.mainGroup})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mainViewPager:
                break;
            case R.id.mainImage:
                break;
            case R.id.mainProgressBar:
                break;
            case R.id.mainText:
                break;
            case R.id.mainTime:
                break;

            case R.id.mainCheck:
                break;
            case R.id.mainGroup:
                break;
        }
    }
}

