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
        SaveData(Console.readLine());
        System.out.println("시도할 횟수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private void SaveData(String cars) {
        for(String s : cars.split(",")) {
            validation.validation_check(s);
            gameData.addData(s);
        }
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
        Map<String, Integer> cars = gameData.getResult();

        List<String> winner = new ArrayList<>();
        int max = -1;
        for(String car : cars.keySet()) {
            if(max <= cars.get(car)) {
                max = cars.get(car);
                winner.add(car);
            }
        }
        gameBoard.showWinner(winner);
    }
}
