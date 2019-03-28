package com.example.geoguessswipe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GeoObjectViewHolder extends RecyclerView.ViewHolder {
	public TextView geoCountry;
	public ImageView geoImage;
	public View view;
	
	public GeoObjectViewHolder(@NonNull View itemView) {
		super(itemView);
		this.geoImage = itemView.findViewById(R.id.geoImageView);
		this.view = itemView;
	}
}
