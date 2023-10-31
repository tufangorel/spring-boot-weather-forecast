package com.weather.forecast.api.repository;


import com.weather.forecast.api.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
}