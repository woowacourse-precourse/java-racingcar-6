package racingcar.race;
import java.util.List;
public class Race {
    private final List<Car> cars;
    private final int rounds;

    public Race(List<Car> cars,  int rounds){
     this.cars = cars;
     this.rounds = rounds;
    }

    public void racing(){
        System.out.println("\n실행 결과");
        for(int i =0; i <rounds; i++){
            cars.forEach(Car::move);
            showLabTime();
        }
    }

    private void showLabTime(){
        for(Car car : cars){
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }
}
