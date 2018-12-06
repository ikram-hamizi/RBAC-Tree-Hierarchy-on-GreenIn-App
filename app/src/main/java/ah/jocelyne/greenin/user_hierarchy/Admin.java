package ah.jocelyne.greenin.user_hierarchy;

import ah.jocelyne.greenin.signup.RegisteredUser;

public class Admin extends RegisteredUser implements Role{

    public Admin(String firstName, String lastName, String email, String hashedPassword, String salt, String role) {
        super(firstName, lastName, email, hashedPassword, salt, role);
    }

    public void editUserPrevileges() {}
    public void addAppSection() {}
    public void addTypeToSolutionsSection() {}

    public void invokeMyFunctions()
    {
        editUserPrevileges();
        addAppSection();
        addTypeToSolutionsSection();
    }

    public invokeMyChildrenFunctions() {
        //Explanation: List mychildren = TreeNodeObject.getChildren();
        getChildren().invokeMyFunctions();
    }
}
