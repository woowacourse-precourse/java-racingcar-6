### 자동차 클래스 `Car`
* 자동차 이름 `name`
* 자동차 현재 위치 `position`
* 생성자 `Car(String name)`
  * 인자: 자동차 이름
  * 자동차 이름을 인자값 `name`으로 설정
  * 자동차 전진 횟수를 `0`으로 초기화
* Getter `getName()`
  * 최종 우승자를 출력하는 데 사용
* Getter `getPosition()`
  * 최종 우승자를 판별하는 데 사용
* 이동 메서드 `move()`
  * 한 칸 전진, 즉 `position` 값을 `1` 증가
  * 반환값 없음
* 결과 출력 메서드 `toString()` 오버라이딩
  * 각 차수별 실행 결과를 표시할 때 사용
  * 자동차 이름(`woni`)과 자동차의 현재 위치(`4`)를 아래와 같이 표시
  * `woni : ----`
* 대소비교 메서드 `compareTo()` 오버라이딩
  * 게임 결과 판정에 사용
  * `position`의 값을 비교하도록 구현

### 게임 시작 함수 `start()`
* 자동차 객체 생성 및 리스트화: `readCarNames()`
* 시도할 횟수 입력: `readGameCount()`
* 게임 진행 함수 호출: `game(int count)`

### 자동차 이름 입력 함수 `readCarNames()`
* String 입력받기: 내장 함수 `readLine()`
* String 분리 및 리스트로 저장: 내장 함수 `split()`
* String 리스트 검증: `validateCarNames(List<String> names)`
* `List<String>`을 바탕으로 `List<Car>` 생성 후 반환

### 게임 횟수 입력 함수: `readGameCount()`
* String 입력받기: 내장 함수 `readLine()`
* String -> int 변환
  * 예외 터지면 `IllegalArgumentException` 터뜨리기
* 입력 검증: `validateGameCount(String input)`
* 자연수 반환

### 사용자 입력 검증 함수 `validateCarNames(List<String> names)`
* 인자: 검증이 필요한 이름들의 리스트
* 문자열 리스트를 iterate 하면서, 하나라도 5글자 초과하는 문자열이 발견되면 예외 터뜨림
* 루프가 끝나면 `false`를 반환

### 사용자 입력 검증 함수 `validateGameCount(String input)`
* 인자: 사용자가 입력한 게임 횟수
* 입력 문자열이 자연수가 아닌 경우 예외 터뜨림

### 게임 진행 함수 `game(int count)`
* 인자: 게임 시도 횟수
* 아래를 `count`회 반복 실행
  * 모든 자동차를 이동: `moveCars()`
  * 실행 결과를 출력: `printResult()`
* 최종 우승자 출력: `printWinners()`

### 이동 여부를 결정하는 함수 `isMovable()`
* 0부터 9까지 중 무작위 정수를 구함
* 무작위 값이 4 이상일 경우 `true` 반환
* 무작위 값이 4 미만일 경우 `false` 반환

### 모든 자동차를 이동하는 함수 `moveCars()`
* `List<Car>`에서 각각의 `Car`에 대해 다음을 실행
  * 전진 여부를 확인: `isMovable()`
  * `isMovable()` 값이 `true`이면 현재 루프의 `Car` 객체 전진: 멤버 메서드 `move()`

### 각각 라운드의 게임 결과를 출력하는 함수 `printResult()`
* `List<Car>` 내의 모든 `Car`를 출력
  * `toString()` 오버라이드 필수

### 최종 우승자를 판단하여 출력하는 함수 `printWinners()`
* `List<Car>` 내의 최댓값 출력
  * `Collections.max()` 사용
  * `compareTo()` 오버라이드 필수