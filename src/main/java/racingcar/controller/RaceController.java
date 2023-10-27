package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceController {

    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final String DELIMITER = ",";

    // 1. 경주할 자동차 이름 입력 받기
    // 2. 시도 횟수 입력 받기
    // 3. 입력받은 이름을 쉼표를 기준으로 나눠서 컬렉션에 넣기
    // 4. 컬렉션을 돌면서 Car 객체 생성해서 컬렉션에 넣기
    // 5. Car 객체가 들어있는 컬렉션으로 Cars 객체 생성하기
    // 6. << 실행 결과 >>
    // 7. loop(시도 횟수)
    //      NumberGenerator로 랜덤 숫자 입력받기
    //      Cars의 move 메서드로 전진하기.
    //      결과 출력
    // 8. Cars에서 winner 얻어오기
    // 9. winner 출력하기

    private List<String> getName() {
        outputView.printInputCarsName();
        String stringNames = inputView.inputName();
        // 검증
        return Arrays.stream(stringNames.split(DELIMITER)).toList();
    }

    private int getTryNumber() {
        outputView.printInputTryNumber();
        String tryNumber = inputView.inputTryNumber();
        // 검증
        return Integer.parseInt(tryNumber);
    }

    

}
