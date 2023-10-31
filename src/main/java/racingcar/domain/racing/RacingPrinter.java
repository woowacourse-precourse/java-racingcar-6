package racingcar.domain.racing;

import racingcar.domain.raingcar.RacingCar;
import racingcar.domain.raingcar.RacingCars;

public class RacingPrinter {
    private static final String RACING_ROUND_RESULT_MESSAGE = "실행 결과\n";
    private StringBuilder sb;

    public RacingPrinter() {
        this.sb = new StringBuilder(RACING_ROUND_RESULT_MESSAGE);
    }

    public void updateRacingResult(RacingCars cars) {
        for(RacingCar car : cars.getCars()) {
            sb.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append("\n");
        }
        sb.append("\n");
    }

    public String getRacingResult() {
        return sb.toString();
    }
}
