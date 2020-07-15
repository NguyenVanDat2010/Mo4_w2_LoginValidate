package demo.formatter;

import demo.model.PhoneNumber;
import demo.service.phone.IPhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PhoneNumberFormatter implements Formatter<PhoneNumber> {
    private IPhoneNumberService phoneNumberService;

    @Autowired
    public PhoneNumberFormatter (IPhoneNumberService phoneNumberService){
        this.phoneNumberService = phoneNumberService;
    }

    @Override
    public PhoneNumber parse(String text, Locale locale) throws ParseException {
        return phoneNumberService.findById(Long.parseLong(text));
    }

    @Override
    public String print(PhoneNumber object, Locale locale) {
        return "[" + object.getId() + "," + object.getNumber() + "]";
    }
}
