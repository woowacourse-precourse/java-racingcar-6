package racingcar;

import java.util.*;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public List<String> inputRacingCarName() {
        String input = Console.readLine();
        String inputArray[] = input.split(",");
        List<String> racingCarName = new ArrayList<>(Arrays.asList(inputArray));
        racingCarNameValidation(racingCarName);
        System.out.println(racingCarName);
        return racingCarName;
    }

    public int inputAttemptNumber() {
        String input = Console.readLine();
        try {
            int attemptNumber = Integer.parseInt(input);
            if(attemptNumber<=0){
                throw new IllegalArgumentException("0보다 큰 수를 입력해주세요");
            }
            return attemptNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야합니다.");
        }
    }

    private void racingCarNameValidation(List<String> racingCarName) {
        HashSet<String> hashSet = new HashSet<>(racingCarName);

        if (hashSet.size() != racingCarName.size()) {
            throw new IllegalArgumentException("이름을 중복으로 입력했습니다.");
        }

        for (int i = 0; i < racingCarName.size(); i++) {
            String validationName = racingCarName.get(i);
            if (validationName.length() > 5 || validationName.length() == 0 || !Pattern.matches("^[a-zA-Z]*$", validationName)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

    }
}
