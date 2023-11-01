# ♻️ 코드 실행 흐름
1. Application.class의 main() 에서 Racing객체 생성
2. Racing.setting()에서 이름, 횟수 입력받기
3. Raging.play() 실행
   - 자동차 개수만큼 객체 만들기


# 💠 각 클래스들 구성

## 🧭 Setting
- `List<String> carName` : 입력한 자동차의 이름을 저장하는 List
- `int cycleNumber` : 사용자가 입력한 자동차 전진 횟수
- `setting()` : 자동차 이름, 전진 횟수 입력받는 메서드
- `getNames()` : i번째 자동차의 이름List를 가져오는 메서드
- `getNumber()` : 전진 횟수를 가져오는 메서드

## 🥇 Racing
- `play()` : for문 돌려서 횟수만큼 각 자동차들의 `goStop()` 진행하기
  - `runOnce()` : car 객체의 `goStop()` 메서드를 호출하는 메서드
  - `printOnce()` : 각 객체들의 distance 만큼 -를 출력하는 메서드
  - `printWinner()` : winner 객체에서 `whoIsWinner()`를 통해 받은 우승자 자동차를 출력해주는 메서드

## 🏎️ Car
- `distance` : 지금까지의 위치(얼마나 이동했는지)를 저장하는 변수
- `name` : 각 자동차의 이름을 저장하는 변수
- `goStop()` : Random 으로 수 가져오기 -> 4보다 크면 distance++
- `getDistance()` : process, winner 를 파악하는데 필요

## 🎫 Winner
- `whoIsWinner()` : 각 자동차의 distance 를 비교하여 최대 distance 를 갖는 자동차 객체 리스트를 반환한다.