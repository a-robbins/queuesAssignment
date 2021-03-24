
public class TestSmallArrayDeq {
    public static void main(String[] args) {
        GenericArrayQueue<Integer> aq = new GenericArrayQueue<Integer>();

        for (int i = 0; i < 10; i++) { aq.enq(i); }
        while (!aq.isEmpty()) {
            aq.print();
            aq.peek();
            aq.deq();
        }

        if (aq.size() == 0) { StdOut.println("test passed!"); }
        StdOut.println(aq.size());

    }
}
