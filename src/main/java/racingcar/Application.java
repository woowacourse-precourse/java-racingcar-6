package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String[] carNames = Console.readLine().split(",");

        int rounds = Integer.parseInt(Console.readLine());

        try {
            Race race = new Race(carNames);
            race.start(rounds);

            System.out.println("최종 우승자 : " + String.join(", ", race.getWinners()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
