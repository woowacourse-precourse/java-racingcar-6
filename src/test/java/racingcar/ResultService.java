package racingcar;

public class ResultService {
    public static void printNumberOfMovingForward(Cars cars) {
        for (Object car : cars.keySet()) {
            System.out.printf("%s : ", car);
            int numberOfMovingForward = (int) cars.get(car);
            printDashes(numberOfMovingForward);
        }
    }

    public static void printDashes(int numberOfMovingForward) {
        if (numberOfMovingForward == 0) {
            System.out.print("\n");
        } else {
            for (int i = 1; i <= numberOfMovingForward; i++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
    }

    public static void printResultStart() {
        System.out.println("실행 결과");
    }



}
