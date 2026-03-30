package lesson4;

class Cat extends Animal {
    private static int catCount = 0;
    private final int maxRun = 200;
    private boolean isFull;

    public Cat(String name) {
        super(name);
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

    public void eat(Bowl bowl, int appetite) {
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
