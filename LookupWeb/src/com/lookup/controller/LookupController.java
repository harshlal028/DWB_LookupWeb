package com.lookup.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lookup.entity.Places;
import com.lookup.requestmodel.CountRecord;
import com.lookup.requestmodel.PlaceName;
import com.lookup.service.IPlacesService;
import com.lookup.utils.IResponse;
import com.lookup.utils.ResponseCodes;

/**
 * LookupController provide methods to query for places.
 * 
 * @author harsh
 *
 */
@ControllerAdvice
@Controller
public class LookupController {

	@Autowired(required = true)
	protected IResponse respHandle;

	@Autowired(required = true)
	protected IPlacesService serviceObj;

	@Autowired
	protected ApplicationContext context;

	/* Defining Logger for Logging messages */
	private static final Logger logger = Logger.getLogger(LookupController.class.getName());

	/* Constructor */
	public LookupController() {
		System.out
				.println("=================================! Controller is UP !======================================");
	}

	/*
	 * ===============================EXCEPTION
	 * HANDLING=======================================
	 */
	@ExceptionHandler(NullPointerException.class)
	public @ResponseBody ResponseEntity<String> NullPointerException(NullPointerException e) {
		e.printStackTrace();
		return RaiseInternalError(e.getMessage());
	}

	@ExceptionHandler(BeansException.class)
	public @ResponseBody ResponseEntity<String> BeansException(BeansException e) {
		e.printStackTrace();
		return RaiseInternalError(e.getMessage());
	}

	@ExceptionHandler(NumberFormatException.class)
	public @ResponseBody ResponseEntity<String> NumberFormatException(NumberFormatException e) {
		e.printStackTrace();
		return RaiseInternalError(e.getMessage());
	}

	@ExceptionHandler(RuntimeException.class)
	public @ResponseBody ResponseEntity<String> RuntimeException(RuntimeException e) {
		e.printStackTrace();
		return RaiseInternalError(e.getMessage());
	}

	@ExceptionHandler(IOException.class)
	public @ResponseBody ResponseEntity<String> IOException(IOException e) {
		e.printStackTrace();
		return RaiseInternalError(e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public @ResponseBody ResponseEntity<String> Exception(Exception e) {
		e.printStackTrace();
		return RaiseInternalError(e.getMessage());
	}
	/*
	 * =============================================================================
	 * =============
	 */

	/**
	 * This function is used to fetch details of all the places stored.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/List", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Places> getAllPlaces() {
		List<Places> placeList = null;
		placeList = serviceObj.getAllPlaces();
		return placeList;
	}

	/**
	 * This function gives a count of all the places stored.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/List/Count", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody CountRecord getPlacesCount() {
		CountRecord countData = (CountRecord) context.getBean("CountRecord");
		int placeCount = 0;
		placeCount = serviceObj.getPlacesCount();
		countData.setCount(placeCount);
		return countData;
	}

	/**
	 * This function is used to return the details of a named place.
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/List/Name", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Places getPlaceDetailByName(@RequestBody PlaceName name) {
		logger.info("Name received for query is " + name);
		Places placeDetails = null;
		placeDetails = serviceObj.getPlaceByName(name.getName());
		return placeDetails;
	}

	/**
	 * This function is used to fetch a list of places based on category.
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/List/Category/{category}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Places> getPlaceDetailByCategory(@PathVariable("category") String category) {
		logger.info("Category received for query is " + category);
		List<Places> placeList = null;
		placeList = serviceObj.getPlaceByCategory(category);
		return placeList;
	}

	/**
	 * This function is used to fetch list of places based on rating.
	 * 
	 * @param rating
	 * @return
	 */
	@RequestMapping(value = "/List/Rating/{rating:.+}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Places> getPlaceDetailByRating(@PathVariable("rating") float rating) {
		logger.info("Rating received for query is " + rating);
		List<Places> placeList = null;
		placeList = serviceObj.getPlaceByRating(rating);
		return placeList;
	}

	/**
	 * This function is used to fetch a list of places with rating greater than
	 * equal to the given rating.
	 * 
	 * @param rating
	 * @return
	 */
	@RequestMapping(value = "/List/Rating/{rating:.+}/Large", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Places> getPlaceDetailByRatingLarge(@PathVariable("rating") float rating) {
		logger.info("Rating received for query is " + rating);
		List<Places> placeList = null;
		placeList = serviceObj.getPlaceByRatingLarge(rating);
		return placeList;
	}

	/**
	 * This function is used to fetch a list of places with rating less than or
	 * equal to the given rating.
	 * 
	 * @param rating
	 * @return
	 */
	@RequestMapping(value = "/List/Rating/{rating:.+}/Small", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Places> getPlaceDetailByRatingSmall(@PathVariable("rating") float rating) {
		logger.info("Rating received for query is " + rating);
		List<Places> placeList = null;
		placeList = serviceObj.getPlaceByRatingSmall(rating);
		return placeList;
	}

	/**
	 * This fucntion is used to fetch a list of places based on category and equal
	 * to a given rating.
	 * 
	 * @param category
	 * @param rating
	 * @return
	 */
	@RequestMapping(value = "/List/Category/{category}/Rating/{rating:.+}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Places> getPlaceDetailByCategoryRating(@PathVariable("category") String category,
			@PathVariable("rating") float rating) {
		logger.info("Category received is " + category);
		logger.info("Rating received is " + rating);
		List<Places> placeList = null;
		placeList = serviceObj.getPlaceByCategoryRating(category, rating);
		return placeList;
	}

	/**
	 * This function is used to fetch a list of places based on category and greater
	 * than equal to a given rating.
	 * 
	 * @param category
	 * @param rating
	 * @return
	 */
	@RequestMapping(value = "/List/Category/{category}/Rating/{rating:.+}/Large", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Places> getPlaceDetailByCategoryRatingLarge(@PathVariable("category") String category,
			@PathVariable("rating") float rating) {
		logger.info("Category received is " + category);
		logger.info("Rating received is " + rating);
		List<Places> placeList = null;
		placeList = serviceObj.getPlaceByCategoryRatingLarge(category, rating);
		return placeList;
	}

	/**
	 * This function is used to fetch a list of places based on category and less
	 * than equal to a given rating.
	 * 
	 * @param category
	 * @param rating
	 * @return
	 */
	@RequestMapping(value = "/List/Category/{category}/Rating/{rating:.+}/Small", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Places> getPlaceDetailByCategoryRatingSmall(@PathVariable("category") String category,
			@PathVariable("rating") float rating) {
		logger.info("Category received is " + category);
		logger.info("Rating received is " + rating);
		List<Places> placeList = null;
		placeList = serviceObj.getPlaceByCategoryRatingSmall(category, rating);
		return placeList;
	}

	/**
	 * This function is used to fetch a list of places based on lattitude.
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/List/Lat/{lattitude:.+}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Places> getPlaceDetailByLat(@PathVariable("lattitude") String lattitude) {
		logger.info("Lattitude received for query is " + lattitude);
		List<Places> placeList = null;
		placeList = serviceObj.getPlaceByLat(lattitude);
		return placeList;
	}

	/**
	 * This function is used to fetch a list of places based on longitude.
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/List/Long/{longitude:.+}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Places> getPlaceDetailByLong(@PathVariable("longitude") String longitude) {
		logger.info("Lattitude received for query is " + longitude);
		List<Places> placeList = null;
		placeList = serviceObj.getPlaceByLong(longitude);
		return placeList;
	}

	/**
	 * This function is used to fetch a list of places based on lattitude &
	 * longitude.
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/List/LatLong/{lattitude:.+}/{longitude:.+}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Places getPlaceDetailByLatLong(@PathVariable("lattitude") String lattitude,
			@PathVariable("longitude") String longitude) {
		logger.info("Lattitude received for query is " + longitude);
		Places place = null;
		place = serviceObj.getPlaceByLatLong(lattitude, longitude);
		return place;
	}

	/**
	 *
	 * @param message
	 * @return error message with corresponding data
	 */
	protected ResponseEntity<String> RaiseInternalError(String message) {
		return respHandle.sendResponse(IResponse.FAILURE, ResponseCodes.INTERNAL_ERROR, message);
	}

}
