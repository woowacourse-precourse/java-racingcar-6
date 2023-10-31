package racingcar;

import java.util.ArrayList;
import java.util.List;
import model.Car;

public class Race {
    private final List<String> positionList = new ArrayList<>();
    private final List<String> currentPositions = new ArrayList<>();

    public String raceCar(List<Car> cars, int times){

        while(times > 0){
            System.out.print("\n");
            for (Car car : cars) {
                int move = car.moveForward();
                System.out.println(car.getName() + " : " + move + car.getPosition());
                currentPositions.add(car.getPosition());
            }
            times--;
        }
        System.out.println(currentPositions);
        for(int i = currentPositions.size()-1; i >= currentPositions.size() - cars.size(); i--){
            positionList.add(currentPositions.get(i));
        }
        System.out.println(positionList);

        return "게임종료";
    }

    public void raceResult(){

    }
}
