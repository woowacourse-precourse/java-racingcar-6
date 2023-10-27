package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class IO {
    public String[] inputName() {
        outputNameRequest();
        String name = Console.readLine();
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (name.charAt(0) == ',' || name.charAt(name.length() - 1) == ',') {
            throw new IllegalArgumentException();
        }
        return name.split(",");
    }

    public int inputNumber() {
        outputNumberRequest();
        String number = Console.readLine();
        if (number.length() == 1 && Character.isDigit(number.charAt(0))) {
            return Integer.parseInt(number);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void outputNameRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void outputNumberRequest() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void outputIntro() {
        System.out.println("실행 결과");
    }

    public void outputStatus(String[] nameArr, Map<String, Integer> nameMap) {
        for (String s : nameArr) {
            System.out.print(s + " : ");
            for (int j = 0; j < nameMap.get(s); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void outputResult(int maxVal, String[] nameArr, Map<String, Integer> nameMap) {
        System.out.print("최종 우승자 : ");
        boolean jointWinnerFlag = false;
        for (String s : nameArr) {
            if (jointWinnerFlag && nameMap.get(s) == maxVal) {
                System.out.print(", ");
                jointWinnerFlag = false;
            }
            if (nameMap.get(s) == maxVal) {
                System.out.print(s);
                jointWinnerFlag = true;
            }
        }
        System.out.println();
    }
}
