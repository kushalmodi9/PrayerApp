package com.example.kushal.prayerapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.google.android.youtube.player.YouTubeIntents;

import com.example.kushal.prayerapp.R;
import com.example.kushal.prayerapp.model.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kushal on 02-07-2015.
 */
public class CardAdapter extends ArrayAdapter<Card> implements View.OnClickListener{

    private static final String TAG = "CardArrayAdapter";
    private List<Card> cardList = new ArrayList<Card>();
    private static final String VIDEO_ID = "-Uwjt32NvVA";

    static class CardViewHolder{
        CardView cardView;
        TextView thummbNail;
        TextView title;
        TextView textVideo;
        TextView textLyrics;
    }

    public CardAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(Card object) {
        cardList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.cardList.size();
    }

    @Override
    public Card getItem(int index) {
        return this.cardList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CardViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.card_layout, parent, false);
            viewHolder = new CardViewHolder();
            viewHolder.cardView = (CardView) row.findViewById(R.id.card_view);
            viewHolder.thummbNail = (TextView) row.findViewById(R.id.thummbNail);
            viewHolder.title = (TextView) row.findViewById(R.id.titleView);
            viewHolder.textVideo = (TextView) row.findViewById(R.id.textVideo);
            viewHolder.textLyrics = (TextView) row.findViewById(R.id.textLyrics);
            row.setTag(viewHolder);
        } else {
            viewHolder = (CardViewHolder)row.getTag();
        }

        Card card = getItem(position);
        viewHolder.thummbNail.setText(card.getImageURL());
        viewHolder.title.setText(card.getTitle());
        viewHolder.textVideo.setText(card.getTextVideo());
        viewHolder.textLyrics.setText(card.getTextLyrics());
        viewHolder.thummbNail.setOnClickListener(this);
        return row;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.thummbNail:
                // Do stuff accordingly...
                Log.v(TAG, "onClick of thumbNail");
                Intent intent = YouTubeIntents.createPlayVideoIntentWithOptions(getContext(), VIDEO_ID, true, false);
                /*startActivity(intent);*/
                break;
            default:
                break;
        }
    }
}
