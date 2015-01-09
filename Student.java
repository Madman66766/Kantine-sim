
/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student extends Persoon
{
    private String studentNummer;
    private String studieRichting;

    /**
     * Constructor for objects of class KantineMedewerker
     */
    public Student()
    {
        super();
        this.studentNummer = "";
        this.studieRichting = "";
    }
    
    /**
     * Override voor methode toString()
     */
    public String toString() {
        return super.toString() + "\nStudentnummer: " + studentNummer + "\nstudieRichting" + studieRichting;
    }

    /**
     * getter voor studierichting
     */
    public String getStudieRichting()
    {
        return studieRichting;
    }
    
    /**
     * getter voor studentnummer
     */
    public String getStudentNummer()
    {
        return studentNummer;
    }
    
    /**
     * setter voor studentnummer
     */
    public void setStudentNummer(String studentNummer)
    {
        this.studentNummer = studentNummer;
    }
    
    /**
     * setter studentenrichting
     */
    public void setStudieRichting(String studieRichting)
    {
        this.studieRichting = studieRichting;
    }
    
}
