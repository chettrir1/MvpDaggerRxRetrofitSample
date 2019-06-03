package com.shiva.practice.mvp.view;

import com.shiva.practice.mvp.model.Cake;

import java.util.List;

public interface MainView extends BaseView {
    void onCakeLoaded(List<Cake> cakes);

    void onShowDialog(String message);

    void onHideDialog();

    void onShowToast(String message);
}
