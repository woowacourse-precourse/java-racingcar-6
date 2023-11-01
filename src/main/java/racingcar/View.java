package racingcar;

import java.util.List;

public class View {

    public static void PRINT_START_GAME() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void PRINT_HOW_MANY_TRY() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void PRINT_RESULT() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void PRINT_RUN_RESULT(List<Car> cars) {

        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i).getName() + " : ");
            PRINT_GO(cars.get(i).getCount()); //
        }
        System.out.println();
    }


    public static void PRINT_REPORT_WINNER(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }


    public static void PRINT_GO(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
