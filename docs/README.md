# 📚 구현 기능 목록
<br>

### 📌 자동차 생성
- [x] 경주할 자동차 이름은 쉼표(,)로 구분하여 5글자 이하로 입력한다.
- [x] 경주를 시도할 횟수를 입력한다.
- [x] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
```agsl
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5
```

<br>

##### 🚫 예외 처리
- [x] 경주에 참가하는 자동차가 1대일 경우 ``IllegalArgumentException``
- [x] 구분자를 쉼표(,)가 아닌 다른 값을 사용 했을 경우 (공백도 포함) ``IllegalArgumentException``
- [x] 쉼표(,)로 구분된 이름이 5글자를 초과할 경우 ``IllegalArgumentException``
- [x] 입력값 마지막을 쉼표(,)로 끝낸 경우 ``IllegalArgumentException``
- [x] 아무런 값을 입력하지 않았을 경우 ``IllegalArgumentException``
- [x] 중복된 자동차 이름을 입력했을 경우 ``IllegalArgumentException``
- [x] 경주를 시도할 횟수에 0보다 작은 값을 입력했을 경우 ``IllegalArgumentException``
- [x] 경주를 시도할 횟수의 첫 번째 수에 0이 포함되어 있을 경우 ``IllegalArgumentException``
- [x] 경주를 시도할 횟수를 숫자가 아닌 값을 이력했을 경우 ``IllegalArgumentException``
- [x] 자동차 이름 중간에 공백은 허용하되``ex:) god jun,po ten``, 영대소문자, 숫자, 한글이 아닌 값을 입력했을 경우, 한다.``IllegalArgumentException``
- [x] 자동차 이름을 공백으로 입력 했을 경우  ``IllegalArgumentException``
  - [x] 자동차 이름의 첫 글자는 공백을 허용하지 않는다.
  - [x] 자동차 이름의 마지막 글자는 공백을 허용하지 않는다.
---
### 📌 자동차 경주 게임 진행
- [x] 경주를 시도할 횟수 동안 n대의 자동차는 전진 또는 정지 할 수 있다.
  - [x] ```Randoms.pickNumberInRange(0, 9)```의 무작위 값이 4 이상일 경우 해당 자동차는 전진한다.
  - [x] ```Randoms.pickNumberInRange(0, 9)```의 무작위 값이 4 미만일 경우 해당 자동차는 정지한다.
- [x] 횟수마다 각각의 자동차들이 움직인 횟수를 "-"로 출력한다.
```agsl
pobi : ---
woni : --
jun : ---
```

---
### 📌 우승자
- [x] 경주를 시도할 횟수에 도달한 자동차의 이름을 출력한다. (우승자는 한명 이상일 수 있다.)
  - [x] 우승자가 한명 일 경우 해당 우승자만 출력한다.
  - [x] 우승자가 여려명일 경우 쉼표(,)로 구분하여 우승자들을 출력한다. (쉼표다음에는 공백이 존재)
```agsl
// 우승자가 한명일 경우
최종 우승자 : pobi

// 우승자가 한명 이상일 경우 (정상 출력 케이스)
최종 우승자 : pobi, jun
```
---