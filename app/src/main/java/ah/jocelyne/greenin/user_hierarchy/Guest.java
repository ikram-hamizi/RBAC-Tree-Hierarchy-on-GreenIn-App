package ah.jocelyne.greenin.user_hierarchy;

import ah.jocelyne.greenin.signup.RegisteredUser;

public class Guest extends RegisteredUser implements Role{

    public Guest(String firstName, String lastName, String email, String hashedPassword, String salt, String role) {
        super(firstName, lastName, email, hashedPassword, salt, role);
    }

    public void readPrivilege()
    {

    }
    public void invokeMyFunctions()
    {
        readPrivilege();
    }

    public invokeMyChildrenFunctions() {
        //Explanation: List mychildren = TreeNodeObject.getChildren();
        getChildren().invokeMyFunctions();
    }
}
