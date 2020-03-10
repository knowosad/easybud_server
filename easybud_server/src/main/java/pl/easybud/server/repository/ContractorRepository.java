package pl.easybud.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.easybud.server.entity.ContractorEntity;

@Repository
public interface ContractorRepository extends JpaRepository<ContractorEntity, Long> {
}
