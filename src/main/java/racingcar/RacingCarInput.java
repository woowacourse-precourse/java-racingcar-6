package racingcar;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class RacingCarInput {
    public List<String> getCarNameInput(){
        String inputStr = Console.readLine();
        List<String> inputCarNames = List.of(inputStr.split(","));
        validateCarName(inputCarNames);
        return deleteDuplicate(inputCarNames);
    }

    private void validateCarName(List<String> inputCarNames) {
        for (String carName : inputCarNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private List<String> deleteDuplicate(List<String> carNames) {
        List<String> distinctCarNames = new ArrayList<>();
        for (String carName : carNames) {
            if (!distinctCarNames.contains(carName)) {
                distinctCarNames.add(carName);
            }
        }
        return distinctCarNames;
    }

    public int getUserInput(){
        String inputStr = Console.readLine();
        return validateUserInputAndConvert(inputStr);
    }

    private int validateUserInputAndConvert(String inputStr) {
        for (char c : inputStr.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("횟수는 숫자만 가능합니다.");
            }
        }
        return Integer.parseInt(inputStr);
    }
}
