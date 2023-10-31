package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.JudgeWinner;
import racingcar.model.RaceNumber;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameManager {
    private Car car;
    private final RaceNumber raceNumber;

    public GameManager() {
        raceNumber = new RaceNumber();
    }

    public void setCarMembers() {
        car = new Car(Input.setCarMembers());
    }

    public void gameStart() {
        setCarMembers();
        int num = Input.setRaceNumber();
        int[] move = new int[car.getCarMembers().size()];
        Output.resultMessage();
        for (int i = 0; i < num; i++) {
            raceNumber.createRaceNumber(car.getCarMembers());
            moveArray(raceNumber.getRaceNumber(), move);
            printResult(car.getCarMembers(), move);
        }
        JudgeWinner judgeWinner = new JudgeWinner(move, car.getCarMembers());
        Output.winnerMessage();
        System.out.println(judgeWinner.getWinner());
    }

    public void moveArray(int[] raceNumber, int[] move) {
        for (int i = 0; i < raceNumber.length; i++) {
            if (raceNumber[i] == 1) {
                move[i] += 1;
            }
        }
    }

    public void printResult(List<String> carMember, int[] moveNumber) {
        for (int i = 0; i < carMember.size(); i++) {
            System.out.print(carMember.get(i) + " : ");
            for (int j = 0; j < moveNumber[i]; j++) {
                Output.raceMessage();
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

}
