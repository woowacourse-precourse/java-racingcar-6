package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {

    public static void printEachForwardResult(List<Car> cars) {
        System.out.println();
        System.out.println("실행 결과");
        for(Car car: cars) {
            System.out.println(getCarStatus(car));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnwerNames = winners.stream()
                        .map(Car::getName)
                                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnwerNames);

    }

    private static String getCarStatus(Car car) {
        return car.getName() + " : " + getCarPositionInDash(car);
    }

    private static String getCarPositionInDash(Car car) {
        return new String(new char[car.getPosition()]).replace("\0", "-");
    }


}
