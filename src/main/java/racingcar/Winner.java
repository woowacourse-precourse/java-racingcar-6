package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {


    public void findWinners(List<Car> carList) {
        // 가장 큰 locate 값 찾기
        int maxLocate = Integer.MIN_VALUE;
        for (Car car : carList) {
            int locate = car.getLocate();
            if (locate > maxLocate) {
                maxLocate = locate;
            }
        }

        // 가장 큰 locate 값을 가진 Car 객체들의 이름 출력
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getLocate() == maxLocate) {
                winners.add(car.getName());
            }
        }

        // 출력
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(winners.get(i));
        }
        System.out.println();
    }
}
