package com.dougritter.databindingexamples;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class UserViewModel extends BaseObservable implements Observable {
    public static final String IMAGE_URL = "http://weloveicons.s3.amazonaws.com/icons/100921_android.png";
    private User user;
    private boolean shouldPassNull;
    private ChangerThread changerThread;

    public UserViewModel() {
        EventBus.getDefault().register(this);
    }

    public void onClickMakeChanges(@NonNull final View view) {
        if (!shouldPassNull) {
            setUser(new User(view.getResources().getString(R.string.default_user_name),
                    view.getResources().getString(R.string.default_user_lastname),
                    18));

            shouldPassNull = true;
            Toast.makeText(view.getContext(), "Passed a valid user", Toast.LENGTH_SHORT).show();

        } else {
            setUser(null);
            shouldPassNull = false;
            Toast.makeText(view.getContext(), "Passed a null user", Toast.LENGTH_SHORT).show();

        }
    }

    public void onClickStartStopThread(@NonNull final View view) {
        if (changerThread == null) {
            changerThread = new ChangerThread();
        }

        if (changerThread.threadIsRunning()) {
            changerThread.stopThread();
        } else {
            changerThread.startThread();
        }
    }


    @Bindable
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        setUserImageUrl(user);
        this.user = user;
        notifyPropertyChanged(com.dougritter.databindingexamples.BR.user);
        notifyPropertyChanged(com.dougritter.databindingexamples.BR.isAdult);

    }

    public void setUserImageUrl(User user) {
        if (user != null) {
            user.setImageUrl(IMAGE_URL);
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventMakeChanges eventMakeChanges) {
        if (user == null) {
            setUser(createNonDefaultUser());
        } else {
            setUser(null);
        }

    }

    public User createNonDefaultUser() {
        return new User(User.NON_DEFAULT_NAME, User.NON_DEFAULT_LAST_NAME, 15);
    }

    @Bindable
    public String getIsAdult() {
        String returnValue = User.IS_NOT_ADULT;
        if (user != null) {
            if (user.getAge() >= 18) {
                returnValue = User.IS_ADULT;
            }
        } else {
            returnValue = User.OBJECT_IS_NULL;
        }

        return returnValue;
    }


}
