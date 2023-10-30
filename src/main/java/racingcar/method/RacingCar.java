package racingcar.method;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;

public class RacingCar {
    public ArrayList<Car> createCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        ArrayList<Car> car_list = new ArrayList<>();
        for (String s : input.split(",")) {
            if (s.length() <= 5) {
                car_list.add(new Car(s));
            } else {
                throw new IllegalArgumentException();
            }
        }
        return car_list;
    }

    public Integer countRacingGame(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        if(input.matches("[1-9]+")){
            return Integer.parseInt(input);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void playRacingGame(ArrayList<Car> car_list){
        for(Car car : car_list){
            car.determine_Move();
            System.out.println(car.getCar_name() + " : " + "-".repeat(car.getMove_count()));
        }
        System.out.println("");
    }
}
