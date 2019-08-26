package com.sano.worker;

import com.sano.util.Util;

public abstract class Worker {

    protected int dailyWorkWorth = 30000;
    protected String name;
    protected int totalRecivedSalary = 0;
    protected Worker secretaryOfTheday;
    protected SkillLevel skillLevel;
    protected int chanceToGetJobToday;

    public int getTotalRecivedSalary() {
        return totalRecivedSalary;
    }

    public String getName() {
        return name;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSecretaryOfTheday(Worker secretaryOfTheday) {
        this.secretaryOfTheday = secretaryOfTheday;
    }

    public int working() {
        if (this.secretaryOfTheday != this) {
            if (Util.giveFortune(this.chanceToGetJobToday)) {
                this.addToSalary();
                return this.addProfitToTheCompany();
            }
        }
        return 0;
    }

    protected SkillLevel giveRandomSkillLevel() {
        int chooseAbleLevels = SkillLevel.values().length;
        return SkillLevel.values()[Util.getRandomNumberInGivenRange(0, chooseAbleLevels - 1)];
    }

    protected void addToSalary() {
        this.totalRecivedSalary += this.dailyWorkWorth / 100 * this.skillLevel.value;
    }

    protected int addProfitToTheCompany() {
        return this.dailyWorkWorth / 100 * (100 - this.skillLevel.value);
    }

}
