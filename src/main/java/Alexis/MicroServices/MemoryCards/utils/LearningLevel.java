package Alexis.MicroServices.MemoryCards.utils;

public enum LearningLevel {

    NEW_WORD(0),
    SEEN_ONCE(1),
    SEEN_TWICE(2),
    CAN_YOU_REMEMBER_IT(3),
    KEEP_GOING(4),
    HALF_THE_JOB(5),
    GETTING_BETTER(6),
    GETTING_KNOWN(7),
    ALMOST_KNOWN(8),
    ONE_LAST(9),
    KNOWN_WORD(10);
    int level;

    LearningLevel(int level) {
        this.level = level;
    }

    public String toString(){
        return Integer.valueOf(level).toString();
    }

    public int getValue() {
        return level;
    }
}
