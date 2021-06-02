package com.example.cowin;

import com.android.volley.toolbox.StringRequest;

public class Hero {
    String name, center_id,slots,vaccine,from,to,date,min_age_limit,available_capacity;

    public Hero(String name, String center_id, String slots, String vaccine, String from,String to,String date,String min_age_limit,String available_capacity) {
        this.name = name;
        this.center_id = center_id;
        this.slots=slots;
        this.vaccine=vaccine;
        this.from=from;
        this.to=to;
        this.date=date;
        this.min_age_limit=min_age_limit;
        this.available_capacity=available_capacity;
    }

    public String getName() {
        return name;
    }

    public String getCenter_id() {
        return center_id;
    }

    public String getSlots() {
        return slots;
    }

    public String getVaccine() {
        return vaccine;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public String getMin_age_limit() {
        return min_age_limit;
    }
}
