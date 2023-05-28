package br.com.nailton.javamongo.services;

import br.com.nailton.javamongo.domain.User;
import br.com.nailton.javamongo.repository.UserRepository;
import br.com.nailton.javamongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        if (repo.findById(id).isPresent()) {
            return repo.findById(id).get();
        }
        throw new ObjectNotFoundException("Objeto não encontrado");
    }
}
