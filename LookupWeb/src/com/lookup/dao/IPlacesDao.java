package com.lookup.dao;

import java.util.List;

import com.lookup.entity.Places;

public interface IPlacesDao {

	List<Places> getAllPlaces() throws IllegalStateException;

	long getPlacesCount() throws IllegalStateException;

	public Places getPlaceByName(String name) throws IllegalStateException;

	List<Places> getPlaceByCategory(String category) throws IllegalStateException;

	List<Places> getPlaceByRating(float rating) throws IllegalStateException;

	List<Places> getPlaceByCategoryRating(String category, float rating) throws IllegalStateException;

	List<Places> getPlaceByCategoryRatingSmall(String category, float rating) throws IllegalStateException;

	List<Places> getPlaceByCategoryRatingLarge(String category, float rating) throws IllegalStateException;

	List<Places> getPlaceByRatingLarge(float rating) throws IllegalStateException;

	List<Places> getPlaceByRatingSmall(float rating) throws IllegalStateException;

	List<Places> getPlaceByLat(String lattitude);

	List<Places> getPlaceByLong(String longitude);

	Places getPlaceByLatLong(String lattitude, String longitude);

}