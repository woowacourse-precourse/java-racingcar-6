package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.CarDto;

public class Util {

    private static final String SPACE = " ";
    private static final String NO_SPACE = "";
    private static final String COMMA = ",";
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    public static String removeSpace(String input) {
        return input.replaceAll(SPACE, NO_SPACE);
    }

    public static String[] splitByComma(String input) {
        return input.split(COMMA);
    }

    public static List<String> arrayToList(String[] array) {
        return Arrays.asList(array);
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    public static CarDto carToCarDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setName(car.getName());
        carDto.setPosition(car.getPosition());
        return carDto;
    }

    public static List<CarDto> carsToCarDtos(List<Car> cars) {
        return cars.stream()
                .map(Util::carToCarDto)
                .collect(Collectors.toList());
    }

    private Util() {
    }
}