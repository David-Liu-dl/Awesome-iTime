package org.unimelb.itime.ui.presenter.activity;

import android.content.Context;

import org.unimelb.itime.base.ItimeBaseMvpView;
import org.unimelb.itime.base.ItimeBasePresenter;
import org.unimelb.itime.ui.mvpview.activity.ItimeActivitiesMvpView;

/**
 * Created by Paul on 3/7/17.
 */

public class ItimeActivitiesPresenter<V extends ItimeBaseMvpView> extends ItimeBasePresenter<V> {
    public ItimeActivitiesPresenter(Context context) {
        super(context);
    }
}