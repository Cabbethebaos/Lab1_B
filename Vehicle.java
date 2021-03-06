import java.awt.*;

public abstract class Vehicle implements Movable {

    private Color color; // Color of the car
    private String modelName; // The car model name
    private double currentSpeed; // The current speed of the car
    private double enginePower; // Engine power of the car
    private double locX; //X coordinate of Location of Car
    private double locY; //Y coordinate of location of Car
    private int dirr; //0 = north, 1=east, 2=south, 3=west

    public Vehicle(Color color, int enginePower, String modelName) {

        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();

        locX = 0;
        locY = 0;
        dirr = 0;
    }

    /**
     *
     * @return modellnamnet
     */
    public String getModelName() {
        return modelName;
    }

    /**
     *
     * @param modelName sätter modellnamn
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     *
     * @return Y-koordinaten
     */
    public double getLocY() {
        return locY;
    }

    /**
     *
     * @param locY Sätter Y-koordinaten
     */

    public void setLocY(double locY) {
        this.locY = locY;
    }

    /**
     *
     * @return X-koordinaten
     */
    public double getLocX() {
        return locX;
    }

    /**
     *
     * @param locX sätter x-koordinaten
     */
    public void setLocX(double locX) {
        this.locX = locX;
    }

    /**
     *
     * @return vilken dirr bilen pekar
     */
    public int getDirr() {
        return dirr;
    }

    /**
     *
     * @param dirr sätter direction
     */
    public void setDirr(int dirr) {
        this.dirr = dirr;
    }

    /**
     *
     * @param enginePower hk som vi vill sätta
     */
    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    /**
     *
     * @return enginepower som en double
     */
    protected double getEnginePower() {
        return this.enginePower;
    }

    /**
     *
     * @return nuvarande hastighet i double
     */
    protected double getCurrentSpeed() {
        return this.currentSpeed;

    }

    /**
     *
     * @return färgen som en color
     */
    protected Color getColor() {
        return this.color;
    }

    /**
     *
     * @param clr anger en color som ska sättas
     */
    protected void setColor(Color clr) {
        this.color = clr;
    }

    /**
     * startar motorn och sätter currentspeed till 0.1
     */
    protected void startEngine() {
        this.currentSpeed = 0.1;
    }

    /**
     * stänger av motorn och sätter hastighet till 0
     */
    protected void stopEngine() {
        this.currentSpeed = 0;
    }

    /**
     * Ökar speed till högst 'enginePower'
     * @param amount mängden som vi vill öka med
     */
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + amount, enginePower);
    }

    /**
     * Minskar speed till minst '0'
     * @param amount mängden som vi vill minska med
     */
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - amount, 0);
    }

    /**
     *  Som incrementSpeed fast tar endast specifika värden
     * @param amount mellan 0 och 1 hur mkt vi vill gasa
     * Eftersom vi endast tillåter värden mellan 0 och 1 kan bilen inte bromsas av denna funktion
     */
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1)
            incrementSpeed(amount);
        else
            throw new RuntimeException("invalid number");
    }

    /**
     *  Som decrementSpeed fast tar endast specifika värden
     * @param amount mängden vi vill bromsa med
     *  Eftersom vi endast tillåter värden mellan 0 och 1 kan bilen inte öka farten av denna funktion
     */
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
        else
            throw new RuntimeException("invalid number");
    }

    /**
     *  Rör sig i den riktningen som bilen pekar med nuvarande hastighet
     */
    public void move() {
        if (dirr == 0) {
            locY += this.getCurrentSpeed();
        } else if (dirr == 1) {
            locX += this.getCurrentSpeed();
        } else if (dirr == 2) {
            locY -= this.getCurrentSpeed();
        } else locX -= this.getCurrentSpeed();

    }

    /**
     * Svänger vänster
     */
    public void turnLeft() {
        if (dirr == 0) {
            dirr = 3;
        } else dirr -= 1;
    }

    /**
     *  Svänger höger
     */
    public void turnRight() {
        if (dirr == 3) {
            dirr = 0;
        } else dirr += 1;
    }

    /**
     *
     * @param speed värdet som hastigheten ska sättas till
     */

    public void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }
}
