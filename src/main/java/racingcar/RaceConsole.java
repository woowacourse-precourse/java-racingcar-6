package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class RaceConsole {

    public void start() {
//        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
//        String names = Console.readLine();
//        String[] carNames = names.split(",");
//
//        System.out.println("시도할 회수는 몇회인가요?");
//        String round = Console.readLine();
//        if (!round.matches("\\d+")) {
//            throw new IllegalArgumentException("getCount");
//        }

        String[] carNames = getInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                s -> false,
                s -> s.split(","));

        int rounds = getInput("시도할 회수는 몇회인가요?",
                s -> !s.matches("\\d+"),
                Integer::parseInt);

        CarRace race = new CarRace(carNames, rounds);

        List<String> winners = race.run();
        System.out.print("최종 우승자 : " + winners.get(0));
        for (int i = 0; i < winners.size(); i++) {
            System.out.println(", " + winners.get(i));
        }
    }

    public <String, R> R getInput(String message, Predicate<String> predicate, Function<String, R> function) {
        System.out.println(message);
        String answer = (String) Console.readLine();
        if (predicate.test(answer)) {
            throw new IllegalArgumentException("invalid input");
        }
        return function.apply(answer);
    }

}
