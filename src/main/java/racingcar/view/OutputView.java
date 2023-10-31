package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winner;

public class OutputView {

    private static final String DISTANCE = "-";
    public static void inputCarNamesMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void inputCountNumberMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printCarPositionMessage(Car car){
        System.out.print(car.getName()+" : ");
        for(int i=0; i<car.getPosition(); i++){
            System.out.print(DISTANCE);
        }
    }

    public static void printWinnerMessage(Winner winner){
        System.out.println("최종 우승자 : ");
        System.out.println(winner.getWinnerNames());
    }
}
