public class Test {
    public static void main(String[] args) {
        int fsi;

        boolean ftest;
        boolean stest;

        NotAbsr ge1 = new NotAbsr(1);
        NotAbsr ge2 = new NotAbsr(1);
        NotAbsr ge3 = new NotAbsr(2);

        ftest = ge1.equals(ge2);
        System.out.println(ftest);

        stest = ge1.equals(ge3);
        System.out.println(stest);
    }
}

class NotAbsr extends Object {
    private int t1;

    NotAbsr(int t1) {
        this.t1 = t1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotAbsr that = (NotAbsr) o;
        if (that.t1 == this.t1) return true;
        return false;
    }

    public int getT1() {
        return t1;
    }
}