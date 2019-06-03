package com.shiva.practice.modules.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shiva.practice.R;
import com.shiva.practice.base.BaseActivity;
import com.shiva.practice.di.components.DaggerCakeComponent;
import com.shiva.practice.di.module.CakeModule;
import com.shiva.practice.modules.home.adapter.CakeAdapter;
import com.shiva.practice.mvp.model.Cake;
import com.shiva.practice.mvp.presenter.CakePresenter;
import com.shiva.practice.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.cakeRecyclerView)
    protected RecyclerView mCakeRecyclerView;

    @Inject
    protected CakePresenter mPresenter;

    private CakeAdapter mCakeAdapter;

    @Override

    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initializeList();
        mPresenter.getCakes();
    }

    private void initializeList() {
        mCakeRecyclerView.setHasFixedSize(true);
        mCakeRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mCakeAdapter = new CakeAdapter(this, getLayoutInflater());
        mCakeRecyclerView.setAdapter(mCakeAdapter);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerCakeComponent.builder()
                .applicationComponent(getApplicationComponent())
                .cakeModule(new CakeModule(this))
                .build().inject(this);
    }

    @Override
    public void onCakeLoaded(List<Cake> cakes) {
        Log.v("getCakesSize", cakes.size() + "");
        mCakeAdapter.addCakes(cakes);
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void onShowToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
