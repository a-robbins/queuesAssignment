// if intellij puts the line 'package tests;' into your file you will need to delete
// it or comment it out. The editor is trying to be too helpful
// package tests;

public class TestPeekWhenEmptyA {
    public static void main(String[] args) {
        GenericListQueue<Integer> q = new GenericListQueue<>();

        // the api definition of peek states that if the queue is empty then
        // null should be returned, so we'll check to make sure that holds true
        if (q.peek() != null) {
            StdOut.println("error: q.peek() should have returned null when the queue is "
                                   + "empty!");
            System.exit(1);
        }
        StdOut.println("Test passed!");
    }
}
