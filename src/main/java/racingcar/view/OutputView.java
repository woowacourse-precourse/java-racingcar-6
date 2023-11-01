package racingcar.view;

import racingcar.model.CarModel;

/**
 * 출력 관리
 */
public class OutputView {
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
     * @param cars 우승 차량들
     */
    public static void printWinners(CarModel[] cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (CarModel car : cars) {
            stringBuilder.append(car.getName()).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        System.out.println("최종 우승자 : " + stringBuilder);
    }
}
