package wcci.org.virtualpet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import wcci.org.virtualpet.Models.*;

@Repository
public interface CatRepository extends JpaRepository <CatModel, Long> {
    List<CatModel> findByNameContainingIgnoreCase(String Name);
}
