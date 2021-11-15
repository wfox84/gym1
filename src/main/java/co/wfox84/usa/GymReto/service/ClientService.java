/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.service;


import co.wfox84.usa.GymReto.model.Client;
import co.wfox84.usa.GymReto.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author masterKomodoro
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {

        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> caux = clientRepository.getClient(client.getIdClient());
            if (caux.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;

            }
        }

    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> cli = clientRepository.getClient(client.getIdClient());
            if (!cli.isEmpty()) {
                if (client.getEmail() != null) {
                    cli.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    cli.get().setPassword(client.getPassword());
                }
                if (client.getName() != null) {
                    cli.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    cli.get().setAge(client.getAge());
                }
                clientRepository.save(cli.get());
                return cli.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int idClient) {
        Boolean aBoolean = getClient(idClient).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

