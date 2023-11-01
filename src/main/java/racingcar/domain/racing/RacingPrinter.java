package racingcar.domain.racing;

import racingcar.domain.raingcar.RacingCar;
import racingcar.domain.raingcar.RacingCars;

public class RacingPrinter {
    private static final String RACING_ROUND_RESULT_MESSAGE = "실행 결과";
    private static final String COLON = " : ";
    private static final String Hyphen = "-";
    private static final String NEW_LINE = "\n";
    private StringBuilder sb;

    public RacingPrinter() {
        this.sb = new StringBuilder(RACING_ROUND_RESULT_MESSAGE).append(NEW_LINE);
    }

    public void updateRacingResult(RacingCars cars) {
        for(RacingCar car : cars.getCars()) {
            sb.append(car.getName()).append(COLON).append(getHyphenRepeat(car)).append(NEW_LINE);
        }
        sb.append("\n");
    }

    private String getHyphenRepeat(RacingCar car) {
        return Hyphen.repeat(car.getPosition());
    }

    public String getRacingResult() {
        return sb.toString();
    }
}
