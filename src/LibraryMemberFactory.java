package src;

public class LibraryMemberFactory {
    public static LibraryMember createMember(String memberType, String memberId, String name, String email) {
        if (memberId == null) {
            throw new IllegalArgumentException("Member Type can not be null");
        }

        switch (memberType.toLowerCase()) {
            case "student":
                return new StudentMember(memberId, name, email);
            case "faculty":
                return new FacultyMember(memberId, name, email);
            default:
                throw new IllegalArgumentException("Member type must be Faculty or Student");
        }
    }
}
