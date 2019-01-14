//Pedri017 park1394
public class ArrayList<T extends Comparable<T>> implements List<T> {

    private T[] a;
    private boolean isSorted;
    private int numEntries=0;

    public ArrayList() {
        a = (T[]) new Comparable[2]; //default size to 2
        isSorted=true;
    }

    /*
     * Add an element to end of the list. If element is null,
     * it will NOT add it and return false.  Otherwise, it
     * will add it and return true. Updates isSorted to false.
     */
    public boolean add(T element) {

        if (numEntries==a.length) { //array is full
            T[] newArray=(T[]) new Comparable[2*a.length]; //creat new array double the size of og
            System.arraycopy(a, 0, newArray, 0, numEntries); //copy over elements to new
            this.a=newArray;
        }
        if (element!=null) {
            a[numEntries]=element; //sets element to last index
            isSorted=false;
            numEntries++;
            return true;
        }

        else {
            return false;
        }

    }

    /*
     *  Add an element at specific index. This method should
     * also shift the element currently at that position (if
     * any) and any subsequent elements to the right (adds
     * one to their indices). If element is null, or if index
     * index is out-of-bounds (index < 0 or index >= size_of_list),
     * it will NOT add it and return false. Otherwise it will
     * add it and return true. See size() for the definition
     * of size of list. Also updates isSorted variable to false.
     */
    public boolean add(int index, T element) {

        if (numEntries == a.length) {               //if the list is at max capacity
            T[] newArray = (T[]) new Comparable[2 * a.length];
            System.arraycopy(a, 0, newArray, 0, numEntries);
            this.a = newArray;
        }

        if (index >= 0 && index <= numEntries && element != null) {
            T[] temp= (T[]) new Comparable[numEntries];
            System.arraycopy(a, index, temp, 0, numEntries-index); //store terms from og array
            a[index] = element; //set index with new element
            System.arraycopy(temp, 0,a,index+1,numEntries-index);
            isSorted = false;
            numEntries++;
            return true;
        }



        return false;
    }

    /*
     * Remove all elements from the list.
     */
    public void clear() {
        int tempEntries=numEntries;
        for (int i=0; i<numEntries; i++) {
            a[i]=null;
            tempEntries--;
        }
        numEntries=tempEntries;
        a = (T[]) new Comparable[2];
    }

    /*
     * Return true if element is in the list and false
     * otherwise. If isSorted is true, uses the ordering
     * of the list to increase the efficiency of the search.
     */
    public boolean contains(T element) {
        if (isSorted){
            int upperBounds=numEntries-1;     //the amount of indexes including the 0th index
            int lowerBounds=0;      //this variable indicates what side we are ignoring

            while (lowerBounds<=upperBounds){
                int half = (upperBounds-lowerBounds)/2+lowerBounds;
                if( a[half].compareTo(element)==0){
                    return true;
                }
                else if(a[half].compareTo(element)>0){
                    upperBounds=half-1;
                }
                else{
                    lowerBounds=half+1;
                }
            } return false;
        }


        else{
            for (int i=0; i<numEntries; i++) {
                if (a[i]==element) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     *  Return the element at given index. If index is
     * out-of-bounds, it will return null.
     *
     */
    public T get(int index) {
        if (index>numEntries-1 || index<0) {
            return null;
        }
        else return a[index];
    }


    /*
     * Return the first index of element in the list. If element
     * is null or not found in the list, return -1. If isSorted is
     * true, uses the ordering of the list to increase the efficiency
     * of the search.
     */
    public int indexOf(T element) {
        if (isSorted) {
            int upperBounds = numEntries - 1;     //the amount of indexes including the 0th index
            int lowerBounds = 0;      //this variable indicates what side we are ignoring

            while (lowerBounds <= upperBounds) {            //binary search
                int half = (upperBounds - lowerBounds) / 2 + lowerBounds;
                if (a[half].compareTo(element) == 0) {
                    return half;
                } else if (a[half].compareTo(element) > 0) {
                    upperBounds = half - 1;
                } else {
                    lowerBounds = half + 1;
                }

            }
            return -1;
        }
        int i=0;
        if (element != null) {
            for (i = 0; i < numEntries; i++) {
                if (a[i] == element) {
                    return i;
                }
            }
            if (i==numEntries) {
                return -1;
            }
        }
        return -1;
    }


    /*
     * Return true if the list is empty and false otherwise.
     */
    public boolean isEmpty() {
        boolean empty = true;
        int i=0;
        for (i = 0; i < numEntries; i++) {
            if (!(a[i] == null)) {
                return false;
            }
        }
        return true;
    }

    /*
     * Same as indexOf(), except it will return the last index
     * of element. If isSorted is true, uses the ordering
     * of the list to increase the efficiency of the search.
     */
    public int lastIndexOf(T element) {
        if (isSorted) {
            int upperBounds = numEntries - 1;     //the amount of indexes including the 0th index
            int lowerBounds = 0;      //this variable indicates what side we are ignoring

            while (lowerBounds <= upperBounds) {
                int half = (upperBounds - lowerBounds) / 2 + lowerBounds;
                if (a[half].compareTo(element) == 0) {
                    int i = 1;
                    while (a[half + i].compareTo(element) == 0) {
                        i++;
                    }
                    return half + i;
                } else if (a[half].compareTo(element) > 0) {
                    upperBounds = half - 1;
                } else {
                    lowerBounds = half + 1;
                }
            }
            return -1;
        }
        int i;
        for (i=numEntries-1; i>0; i--) {  //goes through the list backwards until we hit the element
            if (a[i].compareTo(element)==0) {
                return i;
            }
        }

        return -1;

    }

    /*
     * Replace the element at index with element and return the
     * element that was previously at index. If index is
     * out-of-bounds or element is null, do nothing with element
     * and return null.
     */
    public T set(int index, T element) {
        int size=this.size();
        if (index>=size || element==null) {
            return null;
        }
        else {
            T temp=a[index];
            a[index]=element;
            return temp;
        }
    }

    /*
     * Return the number of elements in the list. For example, if
     * 4 elements added to a list, size will return 4, while the
     * last index in the list will be 3.
     */
    public int size(){
        return numEntries;
    }

    /*
     * Sort the elements of the list. If order is true, sort the
     * list in increasing (alphabeticaly) order. If order is
     * false, sort the list in decreasing (reverse alphabetical)
     * order. Note: only set isSorted to true if sorted in ASCENDING
     * order.
     * If isSorted is true, and the order is true, do NOT resort.
     * Hint: Since T extends Comparable, you will find it useful
     * to use the public int compareTo(T o) method.
     */
    public void sort(boolean order) {
        if (order && !isSorted) { //sort in alphabetical order
            int i, j;
            T comp;

            for (i = 1; i < numEntries; i++) {
                comp = a[i];
                for (j = i - 1; j >= 0 && comp.compareTo(a[j]) < 0; j--) { //first element is greater
                    a[j + 1] = a[j]; //switch first and second element so that lesser element is to the front
                    a[j] = comp;
                }
            }
            isSorted = true;
        } else { //sort in reverse alphabetical order
            int i, j;
            T comp;

            for (i = 1; i < numEntries; i++) {
                comp = a[i];
                for (j = i - 1; j >= 0 && comp.compareTo(a[j]) > 0; j--) { //second element is greater
                    a[j + 1] = a[j]; //switch so that greater element is to the front
                    a[j] = comp;
                }
            }
        }

    }

    /*
     * Remove the first instance of element from the list. This
     * method should also shifts any subsequent elements to the
     * left (subtracts one from their indices). If successful,
     * return true. If element is not found in the list, return
     * false.
     */
    public boolean remove(T element) {
        int i = 0;

        while (a[i]!=element && i<numEntries) {
            i++;
        }
        if (i==numEntries-1 &&a[i]!=element) {
            return false;
        }
        a[i] = null;
        for (int j = i; j < numEntries; j++) {
            a[j] = a[j+1];
        }

        numEntries--;
        return true;
    }


    /*
     * Remove whatever is at index in the list and return
     * it. If index is out-of-bounds, return null. Shift the
     * indices as in the other remove.
     */
    public T remove(int index) {
        if (index<0 || index>numEntries-1) {
            return null;
        }

        T temp=a[index];
        a[index]=null;
        for (int j = index; j < numEntries-1; j++) {
            a[j] = a[j+1];
        }
        a[numEntries-1]=null;
        numEntries--;

        return temp;
    }


    /*
     * Note that this method exists for debugging purposes.
     * It calls the toString method of the underlying elements in
     * the list in order to create a String representation of the list.
     * The format of the toString should appear as follows:
     * Element1
     * Element2
     * .
     * .
     * .
     * Elementn
     * Watch out for extra spaces or carriage returns. Each element
     * should be printed on its own line.
     */
    public String toString() {

        int size = this.size();
        String total="";
        for (int i=1; i<size; i++) {
            total+=a[i].toString()+"\n";
        }

        return total;
    }
}