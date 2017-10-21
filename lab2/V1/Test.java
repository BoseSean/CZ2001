import java.util.function.*;
import java.util.ArrayList;
class Test {
    public static void main(String[] args) {
        HashTable map = new HashTable(100,"MOD_TABLE_SIZE_HASH");
        map.add(10);
        map.add(12,9);
        System.out.println(map.contains(10));
        System.out.println(map.get(12));
    }
}