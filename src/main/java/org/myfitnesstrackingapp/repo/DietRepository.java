package org.myfitnesstrackingapp.repo;

import org.myfitnesstrackingapp.model.entity.Diet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepository extends JpaRepository<Diet,Long> {
}
