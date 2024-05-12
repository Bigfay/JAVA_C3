import java.util.ArrayList;
import java.util.List;

public class CI3 {
    public static void main(String[] args) {
        
        List<Course> coursesList = new ArrayList<>();
        coursesList.add(new Course("patates", 12.3f, false));
        coursesList.add(new Course("pâtes", 1.3f, false));
        
        Course plat = coursesList.get(1);
        Meal meal = new Meal();
        meal.order(plat, 4);
        plat = coursesList.get(0);
        meal.order(plat, 3);
        //meal.displayOrderedCourses();
        System.out.println(plat.name());
        System.out.println(Integer.MAX_VALUE);
    }
}
