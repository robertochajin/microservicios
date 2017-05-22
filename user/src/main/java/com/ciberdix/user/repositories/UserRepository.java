package com.ciberdix.user.repositories;

import com.ciberdix.user.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Roberto Chajin Ortiz
 */
@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
  
}