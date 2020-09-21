package domain;

import java.util.Objects;

public class Motor {
    private String name;
    private int yearCreated;
    private boolean whirring;
    public Motor(String name, int yearCreated){
        this.name=name;
        this.yearCreated = yearCreated;
        this.whirring = false;
    }
    public Motor(){}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public boolean isWhirring() {
        return whirring;
    }

    public void setWhirring(boolean whirring) {
        this.whirring = whirring;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public String whirr(){
        if (whirring) return"This motor is whirring";
        return "This motor is not whirring";
    }

    @Override
    public String toString() {
        return "Motor{" +
                "name='" + name + '\'' +
                ", yearCreated=" + yearCreated +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motor motor = (Motor) o;
        return yearCreated == motor.yearCreated &&
                Objects.equals(name, motor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearCreated);
    }
}
