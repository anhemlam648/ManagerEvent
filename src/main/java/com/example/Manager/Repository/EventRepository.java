package com.example.Manager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.events.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
}
