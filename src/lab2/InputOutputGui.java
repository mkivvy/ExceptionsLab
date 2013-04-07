package lab2;

import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui {

    private NameService nameService;

    public InputOutputGui() {
        nameService = new NameService();
    }

    public void startConversation() {
        String lastName = " ";
        String errorTitle = "Name Entry Error";
        boolean invalidName = true;
        while (invalidName) {
            try {
                String fullName = JOptionPane.showInputDialog("Enter full name:");
                lastName = nameService.extractLastName(fullName);
                invalidName = false;
            } catch (MissingDataException mie) {
                JOptionPane.showMessageDialog(null, mie.getMessage(),
                        errorTitle, JOptionPane.ERROR_MESSAGE);
            } catch (InvalidDataEntryException ide) {
                JOptionPane.showMessageDialog(null, ide.getMessage(),
                        errorTitle, JOptionPane.ERROR_MESSAGE);
            }
        }

        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);

    }
}
