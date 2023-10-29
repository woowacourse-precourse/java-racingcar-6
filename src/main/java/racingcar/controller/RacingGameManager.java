package racingcar.controller;

import racingcar.model.Cars;

public class RacingGameManager {
    private Cars cars;

    public RacingGameManager() {
    }

    public RacingGameManager(Cars cars) {
        this.cars = cars;
    }

    void repeatMove(int tryCount){
        while (tryCount > 0){
            cars.moveCars();
            tryCount--;
        }
    }

    void tryCountValidation(String tryCount){
        if(!isNumeric(tryCount)){
            throw new IllegalArgumentException();
        }
        if(Integer.parseInt(tryCount) < 1){
            throw new IllegalArgumentException();
        }
    }

    private int convertStringToInt(String tryCount){
        return Integer.parseInt(tryCount);
    }

    private boolean isNumeric(String inputString) {
        return inputString.matches("-?\\d+");  // 정수만 허용
    }
}
