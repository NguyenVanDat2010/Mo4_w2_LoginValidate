package demo.validate;

import demo.model.PhoneNumber;
import demo.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
//    private final Validator emailValidator;
//
//    public UserValidator(Validator emailValidator){
//        if (emailValidator == null) {
//            throw new IllegalArgumentException("The supplied [Validator] is " +
//                    "required and must not be null.");
//        }
//        if (!emailValidator.supports(PhoneNumber.class)) {
//            throw new IllegalArgumentException("The supplied [Validator] must " +
//                    "support the validation of [email] instances.");
//        }
//        this.emailValidator = emailValidator;
//    }
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String email = user.getEmail();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","email.empty");
        if (!email.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}")) {
            errors.rejectValue("email", "email.matches");
        }
//        try {
//
//
////            errors.pushNestedPath("email");
////            ValidationUtils.invokeValidator(this.emailValidator,user.getEmail(),errors);
//        }finally {
//            errors.popNestedPath();
//        }
    }
}
