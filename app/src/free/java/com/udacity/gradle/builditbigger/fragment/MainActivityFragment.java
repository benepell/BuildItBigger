
package com.udacity.gradle.builditbigger.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.builditbigger.BuildConfig;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.data.EndpointAsyncTast;
import com.udacity.gradle.builditbigger.model.OnJokeReceive;
import com.udacity.gradle.builditbigger.utility.Util;

import info.pelleritoudacity.android.androidjoker.activity.JokerActivity;
import info.pelleritoudacity.android.androidjoker.utility.Costants;


public class MainActivityFragment extends Fragment implements OnJokeReceive {

    private String mResult;
    private InterstitialAd mInterstitialAd;
    private ProgressBar progressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(com.udacity.gradle.builditbigger.R.layout.fragment_main, container, false);

        AdView mAdView = root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        Context context = getContext();

        if(context!=null){
            MobileAds.initialize(context, getString(R.string.admob_app_id));

            mInterstitialAd = new InterstitialAd(context);
            mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    startActivity();
                }
            });

            reqInterstitial(context);
        }

        progressBar = root.findViewById(R.id.progressBar);
        Button button = root.findViewById(R.id.tell_joke_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeJoke();
            }
        });

        return root;
    }

    @Override
    public void onReceive(String result) {
        hiddenProgressBar();
        mResult = result;
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
        if (!TextUtils.isEmpty(mResult)) {
            startActivity();
        }
    }

    private void reqInterstitial(Context context) {
        AdRequest adRequest;

        if (BuildConfig.DEBUG) {
            Util util = new Util(context);
            String deviceId = util.getDeviceId();

            adRequest = new AdRequest.Builder()
                    .addTestDevice(deviceId)
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();

        } else {
            adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();

        }
        mInterstitialAd.loadAd(adRequest);

    }

    private void executeJoke() {
        showProgressBar();
        new EndpointAsyncTast().execute(this);
    }

    private void startActivity() {
        Intent intent = new Intent(getActivity(), JokerActivity.class);
        intent.putExtra(Costants.EXTRA_JOKE_KEY, mResult);
        startActivity(intent);
    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hiddenProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
