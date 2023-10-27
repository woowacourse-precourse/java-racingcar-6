package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class Print {

    public void message(String message) {
        System.out.println(message);
    }

    public void result(List<Car> carList) {
        System.out.println("실행 결과");
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            System.out.print(car.getName() + " : ");
            for (int j = 0; j < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void winner(List<Car> carList) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (int i = 0; i < carList.size(); i++) {
            sb.append(carList.get(i).getName() + ", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

}
