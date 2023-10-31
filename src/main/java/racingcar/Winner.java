package racingcar;

public class Winner {
    public static String findWinner(RCar[] cars) {
        int maxForwardCount = 0;
        StringBuilder winners = new StringBuilder();

        for (RCar car : cars) {
            int forwardCount = car.getForwardCount();
            if (forwardCount > maxForwardCount) {
                maxForwardCount = forwardCount;
                winners = new StringBuilder(car.getName());
            } else if (forwardCount == maxForwardCount) {
                winners.append(", ").append(car.getName());
            }
        }
        return winners.toString();
    }
}
