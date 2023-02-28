package contacts;

class Contact {
    String name;
    long phNo;
    String email;
    Contact next;

    Contact(String name, long phNo, String email) {
        this.name = name;
        this.phNo = phNo;
        this.email = email;
        next = null;
    }

}
