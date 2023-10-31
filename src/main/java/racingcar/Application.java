package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        //자동차 이름 입력 받기
        try {
            List<String> cars = getCarsName(br);

            //시도 횟수 입력 받기
            System.out.println("시도할 회수는 몇회인가요?");
            int toTry = getToTry(br);

            //전진 횟수 기록할 리스트 생성
            List<Integer> toGo = new ArrayList<>();
            for (int i = 0; i < cars.size(); i++) {
                toGo.add(0);
            }

            //반복해서 전진 및 출력
            System.out.println();
            System.out.println("실행 결과");
            for (int i = 0; i < toTry; i++) {
                for (int j = 0; j < cars.size(); j++) {
                    int randomNumber = getRandomNumber();
                    if (randomNumber >= 4) {
                        toGo.set(j, toGo.get(j) + 1);
                    }
                }

                for (int k = 0; k < cars.size(); k++) {
                    System.out.print(cars.get(k) + " : ");
                    howMuchToGo(toGo, k);
                    System.out.println();
                }
                System.out.println();
            }
            System.out.print("최종 우승자 : ");

            //우승자 구하기
            int maxNum = Collections.max(toGo);
            List<String> winner = new ArrayList<>();

            getWinnerList(cars, toGo, maxNum, winner);

            printWinnerList(winner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }

    private static int getToTry(BufferedReader br) throws IOException {
        String input = br.readLine();
        int toTry = Integer.parseInt(input);
        return toTry;
    }

    private static void printWinnerList(List<String> winner) {
        if (winner.size() > 1) {
            for (int i = 0; i < winner.size() - 1; i++) {
                System.out.print(winner.get(i) + ", ");
            }
            System.out.println(winner.get(winner.size() - 1));
        } else if (winner.size() == 1) {
            System.out.println(winner.get(0));
        }
    }

    private static void getWinnerList(List<String> cars, List<Integer> toGo, int maxNum, List<String> winner) {
        for (int i = 0; i < toGo.size(); i++) {
            if (toGo.get(i) == maxNum) {
                winner.add(cars.get(i));
            }
        }
    }

    private static void howMuchToGo(List<Integer> toGo, int k) {
        for (int l = 0; l < toGo.get(k); l++) {
            System.out.print("-");
        }
    }

    private static List<String> getCarsName(BufferedReader br) throws IOException {
        List<String> cars = List.of(br.readLine().split(","));
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하입니다.");
            }
        }
        return cars;
    }
}
