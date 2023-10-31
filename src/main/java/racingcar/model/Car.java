package racingcar.model;

import racingcar.model.constant.CarConstant;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = CarConstant.INITIAL_POSITION.getNumber();
    }

    public void moveOrStop(int moveCommand) {
        if (isCarMoveable(moveCommand)) {
            this.position++;
        }
    }

    //차 이름과 포지션의 출력 형태를 String으로 보내주는 메소드
    public String provideCarNameAndPositionState() {
        String carNameAndPostionString = this.name + " : ";
        for(int i = 0; i < position; i++){
            carNameAndPostionString += "-";
        }
        return carNameAndPostionString;
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    private static boolean isCarMoveable(int moveCommand){
        return moveCommand >= CarConstant.CAR_MOVEABLE_VALUE.getNumber();
    }
}
