# 2주차 미션 자동차 경주

## 기능 구현 목록

---

### ✔ 자동차 생성
- [x] `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)` 출력
- [x] 자동차 이름 문자열 입력받기
  - 입력받은 값이 없는 경우 (IllegalArgumentException) 발생
  - 입력받은 값 앞뒤 쉼표(,) 포함한 경우(IllegalArgumentException) 발생
- [x] 자동차 이름 문자열을 쉼표(,) 기준으로 분리 
  - 분리된 문자열의 길이가 0인 경우 (IllegalArgumentException) 발생
  - 분리된 문자열의 길이가 6 이상인 경우 (IllegalArgumentException) 발생
  - 분리된 문자열 앞뒤 공백 포함한 경우(IllegalArgumentException) 발생
- [x] 분리된 자동차 문자열을 리스트에 저장
  - 분리된 문자열이 중복인 경우 (IllegalArgumentException) 발생
### ✔ 시도 회수 입력

- [x] `시도할 회수는 몇회인가요?` 출력
- [x] 사용자에게 숫자 입력받기
    - 입력받은 값이 없는 경우 (IllegalArgumentException) 발생
    - 입력받은 값이 숫자가 아닌 경우 (IllegalArgumentException) 발생
    - 입력받은 값이 음수 인 경우 (IllegalArgumentException) 발생
    - 입력받은 값이 정수형(2,147,483,647) 보다 큰경우 (IllegalArgumentException) 발생

### ✔ 자동차 전진

- [x] 0에서 9 사이에서 무작위 값 생성
- [x] 무작위 값이 4 이상일 경우 이동거리 1증가

### ✔ 자동차 전진 상태(실행 결과)
- [x] `실행 결과` 출력
- [x] `{자동차 이름} : {- (이동거리) }` 형태로 출력
  -  자동차 전진 실행
  -  시도 횟수만큼 반복

### ✔ 최종 우승자 출력
- [ ] 우승자가 한 명일 경우 `최종 우승자 : {자동차 이름}` 형태로 출력
- [ ] 우승자가 여려 명일 경우 쉼표(,)로 구분하여 `최종 우승자 : {자동차 이름}, {자동차 이름}` 형태로 출력