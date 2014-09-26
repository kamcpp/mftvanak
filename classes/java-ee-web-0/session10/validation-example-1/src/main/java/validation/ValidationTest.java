package validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationTest {
    public static void main(String[] args) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Person person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }
}
