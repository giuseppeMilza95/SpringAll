public class Main {


    public static void main(String[] args) {
        GenericClass<String, Integer> person = new GenericClass<>("Giuseppe", 25);
        System.out.println(person.getValue());
        System.out.println(person.getKey());
    }
}
