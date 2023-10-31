package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Referee;
import racingcar.domain.ScoreBoard;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Referee referee = new Referee();
        ScoreBoard scoreBoard = new ScoreBoard();
        ArrayList<Car> carList = new ArrayList<>();
        int tryNumber = 0;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다!");
        }
        for (String carName : carNames) {
            if (carName.length() <= 5) {
                carList.add(new Car(carName));
            } else if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다!");
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        try {
            tryNumber = Integer.valueOf(Console.readLine());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("수를 입력해주세요!");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다!");
        }

        System.out.println();
        System.out.print(scoreBoard.showCarsScore(carList, tryNumber));
        System.out.print(referee.showWinner(carList));
        Console.close();
    }
}
