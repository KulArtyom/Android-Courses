package com.kulart05gmail.android_v2.Lessons.Lesson_13.listeners;

import android.support.v4.app.Fragment;

import com.kulart05gmail.android_v2.Lessons.Lesson_13.fragments.BaseFragment;
import com.kulart05gmail.android_v2.Lessons.Lesson_13.fragments.FragmentAnim;

/**
 * Created by KulArtyom on 04.05.2016.
 */
public interface ToolbarListener {

    void setTitle(CharSequence name);

    void setTitle(int resTitleId);

    void switchFragment(BaseFragment fragment, boolean addToBackStack, boolean clearBackStack, FragmentAnim fragmentAnim);

}
