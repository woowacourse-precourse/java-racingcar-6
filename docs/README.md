> 게임 진행
> 1. 자동차 이름 입력
> 2. 시도할 회수 입력
> 3. 각 자동차의 랜덤 값이 4이상인 경우, 전진
> 4. `3번`을 시도한 회수만큼 반복
> 5. 게임 결과 출력
> 6. 우승자 출력
>

# controller

## 1. GameController

# domain

## Car

### data

- `String name`
- `int position`

### method

- move()

## Cars

### data

- `List<Car>`

## CarDto

### data

- `String name`
- `int position`

### data

- `List<>`
- `Car`

## CarDtos

### data

- `List<Car>`

# util

## NumberPicker (interface)

## RandomNumberPicker

# view

## InputView

- 입력 값 받아오기

## OutputView

- 게임 메시지 출력
- 결과 출력
