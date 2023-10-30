package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Car {
    private String name;
    private String race;
    private int tryNum;
    private ArrayList<Car> car = new ArrayList<>();

    public Car(String name) {

    }

    void inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        for (String i : Console.readLine().split(",")) {
            car.add(new Car(i));
        }
    }

    void inputTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        tryNum = Integer.parseInt(Console.readLine());
    }

    void draw() {
        for (int i = 0; i < car.size(); i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.get(i).race+="-";
                continue;
            }
            car.get(i).race+="";
        }
    }

    void outputDraw() {
        for (int i = 0; i < car.size(); i++) {
            System.out.println(car.get(i).name + " : " + car.get(i).race);
        }
        System.out.println();
    }

    void winner() {
        int maxLength = 0;
        for (int i = 0; i < car.size(); i++) {
            maxLength = Math.max(maxLength, car.get(i).race.length());
        }
        String winners = "";
        for (int i = 0; i < car.size(); i++) {
            if (maxLength == car.get(i).race.length()) {
                winners += car.get(i).name + ", ";
            }
        }
        System.out.println("최종 우승자 : ");
        for (int i = 0; i < winners.length() - 1; i++) {
            System.out.printf("%c", winners.charAt(i));
        }
    }
}
