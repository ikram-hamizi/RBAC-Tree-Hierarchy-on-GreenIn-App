package ah.jocelyne.greenin.user_hierarchy;

import ah.jocelyne.greenin.signup.RegisteredUser;

public class CustomerService extends RegisteredUser implements Role{

    public CustomerService(String firstName, String lastName, String email, String hashedPassword, String salt, String role) {
        super(firstName, lastName, email, hashedPassword, salt, role);
    }

    public void addFaq() {}
    public void editFaq() {}
    public void deleteFaq() {}

    public void invokeMyFunctions()
    {
        addFaq();
        editFaq();
        deleteFaq();
    }

    public invokeMyChildrenFunctions() {
        //Explanation: List mychildren = TreeNodeObject.getChildren();
        getChildren().invokeMyFunctions();
    }
}
