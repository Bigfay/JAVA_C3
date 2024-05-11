import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.BeforeParam;

public class MealTest {
    private final String COURSE1 = "Poulet coco";
    private final float PRICE1 = 12.99f;
    private final boolean DESSERT1 = false;
    // private static final Integer QUANTITY1 = 4;

    private final String COURSE2 = "Riz";
    private final float PRICE2 = 3;
    private final boolean DESSERT2 = false;
    // private static final Integer QUANTITY2 = 4;

    // @Before

    // Course course1 = new Course(COURSE1, PRICE1, DESSERT1);
    // Course course2 = new Course(COURSE2, PRICE2, DESSERT2);
    // @Before
    public void setUp() {
        List<Course> coursesList = new ArrayList<>();
        coursesList.add(new Course(COURSE1, PRICE1, DESSERT1));
        coursesList.add(new Course(COURSE2, PRICE2, DESSERT2));
        for (Course course : coursesList) {
            System.out.println(course.price());
            System.out.println(course.name());
            // assertEquals("les plats sont", "pâtes", course.name().toString());
        }
    };

    @Test
    public void testMeal(List<Course> coursesList) {
        // assertEquals("La somme de 1 et 2 devrait être 3", 3, Calculateur.somme(1,
        // 2));
        // assertEquals("coucou", 5, Calculateur.somme(2, 3));

        for (Course course : coursesList) {
            // System.out.println(course.name());
            assertEquals("les plats sont", "pâtes", course.name().toString());
        }
    }
}
