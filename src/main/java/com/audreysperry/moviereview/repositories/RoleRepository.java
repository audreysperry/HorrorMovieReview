package com.audreysperry.moviereview.repositories;


import com.audreysperry.moviereview.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
    Role findByName(String role);
}
