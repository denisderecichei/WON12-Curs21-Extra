package org.fasttrack.repository;

import org.fasttrack.model.Kid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KidRepository extends JpaRepository<Kid, Integer> {
}
