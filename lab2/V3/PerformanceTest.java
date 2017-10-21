import java.util.function.*;
import java.util.ArrayList;
import java.util.Random;
class PerformanceTest {
    public static void main(String[] args) {
        int repeat_time = 100;
        int[] dataSetSize = {2500, 5000, 7500, 20000};
        int[] dataFeature = {1,2,3,139};
        long start, end;
        long time1, time2, time3, time4;
        int prob1, prob2, prob3, prob4;
        for(int size : dataSetSize){
            for(int feature : dataFeature){
                time1 = 0;time2 = 0;time3 = 0;time4 = 0;
                prob1 = 0;prob2 = 0;prob3 = 0;prob4 = 0;
                for (int i =0; i<repeat_time; i++) {
                    HashTable map_prime = new HashTable(10007,"MOD_TABLE_SIZE_HASH");
                    HashTable map_not_prime = new HashTable(10008,"MOD_TABLE_SIZE_HASH");
                    ArrayList<Integer> list = generateList(size, feature, 20000);

                    start = System.nanoTime();
                    addToTable(map_prime, list);
                    end = System.nanoTime();
                    time1 += end - start;
                    prob1 += map_prime.getAddProbeCount();

                    start = System.nanoTime();
                    searchFromTable(map_prime, list);
                    end = System.nanoTime();
                    time2 += end - start;
                    prob2 += map_prime.getGetProbeCount();

                    start = System.nanoTime();
                    addToTable(map_not_prime, list);
                    end = System.nanoTime();
                    time3 += end - start;
                    prob3 += map_not_prime.getAddProbeCount();

                    start = System.nanoTime();
                    searchFromTable(map_not_prime, list);
                    end = System.nanoTime();
                    time4 += end - start;
                    prob4 += map_not_prime.getGetProbeCount();
                }
                System.out.println("=========== PRIME =========== size: 10007");
                System.out.println("size = "+ size +"  keys are multiply of "+ feature);
                // System.out.println("average add time = " + (time1 / repeat_time));
                // System.out.println("average add probes = " + (prob1 / size /repeat_time));
                System.out.println("average search time = " + (time2 / repeat_time));
                System.out.println("average search probes = " + (prob2 / size / repeat_time));
                

                System.out.println("========== NON-PRIME ======== size: 10008");
                System.out.println("size = "+ size +"  keys are multiply of "+ feature);
                // System.out.println("average add time = " + (time3 / repeat_time));
                // System.out.println("average add probes = " + (prob3 / size /repeat_time));
                System.out.println("average search time = " + (time4 / repeat_time));
                System.out.println("average search probes = " + (prob4 / size /repeat_time));
                
                
            }
        }
    }
    private static void addToTable(HashTable table, ArrayList<Integer> list){
        for(int key: list)
            table.add(key, "Client #"+key);
    }
    private static void searchFromTable(HashTable table, ArrayList<Integer> list){
        for(int key: list)
            table.get(key);
    }
    private static ArrayList<Integer> generateList(int size, int multiply_base, int max_multiplier){
        ArrayList<Integer> list = new ArrayList<Integer>(size);
        Random rn = new Random();
        for(int i=0; i<size; i++){
            list.add((rn.nextInt(max_multiplier)+1)*multiply_base);
        }
        return list;
    }
}