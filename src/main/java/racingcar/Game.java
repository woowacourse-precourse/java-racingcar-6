package racingcar;

public class Game {
    private Car[] cars;
    private int rounds;

    public Game(String[] carNames, int rounds) {
        this.rounds = rounds;
        cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    public void startRace() {
        System.out.println();
        System.out.println("실행 결과");
        for (int round = 0; round < rounds; round++) {
            for (Car car : cars) {
                int randomNumber = RandomNum.getRandomNum();
                if (randomNumber >= 4) {
                    car.move();
                }
            }

            printCurrentPositions();
        }
    }

    private void printCurrentPositions() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getDashes(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners() {
        int maxPosition = getMaxPosition();

        StringBuilder winners = new StringBuilder();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.append(car.getName()).append(", ");
            }
        }

        System.out.println("최종 우승자 : " + winners.toString().replaceAll(", $", ""));
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private String getDashes(int position) {
        StringBuilder dashes = new StringBuilder();
        for (int i = 0; i < position; i++) {
            dashes.append("-");
        }
        return dashes.toString();
    }
}
