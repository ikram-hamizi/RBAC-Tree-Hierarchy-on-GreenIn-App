package ah.jocelyne.greenin.user_hierarchy;

import ah.jocelyne.greenin.signup.RegisteredUser;

public class Manager extends RegisteredUser implements Role{

    public Manager(String firstName, String lastName, String email, String hashedPassword, String salt, String role) {
        super(firstName, lastName, email, hashedPassword, salt, role);
    }

    public void addJournalistIser() {}
    public void addCostumorServiceUser() {}
    public void addProjectManagerUser() {}

    public void invokeMyFunctions()
    {
        addJournalistIser();
        addCostumorServiceUser();
        addProjectManagerUser();
    }

    public invokeMyChildrenFunctions() {
        //Explanation: List mychildren = TreeNodeObject.getChildren();
        getChildren().invokeMyFunctions();
    }
}
