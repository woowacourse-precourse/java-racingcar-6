package racingcar.model.race;

public class Race {
    private Car[] cars;

    public Race(String[] carNames) {
        cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    public void printRace() {
        for (int i = 0; i < cars.length; i++) {
            System.out.print(cars[i].printMovement() + "\n");
        }
        System.out.println();
    }

    public void selectWinner() {
        RaceResult.printWinner(cars);
    }
}
