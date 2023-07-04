package com.grupo9.tpintegrador.data.repositories;

import com.grupo9.tpintegrador.data.models.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, UUID> {
    Optional<Cliente> findByDni(String dni);

    @Query("SELECT c FROM Cliente c WHERE (:dni is null or c.dni LIKE CONCAT('%', :dni, '%')) and (:email is null or c.email LIKE CONCAT('%', :email, '%'))")
    Page<Cliente> findByDniAndEmail(@Param("dni") String dni, @Param("email") String email, Pageable pageable);
}
