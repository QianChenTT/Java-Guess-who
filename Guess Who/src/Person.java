import java.util.*;


public class Person {
    public ArrayList<Trait> traits;
    public boolean faceUp;
    public String name;
    public Person(String name){
        this.name = name;
        this.faceUp = true;
        traits = new ArrayList<Trait>();
        traits.add(new Hair());
        traits.add(new Eye());
        traits.add(new Gender());
    }

    public void display(){
        System.out.println("Name: " + this.name);
        for(Trait trait : traits){
            for(Property property : trait.properties){
                System.out.println(trait + " " + property + ": " + property.value);
            }
        }
    }
}
