package dowhile;

import java.util.Optional;

/**
 * Created by chamly on 7/5/2017.
 */
public class Item {
    int nr;

    Item(int nr) {
        this.nr = nr;
    }

    @Override
    public String toString() {
        return "NR : " + nr;
    }
}
