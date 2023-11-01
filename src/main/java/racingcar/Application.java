package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public void check1(String except) {
        if (!except.contains(",")) {
            throw new IllegalArgumentException("String에 ','가 포함되어야합니다.");
        }
    }

    public void check2(String except) {
        try {
            int number = Integer.parseInt(except); // 예외가 발생하지 않으면 문자열이 숫자로 변환 가능

        } catch (NumberFormatException e) {

            System.out.println(except + "는 숫자가 아닙니다.");
            return;
        }
    }

    public static void rand_divisor(int rand, int sum[], String car_input[], int j) {
        String output = car_input[j] + " : ";
        if (rand >= 4) {
            sum[j] += 1;
            for (int k = 0; k < sum[j]; k++) {
                output += "-";
            }
        } else {
            for (int k = 0; k < sum[j]; k++) {
                output += "-";
            }
        }
        System.out.println(output);
        rand = 0;
    }

    public static void main(String[] args) {
        Application except = new Application();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String temp = Console.readLine();
        try {
            except.check1(temp);
        } catch (IllegalArgumentException e) {
            System.out.println("error: " + e.getMessage());
            return;
            // TODO: handle exception
        }
        String[] car_input = temp.split(",");
        int length_car = car_input.length;
        // System.out.println(car_input[0]);
        System.out.println("시도할 회수는 몇회인가요?");
        String temp2 = Console.readLine();
        except.check2(temp2);
        int try_move = Integer.parseInt(temp2);// 시도 횟수

        // int sum[length_car];
        int[] sum = new int[length_car];

        System.out.println("");
        System.out.println("실행 결과");
        for (int i = 0; i < try_move; i++) {
            for (int j = 0; j < length_car; j++) {
                int rand = Randoms.pickNumberInRange(0, 9);
                // System.out.print(car_input[j] + " : ");
                /*
                 * String output = car_input[j] + " : ";
                 * if (rand >= 4) {
                 * sum[j] += 1;
                 * for (int k = 0; k < sum[j]; k++) {
                 * output += "-";
                 * }
                 * } else {
                 * for (int k = 0; k < sum[j]; k++) {
                 * output += "-";
                 * }
                 * }
                 * System.out.println(output);
                 * rand = 0;
                 */
                rand_divisor(rand, sum, car_input, j);
            }
            System.out.println("");
        }
        int max = sum[0];
        int cnt = 0;
        for (int i = 0; i < length_car; i++) {
            if (sum[i] >= max) {
                max = sum[i];
            }
        }
        for (int i = 0; i < length_car; i++) {
            if (sum[i] == max) {
                cnt += 1;
            }
        }
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < length_car; i++) {
            if (sum[i] == max && cnt == 1) {
                System.out.print(car_input[i]);
            } else if (sum[i] == max && cnt != 1 && cnt != 0) {
                System.out.print(car_input[i] + ", ");
                cnt -= 1;
            }
        }
    }
}