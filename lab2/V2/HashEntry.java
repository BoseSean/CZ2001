public class HashEntry {

	private int key;
	private String data;
	private HashEntry next;

	HashEntry(int key, String data) {
		this.key = key;
		this.data = data;
		this.next = null;
	}

	public String getValue() {
		return data;
	}

	public void setValue(String value) {
		this.data = value;
	}

	public int getKey() {
		return key;
	}

	public HashEntry getNext() {
		return next;
	}

	public void setNext(HashEntry next) {
		this.next = next;
	}
}