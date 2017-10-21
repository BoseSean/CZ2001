class modPerformance {
    public static void main(String[] args) {
        int test;
        long start, end;
        start = System.nanoTime();
        for(int i=1; i<100000000; i++){
            test = (139*i)%10007;
        }
        end = System.nanoTime();
        System.out.println(end - start);
        start = System.nanoTime();
        for(int i=1; i<100000000; i++){
            test = (139*i)%10008;
        }
        end = System.nanoTime();
        System.out.println(end - start);
    }
}