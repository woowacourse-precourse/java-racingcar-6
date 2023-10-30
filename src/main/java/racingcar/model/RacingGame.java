package racingcar.model;

public class RacingGame {

    private final Cars cars;
    private final RandomNumberGenerator randomNumberGenerator;
    private final RaceCountInput raceCountInput;

    public RacingGame(Cars cars, RandomNumberGenerator randomNumberGenerator, RaceCountInput raceCountInput) {
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
        this.raceCountInput = raceCountInput;
    }

    public void startGame() {
        for (int i = 0; i < raceCountInput.getRaceCount(); i++) {
            playRound();
        }
    }

    private void playRound() {
        cars.getCars().forEach(car -> {
            if(randomNumberGenerator.getRandomNumber() >= 5){
                car.move();
            }
        });
    }
}
