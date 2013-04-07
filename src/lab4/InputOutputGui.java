package lab4;

import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui {
    private NameService nameService;

    public InputOutputGui() {
        nameService = new NameService();
    }

    public void startConversation() {
        int runCount = 1;
        String lastName = " ";
        String errorTitle = "Name Entry Error";
        boolean invalidName = true;
        while (invalidName) {
            try {
                String fullName = JOptionPane.showInputDialog("Enter full name:");
                lastName = nameService.extractLastName(fullName);
                invalidName = false;
            } catch (NullPointerException ne) {
                JOptionPane.showMessageDialog(null, ne.getMessage(),
                        errorTitle, JOptionPane.ERROR_MESSAGE);
            } catch (InvalidNameException ine) {
                JOptionPane.showMessageDialog(null, ine.getMessage(),
                        errorTitle, JOptionPane.ERROR_MESSAGE);
            }
            finally {
                System.out.println("method startConversation ran "
                        + runCount++ + " times");
            }
        }

        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
        
    }
     
}
