package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static String[] get_user() { // 사용자 이름 입력받기
		String input = Console.readLine();
		String[] user = input.split(",");
		for (int i = 0; i < user.length; i++) {
			if (user[i].length() > 5) {
				throw new IllegalArgumentException();
			}
		}
		return user;
	}

	public static int get_move() { // 움직일 값 입력받기
		int result; // 승패 여부

		int randomNumber = Randoms.pickNumberInRange(0, 9);
		if (randomNumber >= 4) {
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	public static void print_result(String name, int num) { // 결과 출력하기
		System.out.print(name + " : ");
		for (int i = 0; i < num; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static void print_winner(String[] name, int[] num, int usernum) {
		int max = 0; // 최댓값
		int[] result_name = {}; // 우승자 이름 목록
		for (int i = 0; i < usernum; i++) {
			if (num[i] > max) {
				max = num[i];
			}
		}
		int check = 0;
		for (int i = 0; i < usernum; i++) {
			if (num[i] == max && check == 0) {
				check++;
				System.out.print(name[i]);
			} else if (num[i] == max && check != 0) {
				check++;
				System.out.print(", " + name[i]);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		// 사용자 이름 입력받기
		String[] user = get_user();
		int usernum = user.length; // 사용자 인원

		int[] result = new int[usernum]; // 결과값

		System.out.println("시도할 회수는 몇회인가요?");

		// 시도할 횟수 입력받기
		String s = Console.readLine();
		int num = Integer.parseInt(s);

		// 실행결과 출력하기
		System.out.println("\n실행 결과");
		while (num != 0) {
			for (int i = 0; i < usernum; i++) {
				result[i] += get_move();
				print_result(user[i], result[i]);
			}
			System.out.println();
			num--;
		}

		// 최종 우승자 출력하기
		System.out.print("최종 우승자 : ");

		print_winner(user, result, usernum);
	}
}
