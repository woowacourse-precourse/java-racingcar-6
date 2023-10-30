package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String CAR_NAME_INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_PROMPT = "시도할 회수는 몇회인가요?";
    private static final String TRY_COUNT_INPUT_NON_NEGATIVE_ERROR = "시도 횟수는 0 이상이어야 합니다.";
    private static final String INVALID_INPUT_ERROR = "잘못된 입력입니다. 유효한 숫자를 입력해주세요.";
    private static final String CAR_NAME_INPUT_SIZE_ERROR = "적어도 한 개 이상의 자동차 이름을 입력해주세요.";

    public List<String> readCarNames(){
        System.out.println(CAR_NAME_INPUT_PROMPT);
        String input = Console.readLine();
        List<String> names = Arrays.asList(input.split(","));
        validateNotEmpty(names);
        return trimString(names);
    }

    private List<String> trimString(List<String> names) {
        return names.stream()
                .map(String::trim)
                .toList();
    }

    private void validateNotEmpty(List<String> names) {
        if(names.isEmpty()){
            throw new IllegalArgumentException(CAR_NAME_INPUT_SIZE_ERROR);
        }
    }

    public int readTryCount(){
        System.out.println(TRY_COUNT_INPUT_PROMPT);
        int tryCount = readLineAndParseInt();
        validateNonNegative(tryCount);
        return tryCount;
    }

    private int readLineAndParseInt(){
        try{
            String input = Console.readLine().trim();
            return Integer.parseInt(input);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    private void validateNonNegative(int tryCount) {
        if(tryCount < 0){
            throw new IllegalArgumentException(TRY_COUNT_INPUT_NON_NEGATIVE_ERROR);
        }
    }

}
