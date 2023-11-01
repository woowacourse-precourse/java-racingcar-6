package racingcar.view;

import static racingcar.view.constant.ViewConstant.CAR_MOVE;
import static racingcar.view.constant.ViewConstant.RESULT_VIEW;
import static racingcar.view.constant.ViewConstant.WINNER;

import java.util.List;
import racingcar.domain.dto.CarStatus;
import racingcar.domain.dto.CarsStatus;

public class OutputView {

    public static void printRacingResult(List<CarsStatus> totalCarsStatus) {
        System.out.println();
        System.out.println(RESULT_VIEW);
        totalCarsStatus.forEach(OutputView::printCarsStatusResult);
    }

    private static void printCarsStatusResult(CarsStatus carsStatus) {
        carsStatus.getCarsStatus().forEach(OutputView::printCarStatusResult);
        System.out.println();
    }

    private static void printCarStatusResult(CarStatus carStatusDTO) {
        System.out.println(carStatusDTO.getName() + " : " + CAR_MOVE.repeat(carStatusDTO.getPosition()));
    }

    public static void printRacingWinner(String winners) {
        System.out.println(WINNER + winners);
    }
}
