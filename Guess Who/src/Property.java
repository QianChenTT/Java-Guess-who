import java.util.*;


public abstract class Property{
    public Enum[] values;
    public Enum value;
    public Property(Enum[] values){
        this.values = values;
        value = values[(int)(Math.random() * values.length)];
    }

    public String toString(){
        return getClass().getSimpleName();
    }
}