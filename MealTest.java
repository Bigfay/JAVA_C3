import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.BeforeParam;

public class MealTest {
    private static final String COURSE1 = "Poulet coco";
    private static final float PRICE1 = 12.99f;
    private static final boolean DESSERT1 = false;
    private static final Integer QUANTITY1 = 4;

    private static final String COURSE2 = "Riz";
    private static final float PRICE2 = 3;
    private static final boolean DESSERT2 = false;
    private static final Integer QUANTITY2 = 4;

    @Before

    Course course1 = new Course(COURSE1, PRICE1, DESSERT1);
    Course course2 = new Course(COURSE2, PRICE2, DESSERT2);

    @Test
    public void testMeal() {
        // assertEquals("La somme de 1 et 2 devrait être 3", 3, Calculateur.somme(1,
        // 2));
        // assertEquals("coucou", 5, Calculateur.somme(2, 3));

        /*
         * Meal = {(”Poulet coco”, 4)} Meal = {(”Poulet coco”, 4),(”Riz”, 4)}
         * c = ”Riz”
         * number = 4
         */
        // assertEquals(Meal.order(Course) ,);
    }
}
