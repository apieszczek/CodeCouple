package pl.codecouple.customvalidator.car;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

	@PostMapping
	public ResponseEntity<String> createCar(@Valid @RequestBody CarDto carToCreate, Errors errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<>(prepareErrorMessage(errors.getAllErrors()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	private String prepareErrorMessage(List<ObjectError> errors) {
		return errors.stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage)
				.collect(Collectors.joining("\n"));
	}
}
