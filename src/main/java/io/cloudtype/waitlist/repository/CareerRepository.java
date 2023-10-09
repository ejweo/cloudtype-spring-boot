package io.cloudtype.waitlist.repository;

import io.cloudtype.waitlist.model.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<Career, Long> {

}