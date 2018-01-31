
package com.udacity.gradle.builditbigger.fragment;

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

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.data.EndpointAsyncTast;
import com.udacity.gradle.builditbigger.model.OnJokeReceive;

import info.pelleritoudacity.android.androidjoker.activity.JokerActivity;
import info.pelleritoudacity.android.androidjoker.utility.Costants;


public class MainActivityFragment extends Fragment implements OnJokeReceive {

    private String mResult;
    private ProgressBar progressBar;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(com.udacity.gradle.builditbigger.R.layout.fragment_main, container, false);

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
        if (!TextUtils.isEmpty(mResult)) {
            startActivity();
        }
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
