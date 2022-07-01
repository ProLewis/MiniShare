package com.cody.miniShare.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cody.miniShare.models.Set;

@Repository
public interface SetRepository extends CrudRepository<Set, Long> {
	List<Set> findAll();
}
