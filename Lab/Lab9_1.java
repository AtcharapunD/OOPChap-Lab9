package Lab9.Lab;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class Lab9_1 extends JFrame implements ActionListener {
    Student std[];
    Subject sub[];
    String[] studentStr, subjectStr;
    Container container;
    JComboBox<String> stdCombo, subCombo;
    JLabel stdLabel, subLabel;
    JButton addstdBtn, addsubBtn, saveBtn, clearBtn, cancleBtn;
    JTextField stdText;
    JTextArea subTextArea;
    JScrollPane subScroll;
    Register reg;
    int count = 0;

    /** Creates a new instance of Lab9_1 */
    public Lab9_1() {
        super("Program Student Register");
        initStudent();
        initSubject();
        initGui();
        reg = new Register(new Student(), 8);
    }

    public void initStudent() {
        std = new Student[15];
        studentStr = new String[15];
        std[0] = new Student("5066260010", "AAAAA", "BBBBBBBBBBB");
        std[1] = new Student("5066260024", "DDDDD", "GGGGGGGGGG");
        std[2] = new Student("5066260035", "HHHHH", "KKKKKKKKKKK");
        std[3] = new Student("0000000001", "nani", "CCCCCCCCCCC");
        std[4] = new Student("0000000002", "eyhuk", "DDDDDDDDDDD");
        std[5] = new Student("0000000003", "wazan", "AAAAAAAAAAA");
        std[6] = new Student("0000000004", "eiei", "EEEEEEEEEE");
        std[7] = new Student("0000000005", "Mairu", "FFFFFFFFFF");
        std[8] = new Student("0000000006", "Brownie", "HHHHHHHHHH");
        std[9] = new Student("0000000007", "Sometimes", "IIIIIIIIII");
        std[10] = new Student("0000000008", "Jamezconer", "JJJJJJJJJJ");
        std[11] = new Student("0000000009", "Rym us", "LLLLLLLLL");
        std[12] = new Student("0000000010", "HRK", "MMMMMMMMMM");
        std[13] = new Student("0000000011", "Pattiiz", "NNNNNNNNNN");
        std[14] = new Student("0000000012", "Zynazter", "PPPPPPPPPP");

        studentStr[0] = std[0].toString();
        studentStr[1] = std[1].toString();
        studentStr[2] = std[2].toString();
        studentStr[3] = std[3].toString();
        studentStr[4] = std[4].toString();
        studentStr[5] = std[5].toString();
        studentStr[6] = std[6].toString();
        studentStr[7] = std[7].toString();
        studentStr[8] = std[8].toString();
        studentStr[9] = std[9].toString();
        studentStr[10] = std[10].toString();
        studentStr[11] = std[11].toString();
        studentStr[12] = std[12].toString();
        studentStr[13] = std[13].toString();
        studentStr[14] = std[14].toString();
    }

    public void initSubject() {
        sub = new Subject[15];
        subjectStr = new String[15];
        sub[0] = new Subject("662305", "IT Laboratory II", 1);
        sub[1] = new Subject("662309", "Data Structure", 3);
        sub[2] = new Subject("662310", "Database System", 3);
        sub[3] = new Subject("662317", "Data Communication", 3);
        sub[4] = new Subject("662327", "Advanced Computer Programming", 3);
        sub[5] = new Subject("010101", "Fundamental of IT", 3);
        sub[6] = new Subject("662309", "Data Structure 2", 3);
        sub[7] = new Subject("662310", "Stat in Everyday", 3);
        sub[8] = new Subject("662317", "AI", 3);
        sub[9] = new Subject("662327", "Dancing", 3);
        sub[10] = new Subject("662305", "Javascript", 3);
        sub[11] = new Subject("662309", "Object Orainted Programming", 3);
        sub[12] = new Subject("662310", "Web Programming", 3);
        sub[13] = new Subject("662317", "Design Thinking", 3);
        sub[14] = new Subject("662327", "Sofeware Engineering", 3);

        subjectStr[0] = sub[0].toString();
        subjectStr[1] = sub[1].toString();
        subjectStr[2] = sub[2].toString();
        subjectStr[3] = sub[3].toString();
        subjectStr[4] = sub[4].toString();
        subjectStr[5] = sub[5].toString();
        subjectStr[6] = sub[6].toString();
        subjectStr[7] = sub[7].toString();
        subjectStr[8] = sub[8].toString();
        subjectStr[9] = sub[9].toString();
        subjectStr[10] = sub[10].toString();
        subjectStr[11] = sub[11].toString();
        subjectStr[12] = sub[12].toString();
        subjectStr[13] = sub[13].toString();
        subjectStr[14] = sub[14].toString();
    }

    public void initGui() {
        container = getContentPane();
        container.setLayout(new FlowLayout());
        stdLabel = new JLabel("Select Student : ");
        container.add(stdLabel);
        stdCombo = new JComboBox<String>(studentStr);
        stdCombo.setMaximumRowCount(5);
        container.add(stdCombo);

        addstdBtn = new JButton("Add Student");
        addstdBtn.addActionListener(this);
        container.add(addstdBtn);
        stdText = new JTextField(40);
        stdText.setEditable(false);
        container.add(stdText);

        subLabel = new JLabel("Select Subject : ");
        container.add(subLabel);
        subCombo = new JComboBox<String>(subjectStr);
        subCombo.setMaximumRowCount(5);
        container.add(subCombo);

        addsubBtn = new JButton("Add Subject");
        addsubBtn.setEnabled(false);
        addsubBtn.addActionListener(this);
        container.add(addsubBtn);
        subTextArea = new JTextArea(5, 50);
        subTextArea.setEditable(false);
        subScroll = new JScrollPane(subTextArea);
        container.add(subScroll);

        saveBtn = new JButton(" Save ");
        saveBtn.setEnabled(false);
        saveBtn.addActionListener(this);
        container.add(saveBtn);

        cancleBtn = new JButton(" Cancle ");
        cancleBtn.setEnabled(false);
        cancleBtn.addActionListener(this);
        container.add(cancleBtn);

        setSize(450, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == addstdBtn) {
            int n = stdCombo.getSelectedIndex();
            stdText.setText(std[n].toString());
            reg.setStudent(std[n]);
            addstdBtn.setEnabled(false);
            addsubBtn.setEnabled(true);
            saveBtn.setEnabled(true);
            cancleBtn.setEnabled(true);
        } else if (event.getSource() == addsubBtn) {
            int n = subCombo.getSelectedIndex();
            subTextArea.append(sub[n].toString() + "\n");
            reg.setSubject(sub[n], count);
            count++;
            if (count == 8)
                addsubBtn.setEnabled(false);
        } else if (event.getSource() == saveBtn) {
            String output = "";
            output = "Student :" + reg.getStudent();
            output += "\nSubject:\n";
            for (int n = 0; n < count; n++)
                output += reg.getSubject(n) + "\n";
            JOptionPane.showMessageDialog(this, output, "Registration Data", JOptionPane.INFORMATION_MESSAGE);
            resetBtn();
        } else if (event.getSource() == cancleBtn) {
            stdText.setText("");
            subTextArea.setText("");
            count = 0;
            resetBtn();
        }
    }

    public void resetBtn() {
        addstdBtn.setEnabled(true);
        addsubBtn.setEnabled(false);
        saveBtn.setEnabled(false);
        cancleBtn.setEnabled(false);
        stdText.setText("");
        subTextArea.setText("");
    }

    public static void main(String[] args) {
        Lab9_1 lab9_1 = new Lab9_1();
    }
}
