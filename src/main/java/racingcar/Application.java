package racingcar;

import racingcar.domain.Car;
import racingcar.domain.GameController;
import racingcar.domain.GameData;
import racingcar.domain.View;

import java.util.List;

import static racingcar.domain.ExceptionCheck.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        View view = new View();
        GameController controller = new GameController();
        GameData gameData = new GameData();


        view.printAskCarName();
        String carsName = controller.getCarNamesInput();
        String[] carsNameArray = carsName.split(","); //"|", "*", ".", "&" , "^"  등의 문자를 regex로 사용하는 경우 함수가 동작하지 않는다
        isCarNameInputLengthValidate(carsNameArray);
        int carQuantity = carsNameArray.length;
        gameData.createCarList(carQuantity);
        gameData.setCarsName(carsNameArray, gameData.getCarList());

        view.printAskTryRepetitionNumber();
        String repetitionNumberInput = gameData.getRepetitionNumberInput();
        isRepetitionNumberInputTypeValidate(repetitionNumberInput);
        isRepetitionNumberInputRangeValidate(repetitionNumberInput);
        gameData.changeRepetitionNumberType(repetitionNumberInput);
        Integer repetitionNumber = gameData.getRepetitionNumber();
        for (int repetition = 0; repetition < repetitionNumber; repetition++) {

            List<Car> carListBeforeRacing = gameData.getCarList();
            controller.MoveForward(carListBeforeRacing);
            List<Car> carListAfterMove = gameData.getCarList();
            controller.setRacingProgressStatus(carListAfterMove);
            view.printProgressStatus(carListAfterMove);
        }
        List<Car> carListAfterRacing = gameData.getCarList();
        gameData.sortCarListByRank(carListAfterRacing);
        gameData.setWinnerList();

        view.printWinner(gameData.getWinnerList());
    }
}
