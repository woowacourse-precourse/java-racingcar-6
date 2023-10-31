package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    static final String GAME_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String NUMBER_OF_TIMES = "시도할 회수는 몇회인가요?";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //게임 시작
        System.out.println(GAME_START);
        String[] cars = readLine().split(",");
        //검증
        if (!verifyInput(cars)) {
            throw new IllegalArgumentException();
        }
        //검증 통과 시에 제대로 리스트에 자동차 저장
        List<Car> carList = splitAndStoreCars(cars);
        // 횟수 입력
        System.out.println(NUMBER_OF_TIMES);
        String times = readLine();
        // 횟수 입력 시 데이터 검증
        int numOfTimes = validateAndParse(times);  // 시도할 횟수
        //횟수만큼 경주 진행.
        startRace(carList, numOfTimes);
        //차수 별로 출력 끝났으면 우승자 찾기
        List<String> winners = findWinners(carList);
        printWinners(winners);
    }

    private static void startRace(List<Car> carList, int numOfTimes) {
        while (numOfTimes > 0) {
            // 전진 or 멈춤
            moveOrStop(carList);
            // 차수 별 결과 출력
            printResult(carList);
            numOfTimes -= 1;
        }
    }

    private static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }


    private static List<String> findWinners(List<Car> carList) {
        int maxLength = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : carList) {
            int carNowLength = car.getNow().length();  //현재 자동차의 전진 횟수
            if (carNowLength > maxLength) {
                maxLength = carNowLength;
                winners.clear();
                winners.add(car.getName());
            } else if (carNowLength == maxLength) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private static void printResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getNow());
        }
        System.out.println();
    }

    private static void moveOrStop(List<Car> carList) {
        for (Car car : carList) {
            if (move(car)) {   //전진
                car.setNow(car.getNow() + "-");
            }

        }
    }

    private static boolean move(Car car) {
        int num = Randoms.pickNumberInRange(0, 9);
        return num >= 4;
    }

    private static int validateAndParse(String times) {
        int numOfTimes = 0;
        try {
            numOfTimes = Integer.parseInt(times);  //횟수
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return numOfTimes;
    }

    private static List<Car> splitAndStoreCars(String[] cars) {
        List<Car> carList = new ArrayList<>();
        for (String car : cars) {
            Car c = new Car(car);
            carList.add(c);
        }
        return carList;
    }

    private static boolean verifyInput(String[] cars) {
        for (String car : cars) {
            if (car.isEmpty() || car.length() > 5) {
                return false;
            }
        }
        return true;
    }
}