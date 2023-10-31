package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {

    private Cars cars;
    private StepCount stepCount;


    public Game(Cars cars, StepCount stepCount) {
        this.cars = cars;
        this.stepCount = stepCount;
    }

    private void progressGame(){
        for (Car car : cars.getCars()) {
            int randomNumber = createRandomInt();
            car.moveForward(randomNumber);
        }

    }

    public void playGame() {
        System.out.println("실행 결과");
        while (!stepCount.isStepCountZero()) {
            progressGame();
            stepCount.decreaseStep();
            printCurrentSituation();
        }

        List<String> winners = cars.findWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int createRandomInt() {
        return Randoms.pickNumberInRange(0,10);
    }

    private void printCurrentSituation() {
        for (Car car : cars.getCars()) {
            System.out.println(car.printCurrentStatus());
        }
        System.out.println();
    }
}
