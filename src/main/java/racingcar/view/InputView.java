package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");
    private static final String SEPARATOR = ",";
    public List<String> inputCarNames(){
        String carNames = Console.readLine();
        validateNullAndBlank(carNames);
        return Arrays.stream(carNames.split(SEPARATOR))
                .toList();
    }

    private void validateNullAndBlank(String input){
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
    }

    public Integer inputGameCount(){
        String gameCount = Console.readLine();
        validateNullAndBlank(gameCount);
        validateNumeric(gameCount);
        return Integer.parseInt(gameCount);
    }

    private void validateNumeric(String input){
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

}
