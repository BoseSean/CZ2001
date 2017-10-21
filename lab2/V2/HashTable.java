public class HashTable {

	private final static int TABLE_SIZE = 1000;
	HashEntry[] table;
	private int getProbeCount = 0;
	private int putProbeCount = 0;
	
	HashTable() {
		table = new HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	public String get(int key) {
		int hash = (key % TABLE_SIZE);
		if (table[hash] == null) {
			getProbeCount++;
			return "";
		} else {
			HashEntry entry = table[hash];
			while (entry != null && entry.getKey() != key) {
				entry = entry.getNext();
				getProbeCount++;
			}
			getProbeCount++;
			if (entry == null)
				return "";
			else
				return entry.getValue();
		}
	}

	public void put(int key, String value) {
		int hash = (key % TABLE_SIZE);
		if (table[hash] == null) {
			putProbeCount++;
			table[hash] = new HashEntry(key, value);
		} else {
			HashEntry entry = table[hash];
			while (entry.getNext() != null && entry.getKey() != key) {
				putProbeCount++;
				entry = entry.getNext();
			}
			putProbeCount++;
			if (entry.getKey() == key)
				entry.setValue(value);
			else
				entry.setNext(new HashEntry(key, value));
		}
	}

	public void remove(int key) {
		int hash = (key % TABLE_SIZE);
		if (table[hash] != null) {
			HashEntry prevEntry = null;
			HashEntry entry = table[hash];
			while (entry.getNext() != null && entry.getKey() != key) {
				prevEntry = entry;
				entry = entry.getNext();
			}
			if (entry.getKey() == key) {
				if (prevEntry == null)
					table[hash] = entry.getNext();
				else
					prevEntry.setNext(entry.getNext());
			}
		}
	}

	public int getGetProbeCount() {
		int x = getProbeCount;
		getProbeCount = 0;
		return x;
	}

	public int getPutProbeCount() {
		int x = putProbeCount;
		putProbeCount = 0;
		return x;
	}

}