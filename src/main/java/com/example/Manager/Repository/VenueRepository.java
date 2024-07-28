package com.example.Manager.Repository;

import com.example.Manager.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Location,Long> {
}
