package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {

        ArrayList<String> carname= generateCarname();

        String count = askTrynubmer();

        moveCar(count, carname);

    }

    static ArrayList<Integer> carDistances = new ArrayList<>();

    static ArrayList<String> generateCarname() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        ArrayList<String> carNamelist = new ArrayList<>();
        String[] input = Console.readLine().split(",");

        for (String name : input) {
            carNamelist.add(name);
        }

        for (String name : carNamelist) {
            int length = name.length();
            if (length > 5) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < carNamelist.size(); i++) {
            carDistances.add(0);
        }
        return carNamelist;
    }

    static String askTrynubmer() {

        System.out.println("시도할 회수는 몇회인가요?");
        String tryNumber = Console.readLine();
        return tryNumber;
    }

    static String score() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            return "-";
        } else {
            return "";
        }
    }

    static void moveCar(String count, ArrayList<String> carname) {
        System.out.println();
        System.out.println("실행 결과");

        int countNum = Integer.parseInt(count);

        for (int i = 0; i < countNum; i++) {
            moveSingleCar(carname);
            System.out.println();
        }

        List<String> winners = findWinners(carname);
        printWinners(winners);
    }

    static void moveSingleCar(ArrayList<String> carname) {
        for (String name : carname) {
            String theScore = score();

            if (theScore.equals("-")) {
                int index = carname.indexOf(name);
                carDistances.set(index, carDistances.get(index) + 1);
            }

            System.out.println(name + " : " + "-".repeat(carDistances.get(carname.indexOf(name))));
        }
    }

    static List<String> findWinners(ArrayList<String> carname) {
        List<String> winners = new ArrayList<>();
        int maxDistance = 0;

        for (String name : carname) {
            int index = carname.indexOf(name);
            int distance = carDistances.get(index);

            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(name);
            } else if (distance == maxDistance) {
                winners.add(name);
            }
        }

        return winners;
    }

    static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }



}

