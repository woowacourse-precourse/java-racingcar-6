package racingcar.iosystem;

import racingcar.errorCheck.ErrorCheck;
import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);
    private String[] cars;
    private int[] carsMove;
    private int tryCnt;

    public InputView(String[] cars) {
        ErrorCheck.isCarNameFive(cars);
        ErrorCheck.isDuplicationNameCar(cars);
        this.cars = cars;
        this.carsMove = new int[cars.length];
        this.tryCnt = Integer.valueOf(inputTry());

    }
    public String[] getCars() {
        return cars;
    }
    public int[] getCarMove() {
        return carsMove;
    }

    public int getTryCnt() {
        return tryCnt;
    }
    public static String[] setCarsName(String input) {
        String[] carList = input.split(",");
        return carList;
    }

    public static String inputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
//        String a = "pobi,woni,jun";
        return Console.readLine();
//        return a;
    }

    public static String inputTry() {
        System.out.println("시도할 횟수 입력하세여");
        return Console.readLine();
//        return "5";
    }

}
