package racingcar;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingGame {
    ArrayList<Car> userCars = new ArrayList<Car>();
    int tryCount;

    void init(){
        prepareRace();
        startRace();
        showResult();
    }

    void prepareRace(){
        InputValidator iv = new InputValidator();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = readLine();
        if(iv.isBlank(userInput)) throw new IllegalArgumentException("공백을 입력하실 수 없습니다.");
        if(iv.singleInput(userInput)) throw new IllegalArgumentException("2개 이상의 이름을 입력하세요.");

        String[] splitInput = userInput.split(",");

        for(String i : splitInput){
            userCars.add(new Car(i));
        }

        System.out.println("시도할 회수는 몇 회인가요?");
        String userInputTry = readLine();
        if(iv.isNumber(userInputTry)){ //숫자 여부 확인후 tryCount에 입력값넣기
            tryCount = Integer.parseInt(userInputTry);
        }else{
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }

        System.out.println();
    }

    void startRace(){
        System.out.println("실행 결과");
        for(int i=0;i<this.tryCount;i++){
            for(Car car : this.userCars){
                RandomDice dice = new RandomDice();
                dice.setNum();
                if(dice.getNum()>=4){
                    car.addProgress();
                }
                System.out.println(car.showProgress());
            }
            System.out.println();
        }
    }

    void showResult(){
        System.out.println("최종 우승자 : "+checkResult());
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
}
