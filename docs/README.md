## 구현 사항

### 1. `get_name()`: 경주할 자동차의 이름 입력
- 메세지 출력
- 입력에서 ','를 기준으로 이름을 구분
- 각 name에 대해서 글자 수를 확인하고 잘못된 값을 입력한 경우 Exception 발생
- 중복되는 name에 대해서 Exception 발생
- hash 자료구조의 key값으로 각각의 name을 삽입

### 2. `get_number()`: 몇 번 이동할 것인지 결정
- static하게 `race_number` 변수를 선언하고 입력을 받음
- 입력 값이 정수가 아닌 경우 Exception 발생

### 3. `process_race()`: 해당 숫자만큼 경기 진행
- hash값에 대해서 for문을 돌며 진행
- random값을 기준으로 4이상인 경우 value값 + 1

### 4. `print_result()`: value값이 큰 key값 출력
