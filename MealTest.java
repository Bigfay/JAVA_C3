import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class MealTest {

    private final String COURSE1 = "Poulet coco";
    private final float PRICE1 = 12.99f;
    private final boolean DESSERT1 = false;

    private final String COURSE2 = "Riz";
    private final float PRICE2 = 3;
    private final boolean DESSERT2 = false;

    private List<Course> coursesList;

    // setup
    @Before
    public void setUp() {
        coursesList = new ArrayList<>();
        coursesList.add(new Course(COURSE1, PRICE1, DESSERT1));
        coursesList.add(new Course(COURSE2, PRICE2, DESSERT2));
    };

    Meal meal = new Meal();

    @Test
    public void testMeal() {
        // exercise
        Course plat1 = coursesList.get(1);
        Course plat2 = coursesList.get(0);
        meal.order(plat1, 4);
        meal.order(plat2, 3);

        Map<Course, Integer> counts = meal.getCourseCounts();
        // verify
        assertEquals("Poulet coco devrait être commandé 4 fois", (Integer) 4, counts.get(plat1));
        assertEquals("Riz devrait être commandé 3 fois", (Integer) 3, counts.get(plat2));

    }
    // teardown

}
