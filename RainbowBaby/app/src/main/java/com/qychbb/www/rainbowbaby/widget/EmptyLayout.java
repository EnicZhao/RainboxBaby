package com.qychbb.www.rainbowbaby.widget;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.qychbb.www.rainbowbaby.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者： Enic
 * 时间:  2017/4/10.
 * 介绍：
 */

public class EmptyLayout extends FrameLayout implements View.OnClickListener{

    public static final int STATUS_HIDE = 1001;
    public static final int STATUS_LOADING = 1;
    public static final int STATUS_NO_NET = 2;
    public static final int STATUS_NO_DATA = 3;

    @BindView(R.id.mLoadingView)
    ProgressBar mLoadingView;
    @BindView(R.id.mNoDataView)
    TextView mNoDataView;
    @BindView(R.id.mNoNetView)
    TextView mNoNetView;
    @BindView(R.id.mEmptyLayout)
    FrameLayout mEmptyLayout;

    private Context context;
    private View view;
    private int mStatus = STATUS_LOADING;

    public EmptyLayout(@NonNull Context context) {
        super(context);
        this.context = context;
        init();
    }

    public EmptyLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public EmptyLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        View.inflate(context, R.layout.common_layout_empty, this);
        ButterKnife.bind(this);
    }

    public void show(int status){
        mEmptyLayout.setVisibility(VISIBLE);
        _switchEmptyView(status);
    }

    public void hide(){
        mEmptyLayout.setVisibility(GONE);
    }

    @OnClick(R.id.mNoNetView)
    @Override
    public void onClick(View view) {
        if(emptyLayoutListener != null){
            emptyLayoutListener.refresh();
        }
    }

    private void _switchEmptyView(int status){
        mLoadingView.setVisibility(GONE);
        mNoDataView.setVisibility(GONE);
        mNoNetView.setVisibility(GONE);
        switch (status){
            case STATUS_LOADING:
                mLoadingView.setVisibility(VISIBLE);
                break;
            case STATUS_NO_DATA:
                mNoDataView.setVisibility(VISIBLE);
                break;
            case STATUS_NO_NET:
                mNoNetView.setVisibility(VISIBLE);
                break;
        }
    }

    private EmptyLayoutListener emptyLayoutListener;

    public void setEmptyLayoutListener(EmptyLayoutListener emptyLayoutListener) {
        this.emptyLayoutListener = emptyLayoutListener;
    }

    public interface EmptyLayoutListener{
        void refresh();
    }

}
