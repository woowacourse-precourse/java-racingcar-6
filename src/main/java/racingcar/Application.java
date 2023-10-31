package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNameInput();
        int moveNum = moveNumInput();
    }

    private static void carNameInput() {
        String cars = readLine();
        StringTokenizer st = new StringTokenizer(cars, ",");
        ArrayList<String> carList = new ArrayList<>();
        while(st.hasMoreTokens()) {
            String car = st.nextToken().trim();
            if(car.length() > 5 || car.isEmpty()){
                throw new IllegalArgumentException("잘못된 입력값입니다.");
            }
            carList.add(car);
        }
    }

    private static int moveNumInput() {
        String input = readLine();
        validateUserInput(input);
        int moveNum = Integer.parseInt(input);
        if(input.equals("0")){
            throw new IllegalArgumentException("올바른 범위의 숫자를 입력하세요.");
        }
        return moveNum;
    }
    private static void validateUserInput(String input) {
        boolean isNumeric = true;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isDigit(ch)) {
                isNumeric = false;
                break;
            }
        }

        if (!isNumeric) {
            throw new IllegalArgumentException("올바른 범위의 숫자를 입력하세요.");
        }
    }
}
