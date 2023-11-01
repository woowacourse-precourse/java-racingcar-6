package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class InputRacingCar {

    List<String> inputRacingCar() throws IllegalArgumentException {
        List<String> inputCar = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        String doubleComma = ",,";
        if (input.indexOf(doubleComma) > 0) {
            throw new IllegalArgumentException();
        }

        input = input.trim();

        if (input.contains(" ")) {
            throw new IllegalArgumentException();
        }
        // 공백 포함 시, 프로그램 종료

        if (input.length() > 10000) {
            throw new IllegalArgumentException();
        }
        // 10000글자 넘을 시, 프로그램 종료

        char comma = ',';
        int isComma = 1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == comma) {
                isComma++;
            }
        }
        // 맨 앞, 맨 뒤, 글자 사이 "," 두 개 있는지 판별.


        StringTokenizer inputToken = new StringTokenizer(input, ",");

        while (inputToken.hasMoreTokens()) {
            inputCar.add(inputToken.nextToken());
        }

        for (int i = 0; i < inputCar.size(); i++) {
            String check = inputCar.get(i);
            if (check.length() > 5) {
                throw new IllegalArgumentException();
            }
        }


        if (inputCar.size() == 1) {
            throw new IllegalArgumentException();
        }

        LinkedHashSet<String> removeDuplication = new LinkedHashSet<>(inputCar);
        if (removeDuplication.size() != inputCar.size()) {
            throw new IllegalArgumentException();
        }
        inputCar.clear();
        inputCar.addAll(removeDuplication);
        // 중복 제거


        if (inputCar.size() != isComma) {
            throw new IllegalArgumentException();
        }
        // ","의 갯수가 맞지 않을 시, 프로그램 종료

        return inputCar;
    }
}
