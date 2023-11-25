package com.example.clientcrud.services;

import com.example.clientcrud.dto.ClientDTO;
import com.example.clientcrud.entities.Client;
import com.example.clientcrud.repositories.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

   private ClientRepository repository;

    public ClientRepository getrepository() {
        return repository;
    }

    public void setrepository(ClientRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(Pageable pageable) {
        Page<Client> list = repository.findAll(pageable);
        return list.map(x -> new ClientDTO(x));
    }
}
