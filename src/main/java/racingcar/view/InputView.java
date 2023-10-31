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
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
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
        System.out.println("시도할 회수는 몇회인가요?");
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
