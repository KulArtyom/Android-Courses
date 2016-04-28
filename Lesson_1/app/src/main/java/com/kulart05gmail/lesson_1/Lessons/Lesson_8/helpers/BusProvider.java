package com.kulart05gmail.lesson_1.Lessons.Lesson_8.helpers;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by KulArtyom on 15.04.2016.
 */
public class BusProvider {

    private static final Bus BUS = new Bus(ThreadEnforcer.ANY);

    public static Bus getInstance() {
        return BUS;
    }

    private BusProvider() {
    }


}
