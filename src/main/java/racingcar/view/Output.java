package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class Output {
    /**
     * 결과 출력과 관련된 함수
     */
    //++현재 상태를 출력하는 함수
    public void printCurrentCar(List<Car> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getCarName() + " : ");
            for (int j = 0; j < list.get(i).getCount(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    //++최종 우승자를 출력하는 함수
    public void printFinalWinner(List<String> winnerName) {
        System.out.print("최종 우승자 : " + String.join(", ", winnerName));
    }
}
