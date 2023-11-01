package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final int ALONE = 1;

    public static void requestCarNameMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void requestTrialNumberMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void beforePrintResult(){
        System.out.println("실행 결과");
    }

    public static void printScore(List<Car> cars){
        for(Car car : cars){
            printCarScore(car);
        }
        System.out.println();
    }

    public static void printWinners(List<String> carNames) {
        System.out.print("최종 우승자 : ");
        System.out.print(carNames.get(0));
        if (checkWinAlone(carNames)) {
            System.out.println();
            return;
        }
        for (int i = 1; i < carNames.size(); i++) {
            System.out.print(", ");
            System.out.print(carNames.get(i));
        }
        System.out.println();
    }


    private static void printCarScore(Car car) {
        System.out.print(car.getCarName() + " : ");
        printPosition(car);
        System.out.println();
    }

    //더 나은거 없는지 궁리
    private static void printPosition(Car car) {
        for (int i = 0; i < car.getCarPosition(); i++) {
            System.out.print("-");
        }
    }

    private static boolean checkWinAlone(List<String> carNames){
        return carNames.size() == ALONE;
    }




}
