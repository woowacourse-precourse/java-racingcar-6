# 기능 구현 

---
## Controller
### Game
- [x] 전체 게임을 진행하는 기능
  - [x] View를 활용한 게임 진행기능
  - [x] Validator를 활용한 검증 기능
  - [x] Race를 활용한 자동차 경주 기능
  - [x] View를 활용한 우승자 출력 기능

### Race
- [x] 주어진 라운드 수만큼 Race 진행하는 기능
  - [x] 한 라운드 Race를 진행하고 출력하는 기능 
---
## DTO
### CarDto
View에 모델의 정보를 알려주지 않기 위해 만든 Dto
- [x] Car을 바탕으로 CarDto 생성하는 기능
- [x] getter
---
## Model
### Car 
- [x] 값을 판단해서 이동하는 기능
  - [x] 값이 기준치 이상인지 검증하는 기능 

### Cars
List<Car>을 Wrapping하는 일급 컬렉션
- [x] 문자열을 바탕으로 List<Car> 생성하는 기능
- [x] 사이즈 반환 기능
- [x] 인덱스에 해당하는 Car 반환 기능
- [x] List에 존재하는 모든 Car 값 판단하고 이동하는 기능
---
## Util
### CarDtoConverter
-[x] Cars에 해당하는List<CarDto> 반환하는 기능

### RandomNumber
- [x] 난수 생성 범위 정의
- [x] 난수 기준 정의
- [x] 난수 생성 기능

### Validator
- [x] 입력된 자동차 이름 유효성 검증
  - [x] 자동차 두 대 이상인지 검증
  - [x] 이름의 길이가 5이하인지 검증
  - [x] 이름끼리 중복이 없는지 검증
- [x] 입력된 시도할 회수 유효성 검증
  - [x] 입력이 정수 형태 인지 검증
  - [x] 입력이 0이 아닌지 검증
---
## View
### InputView
- [x] 자동차 이름 입력 받는 기능
- [x] 시도할 회수 입력 받는 기능

### OutputView
- [x] 이동거리 막대로 출력하는 기능
- [x] 우승자 출력하는 기능

