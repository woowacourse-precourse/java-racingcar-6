package racingcar.View;

import java.util.Arrays;
import java.util.List;
import  camp.nextstep.edu.missionutils.Console;
import racingcar.Service.Validation;

public class InputView {
    Validation validation = new Validation();

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_PLAY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> inputCarName(){
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String input = Console.readLine();
        validation.checkCarNamesValidation(input);
        List<String> carNames = Arrays.stream(input.split(",")).toList();
        return carNames;
    }
    public int inputPlayCount(){
        System.out.println(INPUT_PLAY_COUNT_MESSAGE);
        int playCount = Integer.parseInt(Console.readLine());
        System.out.println("");
        return playCount;
    }

}
