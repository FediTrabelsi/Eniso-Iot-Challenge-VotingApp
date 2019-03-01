package projects.solo.fedi.trabelsi.votingapp.Teams;

public class TeamModel {
    private String teamname;
    private String university;
    private String number;
    private String color;

    public TeamModel(String teamname,String university,String number,String color){
        this.teamname=teamname;
        this.university=university;
        this.number=number;
        this.number=number;
    }


    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
