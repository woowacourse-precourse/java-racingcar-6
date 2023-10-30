package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String SEPARATOR = ",";
    public List<String> inputCarNames(){
        String carNames = Console.readLine();
        validateNullAndBlank(carNames);
        return Arrays.stream(carNames.split(SEPARATOR))
                .toList();
    }

    private void validateNullAndBlank(String carNames){
        if(carNames == null || carNames.isBlank()){
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
    }
}
