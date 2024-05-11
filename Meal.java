import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @Overview Meal est une repr´esentation mutable d'un repas en cours de
 *           commande
 *           au restaurant Mamayi.
 *           Un Meal peut ^etre vu comme un ensemble de couples (p,q) tel que le
 *           Course 'p' a ´et´e
 *           command´e 'q' fois au sein de ce Meal. Les Course sont tri´es par
 *           ordre de commande.
 *           Une fois un Course de type "Dessert" command´e, il ne peut plus y
 *           avoir que des
 *           Course de type "Dessert".
 *
 * @specfield ordered : {(Course1, Integer1),...,(CourseX, IntegerX)} //
 *            L'ensemble
 *            des plats command´es ainsi que le nombre de fois o`u ils ont ´et´e
 *            command´es
 *
 * @derivedfield price : real // the prix total du repas
 *               // price = Somme(p.price*q) o`u (p,q) in ordered
 *
 * @invariant : une fois un Course "Dessert" command´e, il n'y a que des Course
 *            "Dessert"
 */
public class Meal {

    List<Course> ordered;
    boolean dessertOrdered;

    //[...]

    /**
     * @effects cr´ee un Meal vide pr^et `a recevoir des plats et desserts
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
     *          c `a ordered; sinon v´erifie que les plats sont autoris´es et
     *          rajoute
     *          alors c `a ordered;
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
    //[...]

/**
 * @requires c is not null
 * @modifies this
 * @effects si c est un dessert, indique que nous sommes au dessert et rajoute
 * number fois c `a ordered; sinon v´erifie que les plats sont autoris´es et rajoute
 * alors number fois c `a ordered;
 */
 public void order(Course c, int number) {
 for(int i=1;i<=number;i++){
 order(c);
 }
 }

    //[...]

}
