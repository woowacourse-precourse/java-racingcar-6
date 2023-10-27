package racingcar.view;

import java.util.List;
import racingcar.domain.EachMoveResultDto;

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

    public void displayGameWinner() {
        System.out.println(Message.GAMEWINNER.getMessage());
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
        EACHGAMERESULT(" : ");

        private String message;

        Message(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }
}
