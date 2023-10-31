package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Race;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static int getPositiveRoundNumber() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            int round = Integer.parseInt(Console.readLine());
            if (round < 0)
                throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
            return round;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    public static List<String> getValidCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = Arrays.stream(Console.readLine().split(",")).toList();
        for (String name : carNames) {
            if (name.length() >= 5)
                throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
        return carNames;
    }

    public static void main(String[] args) {
        Race race = new Race(getValidCarNames(), getPositiveRoundNumber());
        race.play();
        race.printWinners();
    }
}
