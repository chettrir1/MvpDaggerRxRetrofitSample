package com.shiva.practice.mvp.presenter;

import com.shiva.practice.api.CakeApiService;
import com.shiva.practice.base.BasePresenter;
import com.shiva.practice.mapper.CakeMapper;
import com.shiva.practice.mvp.model.Cake;
import com.shiva.practice.mvp.model.CakeResponse;
import com.shiva.practice.mvp.model.Storage;
import com.shiva.practice.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CakePresenter extends BasePresenter<MainView> implements Observer<CakeResponse> {
    @Inject
    protected CakeApiService mApiService;

    @Inject
    protected CakeMapper mCakeMapper;

    @Inject
    protected Storage mStorage;


    @Inject
    public CakePresenter() {

    }

    public void getCakes() {
        getView().onShowDialog("Loading cakes...");
        Observable<CakeResponse> cakeResponseObservable = mApiService.getCakes();
        subscribe(cakeResponseObservable, this);
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(CakeResponse cakeResponse) {
        List<Cake> cakes = mCakeMapper.mapCakes(mStorage, cakeResponse);
        getView().onClearItems();
        getView().onCakeLoaded(cakes);
    }

    @Override
    public void onError(Throwable e) {
        getView().onHideDialog();
        getView().onShowToast("Error loading cakes");
    }

    @Override
    public void onComplete() {
        getView().onHideDialog();
        getView().onShowToast("Cakes loading completed");
    }

    public void getCakesFromDatabase() {
        List<Cake> cakes = mStorage.getSavedCakes();
        getView().onClearItems();
        getView().onCakeLoaded(cakes);
    }
}
