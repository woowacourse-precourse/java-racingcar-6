package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.message.RaceMessage;
import racingcar.message.ValidateErrorMessage;

public class InputView {

    public List<String> getCars(){
        System.out.println(RaceMessage.CARS_INPUT_MESSAGE);
        return Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
    public int getRaceCount(){
        System.out.println(RaceMessage.RACE_COUNT_INPUT_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidateErrorMessage.COUNT_TYPE_ERROR);
        }
    }
}
