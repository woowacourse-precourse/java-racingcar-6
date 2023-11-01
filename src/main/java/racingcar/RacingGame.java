package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingGame {
    private List<RacingCar> racingCars;
    private Winner winner;
    private int gameCount;

    public void startGame() {
        inputRacingCars();
        inputGameCount();

        System.out.println("실행 결과");
        for (int i = 0 ; i < gameCount ; i++) {
            doGame();
            viewGame();
        }

        winner = Winner.createWinner(racingCars);
        winner.viewWinner();
    }

    private void doGame(){
        for (RacingCar racingCar : racingCars) {
            racingCar.race();
        }
    }
    private void viewGame(){
        for (RacingCar racingCar : racingCars) {
            System.out.print(racingCar.getName() + " : ");
            for (int i = 0 ; i < racingCar.getPosition() ; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void addRacingCar(String name) {
        this.racingCars.add(RacingCar.createRacingCar(name));
    }

    private void inputGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        int tempGameCount = Integer.parseInt(readLine());
        ErrorCatcher.gameCountCheck(tempGameCount);
        this.gameCount = tempGameCount;
    }

    private void inputRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        this.racingCars = new ArrayList<RacingCar>();

        List<String> tempRacingCars = List.of(readLine().split(","));
        ErrorCatcher.carNamingCheck(tempRacingCars);
        for (String newRacingCar : tempRacingCars) {
            addRacingCar(newRacingCar);
        }
    }
}
