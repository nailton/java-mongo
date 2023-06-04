package br.com.nailton.javamongo.repository;

import br.com.nailton.javamongo.domain.Post;
import br.com.nailton.javamongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
