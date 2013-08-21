public class Animal {
    public String name;
    public int age;
    public int weight;
    public int numLegs;

    public Animal() {
        this.name = "Unknown";
        this.age  = 0;
        this.weight = 0;
        this.numLegs = 0;
    }

    public Animal(String name, int weight) {
        this.name = name;
        this.age  = 0;
        this.weight = weight;
        this.numLegs = 0;
    }

    public Animal(String name, int weight, int age) {
        this.name = name;
        this.age  = age;
        this.weight = weight;
        this.numLegs = 0;
    }
    

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public void eat(int foodWeight) {
        weight += foodWeight;
    }
}

