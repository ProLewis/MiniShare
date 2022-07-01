package com.cody.miniShare.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cody.miniShare.models.Collection;
import com.cody.miniShare.models.Mini;

@Repository
public interface MiniRepository extends CrudRepository<Mini, Long> {
	List<Mini> findAll();
	//List<Mini> findByCollectionIdIs(Long collectionId);
	//List<Mini> findAllByCollections(Collection collection);
}
