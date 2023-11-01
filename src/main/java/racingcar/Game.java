package racingcar;

public class Game {
    private final Cars cars = new Cars();
    private final ResultByRace resultByRace = new ResultByRace();

    public void play() {
        cars.createCars();
        resultByRace.askPlayTime();
        System.out.println("실행 결과");
        resultByRace.showEachResult(cars);
    }
}
