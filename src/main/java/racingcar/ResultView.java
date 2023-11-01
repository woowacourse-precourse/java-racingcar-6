package racingcar;


import java.util.ArrayList;
import java.util.List;


//출력 (ResultView 클래스) : 경주 결과를 화면에 출력하는 기능

public class ResultView {

    public static void displayCarPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + new String(new char[car.getDistance()]).replace('\0', '-'));
        }
        System.out.println();
    }

    public static void displayWinners(List<Car> cars) {
        System.out.println("최종 우승자 : " + getWinners(cars));
    }

    // getWinners, getMaxDistance, getCarNamesWithDistance 메서드 이동

    private static String getWinners(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);
        return getCarNamesWithDistance(cars, maxDistance);
    }
    private static int getMaxDistance(List<Car> cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }
    private static String getCarNamesWithDistance(List<Car> cars, int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }
        return String.join(", ", winners);
    }
}
