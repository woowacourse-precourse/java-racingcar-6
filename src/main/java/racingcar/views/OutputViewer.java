package racingcar.views;

public class OutputViewer {

    private OutputViewer() {
    }

    public static void printRequestingCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRequestingNumberOfTry() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printNoticeResultWillBePrinted() {
        System.out.println("실행 결과");
    }

    public static void printMovedDistanceOfCar(String carName, int movedDistance) {
        String roadPassed = "-".repeat(movedDistance);
        System.out.println(carName + " : " + roadPassed);
    }

    public static void printBlank() {
        System.out.println();
    }

}
