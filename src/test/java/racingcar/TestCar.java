//TestCar
package racingcar;

public class TestCar extends Car {
	private final int fixedRandomNumber;

	public TestCar(String name, int fixedRandomNumber) {
		super(name);
		this.fixedRandomNumber = fixedRandomNumber;
	}

	@Override
	protected int makeRandomNumber() {
		return fixedRandomNumber;
	}
}
