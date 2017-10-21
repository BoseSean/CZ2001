class TableElement{
    private int key;
    private TableElement next;
    private String data;

    public TableElement(int key, String data){
        this.key = key;
        this.data = data;
        this.next = null;
    }
    public int getKey(){
        return key;
    }
    public TableElement getNext(){
        return next;
    }
    public void setNext(TableElement next){
        this.next = next;
    }

    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }
}