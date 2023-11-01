package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarManager carManager = new CarManager();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesInput = Console.readLine();
        List<String> cars = carManager.giveName(namesInput);

        int moveTimes = askTimes();
        System.out.println();

        Racing racing = new Racing();
        Progress progress = new Progress();

        List<Integer> racingResult = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            racingResult.add(0);
        }

        System.out.println("실행 결과");
        for (int i = 0; i < moveTimes; i++) {
            List<Integer> playResult = racing.play(cars);
            for (int j = 0; j < playResult.size(); j++) {
                int sumGoCount = racingResult.get(j) + playResult.get(j);
                racingResult.set(j, sumGoCount);
            }
            progress.onAir(cars, racingResult);
        }

        Referee referee = new Referee();
        String winner = referee.compare(cars, racingResult);
        System.out.println("최종 우승자 : " + winner);
    }

    public static int askTimes() {
        Verification verification = new Verification();

        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        int moveTime = 0;
        try {
            moveTime = Integer.parseInt(input);
            verification.isPositive(moveTime);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        return moveTime;
    }

}
