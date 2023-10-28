package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String WINNER_LIST = "최종 우승자 : ";

    public static void printResult(List<Car> carList){
        System.out.println(EXECUTE_RESULT);
        for (Car car : carList) {
            printCurrentDistance(car);
        }
        System.out.println();
    }

    public static void printCurrentDistance(Car car){
        System.out.print(car.getCarName() + " : ");
        int carPosition = car.getCarPosition();
        for(int i = 0;i < carPosition; ++i){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinnerList(List<Car> carList){
        System.out.print(WINNER_LIST);
        int winnerDistance = findMaximumDistance(carList);
        List<Car> winnerList = findWinnerList(carList, winnerDistance);
        int size = winnerList.size();
        for (int i = 0; i < size - 1; ++i) {
            if(carList.get(i).getCarPosition() < winnerDistance) continue;
            System.out.print(winnerList.get(i).getCarName() + ", ");
        }
        System.out.println(winnerList.get(size - 1).getCarName());
    }

    private static List<Car> findWinnerList(List<Car> carList, int winnerDistance) {
        List<Car> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if(car.getCarPosition() < winnerDistance) continue;
            winnerList.add(new Car(car.getCarName()));
        }
        return winnerList;
    }

    public static int findMaximumDistance(List<Car> carList){
        int maxDistance = 0;
        for (Car car : carList) {
            maxDistance = Math.max(maxDistance, car.getCarPosition());
        }
        return maxDistance;
    }
}