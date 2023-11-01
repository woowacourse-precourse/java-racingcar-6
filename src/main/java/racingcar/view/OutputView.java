package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.constant.OutputConstant.*;

public class OutputView {
    static public void gameStart() {
        System.out.println(GAME_START.getOutput());
    }
    static public void gameProgress(Car car) {
        System.out.print(car.getName() + " : " );
        for (int i = 0; i < car.getCount(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    static public void gameResult(List<String> winners) {
        System.out.print(GAME_RESULT.getOutput());
        for (int i = 0; i < winners.size(); i++) {
            if (winners.size() == i+1) {
                System.out.println(winners.get(i));
                return;
            }
            System.out.print(winners.get(i) + ", ");
        }
    }

    static public void skipLine() {
        System.out.println();
    }
}
