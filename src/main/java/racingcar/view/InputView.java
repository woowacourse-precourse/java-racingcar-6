package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarsRequestDto;
import racingcar.dto.CountRequestDto;

public class InputView {

    public static CarsRequestDto inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        CarsRequestDto carsRequestDTO = new CarsRequestDto();
        carsRequestDTO.setNames(Console.readLine());
        return carsRequestDTO;
    }

    public static CountRequestDto inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        CountRequestDto countRequestDto = new CountRequestDto();
        countRequestDto.setCount(Console.readLine());
        return countRequestDto;
    }
}
