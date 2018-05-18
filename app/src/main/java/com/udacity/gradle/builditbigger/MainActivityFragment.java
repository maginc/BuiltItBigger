package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.ragazm.finalproject.jokedisplay.JokeActivity;

import static com.udacity.gradle.builditbigger.BuildConfig.FLAVOR;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button button = root.findViewById(R.id.tellJoke);
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."

        if (FLAVOR.equals("paid")) {
            mAdView.setVisibility(View.GONE);

        }else {
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();
            mAdView.loadAd(adRequest);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new EndpointsAsyncTask(new EndpointsAsyncTask.Listener() {

                    @Override
                    public void onJokeLoaded(String joke) {
                        Intent intent = new Intent(getContext(), JokeActivity.class);
                        intent.putExtra("joke", joke);
                        startActivity(intent);
                    }
                }).execute();
            }
        });
        return root;
    }
}
