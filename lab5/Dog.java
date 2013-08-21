public class Dog extends Animal {
    public int ownerAge;

    public Dog() {
        super("puppy", 2);
        ownerAge = 0;
    }

    public Dog(String name, int weight) {
        super(name, weight);
    }

    public void bark() {
        System.out.println("Woff!");
    }

    public void setOwnerAge(int ownerAge) {
        this.ownerAge = ownerAge;
    }

    public int getOwnerAge() {
        return this.ownerAge;
    }
}
