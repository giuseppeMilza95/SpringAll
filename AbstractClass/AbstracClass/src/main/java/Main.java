public class Main {

    public static void main(String[] args) {
        Animal dog = new Dog("Yorikie");
        dog.breathe();
        dog.eat();

        Parrot parrot = new  Parrot("Australian ringneck");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.eat();
        penguin.fly();
        penguin.breathe();


        var count = 10;
        int  n1=0,n2=1,n3;
        System.out.print(n1 + " " + n2);
        for(int i = 0; i < count;i++){
            n3=n1+n2;
            n1=n2;
            n2=n3;
            System.out.print(" "+ n3);
        }
    }
}
