package racingcar.race;
import java.util.List;
import java.util.ArrayList;
public class Race {
    private final List<Car> cars;
    private final int rounds;

    public Race(List<Car> cars,  int rounds){
     this.cars = cars;
     this.rounds = rounds;
    }

    public void run(){
        System.out.println("\n실행 결과");
        for(int i =0; i <rounds; i++){
            cars.forEach(Car::move);
            System.out.printf("# LAB %d1\n", i+1);
            showLabTime();
            System.out.println();
        }
    }

    private void showLabTime(){
        for(Car car : cars){
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
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
