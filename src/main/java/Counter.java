public class Counter implements AutoCloseable {

    private static int counter;

    public void add() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void close() {

    }
}
