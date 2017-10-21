import java.util.function.*;

class HashFunctions{
    private int tableSize;
    public Function<Integer, Integer> MOD_TABLE_SIZE_HASH;
    public Function<Integer, Integer> FOLDING_HASH;
    public Function<Integer, Integer> MULTIPLICATIVE_CONGRUENTIAL_HASH;
    public HashFunctions(int tableSize){
        this.tableSize = tableSize;
        MOD_TABLE_SIZE_HASH = this::modTableSizeHash;
        FOLDING_HASH = this::foldingHash;
        MULTIPLICATIVE_CONGRUENTIAL_HASH = this::multiplicativeCongruentialHash;
    }
    private int modTableSizeHash(int key){
        return key%tableSize;
    }
    private int foldingHash(int key){
        int FirstHalf = key / 1000;
        int MidDigit = (key / 100) % 10;
        int SecondHalf = key % 100;
        return (FirstHalf + MidDigit + SecondHalf) % tableSize;
    }
    private int multiplicativeCongruentialHash(int key){
        int multiplier = (tableSize/31)*7 + 5;
        return (key * multiplier) % tableSize;
    }
}