package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {

    private List<String> racingCarNames = new ArrayList<>();
    private ArrayList<RacingCar> racingCarList = new ArrayList<>();
    private int tryCount;
    private ResultView view = new ResultView();

    GameService() {
        setUpGame();
        addRacingCar();
        startGame();
    }

    private void setUpGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        racingCarNames = splitCarNames(Console.readLine());
        System.out.print("시도할 회수는 몇회인가요?");
        tryCount = Integer.parseInt(Console.readLine());
        System.out.println("");
        System.out.println("실행결과");
    }

    public List<String> splitCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    private void addRacingCar() {
        for(int i=0; i<racingCarNames.size(); i++) {
            racingCarList.add(new RacingCar(racingCarNames.get(i)));
        }
    }

    private void startGame() {
        for(int i=0; i<tryCount; i++) {
            for(RacingCar racingCar : racingCarList) {
                racingCar.tryMoveForward();
            }
        }
    }

    void showGameProgress() {
        for(int i=1; i <= tryCount; i++) {
            for(RacingCar racingCar : racingCarList) {
                view.showCurrentPosition(i, racingCar.getSuccessCount());
            }
            System.out.println("");
        }
    }
}
