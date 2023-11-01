package racingcar;

public class Game {
    private final Car[] cars;


    Game(String[] carNames) {
        cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    public void play(int tries) {
        for (int i = 0; i < tries; i++) {
            playRound();
            System.out.println();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
            System.out.println(car.getName() + " : " + car.getProgress());
        }
    }
    public void determineWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        StringBuilder winners = new StringBuilder();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + winners);
    }

}
