package racingcar.Exception;


import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class RacingCarException {

    public void validateGameCount(String count) {

        if(count.isEmpty()){
            throw new IllegalArgumentException("빈칸은 입력 하실 수 없습니다.");
        }

        IntStream.range(0, count.length()).filter(i -> !Character.isDigit(count.charAt(i))).forEach(i -> {
            throw new IllegalArgumentException("숫자만 입력 가능 합니다.");
        });

        if(Objects.equals(count, "")){
            throw new IllegalArgumentException("숫자만 입력 가능 합니다.");
        }

        int cnt = Integer.parseInt(count);

        if (cnt < 1) {
            throw new IllegalArgumentException("1보다 작은 수 는 입력 하실 수 없습니다.");
        }

    }

    public void validateCarName(List<String> carName) {
        carName.stream().filter(String::isEmpty).forEach(s -> {
            throw new IllegalArgumentException("자동차 이름은 문자를 입력 해야 합니다.");
        });

        carName.stream().filter(s -> (int) s.charAt(0) == 32).forEach(s -> {
            throw new IllegalArgumentException("첫 글자는 공백으로 시작 할 수 없습니다.");
        });

        carName.stream().filter(s -> s.length() > 4).forEach(s -> {
            throw new IllegalArgumentException("5자 이상의 자동차 이름은 입력 할 수 없습니다.");
        });

        if(carName.size() == 1){
            throw new IllegalArgumentException("자동차 경주는 2대 이상의 자동차 입력 시 가능합니다.");
        }

        Set<String> carNameSet = new HashSet<>(carName);

        validateDuplicates(carName.size(),carNameSet.size());


    }

    private void validateDuplicates(int carName, int carNameSet) {
        if (carName != carNameSet) {
            throw new IllegalArgumentException("자동차 이름이 중복 되었습니다.");
        }
    }


}
