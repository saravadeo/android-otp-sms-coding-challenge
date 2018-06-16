package com.example.osarvade.kisannetwork;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.osarvade.kisannetwork.PlaceholderFragment.OnListFragmentInteractionListener;
import com.example.osarvade.kisannetwork.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyMessagesRecyclerViewAdapter extends RecyclerView.Adapter<MyMessagesRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
   private final OnListFragmentInteractionListener mListener;

    Contacts contacts=null;

    public MyMessagesRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_messages, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        String name=mValues.get(position).name;
        holder.mItem = mValues.get(position);
        holder.name.setText(name);

        holder.list_image.setText(name.charAt(0)+"");

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    mListener.onListFragmentInteraction(holder.mItem);


            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView name;

        public final TextView list_image;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            name = (TextView) view.findViewById(R.id.name);

            list_image = (TextView) view.findViewById(R.id.list_image);

        }

        @Override
        public String toString() {
            return super.toString() + " '" ;
        }
    }
}
