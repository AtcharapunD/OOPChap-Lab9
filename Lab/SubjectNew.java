package Lab9.Lab;

public class SubjectNew {
    private String SubjectCode;
    private String SubjectName;
    private int SubjectCredit;
    private static int count = 0;

    /** Creates a new instance of Subject */
    public SubjectNew() {
        setSubjectCode("");
        setSubjectName("");
        setSubjectCredit(0);
        count++;
    }

    public SubjectNew(String Code, String Name, int Credit) {
        setSubjectCode(Code);
        setSubjectName(Name);
        setSubjectCredit(Credit);
        count++;
    }

    public SubjectNew(SubjectNew sub) {
        setSubjectCode(sub.getSubjectCode());
        setSubjectName(sub.getSubjectName());
        setSubjectCredit(sub.getSubjectCredit());
        count++;
    }

    public void setSubjectCode(String Code) {
        SubjectCode = Code;
    }

    public void setSubjectName(String Name) {
        SubjectName = Name;
    }

    public void setSubjectCredit(int Credit) {
        SubjectCredit = Credit;
    }

    public String getSubjectCode() {
        return (SubjectCode);
    }

    public String getSubjectName() {
        return (SubjectName);
    }

    public int getSubjectCredit() {
        return (SubjectCredit);
    }

    protected void finalize() {
        count--;
    }

    public static int getCount() {
        return (count);
    }

    public String toString() {
        String str = "";
        str = getSubjectCode() + " " + getSubjectName() + " ";
        str += getSubjectCredit();
        return (str);
    }
}
