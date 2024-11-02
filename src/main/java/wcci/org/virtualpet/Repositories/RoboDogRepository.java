package wcci.org.virtualpet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import wcci.org.virtualpet.Models.*;

@Repository
public interface RoboDogRepository extends JpaRepository <RoboDogModel, Long> {
    List<RoboDogModel> findByNameContainingIgnoreCase(String Name);
}
