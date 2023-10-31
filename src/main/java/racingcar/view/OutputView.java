package racingcar.view;

import racingcar.domain.dto.CarMovementDto;
import racingcar.domain.dto.CarsMovementDto;
import racingcar.domain.dto.WinnersDto;
import racingcar.io.writer.StdWriter;
import racingcar.util.StringUtils;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private final StdWriter writer;
    private boolean isInitialPrintDone = true;

    public OutputView(StdWriter writer) {
        this.writer = writer;
    }

    private void printInitialResultMessage() {
        if (isInitialPrintDone) {
            writer.write(NEW_LINE + "실행 결과" + NEW_LINE);
            isInitialPrintDone = false;
        }
    }

    public void printGameResult(CarsMovementDto carsMovementDto) {
        printInitialResultMessage();
        printCarMovement(carsMovementDto);
    }

    private void printCarMovement(CarsMovementDto carsMovementDto) {
        for (CarMovementDto carMovementDto : carsMovementDto.carsMovementDto()) {
            String carName = carMovementDto.carName();
            String positionDashString = StringUtils.generateDashString(carMovementDto.position());
            writer.write(String.format("%s : %s%s", carName, positionDashString, NEW_LINE));
        }
        writer.write(NEW_LINE);
    }

    public void printGameWinner(WinnersDto winnersDto) {
        writer.write("최종 우승자 : " + winnersDto.winners());
    }
}
