package racingcar.view;

import racingcar.domain.dto.CarDTO;
import java.util.List;

public class OutputView {
    public static void inputNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void inputCountMessage() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void executionResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void carResult(List<CarDTO> carDTOs) {
        for(CarDTO carDTO :carDTOs) {
            System.out.print(carDTO.getCarName() + " : ");
            printPosition(carDTO.getPosition());
        }
        System.out.println();
    }

    private static void printPosition(int position) {
        for(int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void winner(String result) {
        System.out.println("최종 우승자 : " + result);
    }
}
