package ma.enset.immatriculationservice.query.repositories;


import ma.enset.immatriculationservice.query.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, String> {
}
