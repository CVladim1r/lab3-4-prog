
public class TestSingleton {
    public static TestSingleton instance;

    private TestSingleton(){
    }

    public static TestSingleton getInstance(){
        if (instance==null){
            instance = new TestSingleton();
        }
        return instance;
    }

    public void print(){
        System.out.println("printing...");
    }
}