package com.sano.worker;

public class GasFitter extends Worker implements Holiday {

    @Override
    public void setHoliday(boolean holiday) {
        this.onHoliday = holiday;
    }

    private boolean onHoliday;
    private static final int chanceToWork = 65;



    @Override
    public boolean isOnHoliday() {
        return onHoliday;
    }

    @Override
    public void Holiday() {
        System.out.println(super.name + " say: I am on holiday.");
        this.onHoliday = true;
    }


    public GasFitter(String name) {
        super.chanceToGetJobToday = chanceToWork;
        super.name = name;
        super.skillLevel = super.giveRandomSkillLevel();
        this.onHoliday = false;
    }

    @Override
    public String toString() {
        return "GasFitter{" +
                "dailyWorkWorth=" + dailyWorkWorth +
                ", name='" + name + '\'' +
                ", totalRecivedSalary=" + totalRecivedSalary +
                ", secretaryOfTheday=" + secretaryOfTheday +
                ", skillLevel=" + skillLevel +
                ", chanceToGetJobToday=" + chanceToGetJobToday +
                '}';
    }
}
