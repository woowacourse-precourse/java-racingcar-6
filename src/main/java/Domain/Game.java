package Domain;

public class Game {
    private Car[] cars;
    private int tryCount;

    public Game(Car[] cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public Car[] getCars() {
        return cars;
    }

    public void runGame() {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    public String getWinners() {
        int maxPosition = getMaxPosition();
        return buildWinnersString(maxPosition);
    }

    int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private String buildWinnersString(int maxPosition) {
        StringBuilder winners = new StringBuilder();
        boolean isFirstWinner = true;

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                if (isFirstWinner) {
                    winners.append(car.getCarName());
                    isFirstWinner = false;
                } else {
                    winners.append(",").append(car.getCarName());
                }
            }
        }

        return winners.toString();
    }
}
