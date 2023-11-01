package racingcar;

import static racingcar.constants.CAR_NAME_LIMIT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Car {

    // 사용자로부터 경주할 자동차 이름 입력 받기
    public static String getCarName() {
        return Console.readLine();
    }

    // 사용자로부터 입력받은 자동차 이름을 쉼표 기준으로 구분하기
    public static List<String> sortCarName() {
        String cars = getCarName();
        System.out.println(cars);

        String[] carsArr = cars.split(",");
        for(String name: carsArr){
            checkCarNameLength(name);
        }
        List<String> carsList = Arrays.asList(carsArr);

        return carsList;
    }

    //자동차 이름 길이 체크
    public static void checkCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_LIMIT +"자 이하로 입력해 주세요.");
        }
    }

}
