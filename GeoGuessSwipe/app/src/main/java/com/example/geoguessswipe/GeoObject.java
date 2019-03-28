package com.example.geoguessswipe;

public class GeoObject {
	private String mCountryName;
	private int mCountryImageName;
	private boolean mEurope;
	
	public boolean ismEurope() {
		return mEurope;
	}
	
	public void setmEurope(boolean mEurope) {
		this.mEurope = mEurope;
	}
	
	public String getmCountryName() {
		return mCountryName;
	}
	
	public void setmCountryName(String mCountryName) {
		this.mCountryName = mCountryName;
	}
	
	public int getmCountryImageName() {
		return mCountryImageName;
	}
	
	public void setmCountryImageName(int mCountryImageName) {
		this.mCountryImageName = mCountryImageName;
	}
	
	public GeoObject(String mCountryName, int mCountryImageName, boolean mIsInEurope) {
		this.mCountryName = mCountryName;
		this.mCountryImageName = mCountryImageName;
		this.mEurope = mIsInEurope;
	}
	
	public static final String[] PRE_DEFINED_COUNTRY_NAMES = {
			"Denmark",
			"Canada",
			"Bangladesh",
			"Kazachstan",
			"Colombia",
			"Poland",
			"Malta",
			"Thailand"
	};
	
	public static final int[] PRE_DEFINED_COUNTRY_IMAGES = {
			R.drawable.img1_yes_denmark,
			R.drawable.img2_no_canada,
			R.drawable.img3_no_bangladesh,
			R.drawable.img4_yes_kazachstan,
			R.drawable.img5_no_colombia,
			R.drawable.img6_yes_poland,
			R.drawable.img7_yes_malta,
			R.drawable.img8_no_thailand
	};
	
	public static final boolean[] PRE_DEFINED_COUNTRY_IS_EUROPE = {
			true,
			false,
			false,
			true,
			false,
			true,
			true,
			false
	};
	
	
}
