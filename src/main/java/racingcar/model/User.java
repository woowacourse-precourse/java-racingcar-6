package racingcar.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private List<String> carNameList;
    public List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        carNameList = Arrays.asList(input.split(","));
        exceptionOfCarNameList();
        return carNameList;
    }

    public int inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine().charAt(0) - '0';
    }

    private void exceptionOfCarNameList() {
        checkNumberOfChar();
        checkDuplicateName();
    }

    private void checkNumberOfChar() {
        for (int i = 0; i < carNameList.size(); i++) {
            if (carNameList.get(i).isBlank() || carNameList.get(i).length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1~5자여야 합니다.");
            }
        }
    }

    private void checkDuplicateName() {
        HashSet<String> carNameSet = new HashSet<>(carNameList);
        if(carNameList.size() != carNameSet.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
