package Interface;

public class PigInter implements AnimalInter{
    @Override
    public void animalSound() {
        System.out.println("The pig says: wee wee-interface");
    }

    @Override
    public void sleep() {
        System.out.println("Zzzz - interface");
    }
}
