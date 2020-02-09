import org.junit.Test;
import org.ua.axiom.Controller;
import org.ua.axiom.Model;
import org.ua.axiom.Viewer;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringBufferInputStream;

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
}
