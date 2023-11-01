package racingcar.view;

public class CarView {
    private CarView() {
    }

    public static CarView getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final CarView INSTANCE = new CarView();
    }

    public void printCarStatus(String name, int distance, boolean isLast) {
        String distanceString = "-".repeat(distance);
        System.out.printf("%s : %s%n", name, distanceString);
        if (isLast) {
            System.out.println();
        }
    }
}
