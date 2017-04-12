package com.qychbb.www.rainbowbaby.module.base;

import com.qychbb.www.rainbowbaby.widget.EmptyLayout;
import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * 作者： Enic
 * 时间:  2017/4/10.
 * 介绍：
 */

public interface IBaseView {

    void showLoading();

    void hideLoading();

    void showNetError(EmptyLayout.EmptyLayoutListener listener);

    void showDataEmpty();

    void finishRefresh();

    <T> LifecycleTransformer<T> bindToLife();

}
