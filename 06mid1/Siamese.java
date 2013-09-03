public class Siamese extends Cat {
    public void greet() {
        System.out.println("Siamese-Meeeeow!");
    }

    public void greet(Cat c) {
        System.out.println("Siamese-Hellow");
    }

    public static void main(String[] args) {
        (new Tomcat()).greet();
    }
}

