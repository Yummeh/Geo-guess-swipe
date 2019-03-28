package com.example.geoguessswipe;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {
	private List<GeoObject> places;
	
	private RecyclerView mRecyclerView;
	private GestureDetector mGestureDetector;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		places = new ArrayList<>();
		mRecyclerView = findViewById(R.id.recyclerView);
		
		for (int i = 0; i < GeoObject.PRE_DEFINED_COUNTRY_NAMES.length; i++) {
			places.add(new GeoObject(GeoObject.PRE_DEFINED_COUNTRY_NAMES[i], GeoObject.PRE_DEFINED_COUNTRY_IMAGES[i], GeoObject.PRE_DEFINED_COUNTRY_IS_EUROPE[i]));
		}
		
		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mRecyclerView.setHasFixedSize(true);
		final GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, places);
		mRecyclerView.setAdapter(mAdapter);
		mRecyclerView.addOnItemTouchListener(this);
		
		mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				return true;
			}
		});
		
		ItemTouchHelper.SimpleCallback simpleItemCallBack =
				new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
					@Override
					public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
						return false;
					}
					
					@Override
					public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
						int position = viewHolder.getAdapterPosition();
						GeoObject geoObject = places.get(position);
						
						checkAnswer(geoObject.ismEurope(), direction);
						
						places.remove(position);
						mRecyclerView.getAdapter().notifyItemRemoved(position);
					}
				};
		ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemCallBack);
		itemTouchHelper.attachToRecyclerView(mRecyclerView);
	}
	
	private void checkAnswer(boolean isEurope, int direction) {
		String europe = (isEurope) ? "This country is in Europe." : "This country is not in Europe.";
		if ((isEurope && direction == ItemTouchHelper.LEFT) || (!isEurope && direction == ItemTouchHelper.RIGHT)) {
			Toast.makeText(this, "You guessed it right! " + europe, Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "You guessed wrong! " + europe, Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
		View child = rv.findChildViewUnder(e.getX(), e.getY());
		int mAdapterPosition = rv.getChildAdapterPosition(child);
		if (child != null && mGestureDetector.onTouchEvent(e)) {
			Toast.makeText(this, places.get(mAdapterPosition).getmCountryName(), Toast.LENGTH_SHORT).show();
		}
		return false;
	}
	
	@Override
	public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
		
	}
	
	@Override
	public void onRequestDisallowInterceptTouchEvent(boolean b) {
		
	}
}
