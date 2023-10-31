package racingcar;

 import java.util.*;

 import camp.nextstep.edu.missionutils.Console;
 import camp.nextstep.edu.missionutils.Randoms;

 public class Application {
 	public static void main(String[] args) {
 		// TODO: ���α׷� ����
 		Run(Car_Names(), Try_Numb());
 		// Try_Numb();
 		// Run(Car_Names(),Try_Numb());
 	}

 	// ���� ����//
 	public static void Run(String[] Car_Names, Integer Try_Numb) {
 		int[] Car_Score = new int[Car_Names.length];
 		// System.out.println(Car_Score.length);
 		for (int i = 0; i < Try_Numb; i++) {
 			Car_Score = Stage_Calc(Car_Names, Car_Score);
 		}
 		Winner(Car_Names, Car_Score);
 	}

 	// ������� ��� �� ���//
 	public static int[] Stage_Calc(String[] Car_Names, int[] Car_Score) {
 		System.out.println("���� ���");
 		for (int i = 0; i < Car_Names.length; i++) {

 			if (Car_Race() >= 4) {
 				Car_Score[i]++;
 			}

 			// .repeat(Car_Score[i]));}
 			System.out.println(Car_Names[i] + " : " + "-".repeat(Car_Score[i]));
 		}

 		return Car_Score;
 	}

 	// ������//
 	public static Integer Car_Race() {
 		Integer Race_numb = Randoms.pickNumberInRange(1, 9);
 		// System.out.print(Try_numb);
 		return Race_numb;
 	}

 	// �����//
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
 		System.out.print("���� ����� : " + String.join(", ", Winner_index));
 	}

 	// [�Է°�]
 	// ���� �̸�//
 	public static String[] Car_Names() {
 		System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸���(,��ǥ) �������� ����.");
 		String[] Car_Names = Console.readLine().split(",");
 		Names_ErrCheck(Car_Names);
 		return Car_Names;
 	}

 	public static void Names_ErrCheck(String[] Car_Names) {
 		for (int i = 0; i < Car_Names.length; i++) {

 			if (Car_Names[i].length() > 5) {
 				throw new IllegalArgumentException("�ڵ��� �̸��� 5�� �̻��Դϴ�.");
 			}

 		}
 	}

 	// �õ� Ƚ��//
 	public static Integer Try_Numb() {
 		System.out.println("�õ��� ȸ���� ��ȸ�ΰ���?");
 		Integer Try_numb = null;
 		try {
 			Try_numb = Integer.parseInt(Console.readLine());
 		} catch (Exception e1) {
 			throw new IllegalArgumentException("������ �Է��Ͻÿ�.");
 		}
 		// System.out.print(Try_numb);
 		return Try_numb;
 	}

 }