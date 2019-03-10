package com.example.mjlistview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mjlistview.Models.Song;
import com.example.mjlistview.R;

import java.util.List;

public class SongsListAdapter extends BaseAdapter {
    private List<Song> songDetails;
    private LayoutInflater layoutInflater;
    private Context context;

    public SongsListAdapter(Context context, List<Song> songDetails) {
        this.context =  context;
        this.songDetails = songDetails;
        layoutInflater = LayoutInflater.from( context);

    }


    @Override
    public int getCount() {
        return songDetails.size();
    }

    @Override
    public Object getItem(int i) {
        return songDetails.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.rowlist_item, null);
            holder = new ViewHolder();
            holder.tvTrackName = convertView.findViewById(R.id.tv_trackname);
            holder.ivTrackImage = convertView.findViewById(R.id.iv_trackimage);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Song song = this.songDetails.get(position);
        holder.tvTrackName.setText(song.getTrackName());
        Glide.with(context).load(song.getThumbnail()).into(holder.ivTrackImage);

        return convertView;
    }

    static class ViewHolder {
        TextView tvTrackName;
        ImageView ivTrackImage;
    }
}

