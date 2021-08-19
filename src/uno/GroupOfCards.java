/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Gurveer
 */
public class GroupOfCards {
    //The group of cards, stored in an ArrayList
    private final LinkedList<Card> cards;
    private final int size;//the size of the grouping

    public GroupOfCards(LinkedList<Card> cards, int size) {
        this.cards = new LinkedList<>();
        for (int i = 0; i<Math.min(cards.size(), size); i++) {
            this.cards.add(cards.get(i));
        }
        this.size = size;
    }

    public GroupOfCards(int size) {
        this(new LinkedList<>(), size);
    }


    public GroupOfCards(LinkedList<Card> cards) {
        this(cards, cards.size());
    }

    /**
     * A method that will get the group of cards as an LinkedList
     *
     * @return the group of cards.
     */
    public LinkedList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card getTop() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.getFirst();
    }

    public Card remove(int i) {
        if (i < 0 || i >= cards.size()) {
            return null;
        }
        return cards.remove(i);
    }

    public boolean add(Card card) {
        if (cards.size() < size-1) {
            cards.addFirst(card);
            return true;
        }
        return false;
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

}//end class
