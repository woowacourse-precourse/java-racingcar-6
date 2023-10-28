package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public void printCarInfo(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 : ");
        for (int i = 0; i < cars.size(); i++) {
            if (i == cars.size() - 1) {
                stringBuilder.append(cars.get(i).getName() + "\n");
            } else {
                stringBuilder.append(cars.get(i).getName() + ", ");
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public void printCarInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printMoveCountInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }
}
