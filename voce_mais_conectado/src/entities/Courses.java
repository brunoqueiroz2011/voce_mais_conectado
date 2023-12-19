package entities;

public class Courses {

    String courseName;
    String periodTime;
    String requirements;
    String paymentMethods;
    String description;

    public Courses(String courseName, String periodTime, String requirements, String paymentMethods, String description) {
        this.courseName = courseName;
        this.periodTime = periodTime;
        this.requirements = requirements;
        this.paymentMethods = paymentMethods;
        this.description = description;
    }

    @Override
    public String toString() {
        return "- Nome do Curso: '" + courseName + '\'' +
                "\n- Período/Horário: '" + periodTime + '\'' +
                "\n- Requisitos: '" + requirements + '\'' +
                "\n- Formas de Pagamento: '" + paymentMethods + '\'' +
                "\n- O que você vai aprender: '" + description + '\'';
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(String periodTime) {
        this.periodTime = periodTime;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(String paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
