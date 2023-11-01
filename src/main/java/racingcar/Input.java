package racingcar;

import java.util.Arrays;
import java.util.List;

public class Input {
    public static final String DELIMITER = ",";
    private List<String> carList;
    private Integer trialNumber;

    public Input(List<String> carList, Integer trialNumber) {
        this.carList = carList;
        this.trialNumber = trialNumber;
    }

    public List<String> getCarList() {
        return carList;
    }

    public Integer getTrialNumber() {
        return trialNumber;
    }

    public static Input validateInput(String carListInput, String trialNumberInput) {
        List<String> carList = validateCarListInput(carListInput);
        Integer trialNumber = validateAndParseString(trialNumberInput);
        Input input =  new Input(carList, trialNumber);
        return input;
    }

    private static List<String> validateCarListInput(String input) {
        List<String> names = Arrays.asList(input.split(DELIMITER, -1));
        for(String name : names){
            NameChecker.checkName(name);
        }
        return names;
    }

    private static Integer validateAndParseString(String input) {
        if (input.equals("0") || !input.matches("^-?\\d+$")) {
            throw new IllegalArgumentException("정수값으로 시도할 횟수를 입력해야 합니다.");
        }
        return Integer.parseInt(input);
    }
}
