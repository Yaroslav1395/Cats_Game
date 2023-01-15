package ActivitiesWithCats;

import Cats.Cat;

public interface Activable {
    void feedTheCat(Cat cat);
    void playWithCat(Cat cat);
    void treatCat(Cat cat);
    void setPerformed(boolean performed);
}
