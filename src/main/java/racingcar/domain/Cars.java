package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.dto.CarRecord;
import racingcar.vaildator.InputValidator;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.Constant.EXCEPTION_MESSAGE;
import static racingcar.vaildator.InputValidator.isValidLengthCarNames;

public class Cars {

    List<Car> cars = new ArrayList<>();

    public Cars(String nameBeforeSeparation){
        List<String> carNames = Arrays.asList(nameBeforeSeparation.split(","));

        if(!isValidLengthCarNames(carNames)){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }

        cars = MakeCar(carNames);
    }

    public void moveForward() {
        for(int i=0; i<cars.size(); i++){
            int number = Randoms.pickNumberInRange(0, 9);
            cars.get(i).forward(number);
        }
    }

    public List<CarRecord> saveRecord(){
        return cars.stream().map(car -> new CarRecord(car.getCarName(), car.getNowStep())).toList();
    }


    private List<Car> MakeCar(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
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


}
