
//Pedri017 park1394
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by park1394 on 2/26/18.
 */
public class ElephantHerdTest {
    private ElephantHerd list = new ElephantHerd();

    @Test
    public void getHerd() throws Exception {
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        Elephant three= new Elephant ("e", 3, 2.0);
        list.add(one);
        list.add(two);
        List<Elephant> tempList= new ArrayList<Elephant>();
        tempList=list.getHerd();

        assertEquals(tempList.get(0),one);
        assertEquals(tempList.get(1),two);
    }

    @Test
    public void add() throws Exception {
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        boolean a=list.add(one);
        boolean b= list.add(two);
        assertTrue(a);
        assertTrue(b);

    }

    @Test
    public void find() throws Exception {
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        boolean a=list.add(one);
        boolean b= list.add(two);
        Elephant finder=list.find("a");
        Elephant find2=list.find("b");
        assertEquals(one,finder);
        assertEquals(two,find2);
    }

    @Test
    public void remove() throws Exception {
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


    }

    @Test
    public void sort() throws Exception {
        ElephantHerd temp = new ElephantHerd();
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        Elephant three= new Elephant ("e", 3, 2.0);
        Elephant four= new Elephant("d",3,6.6);
        list.add(three);
        list.add(two);
        list.add(one);
        list.add(four);
        list.sort();
        temp.add(four);
        temp.add(one);
        temp.add(two);
        temp.add(three);


       assertEquals(list.getHerd().get(1),one);
       assertEquals(list.getHerd().get(0),four);
       assertEquals(list.getHerd().get(2),two);
       assertEquals(list.getHerd().get(3),three);

    }

    @Test
    public void getTopKLargestElephants() throws Exception {
        Elephant one= new Elephant("a", 2, 3.5);
        Elephant two= new Elephant("b", 3, 2.2);
        Elephant three= new Elephant ("e", 3, 2.0);
        Elephant four= new Elephant("d",3,6.6);
        list.add(three);
        list.add(two);
        list.add(one);
        list.add(four);

        Elephant[] test= new Elephant[2];
        test= list.getTopKLargestElephants(2);
        assertEquals(list.getHerd().get(0),four);

    }

}