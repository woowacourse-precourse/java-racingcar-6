package racingcar.view;

import racingcar.model.CarModel;

/**
 * 출력 관리
 */
public class OutputView {
    private static final int DELETE_LAST_COMMA = 2;
    /**
     * 실행 결과 메세지 출력
     */
    public static void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    /**
     * 단일 차수 실행 결과 출력
     *
     * @param cars 자동차 객체 리스트
     */
    public static void printGameResult(CarModel[] cars) {
        for (CarModel car : cars) {
            System.out.println(printCar(car));
        }
        System.out.println();
    }

    private static String printCar(CarModel car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }

    /**
     * 우승자 출력
     *
     * @param winnersNames 우승 차량 이름 배열
     */
    public static void printWinners(String[] winnersNames) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String winnerName : winnersNames) {
            stringBuilder.append(winnerName)
                    .append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - DELETE_LAST_COMMA, stringBuilder.length());

        System.out.println("최종 우승자 : " + stringBuilder);
    }
}
