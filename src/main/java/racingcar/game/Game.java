package racingcar.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Game {

    private static final int MAX_NAME_LENGTH = 5;
    public static void play() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = getCarNames(Console.readLine());

        int count = getCount();

        Race race = new Race(carNames, count);
        race.start();
    }

    private static int getCount() {
        int count;
        try {
            System.out.println("시도할 횟수는 몇회인가요?");
            count = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 입력해주세요.");
        }
        return count;
    }

    private static String[] getCarNames(String carNameString) {
        String[] carNames = carNameString.split(",");

        boolean exceedsNameLengthMax = Arrays.stream(carNames).anyMatch(name -> name.length() > MAX_NAME_LENGTH);
        if (exceedsNameLengthMax) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "를 초과할 수 없습니다.");
        }

        return carNames;
    }
}
