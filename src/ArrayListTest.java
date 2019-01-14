//Pedri017 park1394
import static org.junit.Assert.*;

public class ArrayListTest {
    private List<Elephant> list= new ArrayList<Elephant>();

    @org.junit.Test
    public void add() {

        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        boolean test= list.add(one);
        boolean test2=list.add(two);
        boolean standard=true;
        assertEquals(standard, test);
        assertEquals(standard, test2);
    }

    @org.junit.Test
    public void add1() {

        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        list.add(one);
        boolean test=list.add(0,two);
        boolean standard=true;
        assertEquals(standard, test);
    }

    @org.junit.Test
    public void clear() {
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        list.add(one);
        list.add(two);
        list.clear();
        int test= list.size();
        int standard=0;
        assertEquals(standard, test);
    }

    @org.junit.Test
    public void contains() {
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        Elephant three= new Elephant ("e", 3, 2.0);
        Elephant five= new Elephant ("y", 5, 2.0);
        list.add(one);
        list.add(two);
        list.add(three);
        list.sort(true);
        Elephant four= new Elephant("d",3,6.6);
        boolean test=list.contains(one);
        boolean test2=list.contains(four);
        list.add(five);
        boolean test3=list.contains(five);

        assertEquals(true, test);
        assertEquals(false, test2);
        assertEquals(true, test3);

    }

    @org.junit.Test
    public void get() {
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        Elephant three= new Elephant ("e", 3, 2.0);
        list.add(one);
        list.add(two);
        list.add(1,three);
        Elephant test=list.get(0);
        Elephant test2=list.get(2);
        assertEquals(one,test);
        assertEquals(two,test2);
    }

    @org.junit.Test
    public void indexOf() {
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        Elephant three= new Elephant ("e", 3, 2.0);
        Elephant five= new Elephant ("y", 5, 2.0);
        Elephant four= new Elephant("d",3,6.6);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.sort(true);
        int test=list.indexOf(one);
        int test2=list.indexOf(four);
        list.add(five);
        int test3=list.indexOf(five);

        assertEquals(0, test);
        assertEquals(2, test2);
        assertEquals(4, test3);

    }

    @org.junit.Test
    public void isEmpty() {
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        Elephant three= new Elephant ("e", 3, 2.0);
        Elephant four= new Elephant("d",3,6.6);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        boolean test = list.isEmpty();
        assertEquals(false, test);

        list.clear();
        boolean test2 = list.isEmpty();
        assertEquals(true, test2);
    }

    @org.junit.Test
    public void lastIndexOf() {
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        Elephant three= new Elephant ("e", 3, 2.0);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(one);
        list.add(three);
        list.add(three);
        list.add(three);

        int test=list.lastIndexOf(one);
        assertEquals(3,test);

    }

    @org.junit.Test
    public void set() {
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        Elephant three= new Elephant ("e", 3, 2.0);
        Elephant four= new Elephant("d",3,6.6);
        list.add(one);
        list.add(two);
        list.add(three);
        Elephant test=list.set(1,four);
        assertEquals(two,test);

    }

    @org.junit.Test
    public void size() {
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 4.4);
        list.add(one);
        list.add(two);
        int test=list.size();
        assertEquals(2,test);
    }

    @org.junit.Test
    public void sort() {
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        Elephant three= new Elephant ("e", 3, 2.0);
        Elephant four= new Elephant("d",3,6.6);
        list.add(three);
        list.add(two);
        list.add(one);
        list.add(four);
        list.sort(true);

        assertEquals(one,list.get(0));
        assertEquals(two,list.get(1));
        assertEquals(four,list.get(2));
    }

    @org.junit.Test
    public void remove() {
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        Elephant three= new Elephant ("e", 3, 2.0);
        list.add(one);
        list.add(two);
        list.add(three);

        boolean test=list.remove(two);

        assertEquals(true,test);



    }

    @org.junit.Test
    public void remove1() {


        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        Elephant three= new Elephant ("e", 3, 2.0);
        Elephant four= new Elephant("d",3,6.6);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);

        Elephant test=list.remove(1);


        assertEquals(two, test);
        assertEquals(null,list.get(3));
        assertEquals(three,list.get(1));

    }
}