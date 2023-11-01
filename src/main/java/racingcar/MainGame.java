package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class MainGame {

    public List<String> judgement(List<Car> cars) {
        int max = 0;
        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCount() > max) {
                max = car.getCount();
                winner.clear();
                winner.add(car.getName());
            } else if (car.getCount() == max) {
                winner.add(car.getName());
            }
        }
        return winner;
    }

    public void run() {
        CustomView customView = new CustomView();
        List<Car> cars = new ArrayList<>();
        customView.printStart();
        String inputPlayer = Console.readLine();
        List<String> players = customView.strSplit(inputPlayer);
        cars = Car.strToCar(players);
        customView.printStartRound();
        int inputRound = Integer.parseInt(Console.readLine());
        Round round = new Round(inputRound);
        round.rounding(cars); // 각 라운드 결과
        customView.printGameResult(judgement(cars));
    }

}
