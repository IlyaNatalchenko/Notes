package com.example.mynotes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class NoteFragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
        String[] nameNotes = getResources().getStringArray(R.array.nameNotes);

        for (int i = 0; i < nameNotes.length; i++) {
            String nameNote = nameNotes [i];
            TextView tv = new TextView(getContext());
            tv.setText(nameNote);
            tv.setTextSize(30);
            layoutView.addView(tv);
            final int position = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showLink(position);
                }
            });
        }
    }

    private void showLink(int position) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            showLandLink(position);
        } else {
            showPortLink(position);
        }
    }

    private void showLandLink(int position) {
        LinkFragment linkFragment = LinkFragment.newInstants(position);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container2, linkFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    private void showPortLink(int position) {
        LinkFragment linkFragment = LinkFragment.newInstants(position);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, linkFragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}