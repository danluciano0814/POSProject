package com.droidcoder.gdgcorp.posproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.droidcoder.gdgcorp.posproject.R;
import com.droidcoder.gdgcorp.posproject.utils.StringConverter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DanLuciano on 3/18/2017.
 */

public class PaymentSuccessFragment extends BaseDialogFragment {

    @BindView(R.id.txtTotal)TextView txtTotal;
    @BindView(R.id.txtChange)TextView txtChange;
    @BindView(R.id.imageDone)ImageView imageDone;
    @BindView(R.id.txtEmail)TextView txtEmail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment_success, container, false);
        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        setCancelable(false);

        txtChange.setText(StringConverter.doubleCommaFormatter(Double.parseDouble(getArguments().getString("change"))));
        txtTotal.setText(StringConverter.doubleCommaFormatter(Double.parseDouble(getArguments().getString("total"))));
        txtEmail.setText(getArguments().getString("email"));

        imageDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

}
