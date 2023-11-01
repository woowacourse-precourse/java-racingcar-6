package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void printGuideSentence() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static String[] getCars() {
        String[] carArr = Console.readLine().split(",");
        return carArr;
    }

    public static void checkCars(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5)
                throw new IllegalArgumentException();
        }
    }

    public static void askTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static int getTrialCount() {
        String input = Console.readLine();
        int trial = Integer.parseInt(input);
        return trial;
    }

    public static int pickRandomNumber() {
        int num = Randoms.pickNumberInRange(0, 9);
        return num;
    }

    public static boolean checkCanMove(int num) {
        if (num >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public static void checkMoved(Car[] cars) {
        for (int j = 0; j < cars.length; j++) {  //  차마다
            boolean canMove = checkCanMove(pickRandomNumber()); //  랜덤 숫자 뽑은 후 전진 조건 충족 여부 확인
            if (canMove) {    //  전진 조건 충족 시
                cars[j].moveForward();  //  차 전진
            }
        }
    }

    public static void printResultOfTrial(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            System.out.print(cars[i].name + " : ");
            for (int j = 0; j < cars[i].moveCount; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static int findMaxDistance(Car[] cars) {
        int max = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].moveCount >= max) {
                max = cars[i].moveCount;
            }
        }
        return max;
    }

    public static List<String> findWInnersWith(Car[] cars, int max) {
        List<String> Winners = new ArrayList<>();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].moveCount == max)
                Winners.add((cars[i].name));
        }
        return Winners;
    }

    public static void printWinners(List<String> winnerName) {
        int printCase = 0;

        if (winnerName.size() == 1)
            printCase = 1;
        else if (winnerName.size() >= 2) {
            printCase = 2;
        }
        System.out.print("최종 우승자 : ");
        switch (printCase) {
            case 1:
                System.out.print(winnerName.get(0));
                break;
            case 2:
                whenWinnerMoreThanTwo(winnerName);

        }
    }

    static public void whenWinnerMoreThanTwo(List<String> winnerName) {
        for (int i = 0; i < winnerName.size(); i++) {
            System.out.print(winnerName.get(i));
            if (i == (winnerName.size() - 1))
                break;
            System.out.print(", ");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //  안내문 출력
        printGuideSentence();
        //  차 이름 배열 입력 받기
        try {
            String[] inputCars = getCars();
            //  이름 글자 수 확인
            checkCars(inputCars);

            //  차 객체 배열 생성
            Car[] cars = new Car[inputCars.length];

            //  차 객체 생성 및 이름 부여
            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car();
                cars[i].name = inputCars[i];
            }
            //  시도 횟수 질문 출력
            askTrialCount();
            //  시도 횟수 입력 받기
            int trialNum = getTrialCount();

            System.out.println("\n실행 결과");
            //  경기 시스템
            for (int i = 0; i < trialNum; i++) {    //  회차 마다 시도
                checkMoved(cars);
                printResultOfTrial(cars);
                System.out.println();
            }
            //  최장 전진 거리 검색
            int maxDistance = findMaxDistance(cars);
            //  우승자 검색
            List<String> winnerArr = findWInnersWith(cars, maxDistance);
            //  우승자 출력
            printWinners(winnerArr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            return;
        }
    }
}

