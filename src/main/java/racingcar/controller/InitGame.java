package racingcar.controller;


import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.view.OutPutString;

public class InitGame {

    private final ArrayList<Car> classList;
    private final int count;

    public InitGame() {
        OutPutString.printGuessName(); // 1.자동차 이름 입력 요구

        CarListController carList = new CarListController(); // 2. 자동차 리스트 생성.
        classList = carList.getClassList(); // 리스트 저장

        OutPutString.printGuessCount(); // 3. 경주횟수 입력 요구

        InputCount inputCount = new InputCount();
        count = inputCount.getCount(); // 4. 경주횟수 저장

        System.out.println();
    }

    public ArrayList<Car> getClassList() {
        return classList;
    }

    public int getCount() {
        return count;
    }

}
