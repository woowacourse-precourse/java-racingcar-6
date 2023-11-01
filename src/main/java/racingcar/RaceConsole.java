package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RaceConsole {

    public static void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        String[] carNames = names.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        String round = Console.readLine();
        if (!round.matches("\\d+")) {
            throw new IllegalArgumentException("getCount");
        }
        CarRace race = new CarRace(carNames, Integer.parseInt(round));

        List<String> winners = race.run();
        System.out.print("최종 우승자 : " + winners.get(0));
        for (int i = 0; i < winners.size(); i++) {
            System.out.println(", " + winners.get(i));
        }
    }


}
