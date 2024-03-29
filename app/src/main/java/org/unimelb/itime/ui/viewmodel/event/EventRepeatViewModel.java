package org.unimelb.itime.ui.viewmodel.event;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;

import org.unimelb.itime.R;
import org.unimelb.itime.bean.Event;
import org.unimelb.itime.ui.mvpview.event.EventRepeatMvpView;
import org.unimelb.itime.ui.presenter.EventRepeatPresenter;
import org.unimelb.itime.util.EventUtil;
import org.unimelb.itime.util.rulefactory.FrequencyEnum;

import java.util.Calendar;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Created by Paul on 2/6/17.
 */

public class EventRepeatViewModel extends BaseObservable {
    private EventRepeatPresenter<EventRepeatMvpView> presenter;
    private EventRepeatMvpView mvpView;
    public ObservableList<RepeatLineViewModel> items = new ObservableArrayList<>();
    public ItemBinding<RepeatLineViewModel> itemBinding = ItemBinding.of(BR.repeatItem, R.layout.row_repeat);

    private Event event;

    public EventRepeatViewModel(EventRepeatPresenter<EventRepeatMvpView> presenter) {
        this.presenter = presenter;
        this.mvpView = presenter.getView();
        init();
    }

    @Bindable
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
        notifyPropertyChanged(BR.event);
    }

    private void init(){
        items.add(new RepeatLineViewModel(getString(R.string.event_no_repeat),
                View.GONE, presenter.getContext().getResources().getDrawable(R.drawable.icon_event_checkmark_blue),true));
        items.add(new RepeatLineViewModel(getString(R.string.event_repeat_everyday),
                View.GONE, presenter.getContext().getResources().getDrawable(R.drawable.icon_event_checkmark_blue),true));
        items.add(new RepeatLineViewModel(getString(R.string.event_repeat_every_week),
                View.GONE, presenter.getContext().getResources().getDrawable(R.drawable.icon_event_checkmark_blue),true));
        items.add(new RepeatLineViewModel(getString(R.string.event_repeat_every_two_weeks),
                View.GONE, presenter.getContext().getResources().getDrawable(R.drawable.icon_event_checkmark_blue),true));
        items.add(new RepeatLineViewModel(getString(R.string.event_repeat_every_month),
                View.GONE, presenter.getContext().getResources().getDrawable(R.drawable.icon_event_checkmark_blue),true));
        items.add(new RepeatLineViewModel(getString(R.string.event_repeat_every_year),
                View.GONE, presenter.getContext().getResources().getDrawable(R.drawable.icon_event_checkmark_blue),true));
        items.add(new RepeatLineViewModel(getString(R.string.event_repeat_custom),
                View.VISIBLE, presenter.getContext().getResources().getDrawable(R.drawable.icon_event_disclosure), false));

        for (RepeatLineViewModel lineVm : items){
            lineVm.setOnClickCallBack(new RepeatLineViewModel.OnClickCallBack() {
                @Override
                public void beforeOnClick(RepeatLineViewModel repeatLineViewModel) {
                    if (repeatLineViewModel.getIconVisibility() == View.GONE){
                        // new click, need to reset all first
                        resetAllClick();
                        // then click this current line
                        repeatLineViewModel.setIconVisibility(View.VISIBLE);
                        updateRecurrence(repeatLineViewModel.getRepeatText());
                    }
                }

                @Override
                public void onClickCustom() {
                    if(mvpView!=null){
                        mvpView.toCustomRepeat(event);
                    }
                }
            });
        }
    }

    private void updateRecurrence(String repeatString){
        if (repeatString.equals(getString(R.string.event_no_repeat))){
            event.getRule().setFrequencyEnum(null);
            event.getRule().setInterval(1);
        }
        if (repeatString.equals(getString(R.string.event_repeat_everyday))){
            event.getRule().setFrequencyEnum(FrequencyEnum.DAILY);
            event.getRule().setInterval(1);
        }
        if (repeatString.equals(getString(R.string.event_repeat_every_week))){
            event.getRule().setFrequencyEnum(FrequencyEnum.WEEKLY);
            event.getRule().setInterval(1);
        }
        if (repeatString.equals(getString(R.string.event_repeat_every_two_weeks))){
            event.getRule().setFrequencyEnum(FrequencyEnum.WEEKLY);
            event.getRule().setInterval(2);
        }
        if (repeatString.equals(getString(R.string.event_repeat_every_month))){
            event.getRule().setFrequencyEnum(FrequencyEnum.MONTHLY);
            event.getRule().setInterval(1);
        }
        if (repeatString.equals(getString(R.string.event_repeat_every_year))){
            event.getRule().setFrequencyEnum(FrequencyEnum.YEARLY);
            event.getRule().setInterval(1);
        }

        event.setRecurrence(event.getRule().getRecurrence());
    }


    /**
     * This method will reset all ticks, except the last custom one.
     */
    private void resetAllClick(){
        for (int i = 0; i < items.size()-1; i++){
            items.get(i).setIconVisibility(View.GONE);
        }
    }


    private String getString(int stringId){
        return presenter.getContext().getString(stringId);
    }

}
