package com.example.kushal.prayerapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.kushal.prayerapp.adapter.CardAdapter;
import com.example.kushal.prayerapp.model.Card;

/**
 * Created by Kushal on 02-07-2015.
 */
public class HindiFragment extends Fragment{

    private static final String TAG = "HindiFragment";
    private CardAdapter cardAdapter;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.hindi_fragment, container, false);

        listView = (ListView) view.findViewById(R.id.card_listView);

        listView.addHeaderView(new View(getActivity().getApplicationContext()));
        listView.addFooterView(new View(getActivity().getApplicationContext()));

        cardAdapter = new CardAdapter(getActivity().getApplicationContext(), R.layout.card_layout);

        for (int i = 0; i < 10; i++) {
            Card card = new Card("Thumbnail " + i, "Title " +i, "Video" + i, "Lyrics" + i);
            cardAdapter.add(card);
        }
        listView.setAdapter(cardAdapter);
        return view;
    }

    public static Fragment create() {

        Fragment f = new HindiFragment();

        return f;
    }
}
