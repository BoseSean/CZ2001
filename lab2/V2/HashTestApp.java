import java.util.ArrayList;
import java.util.Collections;

public class HashTestApp {

	public static void main(String[] args) {

		int[] loadFactor = { 250, 500, 750 };
		int size = loadFactor.length;
		int maxData = 100000;
		int reps = 1000;

		hashingDemo(5, 2);// data in map
		hashingDemo(5, 6);// data not in map

		// generate a list of values from 1 to 100,000
		ArrayList<Integer> listOfNumbers = generateList(maxData);

		// testing each load factor
		for (int i = 0; i < size; i++) {
			startTest(listOfNumbers, loadFactor[i], reps, true);
			startTest(listOfNumbers, loadFactor[i], reps, false);
		}
	}

	public static void hashingDemo(int numOfValues, int search) {

		HashTable inventory = new HashTable();
		for (int i = 0; i < numOfValues; i++) {
			// dummy string
			inventory.put(i, "Shelf No.: " + i);
		}

		String value = inventory.get(search);

		if (value.equals(""))
			System.out.println("Shelf not found.");
		else
			System.out.println("Item is at " + value);
	}

	public static void startTest(ArrayList<Integer> listOfNumbers, int numOfData, int reps, boolean success) {

		long start = 0;
		long end = 0;
		double probeCount = 0;
		double putProbeCount = 0;
		int target = 0;

		double time = 0;
		double probe = 0;
		double putProbe = 0;
		double putTime = 0;

		if (success) {
			System.out.println("****************Success cases****************");
		} else {
			System.out.println("****************Failure cases****************");
		}

		System.out.println("Test for " + numOfData + " data");

		for (int rep = 0; rep < reps; rep++) {
			// randomize list
			Collections.shuffle(listOfNumbers);

			// randomly choose target from list(depends if you want a success search or
			// failure)
			if (success) {
				target = listOfNumbers.get((int) (Math.random() * numOfData));
			} else {
				target = listOfNumbers.get(numOfData + 1); // this value will not be in the list
			}

			// create 
			start = System.nanoTime();
			HashTable clientHashMap = new HashTable();
			for (int i = 0; i < numOfData; i++) {
				// dummy string
				clientHashMap.put(listOfNumbers.get(i), "Client #" + listOfNumbers.get(i));
			}
			end = System.nanoTime();

			putTime += end - start;
			putProbeCount = clientHashMap.getPutProbeCount();
			putProbe += putProbeCount;

			// start of closed address testing
			start = System.nanoTime();
			clientHashMap.get(target);
			end = System.nanoTime();
			probeCount = clientHashMap.getGetProbeCount();

			// sum for time and probes
			time += end - start;
			probe += probeCount;

		}
		System.out.println("===========================");
		System.out.println("averages for " + numOfData + " data test cases for " + reps + " times");
		System.out.println("average time = " + (time / reps));
		System.out.println("average probes = " + (probe / reps));
		System.out.println("average put time = " + (putTime / reps / numOfData));
		System.out.println("average put probes = " + (putProbe / reps / numOfData));

	}

	private static ArrayList<Integer> generateList(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int j = 1; j <= n; j++) {
			list.add(new Integer(j));
		}
		return list;
	}

}
