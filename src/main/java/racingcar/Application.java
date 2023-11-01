package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    public static void printGuideSentence(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static String[] getCars(){
        String[] carArr = Console.readLine().split(",");
        return carArr;
    }
    public static void checkCars(String[] cars){
        for (String car:cars) {
            if (car.length()>5)
                throw new IllegalArgumentException();
        }
    }
    public static void askTrialCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

        public static void main(String[] args) {
        // TODO: 프로그램 구현

        //  안내문 출력
        printGuideSentence();
        //  차 이름 배열 입력 받기
        String[] inputCars = getCars();
        //  이름 글자 수 확인
        checkCars(inputCars);

        //  시도 횟수 질문 출력
        askTrialCount();
    }
}
