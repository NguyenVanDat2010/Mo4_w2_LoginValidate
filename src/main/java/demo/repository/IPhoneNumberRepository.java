package demo.repository;

import demo.model.PhoneNumber;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IPhoneNumberRepository extends PagingAndSortingRepository<PhoneNumber,Long> {
}
