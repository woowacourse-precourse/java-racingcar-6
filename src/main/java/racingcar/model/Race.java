package racingcar.model;
import java.util.List;
import java.util.ArrayList;
import racingcar.constants.Constants;
import racingcar.view.View;

public class Race {
    private final List<Car> cars;
    private final int rounds;

    public Race(List<Car> cars,  int rounds){
     this.cars = cars;
     this.rounds = rounds;
    }

    public void run(){
        System.out.println(Constants.EXECUTION_RESULT);
        for(int i =0; i <rounds; i++){
            cars.forEach(Car::move);
            View.displayLabTimeNotice(i + 1);
            showLabTime();
            System.out.println();
        }
    }

    private void showLabTime(){
        for(Car car : cars){
            View.displayCarPosition(car.getName(), car.getPosition());
        }
    }
    public List<Car> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

}
