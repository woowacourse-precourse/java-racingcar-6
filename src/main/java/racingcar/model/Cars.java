package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.util.Validate;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        Validate.carNamesDuplicate(cars);
        Validate.carNameIsOne(cars);

        this.cars = new ArrayList<>(cars);
    }

    /**
     * 우승자의 이름들를 반환하는 함수
     *
     * @param position : Car member 들의 이름을 구하기 위한 조건
     * @return List<String> : member 들의 이름
     */
    public List<String> getWinnerList(int position) {
        return this.cars
                .stream()
                .filter(car -> car.getPosition() == position)
                .map(Car::getMember)
                .collect(Collectors.toList());
    }

    public void forward() {
        this.cars
                .stream()
                .filter(Car::move)
                .forEach(Car::forward);
    }

    public List<String> getForwardPositions() {
        return this.cars
                .stream()
                .map(Car::getForwardPosition)
                .collect(Collectors.toList());
    }

    public String getWinner(Cars cars) {
        int max = cars.getMaxPosition();

        List<String> winner = cars.getWinnerList(max);

        return String.join(", ", winner);
    }

    /**
     * 입력받은 자동차들 String -> Cars 변환
     *
     * @param inputTemp : 입력받은 자동차들
     * @return : Cars Class
     */
    public static Cars createCarsFromInputString(String inputTemp) {
        Validate.inputStringNotContainsComma(inputTemp); // 구분자가 컴마가 아닌 경우 유효성 검사
        Validate.lastCharIsComma(inputTemp); // 구분자 뒤 자동치 이름이 없는 경우 유효성 검사

        List<String> carList = splitCarNamesReturnList(inputTemp);
        List<Car> cars = convertStringListToCarsModel(carList);

        return new Cars(cars);
    }

    /**
     * 현재 멤버들 중 가장 많이 전진한 position 값 반환
     *
     * @return int: Cars의 멤버 중 가장 높은 position을 반환
     */
    private int getMaxPosition() {
        return this.cars
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private static List<String> splitCarNamesReturnList(String carMembers) {
        final String delimiter = ",";

        return Arrays.asList(carMembers.split(delimiter));
    }

    private static List<Car> convertStringListToCarsModel(List<String> carList) {
        List<Car> cars = new ArrayList<>();

        carList.forEach(car -> cars.add(new Car(car)));

        return cars;
    }


}
