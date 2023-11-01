package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.CarController;
import racingcar.model.Car;
import racingcar.model.CarDto;

public class OutputView {
    public void printStartMessage() {
        System.out.println("실행 결과");
    }

    public void printCarStatus(CarDto dto) {
        System.out.println(dto.getName() + " : " + "-".repeat(dto.getPosition()));
    }

    public void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
