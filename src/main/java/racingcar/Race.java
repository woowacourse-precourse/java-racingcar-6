package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {
    List<RaceCar> raceCarList;

    public Race(){
     raceCarList = new ArrayList<>();
    }

    private List<String> inputRaceCars(){
        String input = Console.readLine();
        List<String> names = Arrays.asList(input.split(","));
        nameValidation(names);
        return names;
    }
    private void nameValidation(List<String> names){
        for(String str : names){
            if( str.length() >5 || str.length() ==0)
                throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public void makeRaceCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = inputRaceCars();
        for(String str : names){
            raceCarList.add(new RaceCar(str));
        }
    }

    private void carsTryMove(){
        for(RaceCar car : raceCarList){
            car.raceForward();
        }
    }

    private void reportingLive(){
        for(RaceCar car : raceCarList){
            car.currentPosition();
        }
    }

    public void raceGame(){
        int rounds;
        System.out.println("시도할 회수는 몇회인가요?");
        rounds = Integer.parseInt(Console.readLine());
        System.out.println("실행 결과");
        for(int i =0; i<rounds;i++){
            carsTryMove();
            reportingLive();
            System.out.println();
        }
    }
}
