package com.lookup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lookup.dao.IPlacesDao;
import com.lookup.entity.Places;

public class PlacesService implements IPlacesService {
	
	@Autowired(required=true)
	IPlacesDao daoObj;
	
	@Override
	public List<Places> getAllPlaces()
	{
		List<Places> placeList = null;
		placeList = daoObj.getAllPlaces();
		return placeList;
	}
	
	@Override
	public int getPlacesCount()
	{
		int count = 0;
		count = (int)daoObj.getPlacesCount();
		return count;
	}
	
	@Override
	public Places getPlaceByName(String name)
	{
		Places place = null;
		place = daoObj.getPlaceByName(name);
		return place;
	}
	
	@Override
	public List<Places> getPlaceByCategory(String category)
	{
		List<Places> placeList = null;
		placeList = daoObj.getPlaceByCategory(category);
		return placeList;
	}
	
	@Override
	public List<Places> getPlaceByRating(float rating)
	{
		List<Places> placeList = null;
		placeList = daoObj.getPlaceByRating(rating);
		return placeList;
	}
	
	@Override
	public List<Places> getPlaceByRatingLarge(float rating)
	{
		List<Places> placeList = null;
		placeList = daoObj.getPlaceByRatingLarge(rating);
		return placeList;
	}
	
	@Override
	public List<Places> getPlaceByRatingSmall(float rating)
	{
		List<Places> placeList = null;
		placeList = daoObj.getPlaceByRatingSmall(rating);
		return placeList;
	}
	
	@Override
	public List<Places> getPlaceByCategoryRating(String category, float rating)
	{
		List<Places> placeList = null;
		placeList = daoObj.getPlaceByCategoryRating(category, rating);
		return placeList;
	}
	
	@Override
	public List<Places> getPlaceByCategoryRatingLarge(String category, float rating)
	{
		List<Places> placeList = null;
		placeList = daoObj.getPlaceByCategoryRatingLarge(category, rating);
		return placeList;
	}
	
	@Override
	public List<Places> getPlaceByCategoryRatingSmall(String category, float rating)
	{
		List<Places> placeList = null;
		placeList = daoObj.getPlaceByCategoryRatingSmall(category, rating);
		return placeList;
	}

	@Override
	public List<Places> getPlaceByLat(String lattitude) {
		List<Places> placeList = null;
		placeList = daoObj.getPlaceByLat(lattitude);
		return placeList;
	}

	@Override
	public List<Places> getPlaceByLong(String longitude) {
		List<Places> placeList = null;
		placeList = daoObj.getPlaceByLong(longitude);
		return placeList;
	}

	@Override
	public Places getPlaceByLatLong(String lattitude, String longitude) {
		Places place = null;
		place = daoObj.getPlaceByLatLong(lattitude, longitude);
		return place;
	}

}
