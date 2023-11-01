## 👩🏻‍💻구현 기능
#### 1) 사용자의 이름 입력받기
사용자로부터 게임에 참여하는 n명의 이름을 입력받는다.
이때 사용자 이름은 5자 이하로 작성해야한다. 그렇지 않을 경우 예외처리.
```
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
```

#### 2) 움직일 값 입력받기
사용자에게 3개의 자연수를 String으로 입력받은 후 List에 넣어주기
```
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
```

#### 3) 결과 출력하기
자동차가 몇번 이동했는지에 대한 결과 출력하기
```
public static void print_result(String name, int num) { // 결과 출력하기
		System.out.print(name + " : ");
		for (int i = 0; i < num; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
```

#### 4) 이긴 사람 출력하기
이긴사람이 1명 이상일 경우 ','로 구분하여 출력하기
```
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
```
