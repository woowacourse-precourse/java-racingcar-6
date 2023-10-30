package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.vo.RacingPreference;

public class InputView {

    public RacingPreference startInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] cars = Console.readLine().split(",");
        System.out.println("시도할 회수는 몇 회 인가요?");
        String attempt = Console.readLine();
        System.out.println("");

        return startInfo(cars, attempt);
    }

    private RacingPreference startInfo(String[] cars, String attempt) {
        validateCarName(cars);
        validateAttempt(attempt);

        return new RacingPreference(cars, Integer.parseInt(attempt));
    }

    public void validateCarName(String[] cars) {
        for (String carName : cars) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateAttempt(String attempt) {
        try {
            Integer.parseInt(attempt);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
