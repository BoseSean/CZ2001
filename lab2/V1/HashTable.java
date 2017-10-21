import java.util.ArrayList;
import java.util.function.Function;
class HashTable {
    public int tableSize;
    private ArrayList<TableElement> table;
    private Function<Integer, Integer> h;
    
    public HashTable(int tableSize, String hashFunctionName){
        this.tableSize = tableSize;
        table = new ArrayList<TableElement>(tableSize);
        for (int i=0; i<tableSize; i++) {
            table.add(null);
        }
        // get hash function
        if (hashFunctionName.equals("MOD_TABLE_SIZE_HASH"))
            h = (new HashFunctions(tableSize)).MOD_TABLE_SIZE_HASH;
        else if (hashFunctionName.equals("FOLDING_HASH"))
            h = (new HashFunctions(tableSize)).FOLDING_HASH;
        else if (hashFunctionName.equals("MULTIPLICATIVE_CONGRUENTIAL_HASH"))
            h = (new HashFunctions(tableSize)).MULTIPLICATIVE_CONGRUENTIAL_HASH;
    }

    public void add(int key, Integer data){
        int hashed_key = h.apply(key);
        TableElement head = table.get(hashed_key);
        TableElement prev = table.get(hashed_key);
        while(head!=null){
            if(head.getKey() == key){
                head.setData(data);
                break;
            }
            prev = head;
            head = head.getNext();
        }
        if(prev != null) {
            prev.setNext(new TableElement(key, data));
        } else {
            table.add(hashed_key, new TableElement(key, data));            
        }

    }
    public void add(int key){
        add(key,null);
    }
    public boolean contains(int key){
        int hashed_key = h.apply(key);
        TableElement head = table.get(hashed_key);
        TableElement prev;
        if(head == null) return false;
        while(head!=null){
            if(head.getKey() == key){
                return true;
            }
            head = head.getNext();
        }
        return false;
    
    }
    public Integer get(int key){
        int hashed_key = h.apply(key);
        TableElement head = table.get(hashed_key);
        TableElement prev;
        if(head == null) return null;
        while(head!=null){
            if(head.getKey() == key){
                return head.getData();
            }
            head = head.getNext();
        }
        return null;
    }

}
