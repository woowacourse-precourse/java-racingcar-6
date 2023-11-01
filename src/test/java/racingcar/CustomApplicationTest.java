package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.view.ConsoleInput;


public class CustomApplicationTest {

    public static InputStream generateInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void 이름이_6자_이상일_경우_오류() {
        assertThatThrownBy(() -> {
            Car car = Car.nameOf("이름이6글자");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름을_입력하지_않았을_경우_오류() {
        assertThatThrownBy(() -> {
            Car car = Car.nameOf("");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_중복될_경우_오류() {
        assertThatThrownBy(() -> {
            String sentence = "pobi,pobi,hello";
            InputStream in = generateInput(sentence);
            System.setIn(in);
            ConsoleInput.carNamesInput();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_포함_문자열_입력_시_공백제거() {
        String sentence = "pobi     ,pedro  ,hello";
        InputStream in = generateInput(sentence);
        System.setIn(in);
        List<Car> carList = ConsoleInput.carNamesInput();
        List<String> carNameList = carList.stream()
                .map(car -> car.getName())
                .toList();
        assertThat(carNameList).containsExactly("pobi", "pedro", "hello");
    }

    @Test
    void 구분자만_명확하면_한글_기호_상관없이_입력가능() {
        String sentence = "한글1호,한글2호!,thisi";
        InputStream in = generateInput(sentence);
        System.setIn(in);
        List<Car> carList = ConsoleInput.carNamesInput();
        List<String> carNameList = carList.stream()
                .map(car -> car.getName())
                .toList();
        assertThat(carNameList).containsExactly("한글1호", "한글2호!", "thisi");
    }

    @Test
    void Integer_값이_아닐_경우_예외_처리() {
        assertThatThrownBy(() -> {
            String sentence = "abc123";
            InputStream in = generateInput(sentence);
            System.setIn(in);
            ConsoleInput.attemptsNumberInput();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Integer_값일_경우_시도_횟수_정상_입력() {
        String sentence = "12345";
        InputStream in = generateInput(sentence);
        System.setIn(in);
        int attemptsNumber = ConsoleInput.attemptsNumberInput();
        assertThat(attemptsNumber).isEqualTo(12345);
    }

    @Test
    void race_실행_시_전진_판정_올바르게_실행() {
        Car car = Car.nameOf("test");
        List<Car> carList = new ArrayList<>();
        carList.add(car);

        GameService gameService = new GameService(carList);
        for (int i = 0; i < 100; i++) { // 값이 증가하도록 충분히 실행
            gameService.race();
        }
        Car racedCar = carList.get(0);

        assertThat(racedCar.getDistance()).isGreaterThan(0);
    }

    @Test
    void race_실행_후_우승자가_올바르게_선별되는지() {
        Car car1 = Car.nameOf("test1");
        Car car2 = Car.nameOf("test2");
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        GameService gameService = new GameService(carList);
        for (int i = 0; i < 1000; i++) { // 두 차량의 distance 값이 동일하지 않도록 충분히 실행
            gameService.race();
        }
        List<Car> winnerList = gameService.selectWinner();
        List<Integer> carDistanceList = carList.stream()
                .map(car -> car.getDistance())
                .toList();

        assertThat(winnerList.size()).isNotEqualTo(0);
        int maxNum = carDistanceList.stream().max(Integer::compare).orElse(-1);
        assertThat(winnerList.get(0).getDistance()).isEqualTo(maxNum);
    }
}
