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
    // TODO : Implement other two hash functions
    private int foldingHash(int key){
        return 1;
    }
    private int multiplicativeCongruentialHash(int key){
        return 1;
    }
}