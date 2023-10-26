package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarGame {
    private String[] carNames;
    private CarInfo[] carArray;
    private int movementAmonut;
    public RacingCarGame(){

    }

    public void startGame(){

    }

    private void inputCarInfo(){
        String inputInfo = Console.readLine();
        this.carNames = inputInfo.split(",", 0);

        checkCarName();
        createCarArray();
    }

    private void checkCarName(){
        for(String carName: this.carNames){
            if(carName.length() > 5) {  // check the car name's length is over than 5
                throw new IllegalArgumentException();
            } else {
                continue;   // do nothing
            }
        }
    }

    private void createCarArray(){
        this.carArray = new CarInfo[this.carNames.length];

        for(int i = 0; i < this.carNames.length; i++){
            this.carArray[i] = new CarInfo(this.carNames[i], 0);
        }
    }

    private void inputMovementAmount(){
        String movementAmount = Console.readLine();

        checkMovementAmount(movementAmount);

        this.movementAmonut = Integer.parseInt(movementAmount);
    }

    private void checkMovementAmount(String movementAmount){
        try{
            Integer.parseInt(movementAmount);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
