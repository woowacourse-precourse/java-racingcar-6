package racingcar.view;

import java.util.List;
import racingcar.dto.CarStatusDto;

public class OutputView {
    private static final String MOVE_EXPRESS = "-";

    private OutputView() {
    }

    public static void printResult(List<CarStatusDto> carStatuses) {
        for (CarStatusDto carStatus : carStatuses) {
            String movement = MOVE_EXPRESS.repeat(carStatus.position());
            System.out.printf("%s : %s \n", carStatus.name(), movement);
        }
        System.out.println();
    }
}
