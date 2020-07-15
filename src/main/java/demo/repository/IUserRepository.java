package demo.repository;

import demo.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IUserRepository extends PagingAndSortingRepository<User,Long> {
}
