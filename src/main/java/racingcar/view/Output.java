package racingcar.view;

import racingcar.model.Car;

public class Output {
    private static final String inputCarName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String number_of_attempts = "시도할 회수는 몇회인가요?";
    private static final String execution_result = "실행 결과";

    private static final String distance_mark = "-";


    public static void printCarName() {
        System.out.println(inputCarName);
    }

    public static void printNumber_of_attempts() {
        System.out.println(number_of_attempts);
    }

    public static void printResult() {
        System.out.println(execution_result);
    }

    private static void printCarScore(Car car) {
        System.out.print(car.getName() + " : ");
        printPosition(car);
        System.out.println();
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(distance_mark);
        }
    }


    public static void printWinner() {
        System.out.println("최종 우승자 : ");
        // 우승자 이름 출력
        System.out.println();

        //만약 우승자가 한명이면
        /*if(car == only){
            System.out.println(); 차 이름 출력
        }

        else{
            sout; // 차름 여러 개 출력
        }
        */
    }
}
