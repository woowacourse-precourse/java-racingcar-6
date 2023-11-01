package Service;

import camp.nextstep.edu.missionutils.Console;

public class RaceInputCount {
    public static int raceInputCount() {
        int gameCount;

        System.out.println("시도할 회수는 몇회인가요?");

        try {
            gameCount = Integer.parseInt(Console.readLine());
            if (gameCount <= 0) {
                throw new IllegalArgumentException("시도할 회수는 0 이하일 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }

        return gameCount;
    }
}
