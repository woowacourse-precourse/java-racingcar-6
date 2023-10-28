package racingcar;

import racingcar.domain.ExceptionCheck;
import racingcar.domain.GameController;
import racingcar.domain.GameData;
import racingcar.domain.View;

import static racingcar.domain.ExceptionCheck.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        View view = new View();
        GameController controller = new GameController();
        GameData gameData = new GameData();


        view.printAskCarName();
        String carsName = controller.getCarNamesInput();
        String[] carsNameArray = carsName.split(",");
        isCarNameInputLengthValidate(carsNameArray);
        int carQuantity = carsNameArray.length;
        gameData.createCarList(carQuantity);
        gameData.setCarsName(carsNameArray);

        view.printAskTryRepetitionNumber();
        String repetitionNumberInput = gameData.getrepetitionNumberInput();
        isRepetitionNumberInputTypeValidate(repetitionNumberInput);
        isRepetitionNumberInputRangeValidate(repetitionNumberInput);
        gameData.changeRepetitionNumberType(repetitionNumberInput);
        Integer repetitionNumber = gameData.getrepetitionNumber();
        for (int repetition = 0; repetition < repetitionNumber; repetition++) {

            controller.MoveForward(gameData.getCarList());
            controller.setRacingProgressStatus(gameData.getCarList());
            view.printProgressStatus(gameData.getCarList());
        }

        gameData.sortCarListByRank();
        gameData.setWinnerList();

        view.printWinner(gameData.getWinnerList());
    }
}
