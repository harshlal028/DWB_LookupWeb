package com.lookup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lookup.entity.Places;

public class PlacesDao implements IPlacesDao {

	public PlacesDao() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Places> getAllPlaces() throws IllegalStateException {
		List<Places> placesList = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANSPersistence");
		EntityManager em = emf.createEntityManager();
		String query = "select s from Places s";
		try {
			placesList = em.createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in executing getAllPlaces Query");
		} finally {
			em.close();
			emf.close();
		}
		return (placesList);
	}

	@Override
	public long getPlacesCount() throws IllegalStateException {
		long count = 0;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANSPersistence");
		EntityManager em = emf.createEntityManager();
		String query = "select count(s) from Places s";
		try {
			count = (long) em.createQuery(query).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in executing getPlacesCount Query");
		} finally {
			em.close();
			emf.close();
		}
		return (count);
	}

	@Override
	public Places getPlaceByName(String name) throws IllegalStateException {
		Places place = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANSPersistence");
		EntityManager em = emf.createEntityManager();
		String query = "select s from Places s where s.name = :name";
		try {
			place = (Places) em.createQuery(query).setParameter("name", name).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in executing getPlaceByName Query");
		} finally {
			em.close();
			emf.close();
		}
		return (place);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Places> getPlaceByCategory(String category) throws IllegalStateException {
		List<Places> placesList = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANSPersistence");
		EntityManager em = emf.createEntityManager();
		String query = "select s from Places s where s.category = :category";
		try {
			placesList = em.createQuery(query).setParameter("category", category).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in executing getPlaceByCategory Query");
		} finally {
			em.close();
			emf.close();
		}
		return (placesList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Places> getPlaceByRating(float rating) throws IllegalStateException {
		List<Places> placesList = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANSPersistence");
		EntityManager em = emf.createEntityManager();
		String query = "select s from Places s where format(s.rating,1) = format(:rating,1)";
		try {
			placesList = em.createQuery(query).setParameter("rating", rating).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in executing getPlaceByRating Query");
		} finally {
			em.close();
			emf.close();
		}
		return (placesList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Places> getPlaceByRatingLarge(float rating) throws IllegalStateException {
		List<Places> placesList = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANSPersistence");
		EntityManager em = emf.createEntityManager();
		String query = "select s from Places s where format(s.rating,1) >= format(:rating,1)";
		try {
			placesList = em.createQuery(query).setParameter("rating", rating).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in executing getPlaceByRatingLarge Query");
		} finally {
			em.close();
			emf.close();
		}
		return (placesList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Places> getPlaceByRatingSmall(float rating) throws IllegalStateException {
		List<Places> placesList = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANSPersistence");
		EntityManager em = emf.createEntityManager();
		String query = "select s from Places s where format(s.rating,1) <= format(:rating,1)";
		try {
			placesList = em.createQuery(query).setParameter("rating", rating).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in executing getPlaceByRatingSmall Query");
		} finally {
			em.close();
			emf.close();
		}
		return (placesList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Places> getPlaceByCategoryRating(String category, float rating) throws IllegalStateException {
		List<Places> placesList = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANSPersistence");
		EntityManager em = emf.createEntityManager();
		String query = "select s from Places s where s.category =:category AND format(s.rating,1) = format(:rating,1)";
		try {
			placesList = em.createQuery(query).setParameter("category", category).setParameter("rating", rating)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in executing getPlaceByCategoryRating Query");
		} finally {
			em.close();
			emf.close();
		}
		return (placesList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Places> getPlaceByCategoryRatingLarge(String category, float rating) throws IllegalStateException {
		List<Places> placesList = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANSPersistence");
		EntityManager em = emf.createEntityManager();
		String query = "select s from Places s where s.category =:category AND format(s.rating,1) >= format(:rating,1)";
		try {
			placesList = em.createQuery(query).setParameter("category", category).setParameter("rating", rating)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in executing getAllPlaces Query");
		} finally {
			em.close();
			emf.close();
		}
		return (placesList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Places> getPlaceByCategoryRatingSmall(String category, float rating) throws IllegalStateException {
		List<Places> placesList = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANSPersistence");
		EntityManager em = emf.createEntityManager();
		String query = "select s from Places s where s.category =:category AND format(s.rating,1) <= format(:rating,1)";
		try {
			placesList = em.createQuery(query).setParameter("category", category).setParameter("rating", rating)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in executing getPlaceByCategoryRatingSmall Query");
		} finally {
			em.close();
			emf.close();
		}
		return (placesList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Places> getPlaceByLat(String lattitude) {
		List<Places> placesList = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANSPersistence");
		EntityManager em = emf.createEntityManager();
		String query = "select s from Places s where s.latitude = :latitude";
		try {
			placesList = em.createQuery(query).setParameter("latitude", lattitude).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in executing getPlaceByLat Query");
		} finally {
			em.close();
			emf.close();
		}
		return (placesList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Places> getPlaceByLong(String longitude) {
		List<Places> placesList = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANSPersistence");
		EntityManager em = emf.createEntityManager();
		String query = "select s from Places s where s.longitude = :longitude";
		try {
			placesList = em.createQuery(query).setParameter("longitude", longitude).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in executing getPlaceByLong Query");
		} finally {
			em.close();
			emf.close();
		}
		return (placesList);
	}

	@Override
	public Places getPlaceByLatLong(String lattitude, String longitude) {
		Places place = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANSPersistence");
		EntityManager em = emf.createEntityManager();
		String query = "select s from Places s where s.latitude =:latitude AND s.longitude = :longitude";
		try {
			place = (Places) em.createQuery(query).setParameter("latitude", lattitude)
					.setParameter("longitude", longitude).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in executing getPlaceByCategoryRating Query");
		} finally {
			em.close();
			emf.close();
		}
		return (place);
	}

}
