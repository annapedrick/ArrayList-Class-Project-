//Pedri017 park1394
public class ElephantHerd {
    private List<Elephant> list;

    public ElephantHerd() {
        list=new ArrayList<Elephant>();
    }

    public List<Elephant> getHerd() {
        return list;
    }

    public boolean add(Elephant ellie) {
        boolean a=list.add(ellie);
        return a;
    }

    public Elephant find(String name) {
        for (int i=0; i<list.size(); i++) {
            Elephant a=list.get(i);
            if (a.getName().contains(name)) {
                return a;
            }
        }
        return null;
    }

    public Elephant remove(int index) {
        Elephant a=list.remove(index);
        return a;
    }

    public void sort() {
        int i, j; //starting index
        Elephant tempE;
        double tempH;

        for (i=1; i<list.size(); i++) {
            tempE=list.get(i);
            tempH=tempE.getHeight();
            for (j=i-1; j>=0 && tempH>list.get(j).getHeight(); j--) { //Previous elephant has smaller height
                list.set(j+1,list.get(j)); //switch Elephants
                list.set(j,tempE);
            }
        }
    }

    @Override
    public String toString() {
        String allElephants="";
        for (int a=0;a<list.size();a++){
            String name=list.get(a).getName();
            int age=list.get(a).getAge();
            double height=list.get(a).getHeight();
            allElephants=allElephants + " "+ name +" "+age+" "+height+"\n";
        }
        return allElephants;
    }

    public Elephant[] getTopKLargestElephants (int k) {
        this.sort();
        int m=list.size();
        if (m>=k) {
            Elephant[] e=new Elephant[k];
            for (int i=0;i<k;i++) {
                e[i]=list.get(i);
            }
            return e;
        }
        else if (m<k) {
            Elephant[] e=new Elephant[m];
            for (int i=0;i<m;i++) {
                e[i]=list.get(i);
            }
            return e;
        }
        return null;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElephantHerd that = (ElephantHerd) o;

        return list != null ? list.equals(that.list) : that.list == null;

    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }
}