package com.kulart05gmail.lesson_1.Other.GeoQuiz;

/**
 * Created by KulArtyom on 05.04.2016.
 */
public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int mTextResId, boolean mAnswerTrue) {
        this.mTextResId = mTextResId;
        this.mAnswerTrue = mAnswerTrue;
    }

    public int getmTextResId() {
        return mTextResId;
    }

    public void setmTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }

    public boolean ismAnswerTrue() {
        return mAnswerTrue;
    }

    public void setmAnswerTrue(boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (mTextResId != question.mTextResId) return false;
        return mAnswerTrue == question.mAnswerTrue;

    }

    @Override
    public int hashCode() {
        int result = mTextResId;
        result = 31 * result + (mAnswerTrue ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "mTextResId=" + mTextResId +
                ", mAnswerTrue=" + mAnswerTrue +
                '}';
    }
}
