package lp3.bomservico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lp3.bomservico.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	boolean existsByUsernameAndPasswordAndEnabled(String username, String password, boolean enabled);
	User findByUsername(String username);
}
