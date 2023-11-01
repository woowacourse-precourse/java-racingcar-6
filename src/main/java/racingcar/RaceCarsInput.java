package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class RaceCarsInput {
    public List<String> getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String raceCarsInput = Console.readLine();
        List<String> raceCars = Arrays.asList(raceCarsInput.split(","));

        validateLength(raceCars);

        return raceCars;
    }

    private void validateLength(List<String> raceCars) {
        for (String raceCar : raceCars) {
            if (raceCar.isEmpty() || raceCar.length() > 5) {
                throw new IllegalArgumentException("자동차 입력값 오류");
            }
        }
    }

    public int getTimes() {
        System.out.println("시도할 회수는 몇회인가요?");

        String timesInput = Console.readLine();

        int times = Integer.parseInt(timesInput);
        if (times < 0) {
            throw new IllegalArgumentException("0회 이상 필요");
        }
        return times;

    }
}