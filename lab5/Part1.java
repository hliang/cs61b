public class Part1 {
    public static void main(String[] args) {
        Animal cat1 = new Animal("kitty", 1);
        Dog dog1 = new Dog();

        System.out.println(cat1.getName());
        System.out.println(dog1.getName());

        Dog dog2;
        Animal ani3;
        dog2 = new Dog("five.lb", 5);
        ani3 = dog2;
        System.out.println(dog2.getName());
        System.out.println(ani3.getName());

        Animal ani4;
        Dog dog5;
        ani4 = new Animal("tiger", 10);
        // dog5 = (Dog) ani4;  // requires a cast to compile.
                            // and will cause a run-time error, 
                            // because ani4 references an Animal object that isn't a Dog.
        System.out.println(ani4.getName());
        // System.out.println(dog5.getName());


        Dog[] dog6a;
        Animal[] ani7a;
        dog6a = new Dog[3];
        dog6a[0] = new Dog();
        dog6a[1] = new Dog();
        dog6a[2] = new Dog();
        System.out.println(dog6a[0].getName());
        System.out.println(dog6a[1].getName());
        System.out.println(dog6a[2].getName());
        ani7a = dog6a;
        System.out.println(ani7a[2].getName());

        Animal[] ani8a;
        ani8a = new Animal[3];
        ani8a[0] = new Dog("pig", 3);
        ani8a[1] = dog6a[1];
        ani8a[2] = ani8a[0];
        ani8a[1] = ani8a[2];
        System.out.println(ani8a[0].getName());
        System.out.println(ani8a[1].getName());
        System.out.println(ani8a[2].getName());
        dog6a[1] = (Dog) ani8a[2];
        System.out.println(dog6a[1].getName());
        dog6a[1].bark();


    }
}
