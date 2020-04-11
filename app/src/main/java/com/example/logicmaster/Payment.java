package com.example.logicmaster;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.gms.wallet.PaymentsClient;
import com.google.android.gms.wallet.Wallet;
import com.google.android.gms.wallet.WalletConstants;

public class Payment extends Activity {

    private PaymentsClient paymentsClient;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_google);

        Wallet.WalletOptions walletOptions = new Wallet.WalletOptions.Builder()
                .setEnvironment(WalletConstants.ENVIRONMENT_TEST)
                .build();

        paymentsClient = Wallet.getPaymentsClient(this, walletOptions);


    }
}
