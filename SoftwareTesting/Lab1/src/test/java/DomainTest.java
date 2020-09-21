import domain.Motor;
import domain.People;
import domain.SpaceShip;
import domain.Whistle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DomainTest {

    @Test public void testCreateSpace(){
        SpaceShip space1 = new SpaceShip("Russia",1987);
        SpaceShip space2 = new SpaceShip();
        assertNotEquals(space1, space2);

        space2.setName("Russia");
        space2.setYearCreated(1987);
        assertEquals(space1, space2);
    }

    @Test public void testAddPeopleToSpace(){
        SpaceShip space = new SpaceShip("Vietnam",1997);
        space.addPeopleToSpaceShip(new People("Duc",25));
        space.addPeopleToSpaceShip(new People("Lan Anh",20));
        space.addPeopleToSpaceShip(new People("Hien",25));

        People duc = new People();
        duc.setAge(25);
        duc.setName("Duc");
        assertTrue(space.getPeopleList().contains(duc));

        People hien = new People("HIEN", 25);
        assertFalse(space.getPeopleList().contains(hien));

        List<People> peopleList = new ArrayList<>();
        peopleList.add(duc);
        hien.setName("Hien");
        peopleList.add(hien);
        assertNotEquals(peopleList, space.getPeopleList());

        peopleList.add(new People("Lan Anh",20));
        assertNotEquals(peopleList, space.getPeopleList());

        peopleList.clear();

        peopleList.add(duc);
        peopleList.add(new People("Lan Anh",20));
        peopleList.add(hien);
        assertEquals(peopleList, space.getPeopleList());
    }

    @Test public void testAddSmallPeopletoSpaceShip(){
        SpaceShip space = new SpaceShip("Vietnam",1997);
        People duc = new People("DUC", 17);
        space.addPeopleToSpaceShip(duc);
        assertNotEquals("Cannot bring under 18 years old person to spaceship",1,space.getNumberPeople());

        duc.setAge(25);
        space.addPeopleToSpaceShip(duc);
        assertEquals("This person is over 18",1,space.getNumberPeople());
    }

    @Test public void testAddManyPeopleToNewSpaceShip(){
        SpaceShip space = new SpaceShip("Vietnam",1997);
        for(int i=0;i<20;i++){
            space.addPeopleToSpaceShip(new People("VietNam"+i, 20+i));
        }
        assertEquals("New Space can only bring maximum 10 people",10,space.getNumberPeople());

    }

    @Test public void testAddManyPeopleToOldSpaceShip(){
        SpaceShip space = new SpaceShip("Vietnam",1897);
        for(int i=0;i<20;i++){
            space.addPeopleToSpaceShip(new People("VietNam"+i, 20+i));
        }
        assertEquals("Old Space can only bring maximum 10 people",2,space.getNumberPeople());
    }

    @Test
    public void testNamePeople(){
        People duc = new People("DUC",25);
        assertEquals("DUC", duc.getName());
        assertNotEquals("Name is case-sensitive","duc", duc.getName());
    }

    @Test public void testNameChangedPeople(){
        People duc = new People("DUC",25);
        assertEquals("DUC", duc.getName());
        duc.setName("duc");
        assertNotEquals("Name is changed","DUC", duc.getName());
    }


    @Test public void testNameMotor(){
        Motor duc = new Motor("main",2000);
        assertEquals("main", duc.getName());
    }

    @Test public void testAddMotorToSpaceShip() {
        SpaceShip spaceShip = new SpaceShip("USA", 2000);
        for (int i = 0; i < 10; i++) {
            spaceShip.addMotorToSpaceShip(new Motor("Motor" + i, i));
        }

        assertEquals(10, spaceShip.getMotorList().size());

    }

    @Test public void testMotorWhirring(){
        SpaceShip space = new SpaceShip("Russia",2019);
        Motor motor = new Motor("main",2999);
        space.addMotorToSpaceShip(motor);

        assertNotEquals("The motor is not running","This motor is whirring", space.getMotorList().get(0).whirr());

        motor.setWhirring(true);
        assertEquals("This motor is whirring", space.getMotorList().get(0).whirr());
    }

    @Test public void testSoundWhistle(){
        SpaceShip spaceShip = new SpaceShip("Russia",2019);
        for (int i = 0; i < 10; i++) {
            spaceShip.addMotorToSpaceShip(new Motor("Motor" + i, i));
        }
        assertEquals("Spaceship must have thin whistle",spaceShip.startRunning(), Whistle.THIN);

        Motor motor = new Motor("future",2021);

        motor.setWhirring(true);
        spaceShip.addMotorToSpaceShip(motor);
        assertEquals("Spaceship must have fat whistle", spaceShip.startRunning(), Whistle.FAT);
    }

}
