import java.util.ArrayList;
import java.util.HashMap;
//import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * @Overview Meal est une représentation mutable d'un repas en cours de
 *           commande
 *           au restaurant Mamayi.
 *           Un Meal peut être vu comme un ensemble de couples (p,q) tel que le
 *           Course 'p' a été
 *           commandé 'q' fois au sein de ce Meal. Les Course sont triés par
 *           ordre de commande.
 *           Une fois un Course de type "Dessert" commandé, il ne peut plus y
 *           avoir que des
 *           Course de type "Dessert".
 *
 * @specfield ordered : {(Course1, Integer1),...,(CourseX, IntegerX)} //
 *            L'ensemble
 *            des plats commandés ainsi que le nombre de fois où ils ont été
 *            commandés
 *
 * @derivedfield price : real // the prix total du repas
 *               // price = Somme(p.price*q) o`u (p,q) in ordered
 *
 * @invariant : une fois un Course "Dessert" commandé, il n'y a que des Course
 *            "Dessert"
 */
public class Meal {

    List<Course> ordered;
    boolean dessertOrdered;

    // [...]

    /**
     * @effects crée un Meal vide prêt à recevoir des plats et desserts
     */
    public Meal() {
        ordered = new ArrayList<Course>();
        // ou ordered = new ArrayList<>();

        dessertOrdered = false;
    }

    /**
     * @requires c is not null
     * @modifies this
     * @effects si c est un dessert, indique que nous sommes au dessert et rajoute
     *          c à ordered; sinon v´erifie que les plats sont autorisés et
     *          rajoute
     *          alors c à ordered;
     */
    public void order(Course c) {
        if (c.isDessert()) {
            dessertOrdered = true;
            ordered.add(c);
        } else {
            if (!dessertOrdered) {
                ordered.add(c);
            }
        }
    }
    // [...]

    /**
     * @requires c is not null
     * @modifies this
     * @effects si c est un dessert, indique que nous sommes au dessert et rajoute
     *          number fois c à ordered; sinon vérifie que les plats sont autorisés
     *          et rajoute
     *          alors number fois c à ordered;
     */
    public void order(Course c, int number) {
        for (int i = 1; i <= number; i++) {
            order(c);
        }
    }

    public Map<Course, Integer> getCourseCounts() {
        Map<Course, Integer> counts = new HashMap<>();
        for (Course course : ordered) {
            counts.put(course, counts.getOrDefault(course, 0) + 1);
        }
        return counts;
    }

    /**
     * Retourne une copie de la liste des plats commandés.
     * 
     * @return une copie de la liste des cours commandés pour éviter la modification
     *         extérieure directe.
     */
    public List<Course> getOrderedCourses() {
        return new ArrayList<>(ordered); // Retourne une copie pour préserver l'encapsulation
    }

    public void displayOrderedCourses() {
        if (ordered.isEmpty()) {
            System.out.println("Aucun plat commandé.");
        } else {
            Map<String, Integer> courseCount = new HashMap<>();
            for (Course course : ordered) {
                String courseKey = course.name() + (course.isDessert() ? " (Dessert)" : " (Plat)");
                courseCount.put(courseKey, courseCount.getOrDefault(courseKey, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : courseCount.entrySet()) {
                System.out.println(entry.getKey() + " commandé " + entry.getValue() + " fois");
            }
        }
    }

    // [...]

}
