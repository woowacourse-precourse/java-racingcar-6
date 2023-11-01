package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        System.out.println("시도할 회수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());

        Race race = new Race(carNames, count);
        race.startRace();

        System.out.println();
        System.out.println("최종 우승자 : " + race.getWinners());
    }
}
