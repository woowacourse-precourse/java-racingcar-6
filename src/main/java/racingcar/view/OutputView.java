package racingcar.view;

import java.util.List;
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

    public void winners(List<String> winners) {
        StringBuilder sb = new StringBuilder();

        sb.append("최종 우승자 : ");
        for (String winner : winners) {
            sb.append(winner + ", ");
        }
        sb.delete(sb.length() - 2, sb.length() + 1);

        System.out.print(sb);
    }
}
