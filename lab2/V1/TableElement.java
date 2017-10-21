class TableElement{
    private int key;
    private TableElement next;
    private Integer data;

    public TableElement(Integer key, Integer data){
        this.key = key;
        this.data = data;
        this.next = null;
    }
    public Integer getKey(){
        return key;
    }
    public TableElement getNext(){
        return next;
    }
    public void setNext(TableElement next){
        this.next = next;
    }

    public Integer getData(){
        return data;
    }
    public void setData(int data){
        this.data = data;
    }
}