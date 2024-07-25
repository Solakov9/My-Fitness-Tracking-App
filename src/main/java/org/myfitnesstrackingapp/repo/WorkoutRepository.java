package org.myfitnesstrackingapp.repo;

import org.myfitnesstrackingapp.model.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Long> {
}
