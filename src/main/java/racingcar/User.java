package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.InputMismatchException;

public class User {
    public String[] EnterCarName() {
        String[] carNameArr;

        while(true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carName = Console.readLine();
            carNameArr = StringToArray(carName);

            int error = Exception(carNameArr);
            if(error == 0) {
                break;
            }
        }
        return carNameArr;
    }

    public String[] StringToArray(String str) {
        String[] arr;
        arr = str.split(",");

        for (int i=0; i<arr.length; i++) {
            String name = arr[i];
            arr[i] = name.trim();
        }

        return arr;
    }

    public int Attempt() {
        int result = 0;

        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            String n = Console.readLine();
            int num = Integer.parseInt(n);

            int[] errorCheck = Attempt_Exception();

            if (errorCheck[0] == 0) {
                result = errorCheck[1];
            }
            if(result != 0)
                break;
        }
        return result;
    }

    public int Exception(String[] arr) {
        int error = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i].length() > 5 || arr[i].length() == 0) {
                error += 1;
                break;
            }
        }
        return error;
    }

    public int[] Attempt_Exception() {
        int tryNum = 0;
        int error = 0;
        int[] result = new int[] {0,0};
        try {
            String t = Console.readLine();
            tryNum = Integer.parseInt(t);
        } catch(InputMismatchException ime) {
            System.out.println("숫자만 입력 가능합니다.");
            error += 1;
        }
        result[0] = error;
        if (result[0] == 0 ) {
            result[1] = tryNum;
        }
        return result;
    }
}
