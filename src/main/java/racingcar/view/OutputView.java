package racingcar.view;

import racingcar.domain.dto.CarMovementDto;
import racingcar.domain.dto.CarsMovementDto;
import racingcar.domain.dto.WinnersDto;

public class OutputView {
    private static final String DISTANCE = "-";
    private static final String NEW_LINE = "\n";
    private boolean isInitialPrintDone = true;

    private void printInitialResultMessage() {
        if (isInitialPrintDone) {
            System.out.print(NEW_LINE + "실행 결과" + NEW_LINE);
            isInitialPrintDone = false;
        }
    }

    public void printGameResult(CarsMovementDto carsMovementDto) {
        printInitialResultMessage();
        printCarMovement(carsMovementDto);
    }

    private void printCarMovement(CarsMovementDto carsMovementDto) {
        for (CarMovementDto carMovementDto : carsMovementDto.carsMovementDto()) {
            String carName = carMovementDto.carName().getName();
            String totalDistanceForPosition = positionToTotalDistance(carMovementDto);
            System.out.printf("%s : %s%s", carName, totalDistanceForPosition, NEW_LINE);
        }
        System.out.println();
    }

    private String positionToTotalDistance(CarMovementDto carMovementDto) {
        return DISTANCE.repeat(carMovementDto.position());
    }

    public void printGameWinner(WinnersDto winnersDto) {
        System.out.println("최종 우승자 : " + winnersDto.winners());
    }
}
