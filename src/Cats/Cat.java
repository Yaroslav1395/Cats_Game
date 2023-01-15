package Cats;

import java.util.Objects;
import java.util.Random;

public class Cat {
    private String name;
    private int age;
    private int satietyLevel;
    private int moodLevel;
    private int healthLevel;

    private final Random random = new Random();

    public Cat(String name) {
        this.name = name;
        this.age = setLevel(1, 18);
        this.satietyLevel = setLevel(0,100);
        this.moodLevel = setLevel(0,100);
        this.healthLevel = setLevel(0,100);
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

    private int setLevel(int startLimit, int entLimit){
        return random.nextInt(entLimit) + startLimit;
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

}
