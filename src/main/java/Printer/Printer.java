package Printer;

import Message.Message;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Printer {
    // 게임 시작
    public void printStart() {
        System.out.print(Message.START.getMessage());
    }

    // 자동차 입력받기
    public String[] inputCars() throws IllegalArgumentException {
        System.out.print(Message.INPUT.getMessage());
        String cars = Console.readLine();

        String[] carsArray = cars.split(",");

        List<String> carsList = new ArrayList<>();
        // 5자 이상의 자동차 이름 체크
        for (int i = 0; i < carsArray.length; i++) {
            if (carsArray[i].length() > 5) {
                throw new IllegalArgumentException();
            } else {
                carsList.add(carsArray[i]);
            }
        }
        System.out.print(carsList);
        return carsArray;
    }
}
