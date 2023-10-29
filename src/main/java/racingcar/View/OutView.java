package racingcar.View;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car;

public class OutView {
    public static void printCurrentRoundResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for(int i=0;i<car.getStepCount();i++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public static void printWinnerCar(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();
        List<Integer> maxValues = new ArrayList<>();
        int max=0;
        for (Car car : carList) {
            if (car.getStepCount() > max) {
                max = car.getStepCount();
                maxValues.clear(); // 더 큰 숫자를 찾았을 때, 기존 최대값 리스트를 비워준다.
                winnerList.clear();
                maxValues.add(max);
                winnerList.add(car.getName());
            } else if (car.getStepCount() == max) {
                winnerList.add(car.getName()); // 같은 숫자가 나타나면 리스트에 추가
            }
        }
        System.out.print("최종 우승자 : " + String.join(", ", winnerList));
    }
}
