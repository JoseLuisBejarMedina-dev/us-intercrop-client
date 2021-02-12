package pe.com.intercorp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.com.intercorp.model.Client;
@Repository
public interface ClientDao extends JpaRepository<Client,Long> {
	@Query(value="SELECT AVG(c.age) FROM client_intercorp c",nativeQuery=true)
	Double findAverageAgeOfAllClients();
	@Query(value="SELECT STDDEV_POP(c.age) FROM client_intercorp c",nativeQuery=true)
	Double findStandartDeviationOfAllClients();

}

