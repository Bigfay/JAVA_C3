import java.util.ArrayList;
import java.util.List;

public class CI3 {
    public static void main(String[] args) {
        // Course ic = new Course("patates", 12.3f, false);
        List<Course> coursesList = new ArrayList<>();
        coursesList.add(new Course("patates", 12.3f, false));
        coursesList.add(new Course("pâtes", 1.3f, false));
        // Course course1 = new Course("patates", 12.3, false);
        // Course course2 = new Course("pâtes", 5, false);
        /*
         * for (Course course : coursesList) {
         * System.out.println(course.name());
         * }
         */
        // order Meal
        Course plat = coursesList.get(1);
        Meal meal = new Meal();
        meal.order(plat, 4);
        plat = coursesList.get(0);
        meal.order(plat, 3);
        meal.displayOrderedCourses();
        System.out.println(plat.name());
    }
}
