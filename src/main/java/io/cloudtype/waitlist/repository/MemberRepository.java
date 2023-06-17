package io.cloudtype.waitlist.repository;

import io.cloudtype.waitlist.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
