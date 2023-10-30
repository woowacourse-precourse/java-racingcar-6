package racingcar.domain;

import java.util.ArrayList;

public class RacingGame {
    private ArrayList<Car> cars;
    private Referee referee;

    public void prepareGame(ArrayList<Car> carList) {
        this.cars = carList;
        this.referee = new Referee(cars);
    }

    public void startGame(int rounds) {
        if (cars == null || referee == null) {
            throw new IllegalStateException("Game objects not initialized.");
        }

        for (int i = 0; i < rounds; i++) {
            this.cars = referee.playRound(cars);

        }

        System.out.println("\n실행 결과");

    }

    public void printRoundResults() {
        if (referee == null) {
            throw new IllegalStateException("Game not started. No round results to display.");
        }

        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getName() + " : " + "-".repeat(cars.get(i).getPosition()));
        }
    }

    public String printGameWinner() {
        if (referee == null) {
            throw new IllegalStateException("Game not started. No winner to display.");
        }

        ArrayList<Car> winners = referee.determineWinner(cars);

        System.out.print("최종 우승자 : ");

        for (Car winner : winners){System.out.print(winners);}
    }

    public Referee getReferee() {
        return referee;
    }
}
