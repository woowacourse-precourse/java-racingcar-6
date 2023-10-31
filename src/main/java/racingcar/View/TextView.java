package racingcar.View;

import racingcar.Model.Car;
import racingcar.Model.RacingMap;

public class TextView implements View{
    @Override
    public void printGetCarString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    @Override
    public void printGetNumOfAttempt() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void printMapProcess(RacingMap map) {

    }

    public void printCarProcess(Car car){

    }

    @Override
    public void printWinner(RacingMap map) {

    }
}
