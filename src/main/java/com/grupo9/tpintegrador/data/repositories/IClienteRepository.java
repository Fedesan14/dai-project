package com.grupo9.tpintegrador.data.repositories;

import com.grupo9.tpintegrador.data.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, UUID> {
    Optional<Cliente> findByDni(String dni);
}
