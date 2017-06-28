package org.unimelb.itime.ui.viewmodel.meeting;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import org.unimelb.itime.BR;
import org.unimelb.itime.bean.Meeting;

/**
 * Created by yuhaoliu on 27/06/2017.
 */

public class MeetingMenu1ViewModel extends BaseObservable {

    private Meeting meeting;
    private OnMenuClick mOnMenuClick;

    public View.OnClickListener onClickPin(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mOnMenuClick!=null){
                    mOnMenuClick.onDataChange();
                }
            }
        };
    }
    public View.OnClickListener onClickMute(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mOnMenuClick!=null){
                    mOnMenuClick.onDataChange();
                }
            }
        };
    }

    public View.OnClickListener onClickArchive(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mOnMenuClick!=null){
                    mOnMenuClick.onDataChange();
                }
            }
        };
    }

    public interface OnMenuClick{
        void onDataChange();
    }

    public void setmOnMenuClick(OnMenuClick mOnMenuClick) {
        this.mOnMenuClick = mOnMenuClick;
    }

    @Bindable
    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
        notifyPropertyChanged(BR.meeting);
    }
}
