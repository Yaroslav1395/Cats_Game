package Cats;

import ActivitiesWithCats.Activable;
import ActivitiesWithCats.StrategyChoose;

import java.util.Objects;
import java.util.Random;

public class Cat {
    private String name;
    private int age;
    private int satietyLevel;
    private int moodLevel;
    private int healthLevel;
    private Activable activeStrategy;

    private final Random random = new Random();

    public Cat(String name) {
        this.name = name;
        age = setLevel(1, 17);
        satietyLevel = setLevel(0,100);
        moodLevel = setLevel(0,100);
        healthLevel = setLevel(0,100);
        setActiveStrategy();
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        satietyLevel = setLevel(20, 80);
        moodLevel = setLevel(20, 80);
        healthLevel = setLevel(20, 80);
        setActiveStrategy();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSatietyLevel() {
        return satietyLevel;
    }

    public void setSatietyLevel(int satietyLevel) {
        this.satietyLevel = satietyLevel;
    }

    public int getMoodLevel() {
        return moodLevel;
    }

    public void setMoodLevel(int moodLevel) {
        this.moodLevel = moodLevel;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public Random getRandom() {
        return random;
    }

    public Activable getActiveStrategy() {
        return activeStrategy;
    }

    public void setActiveStrategy() {
        this.activeStrategy = StrategyChoose.chooseAgeStrategy(this);
        catStrategyPerformedReset();
    }

    private int setLevel(int startWith, int noPlusLimit){
        return random.nextInt(noPlusLimit) + startWith;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && satietyLevel == cat.satietyLevel && moodLevel == cat.moodLevel && healthLevel == cat.healthLevel && Objects.equals(name, cat.name) && Objects.equals(random, cat.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, satietyLevel, moodLevel, healthLevel, random);
    }

    public double calculateAverage(){
        return (healthLevel + satietyLevel + moodLevel) / 3f;
    }

    protected void feedTheCat(){
        activeStrategy.feedTheCat(this);
    }
    protected void playWithCat(){
        activeStrategy.playWithCat(this);
    }
    protected void treatCat(){
        activeStrategy.treatCat(this);
    }
    protected void catStateChange(){
        satietyLevel -= setLevel(1, 6);
        moodLevel += setLevel(-3, 7);
        healthLevel += setLevel(-3, 7);
    }
    protected void catStrategyPerformedReset(){
        activeStrategy.setPerformed(false);
    }
}

