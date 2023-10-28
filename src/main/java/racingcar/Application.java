package racingcar;

import racingcar.domain.GameController;
import racingcar.domain.GameData;
import racingcar.domain.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        View view = new View();
        GameController controller = new GameController();
        GameData gameData = new GameData();

        view.printAskCarName();
        String carNames = controller.getCarNamesInput();
        String[] carNamesArray = carNames.split(","); // 메서드화 하기(split & []->List<Car>)
        gameData.createCarList(carNamesArray.length);
        gameData.setCarsName(carNamesArray);

        view.printAskTryRepetitionNumber();
        gameData.setTryRepetitionNumber();
        for (int Repetition = 0; Repetition < gameData.getTryRepetitionNumber(); Repetition++) {

            controller.MoveForward(gameData.getCarList());
            controller.setRacingProgressStatus(gameData.getCarList());
            view.printProgressStatus(gameData.getCarList());
        }

        gameData.sortCarListByRank();
        gameData.setWinnerList();

        view.printWinner(gameData.getWinnerList());
    }
}
