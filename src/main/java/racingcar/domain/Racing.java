package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.ConstMessages.ATTEMPT_COUNT_MESSAGE;
import static racingcar.util.Validator.validateCarNames;
import static racingcar.util.Validator.validateNumericInput;

public class Racing {
    private final List<Car> carList;
    private Racing(List<Car> cars) {
        this.carList = cars;
    }

    public Racing registerCarList(){
        String names = Console.readLine();
        validateCarNames(names);

        List<Car> cars = makeCarList(names.split(","));

        return new Racing(cars);
    }

    private List<Car> makeCarList(String[] names){
        List<Car> cars = new ArrayList<>();
        for(String name : names){
            cars.add(new Car(name));
        }
        return cars;
    }

    public void racingStart(){
        System.out.println(ATTEMPT_COUNT_MESSAGE);
        String countOfTry = Console.readLine();
        validateNumericInput(countOfTry);
        int countNumber = Integer.parseInt(countOfTry);

        for (int i = 0; i < countNumber; i++) {
            raceOneStep();
        }

        printerWinner();
    }

    public void raceOneStep(){
        for(Car car: carList){
            int randomNumber = Randoms.pickNumberInRange(0,9);
            car.moveAdvance(randomNumber);
        }
        printRacingStatus();
    }

    public void printRacingStatus(){
        System.out.println(this.toString());
    }

    public void printerWinner(){
        int number = getMaxAdvanceCount();
    }

    private int getMaxAdvanceCount(){
        return carList.stream().map(Car::getRaceDistance)
                .mapToInt(i->i)
                .max()
                .getAsInt();
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Car car : carList){
            sb.append(car.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
