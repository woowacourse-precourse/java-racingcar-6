package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class Print {

    static StringBuilder sb;
    public static void printEachRotate(List<Car> cars) {
        sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.name).append(" : ");
            for (int i=0; i<car.length; i++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void printResult(List<String> winCars) {
        sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        String result = String.join(",", winCars);
        sb.append(result);
        System.out.print(sb.toString());
    }


}
