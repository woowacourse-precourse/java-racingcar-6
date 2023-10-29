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