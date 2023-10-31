package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Car> cars = new ArrayList<>();
    NumberGenerator numberGenerator = new NumberGenerator();

    public void save(String[] carNames){
        for (String name : carNames){
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public void giveRandomNumber(){
        for(Car car : cars){
            int randomNumber = numberGenerator.makeRandomNumber();
            car.go(randomNumber);
        }
    }

    public void play(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        save(readLine().split(","));
        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(readLine());
        Narrator narrator = new Narrator();
        for(int i = 0; i<count; i++){
            giveRandomNumber();
            narrator.showEachRound(cars);
        }
        Referee referee = new Referee();
        System.out.print("최종 우승자 : ");
        referee.showWinners(cars);

    }
}
