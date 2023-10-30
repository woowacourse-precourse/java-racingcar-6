package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarList;

import java.util.List;

public class RacingCarView {

    private final String LOCATION = "-";


    public void carNameListInputPrint() {
        System.out.println("경주할 자동차 이름을 입력하시오.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void readCountPrint() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void gameProgressResultPrint(){
        System.out.println("\n실행 결과");
    }
    
    public void gameProgressPrint(CarList carList) {
        for (Car car : carList.getCarList()) {
            int location = car.getLocation();
            System.out.println(car.getName() + " : " + LOCATION.repeat(location));
        }
        System.out.println();
    }

    public void printWinner(List<String> winnerList) {
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winnerList));
    }

}
