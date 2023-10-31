package racingcar;

 import java.util.*;

 import camp.nextstep.edu.missionutils.Console;
 import camp.nextstep.edu.missionutils.Randoms;

 public class Application {
 	public static void main(String[] args) {
 		// TODO: 프로그램 구현
 		Run(Car_Names(), Try_Numb());
 		// Try_Numb();
 		// Run(Car_Names(),Try_Numb());
 	}

 	// 실행 문서//
 	public static void Run(String[] Car_Names, Integer Try_Numb) {
 		int[] Car_Score = new int[Car_Names.length];
 		// System.out.println(Car_Score.length);
 		for (int i = 0; i < Try_Numb; i++) {
 			Car_Score = Stage_Calc(Car_Names, Car_Score);
 		}
 		Winner(Car_Names, Car_Score);
 	}

 	// 실행과정 계산 및 출력//
 	public static int[] Stage_Calc(String[] Car_Names, int[] Car_Score) {
 		System.out.println("실행 결과");
 		for (int i = 0; i < Car_Names.length; i++) {

 			if (Car_Race() >= 4) {
 				Car_Score[i]++;
 			}

 			// .repeat(Car_Score[i]));}
 			System.out.println(Car_Names[i] + " : " + "-".repeat(Car_Score[i]));
 		}

 		return Car_Score;
 	}

 	// 랜덤값//
 	public static Integer Car_Race() {
 		Integer Race_numb = Randoms.pickNumberInRange(1, 9);
 		// System.out.print(Try_numb);
 		return Race_numb;
 	}

 	// 우승자//
 	public static void Winner(String[] Car_Names, int[] Car_Score) {
 		int max = 0;
 		List<String> Winner_index = new ArrayList<>();
 		for (int i = 0; i < Car_Names.length; i++) {

 			if (Car_Score[i] > max) {
 				max = Car_Score[i];
 			}

 		}
 		for (int o = 0; o < Car_Names.length; o++) {

 			if (Car_Score[o] == max) {
 				Winner_index.add(Car_Names[o]);
 			}

 		}
 		System.out.print("최종 우승자 : " + String.join(", ", Winner_index));
 	}

 	// [입력값]
 	// 차량 이름//
 	public static String[] Car_Names() {
 		System.out.println("경주할 자동차 이름을 입력하세요.(이름은(,쉼표) 기준으로 구분.");
 		String[] Car_Names = Console.readLine().split(",");
 		Names_ErrCheck(Car_Names);
 		return Car_Names;
 	}

 	public static void Names_ErrCheck(String[] Car_Names) {
 		for (int i = 0; i < Car_Names.length; i++) {

 			if (Car_Names[i].length() > 5) {
 				throw new IllegalArgumentException("자동차 이름이 5자 이상입니다.");
 			}

 		}
 	}

 	// 시도 횟수//
 	public static Integer Try_Numb() {
 		System.out.println("시도할 회수는 몇회인가요?");
 		Integer Try_numb = null;
 		try {
 			Try_numb = Integer.parseInt(Console.readLine());
 		} catch (Exception e1) {
 			throw new IllegalArgumentException("정수를 입력하시오.");
 		}
 		// System.out.print(Try_numb);
 		return Try_numb;
 	}

 }