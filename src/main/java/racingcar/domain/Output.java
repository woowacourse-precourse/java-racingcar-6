package racingcar.domain;

public class Output {
    public static void printCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getMileage(); ++i) {
            System.out.print("-");
        }
        System.out.println();
    }
}
