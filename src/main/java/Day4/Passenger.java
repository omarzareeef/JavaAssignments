package Day4;

public class Passenger {

    int pclass, survived;
    String name, sex, body, home_dest, boat, cabin, ticket, embarked;
    double age, parch, sibsp, fare;

    @Override
    public String toString() {
        return "TitanicPassenger{" +
                "pclass=" + pclass +
                ", survived=" + survived +
                ", name='" + name + '\'' +
                '}';
    }


    public Passenger(){}

    public Passenger(int pclass, int survived, String name, String sex, String body, String home_dest, String boat, String cabin, String ticket, String embarked, float age, float parch, float sibsp, float fare) {
        this.pclass = pclass;
        this.survived = survived;
        this.name = name;
        this.sex = sex;
        this.body = body;
        this.home_dest = home_dest;
        this.boat = boat;
        this.cabin = cabin;
        this.ticket = ticket;
        this.embarked = embarked;
        this.age = age;
        this.parch = parch;
        this.sibsp = sibsp;
        this.fare = fare;
    }

    public int getPclass() {
        return pclass;
    }

    public void setPclass(int pclass) {
        this.pclass = pclass;
    }

    public int getSurvived() {
        return survived;
    }

    public void setSurvived(int survived) {
        this.survived = survived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHome_dest() {
        return home_dest;
    }

    public void setHome_dest(String home_dest) {
        this.home_dest = home_dest;
    }

    public String getBoat() {
        return boat;
    }

    public void setBoat(String boat) {
        this.boat = boat;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getEmbarked() {
        return embarked;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }

    public double getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public double getParch() {
        return parch;
    }

    public void setParch(float parch) {
        this.parch = parch;
    }

    public double getSibsp() {
        return sibsp;
    }

    public void setSibsp(float sibsp) {
        this.sibsp = sibsp;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }
}
