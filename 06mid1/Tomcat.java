public class Tomcat extends Cat {
    public void greet(Cat c) {
        System.out.println("Tomcat-What up fool?");
        c.greet();
    }

    public static void main(String[] args) {
        // q2.a
        (new Tomcat()).greet();  // abstract class Cat, method greet()
        // q2.b
        (new Tomcat()).greet(new Siamese()); // subclass Tomcat, method greet(Cat)
        
        // q2.c
        Cat c = new Tomcat();
        // Tomcat t = c;  // compile-time error
        Tomcat t = (Tomcat) c;
        t.greet();   // abstract class Cat, method greet()

        Cat c2 = new Siamese();
        c2.greet();
        // q2.d
        ((Cat) c2).greet(); // class Siamese, method greet()

        // q2.e
        // c2.greet(new Tomcat()); // compile-time error: greet() in Cat cannot be applied to (Tomcat). i.e. The Cat class does not have a method with the signature greet(Cat).
        ((Siamese) c2).greet(new Tomcat()); // class Siamese, method greet(Cat)
        // ((Cat) c2).greet(new Tomcat()); // compile-time error. greet() method in Cat cannot be applied to (Tomcat)
        
        // q2.f
        // ((Tomcat) c2).greet(c); // run-time error: Siamese cannot be cast to Tomcat. i.e. Fail to cast a Siamese object to a Tomcat.
        ((Siamese) c2).greet(c2); // class Siamese, method greet(Cat)

        // q2.g
        // Cat c3 = new Cat(); // compile-time error: Cat is abstract; cannot be instantiated. i.e. Cannot create an instance of the abstract class Cat.
        // c3.greet(c3); 
    }

}
