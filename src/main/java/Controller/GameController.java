package Controller;

import Model.GameData;
import View.GameBoard;
import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameController {

    private static GameData gameData;
    private static GameBoard gameBoard = new GameBoard();

    public int getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        SaveData(Console.readLine().split(","));
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void SaveData(String[] cars) {
        gameData = new GameData(cars);
    }

    public void decideToMove() {
        int n = gameData.getCarCount();
        int[] move = new int[n];
        for(int i=0; i<n; i++) {
            if(pickNumberInRange(0, 9) >= 4)
                move[i] = 1;
        }
        gameBoard.showGameResult(gameData.getCars(),
                gameData.getTotalDistance(move));
    }

    public void findWinner() {
        int n = gameData.getCarCount();
        String[] cars = gameData.getCars();
        int[] distance = gameData.getCarDistance();

        gameBoard.showWinner(cars);
    }
}
