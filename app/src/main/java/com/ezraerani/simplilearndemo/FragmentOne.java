package com.ezraerani.simplilearndemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ezraerani on 8/14/17.
 */

public class FragmentOne extends Fragment implements View.OnClickListener {

    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1, container, false);
        button = (Button) view.findViewById(R.id.switchFragmentButton);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        FragmentActivity activity = (FragmentActivity) getActivity();
        activity.switchFragment();
    }
}
