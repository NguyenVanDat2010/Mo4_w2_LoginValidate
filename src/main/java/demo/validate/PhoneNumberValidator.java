package demo.validate;

import demo.model.PhoneNumber;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PhoneNumberValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneNumber.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneNumber phone = (PhoneNumber) target;
        String number = phone.getNumber();
        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
        if (number.length() > 11 || number.length() < 10) {
            errors.rejectValue("number", "number.length");
        }
        if (!number.startsWith("0")) {
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("number", "number.matches");
        }
    }
}
