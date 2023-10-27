package racingcar.view;

import java.util.List;
import racingcar.domain.EachMoveResultDto;
import racingcar.domain.GameWinnerDto;

public class OutputView {
    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void displayGameResult() {
        System.out.println(Message.GAMERESULT.getMessage());
    }

    public void displayGameWinner(List<GameWinnerDto> gameresult) {
        System.out.print(Message.GAMEWINNER.getMessage());

        StringBuilder winners = new StringBuilder();
        for (GameWinnerDto car : gameresult) {
            winners.append(car.getWinnerCar()).append(Message.REST.getMessage());
        }

        winners.setLength(winners.length() - 1);

        System.out.println(winners.toString());
    }

    public void displayEachGameResult(List<EachMoveResultDto> moveResults) {
        for (EachMoveResultDto moveResultDto : moveResults) {
            System.out.println(
                    moveResultDto.getCarName() + Message.EACHGAMERESULT.getMessage() + Message.MOVEFOWARD.getMessage()
                            .repeat(moveResultDto.getPosition()));
        }
    }


    enum Message {
        GAMERESULT("실행 결과"),
        GAMEWINNER("최종 우승자 : "),
        MOVEFOWARD("-"),
        EACHGAMERESULT(" : "),
        REST(",");

        private String message;

        Message(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }
}
