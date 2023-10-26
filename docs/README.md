# 목표

- [ ] 기능 구현 전에 설계를 제대로 해볼 것
- [ ] TDD를 시도 해볼 것

# 간단 기능 목록

# 요구 사항

- [ ] indent depth 3
- [ ] no ternary operator
- [ ] methods only can do one thing

- [ ] 라운드 별 실행 결과 출력
- [ ] 최종 우승자 출력

# 간단 클래스 설계

---

## Cars

모든 자동차를 담고 있는 클래스

-[ ] properties
    - [ ] cars: `List<Car>`
-[ ] behaviours
    - [ ] moveAllBy(`MoveDecider`)

---

## Car

개별 자동차를 담고 있는 클래스

-[ ] properties
 name: `CarName`
 coordinate: `Coordinate`

-[ ] behaviours
    - [ ] move()

---

## Coordinate(wrapping record)

자동차의 위치에 대한 래핑 클래스

-[ ] properties
 coordinate: `int`

-[ ] behaviours
    - [ ] validateCoordinate: 위치는 음수 불가

---

## MoveDecider(interface)

자동차가 움직일지 말지 결정하는 메소드를 가진 인터페이스

-[ ] behaviours
    - [ ] `nextMovement`: `Movement`

---

## CarName(wrapping record)

자동차 이름에 대한 래핑 클래스

-[ ] properties
    - [ ] name: 자동차명

-[ ] behaviours
    - [ ] validateNameLength: 자동차 이름은 1~5자 가능

---

## Movement(enum)

- GO
- STAY

---

## MoveResults

모든 자동차의 현재 위치를 담은 결과

-[ ] properties
    - [ ] moveResults: `List<MoveResult>`

---

## MoveResult

개별 자동차의 현재 위치를 담은 결과

-[ ] properties
    - [ ] name: `String` - 자동차명
    - [ ] coordinate: `int` - 위치

---

## WinnersResult

자동차 최종 순위

-[ ] properties
    - [ ] winnerNames: `List<String>` 자동차명

