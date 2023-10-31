package racingcar.domain;

import racingcar.constant.ErrorMessage;

import java.util.*;

public class Cars implements Iterable<Car> {
    List<Car> cars;

    public Cars() {
    }

    public Cars(String userInputCarName) {
        this.cars = new ArrayList<>();

        splitUserInputCarName(userInputCarName);
    }

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    // 사용자가 입력한 자동차 이름을 쉼표(,)로 구분하여 리스트에 저장
    private void splitUserInputCarName(String userInput) {
        String[] names = userInput.split(",");

        List<String> namesNoBlank = new ArrayList<>();
        Arrays.stream(names).forEach(name -> namesNoBlank.add(name.trim())); // 문자열 양 끝 공백 제거
        validateDuplicate(namesNoBlank);

        for (String name : namesNoBlank) {
            cars.add(new Car(name));
        }
    }

    // 중복된 자동차 이름 있으면 예외 발생
    private void validateDuplicate(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATE);
        }
    }
}
