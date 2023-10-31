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
        int winCarLength = winCars.size();

        sb.append("최종 우승자 : ");
        for (int i=0; i<winCarLength-1; i++) {
            String winCarName = winCars.get(i);
            sb.append(winCarName).append(", ");
        }
        String lastWinCarName = winCars.get(winCarLength-1);
        sb.append(lastWinCarName);
        System.out.print(sb.toString());
    }


}
