package racingcar.game.outputgeneratemanager;

import java.util.ArrayList;
import java.util.List;
import racingcar.game.car.Car;
import racingcar.game.director.Round;
import racingcar.game.director.Rule;

public class OutputGenerateManager {

    private final Rule rule;

    public OutputGenerateManager(Rule rule) {
        this.rule = rule;
    }

    public void printWinners(List<Car> cars) {
        List<Car> winnerList = rule.findWinners(cars);
        String winners = this.winnersToString(winnerList);
        System.out.println(winners);
    }

    private String winnersToString(List<Car> winnerList) {
        List<String> nameList = new ArrayList<>();

        for (Car car : winnerList) {
            String name = car.getName();
            nameList.add(name);
        }

        return String.join(", ", nameList);
    }

    public void printResultList(Round round) {
        List<Car> carList = round.carList();
        for (Car car : carList) {
            String hyphenedPoint = rule.countToHyphen(car);
            System.out.println(car.getName() + " : " + hyphenedPoint);
        }
        System.out.println();
    }

    public void printResultAnnounce() {
        System.out.println("실행 결과");
    }

    public void printWinnerAnnounce() {
        System.out.print("최종 우승자 : ");
    }

    public void printCarNameAnnounce() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRepeatCountAnnounce() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
