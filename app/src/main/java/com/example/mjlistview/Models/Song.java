package com.example.mjlistview.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;



public class Song implements Parcelable {
    @SerializedName("trackName")
    private String trackName;

    @SerializedName("collectionName")
    private String collectionName;

    @SerializedName("trackViewUrl")
    private String trackViewUrl;

    @SerializedName("previewUrl")
    private String previewUrl;

    @SerializedName("artworkUrl100")
    private String thumbnail;


    protected Song(Parcel in) {
        trackName = in.readString();
        collectionName = in.readString();
        trackViewUrl = in.readString();
        previewUrl = in.readString();
        thumbnail = in.readString();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(trackName);
        parcel.writeString(trackViewUrl);
        parcel.writeString(collectionName);
        parcel.writeString(thumbnail);
        parcel.writeString(previewUrl);

    }
}
