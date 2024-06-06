package net.eurovision.repositories;

import net.eurovision.entities.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {
    @Query("SELECT count(1) from Word where name in :permutations")
    public int countValidWords(@Param("permutations") List<String> permutations);

    @Query("SELECT name from Word where name in :permutations")
    public List<String> getValidWords(@Param("permutations") List<String> permutations);
}