package com.kulart05gmail.android_v2.Lessons.Lesson_13.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.kulart05gmail.android_v2.Lessons.Lesson_13.listeners.ToolbarListener;
import com.kulart05gmail.android_v2.R;

/**
 * Created by KulArtyom on 04.05.2016.
 */
public class FragmentTwo extends BaseFragment implements ToolbarListener {

    private ToolbarListener mToolbarListener;
    private static final String TAG = FragmentTwo.class.getSimpleName();

    public static FragmentTwo getInstance(FragmentManager fragmentManager) {

        FragmentTwo mFragment = (FragmentTwo) fragmentManager.findFragmentByTag(FragmentTwo.TAG);

        if (mFragment == null) {
            mFragment = new FragmentTwo();

        }
        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);

        return view;


    }

    @Override
    public String getFragmentTag() {
        return TAG;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (mToolbarListener != null) mToolbarListener.setTitle("FragmentTwo");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ToolbarListener) {
            mToolbarListener = (ToolbarListener) context;
        }
        setHasOptionsMenu(true);
    }

    @Override
    public void onDetach() {
        mToolbarListener = null;
        super.onDetach();
        setHasOptionsMenu(false);
    }

    @Override
    public void setTitle(CharSequence name) {

    }

    @Override
    public void setTitle(int resTitleId) {

    }

    @Override
    public void switchFragment(BaseFragment fragment, boolean addToBackStack, boolean clearBackStack, FragmentAnim fragmentAnim) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_2, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btn_radio:
                Toast.makeText(getActivity(), "RAdio", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);

    }
}
