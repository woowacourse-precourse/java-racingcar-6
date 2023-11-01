package racingcar;

import java.util.Map;
public class MainGame {
    InPutCarName inPutCarName = new InPutCarName();
    InPutPlayNumber inPutPlayNumber = new InPutPlayNumber();
    PintCarMove printCarMove = new PintCarMove();
    GameWinner gameWinner = new GameWinner();
    static final String RESULT = "실행 결과";
    public void gameStart() {
        Map<String, Integer> carInfo = inPutCarName.carName();
        inPutCarName.carNameValidator(carInfo);

        int tryNumber = inPutPlayNumber.inPutNumber();
        InPutPlayNumber.playNumberValidator(tryNumber);

        System.out.println(RESULT);
        for(int i = 0; i < tryNumber; i++) {
            printCarMove.printRaceResult(carInfo);
            System.out.println();
        }

        gameWinner.printFinalWinner(carInfo);

    }
}







