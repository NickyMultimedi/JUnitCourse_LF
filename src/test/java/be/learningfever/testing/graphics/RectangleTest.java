package be.learningfever.testing.graphics;

import be.learningfever.testing.graphics.exceptions.NegativeNumberException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.w3c.dom.css.Rect;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    Rectangle rect;

    @BeforeEach
    public void beforeEach() {
        rect = new Rectangle();
    }

    @Test
    void testHeight() {
        rect.setHeight(2.3);
        assertEquals(2.3, rect.getHeight());
    }

    @Test
    void testHeightDoesntAllowNegativeNumbers() {
        assertThrows(NegativeNumberException.class, () -> rect.setHeight(0));
        assertThrows(NegativeNumberException.class, () -> rect.setHeight(-2.3));
    }

    @Test
    void testWidth() {
        rect.setWidth(2.3);
        assertEquals(2.3, rect.getWidth());
    }

    @Test
    void testWidthDoesntAllowNegativeNumbers() {
        assertThrows(NegativeNumberException.class, () -> rect.setWidth(-2.3));
    }

    @Test
    void testPerimeter() {
        double height = rect.getHeight();
        double width = rect.getWidth();
        double perimeter = 2 * ( height + width );
        assertEquals(perimeter, rect.getPerimeter());
    }

    @Test
    void testArea() {
        double height = rect.getHeight();
        double width = rect.getWidth();
        double area = height * width;
        assertEquals(area, rect.getArea());
    }

    @AfterEach
    public void afterEach() {
        rect = null;
    }
}
