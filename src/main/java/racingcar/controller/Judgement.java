package racingcar.controller;


import java.util.List;

public class Judgement {
    private List<Integer> carRandomNumbers;

    List<Integer> isNumberMoreThan4(List<Integer> carRandomNumbers) {
        for (int carRandomNumber : carRandomNumbers) {
            if (carRandomNumber < 4) {
                carRandomNumber = 0;
            }
        }
        return carRandomNumbers;
    }

}
