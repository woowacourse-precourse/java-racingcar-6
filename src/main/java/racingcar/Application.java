package racingcar;

public class Application {
    public static void main(String[] args) {
        IllegalArgumentException ee = new IllegalArgumentException();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameList = camp.nextstep.edu.missionutils.Console.readLine();
        String name[] = nameList.split(",");
        int dis[] = new int[name.length];

        for (int i = 0; i < name.length; i++) {
            if (name[i].length() > 5) {
                throw ee;
            }
        }

        int n;
        System.out.println("시도 할 횟수는 몇 회 인가요?");
        try {
            n = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        } catch (Exception e) {
            throw ee;
        }
        System.out.println("\n실행결과");
        raceCars(name, dis, n);
        determineWinners(name, dis);
    }

    private static void raceCars(String[] name, int[] dis, int n) {
        for (int i = 0; i < n; i++) {
            raceSingleRound(name, dis);
            System.out.println();
        }
    }

    private static void raceSingleRound(String[] name, int[] dis) {
        for (int j = 0; j < name.length; j++) {
            int randomNum = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) dis[j]++;
            printCarStatus(name[j], dis[j]);
        }
    }

    private static void printCarStatus(String name, int distance) {
        System.out.print(name + " : ");
        for (int k = 0; k < distance; k++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static String determineWinners(String[] name, int[] dis) {
        int maxDis = 0;
        for (int i = 0; i < dis.length; i++) {
            maxDis = Math.max(maxDis, dis[i]);
        }

        String winMembers = "";
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] == maxDis) {
                winMembers += name[i] + ",";
            }
        }

        System.out.print("최종 우승자 : ");
        System.out.println(winMembers.substring(0, winMembers.length() - 1));
        return winMembers.substring(0, winMembers.length() - 1);
    }
}
