package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input= Console.readLine();
        String[] carNames=input.split(",");
        List<Car> cars=new ArrayList<>();
        for (String carName: carNames){
            if(carName.isEmpty()){
                throw new IllegalArgumentException();
            }
            if(carName.length()>5){
                throw new IllegalArgumentException();
            }
            cars.add(new Car(carName));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount;
        try {
            tryCount=Integer.parseInt(Console.readLine());
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }

        if(tryCount<1){
            throw new IllegalArgumentException();
        }

        System.out.println("실행 결과");

        Race race = new Race(cars, tryCount);
        race.conductRace();
        List<String> winners=race.getWinners();
        System.out.println("최종 우승자 : "+String.join(", ", winners));
    }
}
