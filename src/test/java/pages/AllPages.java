package pages;

public class AllPages {

    private CLAddContactPage addContactPage;
    private CLContactListPage contactListPage;
    private CLSignInPage signInPage;

    public CLAddContactPage getAddContactPage() {
        if (addContactPage == null) {
            addContactPage = new CLAddContactPage();
        }
        return addContactPage;
    }

    public CLContactListPage getContactListPage() {
        if (contactListPage == null) {
            contactListPage = new CLContactListPage();
        }
        return contactListPage;
    }

    public CLSignInPage getSignInPage() {
        if (signInPage == null) {
            signInPage = new CLSignInPage();
        }
        return signInPage;
    }
}
