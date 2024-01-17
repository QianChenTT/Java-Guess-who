public class Eye extends Trait{
    public Eye(){
        properties.add(new Color());
        properties.add(new Size());
    }


    public static class Color extends Property {
        enum Value{
            Black, Brown, Golden, Green, Blue
        }
        public Color(){
            super(Value.values());
        }
    }


    public static class Size extends Property {
        enum Value{
            Small, Medium, Large
        }
        public Size(){
            super(Value.values());
        }
    }
}
