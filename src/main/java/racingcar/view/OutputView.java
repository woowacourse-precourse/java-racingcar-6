package racingcar.view;

import racingcar.domain.dto.CarMovementDto;
import racingcar.domain.dto.CarsMovementDto;
import racingcar.domain.dto.WinnersDto;

public final class OutputView {
    private static final String DISTANCE = "-";
    private static final String NEW_LINE = "\n";
    private boolean isFirstPrint = true;

    private void printAllRoundMessageAtFirst() {
        if (isFirstPrint) {
            System.out.print(NEW_LINE + "실행 결과" + NEW_LINE);
            isFirstPrint = false;
        }
    }

    public void printGameResult(CarsMovementDto carsMovementDto) {
        printAllRoundMessageAtFirst();
        for (CarMovementDto carMovementDto : carsMovementDto.carsMovementDto()) {
            System.out.printf("%s : %s%s", carMovementDto.carName().getName(),
                    DISTANCE.repeat(carMovementDto.position()), NEW_LINE);
        }
        System.out.println();
    }

    public void printGameWinner(WinnersDto winnersDto) {
        System.out.println("최종 우승자 : " + winnersDto.winners());
    }
}
