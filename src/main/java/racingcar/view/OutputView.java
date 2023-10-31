package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.response.MovementDto;
import racingcar.dto.response.WinnersDto;
import racingcar.utility.Writer;

public class OutputView {
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void announceGameResult() {
        Writer.println(" ");
        Writer.println(GAME_RESULT_MESSAGE);
    }

    public void writeMovement(final List<Car> carList) {
        MovementDto movementDto;
        for(Car car: carList) {
            movementDto = new MovementDto(car);
            Writer.println(movementDto.createMessage());
        }
        Writer.println(" ");
    }

    public void writeFinalWinner(final WinnersDto winnersDto) {
        Writer.print(WINNER_MESSAGE);
        Writer.print(winnersDto.createMessage());
    }
}
