package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarList;

public class outputView {

    public static void printMessage(CarList carList){
        System.out.println("실행 결과");
        for (Car car : carList.getCarList()){
            System.out.print(car.toString());
        }
    }

    public static void winner(CarList carList) {
        int maxPosition = carList.getCarList().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);  // 만약 리스트가 비어있을 경우 기본값 0 반환

        // 2. 최대 position 값을 가진 Car들의 이름을 리스트로 가져오기
        List<String> winners = carList.getCarList().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        // 3. 우승자(들)의 이름 출력
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
