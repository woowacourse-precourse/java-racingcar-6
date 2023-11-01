package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class Output_View {

    public static void print_Head() {
        System.out.println("실행 결과");
    }

    public static void print_Score(List<Car> cars) {
        for (Car car : cars) {
            print_Car_Score(car);
        }
        System.out.println();
    }

    public static void print_Winners(List<String> carNames) {
        System.out.print("최종 우승자 : ");
        System.out.print(carNames.get(0));
        if (check_SOLO_winner(carNames)) {
            System.out.println();
            return;
        }
        for (int i = 1; i < carNames.size(); i++) {
            System.out.print(", ");
            System.out.print(carNames.get(i));
        }
        System.out.println();
    }

    public static void print_Exception(String message) {
        System.out.println(message);
    }

    private static void print_Car_Score(Car car) {
        System.out.print(car.getName() + " : ");
        print_Position(car);
        System.out.println();
    }

    private static void print_Position(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    private static boolean check_SOLO_winner(List<String> carNames) {
        return carNames.size() == 1;
    }
}
