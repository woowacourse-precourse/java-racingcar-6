이전 포스트인 '객체지향 생활체조'에 이어 객체 지향의 5원칙에 대해서 알아보려고 한다.

[2023.10.22 - \[Backend/Springboot\] - 예시로 보는 객체지향 생활체조](https://castlehi.tistory.com/entry/%EC%98%88%EC%8B%9C%EB%A1%9C-%EB%B3%B4%EB%8A%94-%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5-%EC%83%9D%ED%99%9C%EC%B2%B4%EC%A1%B0)

[예시로 보는 객체지향 생활체조

객체지향 생활체조란? 좋은 객체 지향 디자인을 하기 위한 9가지 규칙 유지 관리가 용이하고 가독성이 높으며 테스트 가능한 코드를 만드는 것을 목표 1. 한 메소드에 한 단계의 들여쓰기만 한다

---

객체지향의 5원칙은 다음과 같다.

> 1. SRP : 단일 책임 원칙  
> 2. OCP : 개방 - 폐쇠 원칙  
> 3. LSP : 리스코프 치환 원칙  
> 4. ISP : 인터페이스 분리 원칙  
> 5. DIP : 의존성 역전 원칙

5가지의 앞글자를 따서 SOLID라고 부른다.

---

### 1\. SRP

#### **S**inglie **R**esponsibility **P**rinciple

#### 단일 책임 원칙

1. 객체는 오직 하나의 책임을 가져야 한다.

2. 객체는 오직 하나의 변경 이유만을 가져야 한다.

위반 예시 :

```java
class User {
    String name;
    String email;

    void saveUser() { /*...*/ }
}
```

준수 예시 :

```java
class User {
    String name;
    String email;
}

class UserDatabase {
    void saveUser(User user) { /*...*/ }
}
```

User객체 - 정보를 보여주는 역할

UserDatabase객체 - 정보를 저장하는 역할

---

### 2. OCP

#### **O**pen-**C**losed **P**rinciple

#### 개방 폐쇠 원칙

1. 객체는 확장에 대해서 개방적이고 수정에 대해서는 폐쇠적이어야 한다.

2. 객체 기능의 확장을 허용하고, 스스로의 변경은 피해야 한다.

보통 인터페이스를 통해 이 원칙을 준수한다.

위반 예시 :

```java
class AreaCalculator {
    double calculateArea(Object shape) {
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return 3.14 * c.radius * c.radius;
        }
        // Additional conditions for other shapes
    }
}
```

준수 예시 :

```java
interface Shape {
    double area();
}

class Circle implements Shape {
    double radius;

    @Override
    double area() { return 3.14 * radius * radius; }
}

class AreaCalculator {
    double calculateArea(Shape shape) {
        return shape.area();
    }
}
```

Shape이라는 interface를 두고 Circle이 이를 implement하여 본인만의 area()를 구현한다.

새로운 Shape을 만들 때 AreaCalculator를 수정하지 않아도 된다.

---

### 3\. LSP

#### **L**iskov **S**ubstitution **P**rinciple

#### 리스코프 치환 원칙

1. 자식 클래스는 언제나 부모 클래스를 대체할 수 있다.

2. 부모 클래스가 들어갈 자리에 자식 클래스를 넣어도 잘 작동해야 한다.

위반 예시 :

```java
class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // A square's height is always the same as its width
    }

    @Override
    public void setHeight(int height) {
        this.width = height; // A square's width is always the same as its height
        this.height = height;
    }
}
```

```java
public void resizeRectangle(Rectangle rect, int width, int height) {
    rect.setWidth(width);
    rect.setHeight(height);
    assert rect.getArea() == width * height;
}
```

resizeRectangle() 메소드의 첫 번째 인자에 자식 클래스인 Square를 대체한다고 가정했을 때, 이 메소드는 실패하게 된다.

rect.setWidth()와 rect.setHeight()에 의해 width, height이 모두 바뀌게 된다.

준수 예시 :

```java
interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    protected int width;
    protected int height;

    //... setters, getters, and area computation as above
}

class Square implements Shape {
    protected int side;

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}
```

Shape interface를 두고 Rectangle, Square가 각각 상속한다면 해결된다.

---

### 4\. ISP

#### **I**nterface **S**egregation **P**rinciple

#### 인터페이스 분리 원칙

1. 클라이언트에서 사용하지 않는 인터페이스는 구현하지 않는다.

2. 인터페이스를 작게 나누어 구현한다.

3. 인터페이스의 SRP

위반 원칙 :

```java
interface Animal {
    void swim();
    void fly();
}

class Shark implements Animal {
    void swim() { /*...*/ }
    
    void fly() {
        throw new UnsupportedOperationException();
    }
}
```

Shark는 수영할 수 있지만 날 수 없다.

즉, fly() 메소드는 사용하지 않는 메소드이므로 Shark를 구현하는데 있어서 fly()는 구현되지 않아도 될 메소드이다.

준수 원칙 :

```java
interface Swimmer {
    void swim();
}

interface Flyer {
    void fly();
}

class Duck implements Swimmer, Flyer {
    void swim() { /*...*/ }
    void fly() { /*...*/ }
}
```

이 경우 Shark는 Swimmer 인터페이스만 implements하면 된다.

---

### 5\. DIP

#### **D**ependency **I**nversion **P**rinciple

#### 의존성 역전 원칙

추상성이 높고 안정적인 고수준의 클래스는 구체적이고 불안정한 저수준의 클래스에 의존해서는 안 된다

> 고수준 클래스 : 비즈니스 로직에 가까운 추상화된 클래스  
> 저수준 클래스 : 입력과 출력으로부터 가까운 클래스

위반 예시 :

```java
class DatabaseStorage {
    void save(String data) { /*...*/ }
}

class User {
    private DatabaseStorage storage = new DatabaseStorage();

    void saveUserData(String data) {
        storage.save(data);
    }
}
```

User가 DatabaseStorage에 의존하고 있다.

User를 저장하는 방식은 언제든 바뀔 수 있는데, 의존성이 심한 경우 바꿀 때 많은 로직의 변화가 필요해진다.

준수 예시 :

```java
interface Storage {
    void save(String data);
}

class DatabaseStorage implements Storage {
    void save(String data) { /*...*/ }
}

class User {
    private Storage storage;

    User(Storage storage) {
        this.storage = storage;
    }

    void saveUserData(String data) {
        storage.save(data);
    }
}
```

DatabaseStorage를 인터페이스 implement로 만들어 OCP를 지키게 한다.

데이터를 저장하는 방식이 바뀌면 언제든지 Store를 implement한 객체를 추가로 만들면 된다.

User는 Store를 가진다.

---

이 부분이 IoC와 헷갈릴 수 있는 부분인 것 같다.

IoC는 Inversion of Control로 제어의 역전을 의미하는데, 위의 예시에서 보면 User가 사용할 객체를 외부에서부터 주입받는다.

User 객체 자체가 제어를 가지고 있는 것이 아닌 외부에서 제어권을 가지고 있는 것이다.

물론 위의 예시에서 생성자를 통해 주입받으므로 IoC의 예시가 쓰인 것이 맞다.

하지만 DIP와 IoC는 다르다.

User가 특정 저장 방식을 쥐고 있는 것이 아닌 저장 방식들의 인터페이스를 들고 있다는 것이 DIP의 예시가 된다.