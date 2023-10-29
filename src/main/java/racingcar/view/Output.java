package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class Output {
    /**
     * 결과 출력과 관련된 함수
     */
    //++현재 상태를 출력하는 함수
    public void printCurrentCar(List<Car> carList) {
        carList.forEach(car -> {
            System.out.print(car.getCarName() + " : ");
            System.out.println("-".repeat(car.getCount()));
        });
        System.out.println();
    }

    //++최종 우승자를 출력하는 함수
    public void printFinalWinner(List<String> winnerName) {
        System.out.print("최종 우승자 : " + String.join(", ", winnerName));
    }
}
