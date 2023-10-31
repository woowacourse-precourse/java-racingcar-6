package racingcar;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = readLine();
        List<String> carNames = Arrays.asList(carNamesInput.split(","));

        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = Integer.parseInt(readLine());

        Race race = new Race(carNames);
        for (int i = 0; i < rounds; i++) {
            race.playRound();
            race.printProgress();
        }

        List<String> winners = race.getWinners();
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}
