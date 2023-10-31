# 기능 구현 목록

## 자동차
- 생성시 이름, raceCount(초기위치 = 0)를 가진다.
- 생성자
    - 입력된 값을 ","로 split 하여 생성
    - raceCount(초기위치)는 0으로 지정

## 이름 확인
  - 이름이 5글자를 초과할 경우 `IllegalArgumentException`을 발생
  - 이름이 공백인 경우 `IllegalArgumentException`을 발생

## 전진 카운트
- 숫자를 랜덤생성하여 4 이상인 경우 raceCount 1 증가

## 숫자 랜덤 생성
- 0과 9사이의 랜덤한 숫자 생성
- `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용

## 우승자 확인
- 가장 멀리간 자동차를 확인하고 우승자를 출력
- 동점자가 존재할 수 있음

---
# 입력
## 자동차 이름 입력
- `List<Car>`를 만들어 이름을 입력받는 동시에 생성자에서 이름에 대한 검증을 하고 리스트에 자동차 객체 저장

## 시도할 회수 입력
- 입력받은 문자열을 정수형으로 변경
- 0 이하가 입력되면 `IllegalArgumentException` 발생

