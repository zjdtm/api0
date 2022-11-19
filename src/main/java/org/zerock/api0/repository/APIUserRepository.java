package org.zerock.api0.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.api0.domain.APIUser;

public interface APIUserRepository extends JpaRepository<APIUser, String> {
}
