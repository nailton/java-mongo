package br.com.nailton.javamongo.repository;

import br.com.nailton.javamongo.domain.Post;
import br.com.nailton.javamongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{'title':  {$regex: ?0, $options: 'i'}}")
    List<Post> searchTitle(String text);
    List<Post> findByTitleContainingIgnoreCase(String text);
}
