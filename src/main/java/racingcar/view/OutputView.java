package racingcar.view;

import racingcar.domain.dto.CarMovementDto;
import racingcar.domain.dto.CarsMovementDto;
import racingcar.domain.dto.WinnersDto;
import racingcar.io.writer.StdWriter;

public class OutputView {
    private static final String DISTANCE = "-";
    private static final String NEW_LINE = "\n";
    private final StdWriter stdWriter;
    private boolean isInitialPrintDone = true;

    public OutputView(StdWriter stdWriter) {
        this.stdWriter = stdWriter;
    }

    private void printInitialResultMessage() {
        if (isInitialPrintDone) {
            stdWriter.write(NEW_LINE + "실행 결과" + NEW_LINE);
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
            stdWriter.write(String.format("%s : %s%s", carName, totalDistanceForPosition, NEW_LINE));
        }
        stdWriter.write(NEW_LINE);
    }

    private String positionToTotalDistance(CarMovementDto carMovementDto) {
        return DISTANCE.repeat(carMovementDto.position());
    }

    public void printGameWinner(WinnersDto winnersDto) {
        stdWriter.write("최종 우승자 : " + winnersDto.winners());
    }
}
