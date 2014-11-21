package com.kenny.openimgur.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.kenny.openimgur.R;
import com.kenny.openimgur.ui.TextViewRoboto;

/**
 * Creates the view for a popup dialog with an L material design
 * Created by kcampagna on 8/19/14.
 */
public class PopupDialogViewBuilder {
    private TextViewRoboto mTitle;

    private TextViewRoboto mMessage;

    private Button mNegativeBtn;

    private Button mPositiveBtn;

    private View mView;

    private AlertDialog mDialog;

    public PopupDialogViewBuilder(Context context) {
        mView = View.inflate(context, R.layout.popup_fragment, null);
        mTitle = (TextViewRoboto) mView.findViewById(R.id.title);
        mMessage = (TextViewRoboto) mView.findViewById(R.id.message);
        mNegativeBtn = (Button) mView.findViewById(R.id.negative);
        mPositiveBtn = (Button) mView.findViewById(R.id.positive);
        mDialog = new AlertDialog.Builder(context).create();
        mDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
    }

    public PopupDialogViewBuilder setTitle(@StringRes int title) {
        mTitle.setText(title);
        return this;
    }

    public PopupDialogViewBuilder setMessage(@StringRes int message) {
        mMessage.setText(message);
        return this;
    }

    public PopupDialogViewBuilder setMessage(String message) {
        mMessage.setText(message);
        return this;
    }

    public PopupDialogViewBuilder setNegativeButton(@StringRes int text, final View.OnClickListener onClickListener) {
        mNegativeBtn.setText(text);
        mNegativeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                mDialog.dismiss();
            }
        });

        return this;
    }

    public PopupDialogViewBuilder setPositiveButton(@StringRes int text, final View.OnClickListener onClickListener) {
        mPositiveBtn.setText(text);
        mPositiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }

                mDialog.dismiss();
            }
        });
        return this;
    }

    public View build() {
        return mView;
    }

    public void show() {
        mDialog.setView(build());
        mDialog.show();
    }

}