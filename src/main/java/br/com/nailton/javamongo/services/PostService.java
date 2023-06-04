package br.com.nailton.javamongo.services;

import br.com.nailton.javamongo.domain.Post;
import br.com.nailton.javamongo.repository.PostRepository;
import br.com.nailton.javamongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;


    public Post findById(String id) {
        if (repo.findById(id).isPresent()) {
            return repo.findById(id).get();
        }
        throw new ObjectNotFoundException("Objeto não encontrado");
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
