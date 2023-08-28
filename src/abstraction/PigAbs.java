package abstraction;

public class PigAbs extends AnimalAbs{
    @Override
    public void animalSound() {
        System.out.println("The pig says: wee wee from abstraction");
    }

    @Override
    public void sleep() {
        super.sleep();
        System.out.println("New sleep class in pig abs");
    }
}
