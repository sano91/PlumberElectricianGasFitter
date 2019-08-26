package com.sano.worker;



public class Plumber extends Worker {

    private static final int chancetoGetJobToday = 80;


    public Plumber(String name) {
        super.name = name;
        super.chanceToGetJobToday = chancetoGetJobToday;
        super.skillLevel = super.giveRandomSkillLevel();
    }



    @Override
    public String toString() {
        return "Plumber{" +
                "name='" + name + '\'' +
                ", totalRecivedSalary=" + totalRecivedSalary +
                ", secretaryOfTheday=" + secretaryOfTheday +
                ", skillLevel=" + skillLevel +
                '}';
    }
}
