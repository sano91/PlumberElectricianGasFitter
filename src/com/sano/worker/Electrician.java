package com.sano.worker;



public class Electrician extends Worker implements Holiday {

    private static final int chanceToWork = 90;

    private boolean onHoliday;


    @Override
    public void setHoliday(boolean holiday) {
        this.onHoliday = holiday;
    }

    @Override
    public boolean isOnHoliday() {
        return onHoliday;
    }

    public Electrician(String name) {
        super.name = name;
        super.chanceToGetJobToday = chanceToWork;
        super.skillLevel = super.giveRandomSkillLevel();
        this.onHoliday = false;
    }

    @Override
    public void Holiday() {
        System.out.println(super.name + " say: I am on the mandatory holiday right now");
    }

    @Override
    public String toString() {
        return "Electrician{" +
                "dailyWorkWorth=" + dailyWorkWorth +
                ", name='" + name + '\'' +
                ", totalRecivedSalary=" + totalRecivedSalary +
                ", secretaryOfTheday=" + secretaryOfTheday +
                ", skillLevel=" + skillLevel +
                ", chanceToGetJobToday=" + chanceToGetJobToday +
                '}';
    }
}
