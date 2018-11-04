package array;

public class DynamicArray<M> {
    private M[] data;
    private int size;

    public DynamicArray(int capacity) {
        this.data = (M[]) new Object[capacity];
        size=0;
    }

    public DynamicArray(M[] data) {
        this.data = data;
        this.size =data.length;
    }

    public DynamicArray(){
        this(10);
    }

    public int getCapacity(){
        return data.length;
    }
    public int getSize(){
        return size;
    }

   public boolean isEmpty(){
        return size==0;
    }

    public void add(int index,M e){
        //判断是否合法
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
//扩充容量
        if(size == data.length)
            resize(2*data.length);

        //index后元素全部后移
        for (int i = size-1; i >=index ; i--) {
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    private void resize(int i) {
        M[] newData = (M[]) new Object[i];
        for (int j = 0; j < size; j++) {
            newData[j]=data[j];
        }
        data=newData;
    }


    public void addLast(M m){
        add(size,m);
    }

    public void addFirst(M e){
        add(0,e);
    }

    public M get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    public void set(int index,M m){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index]=m;
    }

    public boolean contain(M o){
        for (Object object:
             data) {
            if(object.equals(o))
                return true;
        }
        return false;
    }

    public int find(M o){
        for(int i = 0; i <size ; i++) {
            if (data[i].equals(o));
            return i;
        }
        return -1;
    }

    public M remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        {
            M temp= data[index];
            for (int i = index+1; i <size ; i++) {
                data[i-1]=data[i];
            }
            size--;
            if(size!=0&&data.length/size>=4)
                resize(data.length/2);
            return temp;
        }
    }


    // 从数组中删除第一个元素, 返回删除的元素
    public M removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public M removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeMlement(M e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array:size=%d ,capacity=%d\n",size,data.length));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i].toString());
            if(i!=size-1)
                builder.append(",");
        }
        builder.append("]");
        return builder.toString();
    }


    public void swap(int i, int k) {
        M t = data[i];
        data[i]=data[k];
        data[k]=t;
    }
}
