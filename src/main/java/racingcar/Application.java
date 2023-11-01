package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Race;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        System.out.println("시도할 횟수는 몇회인가요?");
        int attemptCount = Integer.parseInt(Console.readLine());
        System.out.println();

        Race race = new Race(carNames, attemptCount);

        System.out.println("실행 결과");
        race.racing();

        List<String> winners = race.getWinners();
        System.out.println("최종 우승자 : " + String.join(", " , winners));

        Console.close();
    }
}
