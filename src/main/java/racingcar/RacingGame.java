package racingcar;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingGame {
    private ArrayList<Car> userCars;
    private int tryCount;

    public RacingGame(){
        this.userCars = new ArrayList<Car>();
        this.tryCount = 0;
    }

    void init(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInputCars = readLine();
        setUserCars(validateUserCars(userInputCars));
        System.out.println("시도할 회수는 몇 회인가요?");
        String userInputTryCount = readLine();
        setTryCount(validateTryCount(userInputTryCount));
        startRace();
        showResult();
    }

    String[] validateUserCars(String userInput) throws IllegalArgumentException {
        if (InputValidator.isBlank(userInput)) throw new IllegalArgumentException("공백을 입력하실 수 없습니다.");
        if (InputValidator.singleInput(userInput)) throw new IllegalArgumentException("2개 이상의 이름을 입력하세요.");
        String[] splitInput = userInput.split(",");
        if(InputValidator.checkNameLength(splitInput)) throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        return splitInput;
    }

    void setUserCars(String[] splitInput)  {
        for (String i : splitInput) {
            userCars.add(new Car(i));
        }
    }

    int validateTryCount(String userInputTry) throws IllegalArgumentException{
        if(InputValidator.isNumber(userInputTry)){ //숫자 여부 확인후 tryCount에 입력값넣기
            return Integer.parseInt(userInputTry);
        }else{
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }
    void setTryCount(int inputCount)  {
        this.tryCount = inputCount;
    }

    void progressCar(Car car,int dice){
        if(dice>=4){
            car.addProgress();
        }
    }

    void startRace(){
        System.out.println("실행 결과");
        for(int i=0;i<this.tryCount;i++){
            for(Car car : this.userCars){
                progressCar(car,RandomDice.getNum());
                System.out.println(car.showProgress());
            }
            System.out.println();
        }
    }

    String checkResult(){
        String winner = "";
        int maxCount = 0;
        for(Car car : this.userCars){
            if(car.getCounter()>maxCount){
                winner = car.name;
                maxCount = car.getCounter();
            }else if(car.getCounter()!=0 && car.getCounter()==maxCount){
                winner += ", "+car.name;
            }
        }
        return winner;
    }

    void showResult(){
        System.out.println("최종 우승자 : "+checkResult());
    }


}
