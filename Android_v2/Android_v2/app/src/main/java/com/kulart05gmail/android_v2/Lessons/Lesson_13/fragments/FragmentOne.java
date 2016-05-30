package com.kulart05gmail.android_v2.Lessons.Lesson_13.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kulart05gmail.android_v2.Lessons.Lesson_13.listeners.ToolbarListener;
import com.kulart05gmail.android_v2.R;

/**
 * Created by KulArtyom on 04.05.2016.
 */
public class FragmentOne extends BaseFragment {

    private static final String KEY_NAME = "key_name";
    private static final String TAG = FragmentOne.class.getSimpleName();

    private Button mChangeButton;
    private ToolbarListener mToolbarListener;

    public static FragmentOne createInstance(FragmentManager fragmentManager, String name) {

        FragmentOne fragmentOne = (FragmentOne) fragmentManager.findFragmentByTag(FragmentOne.TAG);
        if (fragmentOne == null) {
            fragmentOne = new FragmentOne();
        }


        Bundle bundle = new Bundle();
        bundle.putString(KEY_NAME, name);
        fragmentOne.setArguments(bundle);


        return fragmentOne;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_m, container, false);
        mChangeButton = (Button) view.findViewById(R.id.btn_change_fragments);


        Bundle bundle = getArguments();
        if (bundle != null) {
            String name = bundle.getString(KEY_NAME);
            if (!TextUtils.isEmpty(name)) {
                mChangeButton.setText(name);
            }
        }

        mChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((Lesson_13) getActivity()).showFragment(FragmentTwo.getInstance(), true);
                if (mToolbarListener != null)
                    mToolbarListener.switchFragment(FragmentTwo.getInstance(getFragmentManager()), true, false, FragmentAnim.ROTATE);
            }
        });
        return view;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
    public String getFragmentTag() {
        return TAG;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (mToolbarListener != null) mToolbarListener.setTitle("FragmentOne");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_1, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btn_add:
                Toast.makeText(getActivity(), "Add", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
