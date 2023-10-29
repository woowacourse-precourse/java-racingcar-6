# 구현 기능 목록


## 🚗 Car Class
*차와 관련된 변수*

---

- String name;   이름
- int distance;   이동 거리


## ➡️ static int forward() - 전진하는 함수
*모든 car들이 사용하니까 static으로 따로 구현하면 어떨깡.. 일단 구현해보고 car에 넣는게 깔끔할 것 같으면 수정해보기~*

--- 

1. Randoms.pickNumberInRange(0,9) 이용해서 0~9사이 무작위 값 구하기
2. 구한 값이 4이상이면 true 반환, 아니면 false 반환


## 💁🏻‍♀️️ Input Class
*입력과 관련된 변수와 함수*

---

- void getUserInput(String name, int count) - 사용자 입력 받아서 저장하는 함수
- String name : 경주 할 자동차 이름(String을 ,로 구분해서 String[]에 넣기)
- int playCount : 시도할 횟수
- int carCount : 차 갯수(list.size())
- List<String> arrayTolist(String []) : String array -> String list로 변환하는 함수

### 🚫 IllegalArgumentException
*사용자 입력 값 체크*

- 자동차 이름이 5자 이하인가
- 자동차 이름을 , 로 구분하여 입력했는가
- 시도 횟수를 숫자로 입력했는가


## 🖥️ Output Class
*출력과 관련된 변수와 함수*

---

- void resultPrinter() - 실행 결과 출력 함수
- void winnerNotice() - 우승자 안내 문구 출력 함수(공동 우승자는 ,로 구분해서 출력)
- private static final String MSG - 출력 메시지 변수
    - GetUserInput "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    - GetCount "시도할 회수는 몇회인가요?"