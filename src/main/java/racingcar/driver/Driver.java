package racingcar.driver;

import java.util.Arrays;
import java.util.List;

public class Driver {

    public List<String> validateDriverLineUp(String drivers) {
        List<String> driverList = Arrays.asList(drivers.split(","));
        for (String driver : driverList) {
            if (driver.length() >= 5) {
                throw new IllegalArgumentException("이름은 5자 이하로 입력해주세요.");
            }
        }
        return driverList;
    }
}
