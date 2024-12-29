package code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import code.types.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String>
{
	//Pre filled by Spring
}
