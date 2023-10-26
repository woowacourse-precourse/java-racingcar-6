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

    private void inputCarNameMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private void inputMovementAmountMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private void printCurrentResultMessage(){
        System.out.println("실행 결과");
    }

    private void moveCars(){
        for(CarInfo car: this.carArray){
            moveCar(car);
        }
    }

    private void moveCar(CarInfo car) {
        if(decideMoveOrNot()) {
            car.increaseTotalMovement();
        } else {
            ;   // do nothing
        }
    }

    private boolean decideMoveOrNot() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if(randomNumber >= 4) {
            return true;
        } else {
            return false;
        }
    }

    private void printCurrentResult(){

    }

    private void printFinalResult(){

    }
}
