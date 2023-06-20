import org.junit.jupiter.api.Test;

class RectangleTest {

    @Test
    void test() {
        Rectangle r = new Rectangle(5, 3);
        assertEquals(r.area(), 15);
        assertEquals(r.perimeter(), 16);

        RectangleRenderer renderer = new RectangleRenderer();

        renderer.printRectangle(r, "border");
        System.out.println();
        renderer.printRectangle(r, "full");
    }
}