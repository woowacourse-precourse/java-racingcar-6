package racingcar;

import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.dynamic.scaffold.MethodGraph;

import java.util.LinkedList;
import java.util.List;

public class Game {
    private LinkedList<Car> cars = new LinkedList<>();
    private int turns;
    private Dice dice = new Dice(0, 9);

    private void run() {
        getCarsInput();
        getTurnsInput();
        System.out.println("실행 결과");
        for (int i = 0; i < turns; i++) {
            for (Car car : cars) {
                int number = dice.roll();
                car.move(number);
                car.printResult();
            }
            System.out.println("");
        }
        printWinners();
    }

    private void getCarsInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        if (!names.matches("^[a-zA-Z,]*$")){
            throw new IllegalArgumentException("쉼표와 문자만 입력해주세요.");
        }
        String[] namesSplit = names.split(",");
        for (String eachName : namesSplit) {
            if (eachName.length() > 5) {
                throw new IllegalArgumentException("차의 이름은 5글자를 넘을 수 없습니다.");
            }
            Car car = new Car(eachName);
            cars.add(car);
        }
    }

    private void getTurnsInput(){
        System.out.println("시도할 회수는 몇회인가요?");
        String number = Console.readLine();
        if (!number.matches("[0-9]+")){
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        turns = Integer.parseInt(number);
    }

    private void printWinners(){
        int max = 0;
        LinkedList<String> winners = new LinkedList<>();
        for (Car car : cars){
            if (car.getPosition() >= max){
               max = car.getPosition();
            }
        }

        for (Car car: cars){
            if (car.getPosition() == max){
                winners.add(car.getName());
            }
            System.out.println("최종 우승자 : " + String.join(",", winners));
        }
    }

}
