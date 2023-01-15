package ActivitiesWithCats;

import Cats.Cat;

public enum StrategyChoose {
    YOUNG_CAT(5, new YoungCat()),
    ADULT_CAT(10, new AdultCat()),
    OLD_CAT(Integer.MAX_VALUE, new OldCat());

    private final int catAgePeriodLimit;
    private final Activable catAgeStrategy;

    StrategyChoose(int catAgePeriodLimit, Activable catAgeStrategy) {
        this.catAgePeriodLimit = catAgePeriodLimit;
        this.catAgeStrategy = catAgeStrategy;
    }

    public int getCatAgePeriodLimit() {
        return catAgePeriodLimit;
    }

    public static Activable chooseAgeStrategy(Cat cat){
        for (StrategyChoose strategy: StrategyChoose.values()) {
            if(cat.getAge() <= strategy.getCatAgePeriodLimit()){
                return strategy.catAgeStrategy;
            }
        }
        throw new RuntimeException("Проблема с подбором стратегии в методе chooseAgeStrategy");
    }
}
