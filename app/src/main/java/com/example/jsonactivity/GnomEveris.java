package com.example.jsonactivity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
public class GnomEveris implements Parcelable {

    private ArrayList<Gnomo> GnomEveris;

    public GnomEveris(ArrayList<Gnomo> GnomEveris){
        this.GnomEveris = GnomEveris;
    }
    protected GnomEveris(Parcel in) {
        GnomEveris = in.createTypedArrayList(Gnomo.CREATOR);
    }
    public static final Creator<GnomEveris> CREATOR = new Creator<GnomEveris>() {
        @Override
        public GnomEveris createFromParcel(Parcel in) {
            return new GnomEveris(in);
        }
        @Override
        public GnomEveris[] newArray(int size) {
            return new GnomEveris[size];
        }
    };
    public ArrayList<Gnomo> getGnomos() {
        return GnomEveris;
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(GnomEveris);
    }
}