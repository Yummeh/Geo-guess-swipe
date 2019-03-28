package com.example.geoguessswipe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class GeoObjectAdapter extends RecyclerView.Adapter<GeoObjectViewHolder> {
	private Context context;
	public List<GeoObject> listGeoObjects;
	
	public GeoObjectAdapter(Context context, List<GeoObject> listGeoObjects) {
		this.context = context;
		this.listGeoObjects = listGeoObjects;
	}
	
	@NonNull
	@Override
	public GeoObjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_cell, viewGroup,false);
		return new GeoObjectViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(@NonNull GeoObjectViewHolder geoObjectViewHolder, int position) {
		final GeoObject geoObject = listGeoObjects.get(position);
		geoObjectViewHolder.geoImage.setImageResource(geoObject.getmCountryImageName());
	}
	
	@Override
	public int getItemCount() {
		return listGeoObjects.size();
	}
}
