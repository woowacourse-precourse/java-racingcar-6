package racingcar.game.outputgeneratemanager;

import java.util.List;
import racingcar.game.Rule;
import racingcar.game.car.RacingCar;

public class OutputGenerateManager {

    private final Rule rule;

    public OutputGenerateManager(Rule rule) {
        this.rule = rule;
    }

    public void printRace(List<RacingCar> racingCars){
        printResult();
        printResultList(racingCars);
    }

    private void printResult() {
        System.out.println("실행 결과");
    }

    private void printWinner(){
        System.out.print("최종 우승자 : ");
    }

    private void printResultList(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            String hyphenedPoint = rule.countToHyphen(racingCar);
            System.out.println(racingCar.getName() +" : "+hyphenedPoint);
        }
    }

    public void askCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askRepeatCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

}
