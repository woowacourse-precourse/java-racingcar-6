package racingcar.domain;

import racingcar.view.InputView;

public class Car {

    private String carName;

    private int position;

    public Car(String carName) {
        isCarNameLengthOver(carName);
        isNotAlphaBetAndComma(carName);
        isCarNameBlank(carName);
        isCarNameNull(carName);
        this.carName = carName;
        this.position = 0;
    }

    public Car(String carName, int position) {
        isCarNameLengthOver(carName);
        isNotAlphaBetAndComma(carName);
        isCarNameBlank(carName);
        isCarNameNull(carName);
        this.carName = carName;
        this.position = position;
    }

    public void move(){
        this.position++;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    private void isCarNameLengthOver(String carName){
        if(carName.length() > InputView.MAX_NAME_LENGTH){
            throw new IllegalArgumentException();
        }
    }

    private void isNotAlphaBetAndComma(String carName){
        if (!carName.matches("[a-z,]")){
            throw new IllegalArgumentException();
        }
    }

    private void isCarNameBlank(String carName){
        if (carName.isBlank()){
            throw new IllegalArgumentException();
        }
    }

    private void isCarNameNull(String carName){
        if (carName == null){
            throw new IllegalArgumentException();
        }
    }
}
