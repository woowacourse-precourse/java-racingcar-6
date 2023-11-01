package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Application {
    public static void main(String[] args) {

        ArrayList<String> carname= generateCarname();

        String count = askTrynubmer();

        moveCar(count, carname);






    }

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
        Console.close();

        StringJoiner joiner = new StringJoiner(", ");
        for (String name : carNamelist) {
            joiner.add(name);
        }

        System.out.println(joiner);
        return carNamelist;
    }

    static String askTrynubmer() {

        System.out.println("시도할 회수는 몇회인가요?");
        String tryNumber = Console.readLine();
        System.out.println(tryNumber);
        System.out.println();
        return tryNumber;
    }

    static boolean goStop() {

        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            return true;
        } 
        else {
            return false;
        }
    }

    static String  score(){

        boolean goCount = goStop();

        if (goCount == true){

            return


        }
        else {
            return ;
        }

    }

    static void moveCar(String count, ArrayList<String> carname) {
        
        System.out.println();
        System.out.println("실행 결과");
        
        int countNum = Integer.parseInt(count);
        int i = 1;
        while (i <= countNum){

            for (String name: carname) {
                String theScore = score(name);
                System.out.println("name : "+ theScore);

            }

            System.out.println();
        }


    }


}

