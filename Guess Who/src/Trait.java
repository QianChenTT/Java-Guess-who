import java.util.*;


public abstract class Trait {
    ArrayList<Property> properties;
    public Trait(){
        properties = new ArrayList<Property>();

    }

    public String toString(){
        return getClass().getSimpleName();
    }
}