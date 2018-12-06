package ah.jocelyne.greenin.user_hierarchy;

import ah.jocelyne.greenin.signup.RegisteredUser;

public class ProjectMember extends RegisteredUser implements Role{

    public ProjectMember(String firstName, String lastName, String email, String hashedPassword, String salt, String role) {
        super(firstName, lastName, email, hashedPassword, salt, role);
    }

    public void modifyEvent() {    }

    public void invokeMyFunctions()
    {
        modifyEvent();
    }

    public invokeMyChildrenFunctions() {
        //Explanation: List mychildren = TreeNodeObject.getChildren();
        getChildren().invokeMyFunctions();
    }
}
