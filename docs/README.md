### Racer 클래스 

---
#### 멤버 변수

---
- `String name`
  - 운전자의 이름을 저장하는 문자열

- `StringBuilder score`
  - 운전자의 성적을 기록하는 `StringBuilder`
  - 추가가 빈번하기 때문에 `String`이 아닌 `StringBuilder` 사용

#### 멤버 메소드

---
##### 생성자 메소드
- signature : `public Racer(String name)`
- parameters
  - name : 설정할 이름
- return : 게임에 사용될 `Racer` 인스턴스
- description
  - 5자 이하의 문자열을 받아 해당 문자열을 이름으로 가지는 새 레이서를 생성하는 메소드
  - `score`는 새 `StringBuilder`로 초기화한다.

##### 레이서를 움직이는 메소드
- signature : `public void move()`
- return : void
- description 
  - score에 `-`를 `append`해주는 메소드

##### 레이서의 이름을 반환하는 메소드
- signature : `public String getName()`
- return : 해당 객체의 이름
- description
  - 현재 레이서의 이름을 반환한다.

##### 레이서의 성적을 반환하는 메소드
- signature : `public String getScore()`
- return : 해당 객체의 성적
- description
  - 현재 레이서의 성적을 반환한다.

### Game 클래스

#### 멤버 변수

---
- `private GameUtil gameUtil`
  - 각종 문구를 가공하고 출력해줄 gameUtil
- `private List<Racer> racerList`
  - 게임에 사용될 Racer들
- `private int moveCount`
  - 각 레이서들이 움직일 차수
---
#### 멤버 메소드

---

##### 생성자 메소드
- signature : `public Game(int moveCount, String input)`
- parameters
  - moveCount : 게임의 차수
  - input : 사용자가 입력한 문자열
- return : `Game`의 인스턴스
- description
  - 새로운 게임을 생성하는 메소드
  - 전달받은 차수를 설정한다.
  - 입력받은 문자열을 `gameUtil.inputToNameList()`로 가공해 이름 리스트로 변환한다.
  - 리스트의 원소로 새로운 `Racer`를 생성해 `List<Racer>`에 추가한다.

##### 무작위 값을 추출하는 메소드
- signature : `public int getRandomNumber()`
- return : 0 ~ 9 사이의 정수
- description
  - `Random`클래스의 `pickNumberInRange`메소드를 활용해 0 ~ 9 사이의 정수를 추출한다.

##### 추출된 무작위 값으로 움직임 여부 결정하는 메소드
- signature : `public boolean canMove(int randomNumber)`
- parameters
  - randomNumber : 추출된 무작위 값
- return : `boolean`값 `true` 또는 `false`
- description
  - 무작위 값을 받아 4이상이면 `true`를 미만이면 `false`를 반환한다.

##### 가장 많이 움직인 횟수를 구하는 메소드
- signature : `public int getMax()`
- return : `Racer`들의 움직인 거리 중 최대값
- description
  - `Stream`을 이용해 racerList의 각 `Racer`들의 성적을 추출한다.
  - 추출한 성적의 길이를 중 최대값을 찾아 반환한다.

##### 우승자를 선별하는 메소드
- signature : `public List<Racer> getWinner()`
- return : 우승한 Racer를 담은 리스트
- description
  - 각 `Racer`의 score를 비교해 우승자 판별하고 공동 우승의 경우 우승자들을 반환한다.

### GameUtil 클래스

---
입력된 문자열을 변환하고 문구 및 결과를 출력해주는 클래스

#### 멤버 메소드

---

##### 자동차 이름을 입력받는 메서드
- signature : `public String getCarName()`
- return : 입력받은 문자열
- description
  - "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"을 출력한다.
  - `Console.readLine()`메소드로 입력받은 값을 반환한다.

##### 회수를 입력받는 메서드
- signature : `public Integer getMoveCount()`
- return : 입력받은 문자열을 정수로 변환한 값
- error : 정수가 아니라면 `IllegalArgumentException`을 발생시킨다.
- description
  - "시도할 회수는 몇회인가요?"를 출력한다.
  - `Console.readLine()`메소드로 입력을 받는다.
  - 입력받은 값이 정수로 변환될 수 있으면 그 값을 반환한다.
  - 변환이 불가능하다면 `IllegalArgumentException`을 발생시킨다.

##### 각 차수 결과를 출력해주는 메소드
- signature : `public void printEachResult(final List<Racer> racerList)`
- parameters
  - racerList : 게임에 참여한 `Racer`를 담은 리스트
- return : void
- description
  - `StringBuilder` result에 각 `Racer`마다 이름과 차수결과를 `append`한다.
  - 모든 `Racer`의 결과를 담았다면 출력한다.

##### 입력받은 문자열을 이름으로 바꿔주는 메소드
- signature : `public List<String> inputToNameList(String input)`
- parameters
  - input : 유저가 입력한 이름들
- error : `IllegalArgumentException`
- return : 이름으로 사용될 문자열을 담는 `String`리스트
- description
  - 입력받은 문자열을 `,`로 구분한다.
  - 구분한 문자열 배열의 각 원소를 `trim()` 메소드로 앞 뒤 공백을 자른다.
  - `isNameOK`메소드로 구분된 문자열들이 적합한지 판단한다.
  - `isNameOK`의 결과가 `false`라면 `IllegalArgumentException`을 발생시킨다.
  - 모든 결과가 `true`면 `List<String>`을 반환한다.

##### 문자열이 이름으로 적합한지 확인하는 메소드
- signature : `private boolean isNameOK(String nameCandidate)`
- parameters
  - nameCandidate : 적합한 이름인지 판단할 문자열
- return : `boolean`값 `true` 또는 `false`
- description
  - 만약 문자열의 길이가 5를 초과하거나 0이하면 `false`를 반환한다.
  - 1 ~ 5자면 `true`를 반환한다.

##### 우승자를 출력하는 메소드
- signature : `public void printWinner(List<Racer> winner)`
- parameters
  - winner : 우승자를 담은 배열
- description
  - 우승자 배열에서 각 우승자의 이름을 추출한다.
  - 추출한 우승자 이름을 ','과 함께 합쳐 출력한다.