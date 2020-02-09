import org.junit.Assert;
import org.junit.Test;
import org.ua.axiom.Controller;
import org.ua.axiom.Model;
import org.ua.axiom.Viewer;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringBufferInputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;

public class GeneralTest {

    @Test(timeout = 400)
    public void testSimpleInput() {
        InputStream inputStream = new StringBufferInputStream("2\n1\n0\n");
        new Controller(new Model(), new Viewer(System.out)).run(inputStream);
    }

    @Test(timeout = 400)
    public void testComplexInput() {
        InputStream inputStream = new StringBufferInputStream("10\n1\n2\n3\n4\n5\n6\n7\n8\n9\n");
        new Controller(new Model(), new Viewer(System.out)).run(inputStream);
    }

    @Test(timeout = 300)
    public void tesGuessesCollection() {
        InputStream inputStream = new StringBufferInputStream("10\n1\n2\n3\n4\n5\n6\n7\n8\n9\n");
        Model model = new Model();
        Controller controller = new Controller(model, new Viewer(System.out));
        controller.run(inputStream);

        Queue<Integer> expectedGuesses = new ArrayDeque<>();

        expectedGuesses.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        Assert.assertTrue(expectedGuesses.containsAll(model.getGuesses()));
    }
}
