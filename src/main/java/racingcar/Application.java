package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = new Cars();
        Race race = new Race();
        
        String[] carArray = cars.enterCars();
        cars.validateCarsName(carArray);
        
        race.initScorePerCar(carArray);
        race.enterRaceNum();
        race.raceProgress();
        race.findWinner();
    }
}
