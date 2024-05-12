import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Meal2Test {

    private final String COURSE1 = "Poulet coco";
    private final float PRICE1 = 12.99f;
    private final boolean DESSERT1 = false;

    private final String COURSE2 = "Glace";
    private final float PRICE2 = 3f;
    private final boolean DESSERT2 = true;

    private List<Course> coursesList;

    @Before
    public void setUp() {
        coursesList = new ArrayList<>();
        coursesList.add(new Course(COURSE1, PRICE1, DESSERT1));
        coursesList.add(new Course(COURSE2, PRICE2, DESSERT2));
    };

    Meal meal = new Meal();

    @Test
    public void test2Meal() {
        // setup
        Course plat1 = coursesList.get(0);
        Course plat2 = coursesList.get(1);
        meal.order(plat1, 4);
        // exercise
        meal.order(plat2, 3);
        assertEquals((float) PRICE1, plat1.price(), 0);
        assertEquals((float) PRICE2, plat2.price(), 0);

    }

    @Test
    public void testCourseImmutability() {
        Course course = new Course("Sushi", 10.00f, false);
        Course modifiedCourse = new Course("Sushi", 15.00f, false);
        assertNotEquals("Les instances avec des prix différents doivent être différentes", course, modifiedCourse);
    }

    @Test
    public void testNoMainCourseAfterDessert() {
        Meal meal = new Meal();
        Course dessert = new Course("Ice Cream", 5.00f, true);
        Course mainCourse = new Course("Burger", 12.00f, false);
        meal.order(dessert, 1);
        meal.order(mainCourse, 1);
        assertNull("Burger ne doit pas être ajouté après un dessert", meal.getCourseCounts().get(mainCourse));
    }

    @Test
    public void testAddingMultipleDesserts() {
        Meal meal = new Meal();
        Course firstDessert = new Course("Cake", 4.50f, true);
        Course secondDessert = new Course("Cookie", 2.50f, true);
        meal.order(firstDessert, 1);
        meal.order(secondDessert, 1);
        assertTrue("Devrait permettre l'ajout de plusieurs desserts", meal.getCourseCounts().get(secondDessert) == 1);
    }

    @Test
    public void testAddingSingleCourse() {
        Meal meal = new Meal();
        Course course = new Course("Steak", 20.00f, false);
        meal.order(course, 1);
        assertEquals("Doit contenir 1 plat commandé", 1, meal.getCourseCounts().get(course).intValue());
    }

    @Test
    public void testAddingCourseWithZeroQuantity() {
        Meal meal = new Meal();
        Course course = new Course("Fish and Chips", 10.00f, false);
        meal.order(course, 0);
        assertFalse("Aucune commande de 'Fish and Chips' ne devrait être ajoutée",
                meal.getCourseCounts().containsKey(course));
    }

    // teardown
    @After
    public void tearDown() {
        coursesList.clear();
    }

    @Test
    public void testMealInitialization() {
        Meal meal = new Meal();
        assertTrue("Meal doit être initialisé sans plats", meal.getCourseCounts().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testAddingCourseWithNullValue() {
        Meal meal = new Meal();
        meal.order(null, 1); // Supposons que commander un plat null devrait lancer une NullPointerException

    } 

    @Test
    public void testAddingCourseWithNegativeQuantity() {
        Meal meal = new Meal();
        Course course = new Course("Fish and Chips", 10.00f, false);
        meal.order(course, -1);
        assertFalse("Aucune commande de 'Fish and Chips' ne devrait être ajoutée",
                meal.getCourseCounts().containsKey(course));
    }

    @Test
    public void testToString() {
        Course course = new Course("Tarte aux pommes", 4.99f, true);
        String expected = "Dessert : Tarte aux pommes";
        assertEquals("La méthode toString doit renvoyer la représentation correcte du plat", expected,
                course.toString());

        Course course2 = new Course("Steak frites", 12.50f, false);
        String expected2 = "Plat : Steak frites";
        assertEquals("La méthode toString doit renvoyer la représentation correcte du plat", expected2,
                course2.toString());
    }

    @Test
    public void testNoDuplicatesInOrderedCourses() {
        Meal meal = new Meal();
        Course course = new Course("Sushi", 20.00f, false);
        meal.order(course, 1);
        meal.order(course, 2);
    
        List<Course> orderedCourses = meal.getOrderedCourses();
        assertEquals(3,  orderedCourses.size());
    }

}
