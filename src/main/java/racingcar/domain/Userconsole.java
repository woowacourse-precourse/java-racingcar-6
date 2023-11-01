package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class Userconsole {
    public String[] makingCarList(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carname = Console.readLine();
        if(carname.equals("")){
            throw new IllegalArgumentException();
        }
        String[] cars = carname.split(",");
        if(cars.length < 1){
            throw new IllegalArgumentException();
        }
        for(int i=0; i<cars.length; i++){
            if(cars[i].length() > 5){
                throw new IllegalArgumentException();
            }
        }
        return cars;
    }

    public int askRounds(){
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = Console.readLine();
        int rounds = Integer.parseInt(input);
        return rounds;
    }
}
