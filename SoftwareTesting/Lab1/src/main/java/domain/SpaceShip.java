package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Spaceship has only space for 10 people for new, and 2 for old
 */
public class SpaceShip {
    private String name;
    private int yearCreated;
    private List<People> peopleList= new ArrayList<>();
    private List<Motor> motorList = new ArrayList<>();
    private Status status;
    public SpaceShip(String name, int yearCreated){
        this.name = name;
        this.yearCreated = yearCreated;
        setStatus();
    }

    public SpaceShip(){}

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus() {
        if (2020-yearCreated >50) this.status = Status.OLD;
        else this.status = Status.NEW;
    }

    public Status getStatus(){
        return this.status;
    }
    public String getName() {
        return name;
    }

    public Whistle startRunning(){
        for(int i=0;i<motorList.size();i++) if (motorList.get(i).isWhirring()){
            return Whistle.FAT;
        }
        return Whistle.THIN;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceShip spaceShip = (SpaceShip) o;
        return yearCreated == spaceShip.yearCreated &&
                Objects.equals(name, spaceShip.name) &&
                Objects.equals(peopleList, spaceShip.peopleList) &&
                Objects.equals(motorList, spaceShip.motorList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearCreated, peopleList, motorList);
    }

    @Override
    public String toString() {
        return "SpaceShip{" +
                "name='" + name + '\'' +
                ", yearCreated=" + yearCreated +
                ", peopleList=" + peopleList +
                ", motorList=" + motorList +
                '}';
    }

    public List<Motor> getMotorList() {
        return motorList;
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setMotorList(List<Motor> motorList) {
        this.motorList = motorList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }
    public void addPeopleToSpaceShip(People e){
        if (e.getAge() < 18 || e.getAge()>60) return;
        if (this.status == Status.NEW){
            if (peopleList.size() < 10) this.peopleList.add(e);
        } else{
            if (peopleList.size() < 2) this.peopleList.add(e);
        }
    }
    public void addMotorToSpaceShip(Motor m){
        this.motorList.add(m);
    }

    public int getNumberPeople(){
        return this.peopleList.size();
    }

    public int getNumberMotor(){
        return this.motorList.size();
    }
}
