package com.client.module.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.client.module.entity.Commande;


@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
	

	Commande findByIdAndClient(Integer id,Integer idClient);
	void deleteByIdAndClient(Integer id,Integer idClient);
	
	@Query(   "SELECT c "
			+ "FROM Commande c "
			+ "INNER JOIN c.client cli "
			+ "WHERE cli.id = :id"
		  )
	public List<Commande> findByClient(@Param("id") Integer idClient);

}
