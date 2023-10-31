package Controller;

import Model.GameData;
import View.GameBoard;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameController {

    private static GameData gameData = new GameData();
    private static GameBoard gameBoard = new GameBoard();
    private static Validation validation = new Validation();

    public int getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        SaveCar(Console.readLine());
        System.out.println("시도할 횟수는 몇회인가요?");
        return SaveNum(Console.readLine());
    }

    private void SaveCar(String cars) {
        for(String s : cars.split(",")) {
            validation.validationName_check(s);
            gameData.addData(s);
        }
        validation.validation_isEmpty(gameData.getCarList());
    }

    private int SaveNum(String num) {
        validation.validationGame_check(num);
        return Integer.parseInt(num);
    }

    public void decideToMove() {
        for(String car : gameData.getCarList()) {
            int move = 0;
            if(Randoms.pickNumberInRange(0,9) >= 4)
                move = 1;
            gameBoard.showGameResult(car, gameData.moveForward(car, move));
        }
        System.out.println();
    }

    public void findWinner() {
        List<Map.Entry<String, Integer>> cars = gameData.getResult();

        List<String> winner = new ArrayList<>();
        int max = -1;
        for(Map.Entry<String,Integer> car : cars) {
            if(max <= car.getValue()) {
                max = car.getValue();
                winner.add(car.getKey());
            }
        }
        gameBoard.showWinner(winner);
    }
}
