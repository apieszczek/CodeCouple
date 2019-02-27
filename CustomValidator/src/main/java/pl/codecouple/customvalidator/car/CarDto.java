package pl.codecouple.customvalidator.car;

import pl.codecouple.customvalidator.number.ExpectedNumbers;

public class CarDto {

	String model;
	@ExpectedNumbers(expectedNumbers = {3,5}, message = "Wrong number of doors.")
	Integer doorNumber;
	@ExpectedNumbers(expectedNumbers = {50,100, 150}, message = "Wrong number of horse power.")
	Integer horsePower;

	public CarDto() {
	}

	public String getModel() {
		return model;
	}

	public void setModel(final String model) {
		this.model = model;
	}

	public Integer getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(final Integer doorNumber) {
		this.doorNumber = doorNumber;
	}

	public Integer getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(final Integer horsePower) {
		this.horsePower = horsePower;
	}
}
