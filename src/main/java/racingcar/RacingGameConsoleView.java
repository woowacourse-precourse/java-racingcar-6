package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameConsoleView {

    private static final String RACING_CAR_NAME_REQUEST_MESSAGE =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_COUNT_REQUEST_MESSAGE =
            "시도할 회수는 몇회인가요?";

    public MoveCountDto inputMoveCount() {
        System.out.println(MOVE_COUNT_REQUEST_MESSAGE);
        return new MoveCountDto(Console.readLine());
    }

    public RacingCarNameRegistryDto inputRacingCarNames() {
        System.out.println(RACING_CAR_NAME_REQUEST_MESSAGE);
        return new RacingCarNameRegistryDto(Console.readLine());
    }
}
