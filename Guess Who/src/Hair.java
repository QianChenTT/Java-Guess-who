public class Hair extends Trait {
    public Hair(){
        properties.add(new Color());
        properties.add(new Length());
    }


    public static class Color extends Property {
        enum Value{
            Black, Brown, Red, Blond
        }
        public Color(){
            super(Value.values());
        }
    }


    public static class Length extends Property {
        enum Value{
            Short, Medium, Long
        }
        public Length(){
            super(Value.values());
        }
    }
    
}
