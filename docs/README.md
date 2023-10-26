# 🏎️ 자동차 경주 🏎️

## 🔍 구현할 기능 목록

#### 1. 경주 할 n대의 자동차 이름 입력
- ✔️ 자동차 이름을 쉼표(,)를 기준으로 구분
- ✔️ 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
- ✔️ 올바른 값 입력 검증 (잘못된 값이 입력되면 **IllegalArgumentException()**)

  - 입력한 값에서 이름을 각각 추출했을 때, 그 길이가 5 이하인가

#### 2. 시도할 횟수 입력
- ✔️ 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
- ✔️ 올바른 값 입력 검증 (잘못된 값이 입력되면 **IllegalArgumentException()**)

  - 입력한 값이 숫자인가

#### 3. 전진 구현

##### 3-1. 랜덤 값 생성
- ✔️ 0에서 9 사이의 무작위 값 생성
  - 4 이상일 경우 전진 💨
  - 4 미만일 경우 정지 🛑
- ✔️ Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용

##### 3-2. Dash(-)로 전진 표시
- ✔️ 전진하면 값 점차 누적해서 저장
- ✔️ 게임 횟수에 따라 자동차 이름 별로 점차 누적되는 전진 출력

#### 4. 우승자 출력
- ✔️ 누적된 전진 횟수를 분석하여 최종 우승자 출력
- ✔️ 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분