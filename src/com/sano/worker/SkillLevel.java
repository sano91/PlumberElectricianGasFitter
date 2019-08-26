package com.sano.worker;

public enum SkillLevel {
    BEGINNER(60),
    MEDIUM_LEVEL(70),
    PRO(80);

    public final int value;

    private SkillLevel(int percentage) {
        this.value = percentage;
    }
}
