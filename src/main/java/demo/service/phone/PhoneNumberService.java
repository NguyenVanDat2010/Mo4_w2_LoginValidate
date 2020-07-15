package demo.service.phone;

import demo.model.PhoneNumber;
import demo.repository.IPhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PhoneNumberService implements IPhoneNumberService {
    @Autowired
    private IPhoneNumberRepository phoneNumberRepository;

    @Override
    public Iterable<PhoneNumber> findAll() {
        return phoneNumberRepository.findAll();
    }

    @Override
    public PhoneNumber findById(Long id) {
        return phoneNumberRepository.findOne(id);
    }

    @Override
    public void save(PhoneNumber model) {
        phoneNumberRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        phoneNumberRepository.delete(id);
    }
}
