package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 자동차들 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = makingCarList(Console.readLine());
        // 실시횟수 입력받기

        // 레이싱 진행

        // 진행도출력

        // 우승자 판독 출력
    }
    public static void randomForward(String[] cars, int[] progress){

    }

    public static void whoisWinner(String[] cars, int[] progress){

    }

    public static String[] makingCarList(String userinput){
        String[] cars = userinput.split(",");
        return cars;
    }
}
