package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.constant.OutputConstant.*;

public class OutputView {
    public void inputCarName() {
        System.out.println(INPUT_CAR_NAME.getOutput());
    }

    public void howManyTime() {
        System.out.println(HOW_MANY_TIME.getOutput());
    }

    public void gameStart() {
        System.out.println(GAME_START.getOutput());
    }

    public void gameProgress(Car car) {
        System.out.print(car.getName() + " : " );
        for (int i = 0; i < car.getCount(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void gameResult(List<String> winners) {
        System.out.print(GAME_RESULT.getOutput());
        for (int i = 0; i < winners.size(); i++) {
            if (winners.size() == i+1) {
                System.out.println(winners.get(i));
                return;
            }
            System.out.print(winners.get(i) + ", ");
        }
    }

    public void skipLine() {
        System.out.println();
    }
}
