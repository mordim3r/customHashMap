public class Main {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        System.out.println("---------Вставка-------------");
        System.out.println("put one=1: " + map.put("one", 1));
        System.out.println("put two=2: " + map.put("two", 2));
        System.out.println("put three=3: " + map.put("three", 3));
        System.out.println("put three=3: " + map.put("three", 3));
        System.out.println("size после 3 put: " + map.size());
        System.out.println("isEmpty после put: " + map.isEmpty());

        System.out.println("------------Получение значений---------------");
        System.out.println("get one: " + map.get("one"));
        System.out.println("get two: " + map.get("two"));
        System.out.println("get four: " + map.get("four"));

        System.out.println("-----------Удаление--------------");
        System.out.println("size до remove: " + map.size());
        System.out.println("remove two: " + map.remove("two"));
        System.out.println("get two: " + map.get("two"));
        System.out.println("size после remove: " + map.size());
    }
}
