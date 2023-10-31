package racingcar.view;

import java.util.List;
import racingcar.Dto.CarDto;
import racingcar.Dto.CurrentRacingStatusDto;

public class OutputView {
    private final String SKID = "-";

    public void printInit() {
        System.out.println("실행 결과");
    }

    public void printCurrentStatus(CurrentRacingStatusDto currentRacingStatusDto) {
        for(CarDto car : currentRacingStatusDto.cars()) {
            System.out.println(car.name() + " : " + "-".repeat(car.distance()));
        }
    }

    public void printResult(List<String> result) {
        System.out.println("최종 우승자 : " + String.join(", ", result));
    }
}
