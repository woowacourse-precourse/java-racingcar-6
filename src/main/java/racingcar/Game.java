package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedList;

public class Game {
    private RacingCars racingCars;
    private int turns;
    private final Dice dice = new Dice();

    protected void run() {
        racingCars = new RacingCars(assignCars());
        turns = getTurnsInput();
        Console.close();
        System.out.println("실행 결과");
        for (int i = 0; i < turns; i++) {
            racingCars.moveCars(dice);
        }
        printWinners();
    }

    private LinkedList<Car> assignCars(){
        LinkedList<Car> cars = new LinkedList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        if (!names.matches("^[a-zA-Z, ]*$")){
            throw new IllegalArgumentException("쉼표와 문자만 입력해주세요."); // 숫자 허용하지 않음
        }
        String[] namesSplit = names.split(",");
        for (String eachName : namesSplit) {
            cars.add(new Car(eachName.trim()));
        }
        return cars;
    }

    private int getTurnsInput(){
        System.out.println("시도할 회수는 몇회인가요?");
        String number = Console.readLine();
        if (!number.matches("[0-9]+")){
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        else if (number.equals("0")){
            throw new IllegalArgumentException("1 이상의 수를 입력해주세요.");
        }
        return Integer.parseInt(number);
    }

    private void printWinners(){
        LinkedList<String> winners = racingCars.getWinners();
        if (winners.isEmpty()) {
            System.out.println("이런, 아무도 움직이지 못했군요! 우승자가 없습니다.");
        }
        else {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }

}
