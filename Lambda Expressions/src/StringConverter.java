public class StringConverter {
    static String conv(StringConverterInterface stringConverterInterface, String text){
        return stringConverterInterface.convert(text);
    }

    static void main() {
        System.out.println(conv((text) -> text.toUpperCase(), "hello"));
        System.out.println(conv((text) -> text.toUpperCase(), "java"));
    }
}
