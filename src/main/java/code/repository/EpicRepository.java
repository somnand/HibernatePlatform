package code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import code.types.Epic;
import code.types.EpicId;

@Repository
public interface EpicRepository extends JpaRepository<Epic, EpicId>
{
	//Pre filled by Spring
}
