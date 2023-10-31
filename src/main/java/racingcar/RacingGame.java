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

    void setUserCars(String[] splitInput)  {
        for (String i : splitInput) {
            userCars.add(new Car(i));
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

    void init(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInputCars = readLine();
        InputValidator.carNameValidator(userInputCars);
        String[] splitInput = userInputCars.split(",");
        setUserCars(splitInput);

        System.out.println("시도할 회수는 몇 회인가요?");
        String userInputTryCount = readLine();
        InputValidator.tryCountValidator(userInputTryCount);
        setTryCount(Integer.parseInt(userInputTryCount));
        startRace();
        showResult();
    }

}
