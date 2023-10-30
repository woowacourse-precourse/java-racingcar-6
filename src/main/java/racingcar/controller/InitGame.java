package racingcar.controller;


import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.view.OutputString;

public class InitGame {
    private final ArrayList<Car> classList;
    private final int count;

    public InitGame() {
        OutputString.printGuessName();      // 1. 이름입력

        CarListController carList = new CarListController();    // 2. 자동차클래스리스트 생성
        classList = carList.getClassList(); // 3. 자동차클래스리스트 저장

        OutputString.printGuessCount();     // 4. 횟수입력

        InputCount inputCount = new InputCount(); // 횟수객체 생성
        count = inputCount.getCount(); // 횟수저장

        System.out.println();
    }

    public ArrayList<Car> getClassList() {
        return classList;
    }

    public int getCount() {
        return count;
    }

}
