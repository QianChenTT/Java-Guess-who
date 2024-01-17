public class Gender extends Trait{
    public Gender(){
        properties.add(new GenderProperty());
    }


    public static class GenderProperty extends Property {
        enum Value{
            Male, Female
        }
        public GenderProperty(){
            super(Value.values());
        }
        public String toString() {
            return "";
        }
    }
}
