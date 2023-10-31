package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.CarView;

import java.util.ArrayList;

public class GameController {
    private Race race;
    private CarView view;

    public void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        ArrayList<String> carNames = new ArrayList<>();
        for (String name : input.split(",")) {
            carNames.add(name.trim());
        }
        race = new Race(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int moves = Integer.parseInt(Console.readLine());

        for (int i = 0; i < moves; i++) {
            race.moveCars();
            view.printRaceResult(race.getCars());
        }

        System.out.println("실행 결과");
        ArrayList<Car> winners = getWinners();
        view.printWinners(winners);
    }

    private ArrayList<Car> getWinners() {
        int maxPosition = 0;
        ArrayList<Car> winners = new ArrayList<>();
        for (Car car : race.getCars()) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car);
            } else if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public void setView(CarView view) {
        this.view = view;
    }
}
