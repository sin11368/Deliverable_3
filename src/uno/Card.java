/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package uno;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author Gurveer
 */
public class Card {
    private final String color;
    private final int number;

    public Card(String color, int number) {
        this.color = color;
        this.number = number;
    }

    public Card(Card other) {
        this(other.color, other.number);
    }

    public boolean matches(Card other) {
        return number == other.number || color.equals(other.color);
    }

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public String toString() {
        return number + "\t" + color;
    }
}
