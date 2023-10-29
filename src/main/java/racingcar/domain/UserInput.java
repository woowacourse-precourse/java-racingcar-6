package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        String[] carNames = inputCarNames.split(",");
        List<String> dupCheckList = new ArrayList<>();
        for (String carName : carNames) {
            if (dupCheckList.contains(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복없이 설정해주세요.");
            }
            dupCheckList.add(carName);
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
            }
        }
        return carNames;
    }

    private int getTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int tryNumber = Integer.parseInt(Console.readLine());
            return tryNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해주세요.");
        }
    }

    public List<Object> inputRacingData() {
        List<Object> racingData = new ArrayList<>();
        String[] carNames = getCarNames();
        int tryNumber = getTryNumber();
        racingData.add(carNames);
        racingData.add(tryNumber);
        return racingData;
    }
}
