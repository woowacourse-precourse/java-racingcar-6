package racingcar;

import java.util.List;

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
    public void viewOneGame() {
        List<Car> carList = cars.getCars();
        carList.stream()
                .forEach(car -> printCarPlay(car));
    }

    private void printCarPlay(Car car) {
        System.out.println(car.getCarName() + " : ");
        for(int i = 0 ; i < car.getPosition() ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
