package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class GameBoard {

    private Cars cars;
    private Integer tryInput;
    GameBoard(Cars cars, Integer tryInput) {
        this.cars = cars;
        this.tryInput = tryInput;
    }

    public void viewGamePlaying(){
        System.out.println("실행 결과");
        for(int i = 0 ; i < tryInput ; i++) {
            viewOneGame();
        }
    }

    public void viewGameWinner() {
        String printWinnerCars = cars.getWinners().stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(","));
        System.out.print("최종 우승자 : ");
        System.out.println(printWinnerCars);
    }
    public void viewOneGame() {
        List<Car> carList = cars.getCars();
        carList.stream()
                .forEach(car -> carPlay(car));
        System.out.println();
    }

    private void carPlay(Car car) {
        car.selectMove();
        printCarPlay(car);
    }

    private void printCarPlay(Car car) {
        System.out.print(car.getCarName() + " : ");
        for(int i = 0 ; i < car.getPosition() ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
