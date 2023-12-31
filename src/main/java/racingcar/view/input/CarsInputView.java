package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarsRequestDto;

public class CarsInputView {

    public static CarsRequestDto readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return toDto(Console.readLine());
    }

    public static CarsRequestDto toDto(String input) {
        CarsRequestDto dto = new CarsRequestDto();
        dto.setNames(input);
        return dto;
    }
}
