package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.dto.CarRecord;
import racingcar.vaildator.InputValidator;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static racingcar.Constant.DUPLICATE_NAME_ERROR;
import static racingcar.Constant.EXCEPTION_MESSAGE;

public class Cars {

    List<Car> cars = new ArrayList<>();

    public Cars(String nameBeforeSeparation){
        List<String> carNames = transToListString(nameBeforeSeparation);

        noHaveCarNames(carNames);
        duplicateNameCheck(carNames);

        cars = makeCar(carNames);
    }

    private List<String> transToListString(String carNamesBeforeSeparation) {
        return Arrays.stream(carNamesBeforeSeparation.split(",")).map(String::trim).toList();
    }

    public void moveForward() {
        for(int i=0; i<cars.size(); i++){
            int number = Randoms.pickNumberInRange(0, 9);
            cars.get(i).forward(number);
        }
    }

    public List<String> pickWinnersName(){
        List<String> winnerNames = new ArrayList<>();

        int count = 0;
        for(Car car : cars){
            int number_of_step = car.getNowStep();

            if(number_of_step > count){
                winnerNames.clear();
                winnerNames.add(car.getCarName());
                count = number_of_step;
            }
            else if(number_of_step == count){
                winnerNames.add(car.getCarName());
            }
        }

        return winnerNames;
    }

    public List<CarRecord> saveRecord(){
        return cars.stream().map(car -> new CarRecord(car.getCarName(), car.getNowStep())).toList();
    }

    protected List<Car> makeCar(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    protected void duplicateNameCheck(List<String> carNames) {
        if(carNames.stream().distinct().count() < carNames.size()){
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
        }
    }

    protected void noHaveCarNames(List<String> carNames) {
        if(carNames.size() == 0) throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

}
