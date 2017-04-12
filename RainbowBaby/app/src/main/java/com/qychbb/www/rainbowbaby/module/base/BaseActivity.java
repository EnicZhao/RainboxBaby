package com.qychbb.www.rainbowbaby.module.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qychbb.www.rainbowbaby.R;
import com.qychbb.www.rainbowbaby.widget.EmptyLayout;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： Enic
 * 时间:  2017/4/10.
 * 介绍：
 */

public abstract class BaseActivity extends RxFragmentActivity implements IBaseView {

    @Nullable
    @BindView(R.id.mEmptyLayout)
    private EmptyLayout mEmptyLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(_attachLayoutRes());
        ButterKnife.bind(this);
        mEmptyLayout.show(EmptyLayout.STATUS_LOADING);
    }

    protected abstract int _attachLayoutRes();

    @Override
    public void showLoading() {
        if(mEmptyLayout != null)
            mEmptyLayout.show(EmptyLayout.STATUS_LOADING);
    }

    @Override
    public void hideLoading() {
        if(mEmptyLayout != null)
            mEmptyLayout.hide();
    }

    @Override
    public void showNetError(EmptyLayout.EmptyLayoutListener listener) {
        if(mEmptyLayout != null){
            mEmptyLayout.setEmptyLayoutListener(listener);
            mEmptyLayout.show(EmptyLayout.STATUS_NO_NET);
        }
    }

    @Override
    public void showDataEmpty() {
        if(mEmptyLayout != null)
            mEmptyLayout.show(EmptyLayout.STATUS_NO_DATA);
    }

    @Override
    public void finishRefresh() {

    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLife();
    }
}
