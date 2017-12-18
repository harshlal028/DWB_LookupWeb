package com.lookup.service;

import java.util.List;

import com.lookup.entity.Places;

public interface IPlacesService {

	public List<Places> getAllPlaces();

	public int getPlacesCount();

	public Places getPlaceByName(String name);

	public List<Places> getPlaceByCategory(String category);

	public List<Places> getPlaceByRating(float rating);

	public List<Places> getPlaceByRatingLarge(float rating);

	public List<Places> getPlaceByRatingSmall(float rating);

	public List<Places> getPlaceByCategoryRating(String category, float rating);

	public List<Places> getPlaceByCategoryRatingLarge(String category, float rating);

	public List<Places> getPlaceByCategoryRatingSmall(String category, float rating);

	public List<Places> getPlaceByLat(String lattitude);

	public List<Places> getPlaceByLong(String longitude);

	public Places getPlaceByLatLong(String lattitude, String longitude);

}
