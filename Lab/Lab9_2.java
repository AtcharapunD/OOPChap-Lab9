package Lab9.Lab;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab9_2 extends JFrame implements ActionListener {
    SubjectNew sub[];
    Container container;
    // JComboBox<String> stdCombo, subCombo;
    JLabel codeLabel, nameLabel, creditLabel;
    JButton addBtn, editBtn, deleteBtn, showBtn, clearBtn;
    JTextField codeText, nameText, creditText, statusText;
    JTextArea subTextArea;
    JScrollPane subScroll;

    /** Creates a new instance of Lab9_2 */
    public Lab9_2() {
        initGui();
        sub = new SubjectNew[10];
        statusText.setText("Number Object : " + SubjectNew.getCount());
    }

    public Lab9_2(int max) {
        initGui();
        sub = new SubjectNew[max];
        statusText.setText("Number Object : " + SubjectNew.getCount());
    }

    public void initGui() {
        container = getContentPane();
        container.setLayout(new FlowLayout());
        codeLabel = new JLabel(" Subject Code : ");
        container.add(codeLabel);
        codeText = new JTextField(30);
        container.add(codeText);

        container.add(new JLabel(" "));
        nameLabel = new JLabel(" Subject Name : ");
        container.add(nameLabel);
        nameText = new JTextField(30);
        container.add(nameText);

        creditLabel = new JLabel("Subject Credit : ");
        container.add(creditLabel);
        creditText = new JTextField(30);
        container.add(creditText);

        container.add(new JLabel(" "));
        addBtn = new JButton("Add");
        addBtn.addActionListener(this);
        container.add(addBtn);

        editBtn = new JButton("Edit");
        editBtn.addActionListener(this);
        container.add(editBtn);

        deleteBtn = new JButton("Delete");
        deleteBtn.addActionListener(this);
        container.add(deleteBtn);

        showBtn = new JButton("Show");
        showBtn.addActionListener(this);
        container.add(showBtn);

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(this);
        container.add(clearBtn);

        subTextArea = new JTextArea(8, 25);
        subTextArea.setEditable(false);
        subScroll = new JScrollPane(subTextArea);
        container.add(subScroll);
        statusText = new JTextField(30);
        statusText.setEnabled(false);
        container.add(statusText);

        setSize(470, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == addBtn) {
            if (SubjectNew.getCount() == sub.length) {
                JOptionPane.showMessageDialog(this, "Array full , can not add", "Message",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int pos = CheckArrayEmpty();
            int n = Integer.parseInt(creditText.getText());
            sub[pos] = new SubjectNew(codeText.getText(), nameText.getText(), n);
            subTextArea.setText(readString(sub));
            JOptionPane.showMessageDialog(this, "Add Subject already", "Message", JOptionPane.INFORMATION_MESSAGE);
            clearTextField();

        } else if (event.getSource() == editBtn) {

            String s = codeText.getText();
            int n = searchSubject(sub, s);

            if (n >= 0) {
                sub[n].setSubjectName(nameText.getText());
                sub[n].setSubjectCredit(Integer.parseInt(creditText.getText()));
                subTextArea.setText(readString(sub));
                JOptionPane.showMessageDialog(this, "Edit Subject already", "Message", JOptionPane.INFORMATION_MESSAGE);
                clearTextField();
            } else {
                // JOptionPane.showMessageDialog(this, "can not found subject code", "ErrorMessage",JOptionPane.ERROR_MESSAGE);
                
                int pos = CheckArrayEmpty();
                int X = Integer.parseInt(creditText.getText());
                sub[pos] = new SubjectNew(codeText.getText(), nameText.getText(), X);
                subTextArea.setText(readString(sub));
                JOptionPane.showMessageDialog(this, "Add Subject already", "Message", JOptionPane.INFORMATION_MESSAGE);
                clearTextField();
            }

        } else if (event.getSource() == deleteBtn) {
            String s = codeText.getText();
            int n = searchSubject(sub, s);
            if (n >= 0) {
                nameText.setText(sub[n].getSubjectName());
                creditText.setText(sub[n].getSubjectCredit() + "");
                int ans = JOptionPane.showConfirmDialog(this, "Delete subject ", "Confirm", JOptionPane.YES_NO_OPTION);
                // 0 - Yes, 1 - No
                if (ans == 0) {
                    sub[n] = null;
                    System.gc();
                    subTextArea.setText(readString(sub));
                }
                clearTextField();
            } else {
                JOptionPane.showMessageDialog(this, "can not found subject code", "Error Message",JOptionPane.ERROR_MESSAGE);
            }

        } else if (event.getSource() == showBtn) {
            String s = codeText.getText();
            int n = searchSubject(sub, s);
            if (n >= 0) {
                nameText.setText(sub[n].getSubjectName());
                creditText.setText(sub[n].getSubjectCredit() + "");
            } else {
                JOptionPane.showMessageDialog(this, "can not found subject code", "Error Message",JOptionPane.ERROR_MESSAGE);
            }
        } else if (event.getSource() == clearBtn) {
            clearTextField();
        }
        statusText.setText("Number Object : " + SubjectNew.getCount());
    }

    public int CheckArrayEmpty() {
        for (int n = 0; n < sub.length; n++)
            if (sub[n] == null)
                return (n);
        return (-1);
    }

    public void clearTextField() {
        codeText.setText("");
        nameText.setText("");
        creditText.setText("");
    }

    public int searchSubject(SubjectNew sub[], String s) {
        for (int n = 0; n < sub.length; n++) {
            if (sub[n] != null)
                if (s.equals(sub[n].getSubjectCode()))
                    return (n);
        }
        return (-1);
    }

    public String readString(SubjectNew sub[]) {
        String str = "";
        for (int n = 0; n < sub.length; n++) {
            if (sub[n] != null)
                str += sub[n].toString() + "\n";
        }
        return (str);
    }

    public static void main(String[] args) {
        Lab9_2 lab9_2 = new Lab9_2(15);
    }
}
