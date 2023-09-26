package org.fasttrack.repository;

import org.fasttrack.model.ParentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentDetailsRepository extends JpaRepository<ParentDetails, Integer> {
}
