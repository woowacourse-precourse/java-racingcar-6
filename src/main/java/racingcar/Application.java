package racingcar;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static String[] strArr;

    public static void main(String[] args) {
        inputname();
    }

    public static void inputname() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        splitName(readLine());
    }

    public static int splitName(String inputname) {
        strArr = inputname.split(",");
        int Number_of_races = 0;

        if (strArr.length == 0 || strArr.length == 1) {
            inputname();
        } else {
            System.out.println("시도할 회수는 몇회인가요?");

            try {
                Number_of_races = Integer.parseInt(readLine());
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                return splitName(inputname);
            }
        }

        return Number_of_races;
    }


}
