package racingcar.View;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Service.RaceService;

public class InputView {
    RaceService raceService = new RaceService();

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_PLAY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> inputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String input = Console.readLine();
        raceService.checkCarNamesValidation(input);
        return Arrays.stream(input.split(",")).toList();
    }

    public int inputPlayCount() {
        System.out.println(INPUT_PLAY_COUNT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

}
