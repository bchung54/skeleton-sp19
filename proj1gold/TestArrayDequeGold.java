import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TestArrayDequeGold {

    StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
    ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

    @Test
    public void testStudentArrayDeque() {
        StringBuilder cmdList = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            double randNumber = StdRandom.uniform();
            int r = StdRandom.uniform(100);
            if (randNumber < 0.5) {
                sad.addFirst(r);
                ads.addFirst(r);
                cmdList.append("addFirst(" + r + ")\n");
                assertEquals("Oh noooo!\nThis is bad:\n   Actual " + sad.get(0)
                                + ", is not equal to " + ads.get(0) + "!",
                        sad.get(0), ads.get(0));
            } else {
                sad.addLast(r);
                ads.addLast(r);
                cmdList.append("addLast(" + r + ")\n");
                assertEquals("Oh noooo!\nThis is bad:\n   Actual " + sad.get(i)
                                + ", is not equal to " + ads.get(i) + "!",
                        sad.get(i), ads.get(i));
            }
        }

        for (int i = 0; i < 3; i++) {
            double randNumber = StdRandom.uniform();
            if (randNumber < 0.5) {
                cmdList.append("removeFirst()");
                assertEquals(cmdList.toString(),  sad.removeFirst(), ads.removeFirst());
            } else {
                cmdList.append("removeLast()");
                assertEquals(cmdList.toString(),  sad.removeLast(), ads.removeLast());
            }
        }

        assertEquals("Oh noooo!\nThis is bad:\n   Size, actually " + sad.size()
                        + ", is not equal to " + ads.size() + "!",
                sad.size(), ads.size());

        for (int i = 0; i < ads.size(); i++) {
            assertEquals("Oh no its fucked at " + i,  sad.get(i), ads.get(i));
            System.out.println("Sad: " + sad.get(i));
            System.out.println("Ads: " + ads.get(i));
        }
    }
}