package lesson4;

class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = Math.max(foodAmount, 0);
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавили " + amount + " еды. Теперь в миске: " + foodAmount);
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды");
        }
    }

    public boolean decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }
}
abstract class Animal {
    protected String name;
    protected static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
    public static int getAnimalCount() {
        return animalCount;
    }
}

class Dog extends Animal {
    private static int dogCount = 0;
    private final int maxRun = 500;
    private final int maxSwim = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
    }
    @Override
    public void run(int distance) {
        if (distance <= maxRun) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать больше " + maxRun + " м.");
        }
    }
    @Override
    public void swim(int distance) {
        if (distance <= maxSwim) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть больше " + maxSwim + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}
class Cat extends Animal {
    private static int catCount = 0;
    private final int maxRun = 200;
    private boolean isFull;
    private int appetite;
    public Cat(String name, int appetite) {
        super(name);
        this.appetite = appetite;
        this.isFull = false;
        catCount++;
    }
    @Override
    public void run(int distance) {
        if (distance <= maxRun) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать больше " + maxRun + " м.");
        }
    }
    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl) {
        if (isFull) {
            System.out.println(name + " уже сыт.");
            return;
        }

        if (bowl.decreaseFood(appetite)) {
            isFull = true;
            System.out.println(name + " съел " + appetite + " еды и теперь сыт.");
        } else {
            System.out.println(name + " не хватило еды в миске (нужно " + appetite + ", в миске " + bowl.getFoodAmount() + "). Остался голодным.");
        }
    }

    public String getFullStatus() {
        return name + ": " + (isFull ? "сыт" : "голоден");
    }

    public static int getCatCount() {
        return catCount;
    }
}
