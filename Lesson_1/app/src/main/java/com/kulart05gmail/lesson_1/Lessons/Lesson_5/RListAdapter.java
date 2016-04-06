package com.kulart05gmail.lesson_1.Lessons.Lesson_5;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.kulart05gmail.lesson_1.R;

import java.util.List;

/**
 * Created by KulArtyom on 04.04.2016.
 */
public class RListAdapter extends RecyclerView.Adapter<RListAdapter.Holder> {

    private onItemClickkListener mListener;
    private List<String> mList;

    public RListAdapter(List<String> mList, onItemClickkListener listener) {
        this.mList = mList;
        this.mListener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        final String text = mList.get(position);
        holder.mTextView.setText(text);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) mListener.OnClick(text, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    protected static class Holder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public Holder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tvText);
        }
    }

    interface onItemClickkListener {
        void OnClick(String text, int position);


    }
}
