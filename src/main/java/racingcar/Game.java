package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    public Game(){
    }

    public void play() {
        Input input = getInput();
    }

    private Input getInput() {
        printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carListInput = readLine();
        isValidCarListInput(carListInput);
        List<String> carList = Arrays.stream(carListInput.split(",")).collect(Collectors.toList());

        printMessage("시도할 회수는 몇회인가요?");
        String trialNumberInput = readLine();
        Integer trialNumber = validateAndParseString(trialNumberInput);

        Input input = new Input(carList, trialNumber);
        return input;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void isValidCarListInput(String input) {
        if (!input.matches("^\\w{1,5}(,\\w{1,5})*$")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능합니다.");
        }
    }

    private Integer validateAndParseString(String input) {
        if(input.equals("0") || !input.matches("^-?\\d+$")) {
            throw new IllegalArgumentException("정수값으로 시도할 횟수를 입력해야 합니다.");
        }
        return Integer.parseInt(input);
    }
}
