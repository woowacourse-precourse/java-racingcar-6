package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.StringJoiner;
import racingcar.dto.CreateMoveOpportunityRequest;
import racingcar.dto.CreateRacingCarRequest;
import racingcar.dto.RacingCarDto;

public class RacingGameConsoleView {

    private static final String RACING_CAR_NAME_REQUEST_MESSAGE =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_COUNT_REQUEST_MESSAGE =
            "시도할 회수는 몇회인가요?";
    private static final String RACING_RESULT_TITLE_MESSAGE = "실행 결과";
    private static final String RACING_WINNER_RESULT_MESSAGE = "최종 우승자 : ";

    public CreateMoveOpportunityRequest inputMoveOpportunity() {
        System.out.println(MOVE_COUNT_REQUEST_MESSAGE);
        return new CreateMoveOpportunityRequest(Console.readLine());
    }

    public CreateRacingCarRequest inputRacingCarNames() {
        System.out.println(RACING_CAR_NAME_REQUEST_MESSAGE);
        return new CreateRacingCarRequest(Console.readLine());
    }

    public void printResultTitle() {
        System.out.println();
        System.out.println(RACING_RESULT_TITLE_MESSAGE);
    }

    public void printResult(List<RacingCarDto> racingResultDtos) {
        for (RacingCarDto racingCarDto : racingResultDtos) {
            Name name = racingCarDto.getName();
            Position position = racingCarDto.getPosition();
            System.out.print(name);
            System.out.print(" : ");
            System.out.print("-".repeat(position.getPosition()));
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(List<RacingCarDto> racingCarDtos) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        System.out.print(RACING_WINNER_RESULT_MESSAGE);
        for (RacingCarDto racingCarDto : racingCarDtos) {
            Name name = racingCarDto.getName();
            stringJoiner.add(name.toString());
        }
        System.out.println(stringJoiner);
    }
}
