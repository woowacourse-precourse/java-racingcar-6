
## *interface* `Rule`
- 사용자로부터 자동차 이름 입력받기
- 사용자로부터 이동 횟수 입력 받기
- 현재 결과 출력하기
- 최종 결과 출력하기


## *interface* `Car`
- 현재 위치 반환
- 현재 위치 기준, 전진


# *class* `Game`
  - `Rule` 인터페이스를 구현한다.
  - 사용자로부터 자동차 이름 입력받기
    - 쉼표로 구분된 전체 문자열에 대한 분리
    - 잘못된 형식이면 IllegalArgumentException 발생
  - 사용자로부터 이동 횟수 입력 받기
    - 잘못된 값을 입력하면 IllegalArgumentException 발생


# *class* `RacingCar`
  - 자동차의 속성은 다음과 같다.
    - 이름 (5자 이하)
      - 5자 이상이면 IllegalArgumentException 발생
    - 주행거리 (기본값=0)
    - 단위 이동 시 필요한 연료량 (기본값=4)
  - 자동차의 메서드는 다음과 같다.
    - 주행 (`임시 연료 공급량`이 4 이상)
    - 임시 연료 공급 (0에서 9 사이의 난수 반환)


