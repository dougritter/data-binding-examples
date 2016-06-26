package com.dougritter.databindingexamples;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

public class UserViewModel extends BaseObservable {
    private User user;
    private boolean shouldPassNull;

    public void onClickMakeChanges(@NonNull final View view) {
        if (!shouldPassNull) {
            setUser(new User(view.getContext().getString(R.string.default_user_name),
                    view.getContext().getString(R.string.default_user_lastname)));

            shouldPassNull = true;
            Toast.makeText(view.getContext(), "Passed a valid user", Toast.LENGTH_SHORT).show();

        } else {
            setUser(new User(null, null));
            shouldPassNull = false;
            Toast.makeText(view.getContext(), "Passed a null user", Toast.LENGTH_SHORT).show();

        }
    }

    @Bindable
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        notifyPropertyChanged(com.dougritter.databindingexamples.BR.user);
    }
}
