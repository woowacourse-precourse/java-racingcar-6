package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    private static final String SPACE = " ";
    private static final String NO_SPACE = "";
    private static final String COMMA = ",";

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
        return Randoms.pickNumberInRange(0, 9);
    }

    public static CarDto carToCarDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setName(car.getName());
        carDto.setPosition(car.getPosition());
        return carDto;
    }

    public static List<CarDto> carsToCarDtos(List<Car> cars) {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {
            CarDto carDto = Util.carToCarDto(car);
            carDtos.add(carDto);
        }
        return carDtos;
    }

    private Util() {
    }
}