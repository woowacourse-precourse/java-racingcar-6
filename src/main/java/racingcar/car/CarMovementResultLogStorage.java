package racingcar.car;

public class CarMovementResultLogStorage {

	private String resultStringOfCarMovements = "";

	public void addLog(String logs) {
		resultStringOfCarMovements = resultStringOfCarMovements + logs;
	}

	public String getResultStringOfCarMovements() {
		return resultStringOfCarMovements;
	}
}
