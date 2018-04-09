package com.example.nikma.firebasedatabase;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nikma on 4/9/2018.
 */

public class artisltlist extends ArrayAdapter<Artist> {
     private Activity context;
    List<Artist> artistList;

    public artisltlist(Activity context,List<Artist> artistList) {
        super(context,R.layout.artistlist,artistList);
        this.context = context;
        this.artistList = artistList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View listviewitem = layoutInflater.inflate(R.layout.artistlist,null,true);
        TextView name = (TextView) listviewitem.findViewById(R.id.name);
        TextView genre = (TextView) listviewitem.findViewById(R.id.genre);
        Artist artist =    artistList.get(position);
        name.setText(artist.getName());
        genre.setText(artist.getGenre());
        return listviewitem;
    }
}
