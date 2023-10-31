package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNameInput();
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
}
