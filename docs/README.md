# 자동차 경주
<hr>

## 기능 요구 사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 주어진 휫수(전진)가 끝나면 우승자를 가린다. 우승자는 한 명 이상일 수 있다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하였습니다.
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용히였습니다.
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용하였습니다.

<hr>

# 구현 기능 목록
## Random 값 추출기능
- 1부터 9사이의 1개의 난수 발생
- pickNumberInRange()를 활용
- computer
- 메서드로 처리 getNewRandomNumber

## 입력기능
- 중복 없는 세 자리 숫자 입력
- 게임 종료 및 재시작 의사결정을 위한 1, 2 입력
- readLine()을 활용
- inputNumber(String)에 저장


## 비교
- 랜덤값과 사용자 입력한 숫자 비교

## 출력
- 게임 시작을 위한 안내문 출력
- 사용자가 입력한 값에 해당하는 스트라이크 볼 낫싱값 출력
- 게임 종료 안내문 출력
- 게임 종료 및 재시작에 관한 안내문 출력 

<hr>

# 구현한 메서드
- `getNewRandomNumber()` : 1 ~ 9 사이의 난수 1개를 반환해주는 메서드

<br>

- `run()` : 자동차 경주 게임을 시작하는 메서드, `gameStart()`, `printWinnerCars()` 호출

<br>

- `printStart()` : 자동차 이름을 입력하라는 출력문
- `printCurrentStatus(String)` : 현재 전진한 자동차의 상태 출력
- `printWinnerCars()` : 우승한 자동자의 이름 출력, 공동 우승할 경우 두 개의 이름을 ','로 구분해 출력

<br>

- `gameStart()` : 입력 받은 횟수 만큼 경주 시작, `checkOneLab()` 호출
- `checkOneLab()` : 하나의 회차 동안 이루어질 전진 여부 `getNewRandomNumber()` 호출

<br>

- `setCarsName()` : 경기에 참가하는 자동차들을 입력받아 저장하는 함수
- `setCircuitLength()` : 입력값을 시도할 횟수로 초기화

<br>

- `validityCheckByCircuitLength(String totalLength)` : 시도할 횟수 입력값에 대한 예외처리
- `validityCheckByCarsName(String)` : 입력한 자동차 이름에 대한 예외처리
- `isNumeric(String str)` : 정규 표현식을 사용해 숫자로만 구성되어 있는지 확인

<hr>

# 테스트 도구 구현 

1. `전진_정지()`: 전반적인 기능 테스트
2. `회차_동안의_자동차의_전진_상태()` : 한 회차동안 출력되는 출력문 테스트
3. `이름에_대한_예외_처리_4자리초과()` : 4자리가 초과되는 자동차 이름 입력 테스트
4. `이름에_대한_예외_처리_중복()` : 중복된 자동차 이름 입력 테스트
5. `이름에_대한_예외_처리_공백()` : 자동차 이름 입력에 대한 공백 테스트
6. `입력_횟수에_대한_예외_처리()` : 잘못된 실행 횟수 입력에 대한 테스트
