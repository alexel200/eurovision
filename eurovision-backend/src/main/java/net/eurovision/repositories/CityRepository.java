package net.eurovision.repositories;

import net.eurovision.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    
    @Query("SELECT name FROM City where LENGTH(name) = :wordLength")
    List<String> getNameSevenLength(@Param("wordLength") int wordLength);
}