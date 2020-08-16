package bogdan.programming;

public class Vehicle {

    private String name;
    private String size;

    private int curretVelocity;
    private int currentDirection;

    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;

        this.curretVelocity = 0;
        this.currentDirection =0;
    }

    public void steer (int direction){
        currentDirection += direction;
        System.out.println("Vehicle.steer(): Steering at "+currentDirection+" degrees!");
    }

    public void move(int velocity, int direction){
        curretVelocity = velocity;
        currentDirection = direction;
        System.out.println("Vehicle.move(): Moving at "+curretVelocity+
                " and steering at "+currentDirection+" degrees");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCurretVelocity() {
        return curretVelocity;
    }

    public void setCurretVelocity(int curretVelocity) {
        this.curretVelocity = curretVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void stop(){
        this.curretVelocity=0;
    }
}
