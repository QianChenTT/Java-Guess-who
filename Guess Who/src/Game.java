import java.util.*;

public class Game {
    ArrayList<Person> people;
    Person target;
    int faceUp, guessesMade;
    Scanner input = new Scanner(System.in);
    public Game(){
        people = new ArrayList<Person>(25);
        guessesMade = 0;
        for(int i = 0; i < 25 ; i++){
            people.add(new Person("" + i));
        }
        faceUp = people.size();
        target = people.get((int)(Math.random() * people.size()));
    }
    public void start(){
        while(faceUp != 1){
            display();
            guess();
        }
        System.out.println("\nGame over! \nYou made: " + guessesMade + " guesses\n");
        System.out.println("The target was: ");
        target.display();
        input.close();
    }
    public void guess(){
        guessesMade++;
        System.out.println("Choose a trait to guess: ");
        int i = 1;
        System.out.println("0. Name");
        for(Trait trait : target.traits){
            System.out.println(i + ". " + trait);
            i++;
        }
        int traitChoice = input.nextInt();
        if(traitChoice == 0){
            System.out.println("Input the name: ");
            String name = input.next();
            if(name.equals(target.name)){
                faceUp = 1;
            } else {
                people.get(Integer.parseInt(name)).faceUp = false;
                faceUp--;
            }
            return;
        }
        traitChoice -= 1;
        int propertyChoice;
        if(target.traits.get(traitChoice).properties.size() == 1){
            propertyChoice = 0;
        } else {
            System.out.println("Choose a property to guess: ");
            i = 0;
            for(Property property : target.traits.get(traitChoice).properties){
                System.out.println(i + ". " + property);
                i++;
            }
            propertyChoice = input.nextInt();
        }
        System.out.println("Choose a value to guess: ");
        i = 0;
        for(Enum value : target.traits.get(traitChoice).properties.get(propertyChoice).values){
            System.out.println(i + ". " + value);
            i++;
        }
        int valueChoice = input.nextInt();
        eliminate(traitChoice, propertyChoice, valueChoice);
    }
    public void eliminate(int traitChoice, int propertyChoice, int valueChoice){
        if(target.traits.get(traitChoice).properties.get(propertyChoice).value.ordinal() == valueChoice){
            for(Person person : people){
                if(person.traits.get(traitChoice).properties.get(propertyChoice).value.ordinal() != valueChoice && person.faceUp){
                    person.faceUp = false;
                    faceUp--;
                }
            }
        }else {
            for(Person person : people){
                if(person.traits.get(traitChoice).properties.get(propertyChoice).value.ordinal() == valueChoice && person.faceUp){
                    person.faceUp = false;
                    faceUp--;
                }
            }
        }
    }
    public void display(){
        for(Person person : people){
            if(person.faceUp){
                person.display();
                System.out.println();
            }
        }
    }
}
