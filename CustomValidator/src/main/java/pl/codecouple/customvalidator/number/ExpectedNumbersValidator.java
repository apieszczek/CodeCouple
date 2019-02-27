package pl.codecouple.customvalidator.number;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExpectedNumbersValidator implements ConstraintValidator<ExpectedNumbers, Integer> {

	private int[] expectedNumbers;

	@Override
	public void initialize(ExpectedNumbers expectedNumbers) {
		this.expectedNumbers = expectedNumbers.expectedNumbers();
	}

	@Override
	public boolean isValid(Integer fieldValue, ConstraintValidatorContext cxt) {
		return fieldValue == null || Arrays.stream(expectedNumbers).boxed().collect(Collectors.toList()).contains(fieldValue);
	}
}
