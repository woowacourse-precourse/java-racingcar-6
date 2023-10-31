package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.CarView;

import java.util.ArrayList;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private Race race;
    private CarView view;

    public void startGame() {
        ArrayList<String> carNames = receiveCarNames();
        int moves = receiveMoveNum();

        race = new Race(carNames);

        startRace(moves);
        announceWinners();
    }

    private ArrayList<String> receiveCarNames() {
        /* Get car names */
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        /* Parse input (car names) into Arraylist */
        StringTokenizer st1 = new StringTokenizer(input, ",");
        ArrayList<String> carNames = new ArrayList<String>();
        while(st1.hasMoreTokens()) carNames.add(st1.nextToken());

        return carNames;
    }

    private int receiveMoveNum() {
        /* Get number of moves */
        System.out.println("시도할 회수는 몇회인가요?");
        int moves = Integer.parseInt(Console.readLine());

        return moves;
    }

    private void startRace(int moves) {
        for (int i = 0; i < moves; i++) {
            race.moveCars();
            view.printRaceResult(race.getCars());
        }
    }

    private void announceWinners() {
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
