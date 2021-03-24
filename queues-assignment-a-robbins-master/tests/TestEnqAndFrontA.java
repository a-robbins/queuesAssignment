// if intellij puts the line 'package tests;' into your file you will need to delete
// it or comment it out. The editor is trying to be too helpful
// package tests;

public class TestEnqAndFrontA {
    public static void main(String[] args) {
        GenericListQueue<Integer> q = new GenericListQueue<>();

        int origFrontVal = 0;
        for (int i = origFrontVal; i < 10; i++) {
            q.enq(i);
            int frontVal = q.peek();
            if (frontVal != origFrontVal) {
                StdOut.printf("error: the front of the queue should be %d but got %d from peek()!",
                              i,
                              frontVal);
                System.exit(1);
            }
        }
        StdOut.println("Test passed!");
    }
}
