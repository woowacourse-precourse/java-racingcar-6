package racingcar.view;

import racingcar.dto.CarResultResponse;

public class OutputView {

    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_GAME_PROGRESS_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printTempMessage() {

        System.out.println(INPUT_GAME_PROGRESS_COUNT_MESSAGE);

    }

    public void printGameProcessResult(CarResultResponse carResultResponse) {
        System.out.println(carResultResponse.toString());
    }
}
