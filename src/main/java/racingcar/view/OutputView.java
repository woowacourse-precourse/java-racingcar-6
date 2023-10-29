package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
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

        String winners = gameresult.stream()
                .map(GameWinnerDto::getWinnerCar)
                .collect(Collectors.joining(Message.REST.getMessage()));

        System.out.println(winners);
    }

    public void displayEachGameResult(List<EachMoveResultDto> moveResults) {

        moveResults.stream()
                .forEach(moveResultDto -> System.out.println(
                        moveResultDto.getCarName() + Message.EACHGAMERESULT.getMessage()
                                + Message.MOVEFOWARD.getMessage()
                                .repeat(moveResultDto.getPosition())));
        System.out.println();

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
