package pl.kurs.java.encrypt.error;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.java.encrypt.service.EncryptAlgo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ValidAlgoValidator implements ConstraintValidator<ValidAlgo, String> {
    private final Set<EncryptAlgo> allAglos;
    @Override
    public boolean isValid(String algo, ConstraintValidatorContext constraintValidatorContext) {
        return allAglos.stream().anyMatch(a -> a.key().equals(algo));
    }
}
