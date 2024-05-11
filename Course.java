/**
 * Course est une repr´esentation immutable pour un plat.
 * il est typiquement d´efinit comme un uplet {name, price, type}
 * 
 * @specfield price : real - le prix du plat;
 * @specfield name : String - le nom du plat;
 * @specfield type : {Principal, Dessert} - le type de plat;
 */
public class Course {

    private float price;
    private String name;
    private boolean dessert; // true is dessert

    /**
     * FA(c) = {c.name, c.price, c.dessert}
     */

    /**
     * IR : name is not null &&
     * name est non vide &&
     * price >=0 (?)
     */

    public Course(String name, float price, boolean dessert) {
        this.price = price;
        this.name = name;
        this.dessert = dessert;
    }

    public boolean isDessert() {
        return this.dessert;
    }

    public String name() {
        return this.name;
    }

    public float price() {
        return this.price;
    }

    // Course est immutable, l'égalité référentielle (implem. par défaut)
    // n'est pas suffisante, il faut donc le réimplémenter
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Course)) {
            return false;
        }
        Course d = (Course) o;
        return equals(d);
        // return (d.price == price && d.name == name && d.dessert == dessert);
    }

    public boolean equals(Course d) {
        return (d.price == price && d.name.equals(name) && d.dessert == dessert);
    }

    // equals est réimplémenté, donc je dois réimplémenter hashCode
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Float.floatToIntBits(price);
        result = 31 * result + name.hashCode();
        result = 31 * result + (dessert ? 1 : 0);
        return result;
    }

    // clone et constructeur par copie ne doivent pas être réimplémenté
    // pour un type immutable

    @Override
    public String toString() {
        if (dessert)
            return "Dessert : " + name();
        else
            return "Plat : " + name();
    }
}