package com.example.jsonactivity;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class Gnomo implements Parcelable {
    private int id;
    private int age;
    private String name;
    private double height;
    private double weight;
    private String thumbnail;
    private String hair_color;
    private ArrayList<String> professions;
    private ArrayList<String> friends;




    protected Gnomo(Parcel in) {
        id = in.readInt();
        age = in.readInt();
        name = in.readString();
        height = in.readDouble();
        weight = in.readDouble();
        thumbnail = in.readString();
        hair_color = in.readString();
        professions = in.createStringArrayList();
        friends = in.createStringArrayList();
    }

    public static final Creator<Gnomo> CREATOR = new Creator<Gnomo>() {
        @Override
        public Gnomo createFromParcel(Parcel in) {
            return new Gnomo(in);
        }

        @Override
        public Gnomo[] newArray(int size) {
            return new Gnomo[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public ArrayList<String> getProfessions() {
        return professions;
    }
    public void setProfessions(ArrayList<String> professions) {
        this.professions = professions;
    }
    public ArrayList<String> getFriends() {
        return friends;
    }
    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getThumbnail() {
        return thumbnail;
    }
    public void Thumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getHair_color() {
        return hair_color;
    }
    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(age);
        dest.writeString(name);
        dest.writeDouble(height);
        dest.writeDouble(weight);
        dest.writeString(thumbnail);
        dest.writeString(hair_color);
        dest.writeStringList(professions);
        dest.writeStringList(friends);
    }
}
