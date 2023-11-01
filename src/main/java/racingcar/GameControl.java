package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameControl extends Cars {

    public void gameSet() {
        Cars cars = new Cars();
        String[] names = cars.carNamingAndException();

        System.out.println("시도할 회수는 몇회인가요?");
        int countNumber = Integer.parseInt(Console.readLine());

        // 차량의 이동 결과를 저장하는 배열
        List<String> carResults = new ArrayList<>();

        for (String name : names) {
            carResults.add(name + " : ");
        }
        // 시도 횟수만큼 루프
        for (int i = 1; i <= countNumber; i++) {
            forward(carResults, i); // i회차 누적결과 출력
        }
        printWinners(names, carResults);
    }

    private List<String> forward(List<String> carResults, int round) {

        for (int j = 0; j < carResults.size(); j++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            //4이상이 나오면 기존값 + "-" 출력
            if (randomNumber > 3) {
                carResults.set(j, carResults.get(j) + "-");
            } else {
                carResults.set(j, carResults.get(j));
            }
        }
        // i회차 누적 결과 출력
        for (String result : carResults) {
            System.out.println(result);
        }
        System.out.println();
        return carResults;
    }

    private void printWinners(String[] names, List<String> carResults) {
        List<String> winners = new ArrayList<>();
        String carResultArray[] = carResults.toArray(new String[carResults.size()]); //리스트에서 배열로 전환

        int max = 0;

        for (int i = 0; i < carResultArray.length; i++) {
            //결과 배열에서 "-"를 찾아 갯수를 숫자로 반환
            int findHyphen = (int) carResultArray[i].chars().filter(i1 -> String.valueOf((char) i1).equals("-")).count();

            if (findHyphen > max) {
                max = findHyphen;  // 최대값 업데이트
                winners.clear();
                winners.add(names[i]);
            } else if (findHyphen == max) {
                winners.add(names[i]);
            }
        }

        System.out.print("최종 우승자 : ");
        String winnersString = String.join(", ", winners);
        System.out.println(winnersString);
    }
}


