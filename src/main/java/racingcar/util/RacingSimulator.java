package racingcar.util;

import racingcar.domain.Car;
import racingcar.message.GameMessage;
import racingcar.view.OutputView;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.util.stream.Collectors;


public class RacingSimulator {
    String turn;
    int number;
    Map<Integer, Integer> result = new HashMap<Integer, Integer>();



    public RacingSimulator(String turn) {
        this.turn = turn;
    }

    public void checkNumberValidation() {
        Validator.checkNumberValidation(this.turn);
    }

    public void invertStringToInt (){
        this.number = Integer.parseInt(turn);
    }

    public void minusNumber(){
        --number;
    }

    public boolean checkZero(){
        if(number==0){
            return false;
        }
        return true;
    }

    public void playSimulator(List<Car> cars){
        int orderNumber = 0;
        for(Car car : cars) {

            if (RandomGenerator.generateNumber()>=4){
                  car.addResult();
                  addResult(orderNumber);

            }
            ++orderNumber;
        }
    }
    public void addResult(int orderNumber) {
        result.compute(orderNumber, (key, value) -> {
            if (value == null) {
                return 1;
            } else {
                return value + 1;
            }
        });
    }

    public List<Integer> checkMaxKey() {
        int max = result.values().stream()
                .max(Integer::compare)
                .orElse(0);

        List<Integer> maxKeys = result.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .map(Entry::getKey)
                .collect(Collectors.toList());

        return maxKeys;

    }









}
