package racingcar.game.outputgeneratemanager;

import java.util.List;
import racingcar.game.Round;
import racingcar.game.Rule;
import racingcar.game.car.Car;

public class OutputGenerateManager {

    private final Rule rule;

    public OutputGenerateManager(Rule rule) {
        this.rule = rule;
    }

    public void printResultAnnounce() {
        System.out.println("실행 결과");
    }

    public void printWinnerAnnounce(){
        System.out.print("최종 우승자 : ");
    }

    public void printWinners(List<Car> cars){
        String winners = rule.printWinners(cars);
        System.out.println(winners);
    }

    public void printCarNameAnnounce(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRepeatCountAnnounce(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultList(Round round) {
        List<Car> carList = round.carList();
        for (Car car : carList) {
            String hyphenedPoint = rule.countToHyphen(car);
            System.out.println(car.getName() + " : " + hyphenedPoint);
        }
        System.out.println();
    }
}
