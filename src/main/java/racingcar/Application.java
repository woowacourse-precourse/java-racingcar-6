package racingcar;

import racingcar.domain.NumberGenerator;
import racingcar.domain.RacingInput;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구게임을 시작합니다.");

        NumberGenerator generator = new NumberGenerator();
        List<Integer> numbers = generator.Go();

        System.out.println(numbers);

        RacingInput.askNumber();
    }
}
