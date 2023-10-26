package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.Queue;

public class RacingCarGame {
    private String[] carNames;
    private CarInfo[] carArray;
    private int movementAmonut;
    private Queue<String> finalWinners;

    public RacingCarGame(){
        this.carNames = null;
        this.carArray = null;
        movementAmonut = 0;
        finalWinners = new LinkedList<>();
    }

    public void startGame(){
        inputCarNameMessage();
        inputCarInfo();
        inputMovementAmountMessage();
        inputMovementAmount();
        printCurrentResultMessage();

        for(int i = 0; i < this.movementAmonut; i++) {
            moveCars();
            printCurrentResult();
        }

        printFinalResult();
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
        for(CarInfo car: this.carArray){
            printCurrentCarInfo(car);
        }

        System.out.println();
    }

    private void printCurrentCarInfo(CarInfo car){
        System.out.print(car.getCarName() + " : ");

        for(int i = 0; i < car.getTotalMovement(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    private void printFinalResult(){
        insertFinalWinners();

        System.out.print("최종 우승자 : ");

        String winner;
        while(this.finalWinners.size() > 1) {
            winner = this.finalWinners.poll();

            System.out.print(winner + ", ");
        }
        winner = this.finalWinners.poll();
        System.out.print(winner);
    }

    private void insertFinalWinners() {
        int maximum = getMaximumMovement();

        for(CarInfo car: this.carArray) {
            if(car.getTotalMovement() >= maximum) {
                finalWinners.add(car.getCarName());
            } else {
                continue;   // do nothing
            }
        }
    }

    private int getMaximumMovement() {
        int maximum = 0;

        for(CarInfo car: this.carArray){
            if(maximum < car.getTotalMovement()){
                maximum = car.getTotalMovement();
            }
            else{
                continue;   // do nothing
            }
        }

        return maximum;
    }
}
