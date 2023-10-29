package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Cars {
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 9;

    private List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList){
        this.carList = carList;
    }
    public void setCarList(String inputString) {
        String[] names = inputString.split(",");

        for (String name : names) {
            Car car = new Car(name.trim());
            carList.add(car);
        }
    }

    public void moveCars() {
        for (Car car : carList) {
            car.run(generateRandomNumber());
        }
    }

    public List<Car> getWinner(){
        List<Car> winner = new ArrayList<>();

        Optional<Integer> maxDistance = getMaxDistance();

        carList.stream()
                .filter(car -> car.getDistance() == maxDistance.orElse(0))
                .forEach(winner::add);

        return winner;
    }

    public String getProgressStatus() {
        StringBuilder sb = new StringBuilder();

        carList.forEach(car -> {
            sb.append(car.getName() + " : ");
            sb.append("-".repeat(car.getDistance()));
            sb.append("\n");
        });
        sb.append("\n");

        return sb.toString();
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

    private Optional<Integer> getMaxDistance(){
        Optional<Integer> maxDistance = carList.stream()
                .map(Car::getDistance)
                .max(Comparator.naturalOrder());

        return maxDistance;
    }
}
