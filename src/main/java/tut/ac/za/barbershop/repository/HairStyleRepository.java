package tut.ac.za.barbershop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tut.ac.za.barbershop.entities.HairStyle;

@Repository
public interface HairStyleRepository extends JpaRepository<HairStyle, Long> {
}
