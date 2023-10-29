package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Game;

public class OutputView {

    public void resultPhrase() {
        System.out.println("실행 결과\n");
    }
    public void resultByRound(Game game) {
        Car[] cars = game.getCars();
        StringBuilder sb = new StringBuilder();

        for(Car car : cars) {
            sb.append(car.getName() + " : " + car.getStep() + "\n");
        }

        System.out.print(sb);
    }
}
