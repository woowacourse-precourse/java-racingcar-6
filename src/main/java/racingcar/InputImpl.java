package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputImpl implements Input {

    @Override
    public List<String> carName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = validateCarNames(input);
        return carNames;
    }

    @Override
    public int attemptsNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        int attempts = validateAttemptsNumber(input);
        Console.close();
        return attempts;
    }
    
    private List<String> validateCarNames(String input){
        String[] carNamesArray = input.split(",");
        List<String> carNames = new ArrayList<>();
        for (String name : carNamesArray) {
            String trimmedName = name.trim();
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            carNames.add(trimmedName);
        }
        
        return carNames;
    }
    
    private int validateAttemptsNumber(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 0이상이어야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
    }

}
