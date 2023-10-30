package racingcar.domain;

import racingcar.view.InputView;

import java.util.*;

public class Cars {

    private List<Car> cars;

    public Cars(String carNames) {

        this.cars = carList(carNames);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void carMove(CarMoveCondition carMoveCondition){

        for (Car car : this.cars){
            if (carMoveCondition.moveCondition()){
                car.move();
            }
        }
    }

    public List<Car> carList(String cars){

        List<Car> carsList = Arrays.stream(cars.split(InputView.COMMA))
                .map(Car::new)
                .toList();

        long duplicateNameRemoveLength = carsList.stream().
                distinct().
                count();

        DuplicateCarName(carsList, duplicateNameRemoveLength);

        return carsList;
    }

    public Cars winners() {

        List<Car> winnersCars = new ArrayList<>(this.cars);

        Collections.sort(winnersCars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Integer.compare(o2.getPosition(), o1.getPosition());
            }
        });

        int winnerPosition = winnersCars.get(0).getPosition();

        List<Car> winners = new ArrayList<>();

        for (Car car : winnersCars) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car);
            }
        }

        return new Cars(winners);
    }

    private void DuplicateCarName(List<Car> cars,
                                  long size){
        if (cars.size() != size){
            throw new IllegalArgumentException();
        }
    }
}
