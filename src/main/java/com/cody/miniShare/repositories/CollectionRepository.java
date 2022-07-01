package com.cody.miniShare.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cody.miniShare.models.Collection;

@Repository
public interface CollectionRepository extends CrudRepository<Collection, Long>{
	List<Collection> findAll();
	Collection findByIdIs(Long id);
}
