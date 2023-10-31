package racingcar.View;

import racingcar.Model.Car;
import racingcar.Model.RacingMap;

import java.util.List;

public class TextView implements View{
    @Override
    public void printSetCarString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void printSetNumOfAttempt() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void printMapProcess(RacingMap map) {
        for(Car car: map.getCarList()){
            printCarProcess(car.getName(), car.getProcess());
        }
        System.out.println();
    }

    public void printCarProcess(String name, int process){
        System.out.println(name + " : " + "-".repeat(process));
    }

    @Override
    public void printWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
