
public class TestTemperatureAlert {
    public static void main(String[] args) {
        TemperatureAlert westCoast = new TemperatureAlert();
        Student s1 = new Student("s1", westCoast);
        Student s2 = new Student("s2", westCoast);

        westCoast.setTemperature(40);
        westCoast.setTemperature(25);
        westCoast.setTemperature(5);

        westCoast.unregister(s1);
        Student s3 = new Student("s3", westCoast);
        Fish f1 = new Fish("f1", westCoast);

        westCoast.setTemperature(2);


    }
}
