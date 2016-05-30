package com.kulart05gmail.android_v2.Lessons.Lesson_13.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kulart05gmail.android_v2.Lessons.Lesson_13.fragments.BaseFragment;
import com.kulart05gmail.android_v2.Lessons.Lesson_13.fragments.FragmentAnim;
import com.kulart05gmail.android_v2.Lessons.Lesson_13.fragments.FragmentOne;
import com.kulart05gmail.android_v2.Lessons.Lesson_13.listeners.ToolbarListener;
import com.kulart05gmail.android_v2.R;


public class Lesson_13 extends BaseActivity implements ToolbarListener {

    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_13);
        initToolbar();
        showFragment(FragmentOne.createInstance(getSupportFragmentManager(), "Super Button"), false, false, FragmentAnim.NONE);

    }

    private void initToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        assert toolbar != null;
        mText = (TextView) toolbar.findViewById(R.id.tv_title);

        toolbar.setNavigationIcon(R.drawable.ic_radio_button_checked_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Lesson_13.this, "Navigation Icon", Toast.LENGTH_SHORT).show();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }


    }

    private void showFragment(BaseFragment fragment, boolean addToBackStack, boolean clearBackStack, FragmentAnim fragmentAnim) {


        //Cleat history fragment
        if (clearBackStack) {
            while (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStackImmediate();
            }

        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragmentAnim == FragmentAnim.ROTATE) {
            transaction.setCustomAnimations(R.anim.alpha, R.anim.rotate, R.anim.scale, R.anim.translate);
        }

        transaction.replace(R.id.container, fragment, fragment.getFragmentTag());

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();


    }

    @Override
    public void switchFragment(BaseFragment fragment, boolean addToBackStack, boolean clearBackStack, FragmentAnim fragmentAnim) {
        showFragment(fragment, addToBackStack, clearBackStack, fragmentAnim);
    }

    @Override
    public void setTitle(CharSequence title) {
        mText.setText(title);
    }

    @Override
    public void setTitle(int titleId) {

        mText.setText(titleId);
    }
}
