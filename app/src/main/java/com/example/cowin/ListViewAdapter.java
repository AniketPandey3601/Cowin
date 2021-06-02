package com.example.cowin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


    import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;



    public class ListViewAdapter extends ArrayAdapter<Hero> {


        private List<Hero> heroList;


        private Context mCtx;


        public ListViewAdapter(List<Hero> heroList, Context mCtx) {
            super(mCtx, R.layout.list_items, heroList);
            this.heroList = heroList;
            this.mCtx = mCtx;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(mCtx);

            View listViewItem = inflater.inflate(R.layout.list_items, null, true);


            TextView name = listViewItem.findViewById(R.id.name);
            TextView center_id = listViewItem.findViewById(R.id.center_id);
            TextView slots = listViewItem.findViewById(R.id.slots);
            TextView vaccine = listViewItem.findViewById(R.id.vaccine);
            TextView from = listViewItem.findViewById(R.id.from);
            TextView to = listViewItem.findViewById(R.id.to);
            TextView date= listViewItem.findViewById(R.id.date);
            TextView min_agelimit = listViewItem.findViewById(R.id.min_agelimit);
            TextView available_capacity=listViewItem.findViewById(R.id.available_capacity);


            Hero hero = heroList.get(position);

            name.setText(hero.getName());
            center_id.setText(hero.getCenter_id());
            slots.setText(hero.getSlots());
            vaccine.setText(hero.getVaccine());
            from.setText(hero.getFrom());
            to.setText(hero.getTo());
            date.setText(hero.getDate());
            min_agelimit.setText(hero.getMin_age_limit());
            available_capacity.setText(hero.available_capacity);


            return listViewItem;
        }
    }

